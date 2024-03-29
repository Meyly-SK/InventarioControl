package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import Entidad.Cargos;
import Entidad.Empleados;
import Entidad.EstadoCivil;
import Entidad.Genero;
import Entidad.Sedes;
import Mantenimiento.GestionCargosDAO;
import Mantenimiento.GestionEmpleadoDAO;
import Mantenimiento.GestionEstadoCivilDAO;
import Mantenimiento.GestionGeneroDAO;
import Mantenimiento.GestionSedesDAO;
import Utils.ModifyThread;
import Utils.Validaciones;
import Utils.cboProperties;
import Utils.editCells;
import Utils.editColumns;
import Utils.tableModel;
import Utils.typeUtility;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

public class registrarEmpleado extends JInternalFrame
		implements ActionListener, MouseListener, FocusListener, PropertyChangeListener, InternalFrameListener {

	private final JPanel contentPanel = new JPanel();
	private JPanel pPrincipal;
	private JPanel pTable;
	private JPanel pText;
	private JTable tbEmpleados;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtCelular;
	private JTextField txtCorreo;
	private JComboBox cboSede;
	private JComboBox cboCargo;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JLabel lblNewLabel_10;
	private JLabel txtEdad;
	private JDateChooser dCFechaNac;

	GestionCargosDAO gCargos = new GestionCargosDAO();
	GestionSedesDAO gSedes = new GestionSedesDAO();
	GestionEstadoCivilDAO gEstCivil = new GestionEstadoCivilDAO();
	GestionGeneroDAO gGenero = new GestionGeneroDAO();
	GestionEmpleadoDAO gEmp = new GestionEmpleadoDAO();
	Empleados trabajador;

	tableModel modelo;
	ArrayList<Empleados> listaPersonas;
	ArrayList<Object> listaTitulos;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_11;
	private JPanel pTxts1;
	private JPanel pTxts2;
	private JPanel pTxts3;
	private JPanel pTxts4;
	private JPanel pTxts5;
	private JPanel pTxts6;
	private JPanel pTxts7;
	private JPanel pTxts8;
	private JPanel pTxts9;
	private JPanel pTxts10;
	private JLabel lblNewLabel_12;
	private JPanel pTxts11;
	private JPanel pTxts12;
	private JPanel pTxts13;
	private JPanel pTxts14;
	private JLabel lblCoberturaSede;
	private JLabel lblCoberturaCargo;
	private JLabel lblCoberturaFecha;
	private JLabel lblCoberturaApellido;
	private JLabel lblCoberturaNombre;
	private JLabel lblCoberturaDni;
	private JLabel lblCoberturaGenero;
	private JLabel lblCoberturaEstCivil;
	private JLabel lblCoberturaCelular;
	private JLabel lblCoberturaCorreo;
	private JLabel lblCoberturaDireccion;
	private JComboBox cboEstCivil;
	private JComboBox cboGenero;

	boolean DataSelection = true;
	boolean registro = false;
	boolean modificar = false;
	boolean conditionOrder = true;
	int numOrder = 0;

	private JLabel lblBorderFecha;
	private JButton btnModificar;
	private JPanel pButtonsModify;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnRefresh;
	private JPanel panel;
	private JLabel lblCountEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrarEmpleado frame = new registrarEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public registrarEmpleado() {
		setFrameIcon(new ImageIcon(registrarEmpleado.class.getResource("/IMG/register.png")));
		addInternalFrameListener(this);
		setTitle("Mantenimiento Empleados");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 1100, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		pPrincipal = new JPanel();
		pPrincipal.setOpaque(false);
		contentPanel.add(pPrincipal, BorderLayout.CENTER);
		pPrincipal.setLayout(new BorderLayout(0, 0));

		pTable = new JPanel();
		pTable.setOpaque(false);
		pTable.setPreferredSize(new Dimension(830, 450));
		pPrincipal.add(pTable, BorderLayout.CENTER);
		pTable.setLayout(new BorderLayout(5, 1));

		scrollPane = new JScrollPane();
		pTable.add(scrollPane);

		tbEmpleados = new JTable();
		tbEmpleados = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tbEmpleados.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		tbEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbEmpleados.addMouseListener(this);
		scrollPane.setViewportView(tbEmpleados);

		panel = new JPanel();
		panel.setOpaque(false);
		pTable.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(20, 0));

		lblCountEmp = new JLabel("Numero de Empleados Registrados:  ");
		panel.add(lblCountEmp, BorderLayout.EAST);

		pButtonsModify = new JPanel();
		pButtonsModify.setOpaque(false);
		pPrincipal.add(pButtonsModify, BorderLayout.SOUTH);
		pButtonsModify.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(this);
		btnNuevo.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnNuevo.setContentAreaFilled(false);
		btnNuevo.setOpaque(false);
		btnNuevo.setIcon(new ImageIcon(registrarEmpleado.class.getResource("/IMG/new.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setPreferredSize(new Dimension(80, 30));
		btnNuevo.setFocusable(false);
		pButtonsModify.add(btnNuevo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(this);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setOpaque(false);
		btnEliminar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnEliminar.setIcon(new ImageIcon(registrarEmpleado.class.getResource("/IMG/delete.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setPreferredSize(new Dimension(80, 30));
		btnEliminar.setFocusable(false);
		pButtonsModify.add(btnEliminar);

		btnActualizar = new JButton("Modificar");
		btnActualizar.addMouseListener(this);
		btnActualizar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setOpaque(false);
		btnActualizar.setIcon(new ImageIcon(registrarEmpleado.class.getResource("/IMG/edit.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setPreferredSize(new Dimension(80, 30));
		btnActualizar.setFocusable(false);
		pButtonsModify.add(btnActualizar);

		btnRefresh = new JButton("");
		btnRefresh.addMouseListener(this);
		btnRefresh.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnRefresh.setContentAreaFilled(false);
		btnRefresh.addActionListener(this);
		btnRefresh.setIcon(new ImageIcon(registrarEmpleado.class.getResource("/IMG/refresh.png")));
		btnRefresh.setToolTipText("Actualizar Tabla");
		btnRefresh.setPreferredSize(new Dimension(30, 30));
		pButtonsModify.add(btnRefresh);

		pText = new JPanel();
		pText.setOpaque(false);
		pText.setPreferredSize(new Dimension(240, 450));
		contentPanel.add(pText, BorderLayout.EAST);
		// pPrincipal.add(pText);
		pText.setLayout(new GridLayout(0, 1, 0, 0));

		pTxts1 = new JPanel();
		pTxts1.setOpaque(false);
		pTxts1.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts1);
		pTxts1.setLayout(null);

		lblNewLabel = new JLabel("CODIGO");
		lblNewLabel.setBounds(10, 5, 73, 20);
		pTxts1.add(lblNewLabel);

		txtCodigo = new JLabel("");
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCodigo.setBounds(93, 5, 137, 20);
		pTxts1.add(txtCodigo);

		pTxts2 = new JPanel();
		pTxts2.setOpaque(false);
		pTxts2.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts2);
		pTxts2.setLayout(null);

		lblCoberturaNombre = new JLabel("");
		lblCoberturaNombre.addMouseListener(this);
		lblCoberturaNombre.setBounds(93, 5, 137, 20);
		pTxts2.add(lblCoberturaNombre);

		lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(10, 5, 73, 20);
		pTxts2.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(this);
		txtNombre.setAutoscrolls(false);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(93, 5, 137, 20);
		pTxts2.add(txtNombre);
		txtNombre.setColumns(10);

		pTxts3 = new JPanel();
		pTxts3.setOpaque(false);
		pTxts3.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts3);
		pTxts3.setLayout(null);

		lblCoberturaApellido = new JLabel("");
		lblCoberturaApellido.addMouseListener(this);
		lblCoberturaApellido.setBounds(93, 5, 137, 20);
		pTxts3.add(lblCoberturaApellido);

		lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setBounds(10, 5, 73, 20);
		pTxts3.add(lblNewLabel_2);

		txtApellido = new JTextField();
		txtApellido.addFocusListener(this);
		txtApellido.setAutoscrolls(false);
		txtApellido.setOpaque(false);
		txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellido.setBounds(93, 5, 137, 20);
		pTxts3.add(txtApellido);
		txtApellido.setColumns(10);

		pTxts4 = new JPanel();
		pTxts4.setOpaque(false);
		pTxts4.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts4);
		pTxts4.setLayout(null);

		lblCoberturaDni = new JLabel("");
		lblCoberturaDni.addMouseListener(this);
		lblCoberturaDni.setBounds(93, 5, 137, 20);
		pTxts4.add(lblCoberturaDni);

		lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(10, 5, 73, 20);
		pTxts4.add(lblNewLabel_3);

		txtDni = new JTextField();
		txtDni.addFocusListener(this);
		txtDni.setAutoscrolls(false);
		txtDni.setOpaque(false);
		txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDni.setBounds(93, 5, 137, 20);
		pTxts4.add(txtDni);
		txtDni.setColumns(10);

		pTxts6 = new JPanel();
		pTxts6.setOpaque(false);
		pTxts6.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts6);
		pTxts6.setLayout(null);

		lblCoberturaFecha = new JLabel("");
		lblCoberturaFecha.addMouseListener(this);
		lblCoberturaFecha.setBorder(null);
		lblCoberturaFecha.setBounds(93, 5, 137, 20);
		pTxts6.add(lblCoberturaFecha);

		lblNewLabel_10 = new JLabel("FECHA NAC.");
		lblNewLabel_10.setBounds(10, 8, 73, 14);
		pTxts6.add(lblNewLabel_10);

		dCFechaNac = new JDateChooser();
		dCFechaNac.addFocusListener(this);
		dCFechaNac.getCalendarButton().setBorder(null);
		dCFechaNac.setBorder(null);
		dCFechaNac.addPropertyChangeListener(this);
		dCFechaNac.setBounds(93, 5, 137, 20);
		pTxts6.add(dCFechaNac);
		dCFechaNac.setDateFormatString("yyyy/MM/dd");
		dCFechaNac.getCalendarButton().setLocation(168, 0);

		lblBorderFecha = new JLabel("");
		lblBorderFecha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblBorderFecha.setBounds(93, 6, 137, 20);
		pTxts6.add(lblBorderFecha);

		pTxts5 = new JPanel();
		pTxts5.setOpaque(false);
		pTxts5.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts5);
		pTxts5.setLayout(null);

		lblNewLabel_4 = new JLabel("EDAD");
		lblNewLabel_4.setBounds(10, 5, 73, 20);
		pTxts5.add(lblNewLabel_4);

		txtEdad = new JLabel("");
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEdad.setBounds(93, 5, 137, 20);
		pTxts5.add(txtEdad);

		pTxts7 = new JPanel();
		pTxts7.setOpaque(false);
		pTxts7.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts7);
		pTxts7.setLayout(null);

		lblCoberturaGenero = new JLabel("");
		lblCoberturaGenero.setBorder(null);
		lblCoberturaGenero.addMouseListener(this);
		lblCoberturaGenero.setBounds(93, 5, 137, 20);
		pTxts7.add(lblCoberturaGenero);

		lblNewLabel_11 = new JLabel("GENERO");
		lblNewLabel_11.setBounds(10, 5, 73, 20);
		pTxts7.add(lblNewLabel_11);

		cboGenero = new JComboBox();
		cboGenero.setName("comboGenero");
		cboGenero.setOpaque(false);
		cboGenero.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboGenero.setBackground(new Color(224, 255, 255));
		cboGenero.setUI(cboProperties.createUI(rootPane));
		cboGenero.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));
		cboGenero.setBounds(93, 5, 137, 20);
		pTxts7.add(cboGenero);

		pTxts8 = new JPanel();
		pTxts8.setOpaque(false);
		pTxts8.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts8);
		pTxts8.setLayout(null);

		lblCoberturaEstCivil = new JLabel("");
		lblCoberturaEstCivil.addMouseListener(this);
		lblCoberturaEstCivil.setBounds(93, 6, 137, 20);
		pTxts8.add(lblCoberturaEstCivil);

		lblNewLabel_12 = new JLabel("EST. CIVIL");
		lblNewLabel_12.setBounds(10, 6, 73, 20);
		pTxts8.add(lblNewLabel_12);

		cboEstCivil = new JComboBox();
		cboEstCivil.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboEstCivil.setName("comboEstCivil");
		cboEstCivil.setBackground(new Color(224, 255, 255));
		cboEstCivil.setUI(cboProperties.createUI(rootPane));
		cboEstCivil.setOpaque(false);
		cboEstCivil.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));
		cboEstCivil.setBounds(93, 6, 137, 20);
		pTxts8.add(cboEstCivil);

		pTxts9 = new JPanel();
		pTxts9.setOpaque(false);
		pTxts9.setLayout(null);
		pTxts9.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts9);

		lblCoberturaCelular = new JLabel("");
		lblCoberturaCelular.addMouseListener(this);
		lblCoberturaCelular.setBounds(93, 5, 137, 20);
		pTxts9.add(lblCoberturaCelular);

		lblNewLabel_6 = new JLabel("CELULAR");
		lblNewLabel_6.setBounds(10, 5, 73, 20);
		pTxts9.add(lblNewLabel_6);

		txtCelular = new JTextField();
		txtCelular.setHorizontalAlignment(SwingConstants.LEFT);
		txtCelular.addFocusListener(this);
		txtCelular.setAutoscrolls(false);
		txtCelular.setOpaque(false);
		txtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCelular.setBounds(93, 5, 137, 20);
		pTxts9.add(txtCelular);
		txtCelular.setColumns(10);

		pTxts11 = new JPanel();
		pTxts11.setOpaque(false);
		pTxts11.setLayout(null);
		pTxts11.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts11);

		lblCoberturaCorreo = new JLabel("");
		lblCoberturaCorreo.addMouseListener(this);
		lblCoberturaCorreo.setBounds(93, 5, 137, 20);
		pTxts11.add(lblCoberturaCorreo);

		lblNewLabel_7 = new JLabel("CORREO");
		lblNewLabel_7.setBounds(10, 5, 73, 20);
		pTxts11.add(lblNewLabel_7);

		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(this);
		txtCorreo.setAutoscrolls(false);
		txtCorreo.setOpaque(false);
		txtCorreo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCorreo.setBounds(93, 5, 137, 20);
		pTxts11.add(txtCorreo);
		txtCorreo.setColumns(10);

		pTxts10 = new JPanel();
		pTxts10.setOpaque(false);
		pTxts10.setLayout(null);
		pTxts10.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts10);

		lblCoberturaDireccion = new JLabel("");
		lblCoberturaDireccion.addMouseListener(this);
		lblCoberturaDireccion.setBounds(93, 5, 137, 20);
		pTxts10.add(lblCoberturaDireccion);

		lblNewLabel_5 = new JLabel("DIRECCION");
		lblNewLabel_5.setBounds(10, 5, 73, 20);
		pTxts10.add(lblNewLabel_5);

		txtDireccion = new JTextField();
		txtDireccion.addFocusListener(this);
		txtDireccion.setAutoscrolls(false);
		txtDireccion.setOpaque(false);
		txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(93, 5, 137, 20);
		pTxts10.add(txtDireccion);
		txtDireccion.setColumns(10);

		pTxts13 = new JPanel();
		pTxts13.setOpaque(false);
		pTxts13.setLayout(null);
		pTxts13.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts13);

		lblCoberturaCargo = new JLabel("");
		lblCoberturaCargo.addMouseListener(this);
		lblCoberturaCargo.setBounds(93, 5, 137, 20);
		pTxts13.add(lblCoberturaCargo);

		lblNewLabel_8 = new JLabel("CARGO");
		lblNewLabel_8.setBounds(10, 5, 73, 20);
		pTxts13.add(lblNewLabel_8);

		cboCargo = new JComboBox();
		cboCargo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboCargo.setOpaque(false);
		cboCargo.setBackground(new Color(224, 255, 255));
		cboCargo.setUI(cboProperties.createUI(rootPane));
		cboCargo.setName("comboCargo");
		cboCargo.setFocusable(false);
		cboCargo.setBounds(93, 5, 137, 20);
		pTxts13.add(cboCargo);
		cboCargo.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));

		pTxts14 = new JPanel();
		pTxts14.setOpaque(false);
		pTxts14.setLayout(null);
		pTxts14.setBackground(Color.DARK_GRAY);
		pText.add(pTxts14);

		lblCoberturaSede = new JLabel("");
		lblCoberturaSede.setVisible(false);
		lblCoberturaSede.addMouseListener(this);
		lblCoberturaSede.setBackground(new Color(240, 240, 240));
		lblCoberturaSede.setBounds(93, 5, 137, 20);
		pTxts14.add(lblCoberturaSede);

		lblNewLabel_9 = new JLabel("SEDE");
		lblNewLabel_9.setBounds(10, 5, 73, 20);
		pTxts14.add(lblNewLabel_9);

		cboSede = new JComboBox();
		cboSede.setOpaque(false);
		cboSede.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboSede.setBackground(new Color(224, 255, 255));
		cboSede.setUI(cboProperties.createUI(rootPane));
		cboSede.setFocusable(false);
		cboSede.setName("comboSede");
		cboSede.setBounds(93, 5, 137, 20);
		pTxts14.add(cboSede);
		cboSede.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));

		pTxts12 = new JPanel();
		pTxts12.setOpaque(false);
		pTxts12.setLayout(null);
		pTxts12.setBackground(Color.LIGHT_GRAY);
		pText.add(pTxts12);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.addMouseListener(this);
		btnRegistrar.setBounds(14, 1, 99, 30);
		pTxts12.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setVisible(false);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.addMouseListener(this);
		btnCancelar.setBounds(127, 1, 99, 30);
		pTxts12.add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setVisible(false);

		btnModificar = new JButton("Actualizar");
		btnModificar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnModificar.setContentAreaFilled(false);
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setBounds(20, 1, 89, 30);
		pTxts12.add(btnModificar);
		btnModificar.setVisible(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == btnRefresh) {
			do_btnRefresh_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}

		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
	}

	private void do_btnRefresh_actionPerformed(ActionEvent e) {
		construirTabla(numOrder);
	}

	private void limpiarNuevo() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		dCFechaNac.setDate(null);
		txtEdad.setText("");
		txtDireccion.setText("");
		txtCelular.setText("");
		txtCorreo.setText("");
		cboCargo.setSelectedIndex(0);
		cboSede.setSelectedIndex(0);
		cboGenero.setSelectedIndex(0);
		cboEstCivil.setSelectedIndex(0);
	}

	private void editarVisible(boolean e) {

		lblCoberturaNombre.setVisible(e);
		lblCoberturaApellido.setVisible(e);
		lblCoberturaDni.setVisible(e);
		lblCoberturaFecha.setVisible(e);
		lblCoberturaGenero.setVisible(e);
		lblCoberturaEstCivil.setVisible(e);
		lblCoberturaCelular.setVisible(e);
		lblCoberturaCorreo.setVisible(e);
		lblCoberturaDireccion.setVisible(e);
		lblCoberturaCargo.setVisible(e);
		lblCoberturaSede.setVisible(e);

	}

	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		tbEmpleados.setEnabled(true);
		tbEmpleados.requestFocus();
		btnRegistrar.setVisible(false);
		btnCancelar.setVisible(false);
		rematizarBordes();
		limpiarNuevo();
		editarVisible(true);
		DataSelection = true;
		btnEliminar.setEnabled(true);
		btnActualizar.setEnabled(true);
		btnRefresh.setEnabled(true);
		btnNuevo.setEnabled(true);
		btnModificar.setVisible(false);
	}

	private void rematizarBordes() {
		ArrayList<JComponent> lista = cargarListaTXT();
		for (JComponent j : lista) {
			j.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {

		int pos = tbEmpleados.getSelectedRow();
		if (pos != -1) {
			int OK = JOptionPane.showConfirmDialog(null, "Se modificarán los datos\n>>ACCION NO REVERSIBLE<<",
					"¿Desea continuar?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (OK == 0) {
				validarModificar();
			}

		}
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		ModifyThread mT = new ModifyThread(this, "registroEmpleado");
		Thread tt = new Thread(mT);
		tt.start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (registro) {
			btnRegistrar.setVisible(false);
			btnCancelar.setVisible(false);
			limpiarNuevo();
			editarVisible(true);
			ModifyThread mT2 = new ModifyThread(this, "construirtablaEmp");
			Thread tt2 = new Thread(mT2);
			tt2.start();
			DataSelection = true;
			btnEliminar.setEnabled(true);
			btnActualizar.setEnabled(true);
			btnRefresh.setEnabled(true);
			tbEmpleados.setEnabled(true);
			tbEmpleados.requestFocus();
			rematizarBordes();
			registro = false;

		}
	}

	private void cargarCargos() {
		cboCargo.removeAllItems();
		ArrayList<Cargos> lista = gCargos.listarCargos();
		cboCargo.addItem("SELECCIONAR....");
		for (Cargos c : lista) {
			cboCargo.addItem(c.getDescripcion());
		}
	}

	private void cargarSedes() {
		cboSede.removeAllItems();
		ArrayList<Sedes> lista = gSedes.listarSedes();
		cboSede.addItem("SELECCIONAR....");
		for (Sedes s : lista) {
			cboSede.addItem(s.getDescripcion());
		}
	}

	private void cargarEstCivil() {
		cboEstCivil.removeAllItems();
		ArrayList<EstadoCivil> lista = gEstCivil.listarEstadoCivil();
		cboEstCivil.addItem("SELECCIONAR....");
		for (EstadoCivil s : lista) {
			cboEstCivil.addItem(s.getDescripcion());
		}
	}

	private void cargarGenero() {
		cboGenero.removeAllItems();
		ArrayList<Genero> lista = gGenero.listarGenero();
		cboGenero.addItem("SELECCIONAR....");
		for (Genero s : lista) {
			cboGenero.addItem(s.getDescripcion());
		}
	}

	private ArrayList<Object> cargarColumnas() {
		ArrayList<Object> lista = gEmp.leerColumnas();
		return lista;
	}

	private ArrayList<Empleados> cargarEmpleados(int nume) {
		ArrayList<Empleados> lista = gEmp.leerEmpleados(nume, conditionOrder);
		return lista;
	}

	public void construirTabla(int nume) {
		listaPersonas = cargarEmpleados(nume);
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Empleados");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
		lblCountEmp.setText("Numero de Empleados Registrados:  " + tbEmpleados.getRowCount());
	}

	public void construirTablaPorCodigo(String code) {
		listaPersonas = gEmp.busquedaPorCodigo(code);
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Empleados");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
		lblCountEmp.setText("Numero de Empleados Registrados:  " + tbEmpleados.getRowCount());
	}

	private void construirTabla(String[] titulos, Object[][] data, typeUtility util) {
		int num = titulos.length;

		boolean[] columEdit = new boolean[num];

		for (int i = 0; i < num; i++) {
			columEdit[i] = false;
		}

		Class[] tipoEdit = new Class[num];

		for (int i = 0; i < num; i++) {
			tipoEdit[i] = java.lang.Object.class;
		}

		modelo = new tableModel(data, titulos) {
			public boolean isCellEditable(int row, int col) {
				return columEdit[col];
			}

			public Class getColumnClass(int index) {
				return tipoEdit[index];
			}
		};
		tbEmpleados.setModel(modelo);

		// Se asigna el tipo de dato que tendra cada celda
		tbEmpleados.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getNombre()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getApellido()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getDni()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getEdad()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getFechaNac()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getGenero()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getEstadoCivil()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getCelular()).setCellRenderer(new editCells("numerico"));
		tbEmpleados.getColumnModel().getColumn(util.getCorreo()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getDireccion()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getCargo()).setCellRenderer(new editCells("texto"));
		tbEmpleados.getColumnModel().getColumn(util.getSede()).setCellRenderer(new editCells("texto"));

		tbEmpleados.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
		tbEmpleados.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
		tbEmpleados.getColumnModel().getColumn(util.getApellido()).setPreferredWidth(150);
		tbEmpleados.getColumnModel().getColumn(util.getDni()).setPreferredWidth(115);
		tbEmpleados.getColumnModel().getColumn(util.getEdad()).setPreferredWidth(55);
		tbEmpleados.getColumnModel().getColumn(util.getFechaNac()).setPreferredWidth(180);
		tbEmpleados.getColumnModel().getColumn(util.getGenero()).setPreferredWidth(70);
		tbEmpleados.getColumnModel().getColumn(util.getEstadoCivil()).setPreferredWidth(100);
		tbEmpleados.getColumnModel().getColumn(util.getCelular()).setPreferredWidth(110);
		tbEmpleados.getColumnModel().getColumn(util.getCorreo()).setPreferredWidth(250);
		tbEmpleados.getColumnModel().getColumn(util.getDireccion()).setPreferredWidth(210);
		tbEmpleados.getColumnModel().getColumn(util.getCargo()).setPreferredWidth(100);
		tbEmpleados.getColumnModel().getColumn(util.getSede()).setPreferredWidth(100);

		tbEmpleados.getTableHeader().setReorderingAllowed(false);
		tbEmpleados.setRowHeight(25);
		tbEmpleados.setGridColor(new Color(0, 0, 0));

		JTableHeader jtableheader = tbEmpleados.getTableHeader();
		jtableheader.setDefaultRenderer(new editColumns());
		tbEmpleados.setTableHeader(jtableheader);

	}

	private Object[][] obtenerMatrizDatos(ArrayList<Object> listaTitulos2, typeUtility util) {
		String informacion[][] = new String[listaPersonas.size()][listaTitulos.size()];

		for (int x = 0; x < informacion.length; x++) {

			informacion[x][util.getCodigo()] = listaPersonas.get(x).getCodigo() + "";
			informacion[x][util.getNombre()] = listaPersonas.get(x).getNombre() + "";
			informacion[x][util.getApellido()] = listaPersonas.get(x).getApellido() + "";
			informacion[x][util.getDni()] = listaPersonas.get(x).getDni() + "";
			informacion[x][util.getEdad()] = listaPersonas.get(x).getEdad() + "";
			informacion[x][util.getFechaNac()] = listaPersonas.get(x).getFechaNac() + "";
			informacion[x][util.getGenero()] = listaPersonas.get(x).getGenero() + "";
			informacion[x][util.getEstadoCivil()] = listaPersonas.get(x).getEstadoCivil() + "";
			informacion[x][util.getCelular()] = listaPersonas.get(x).getCelular() + "";
			informacion[x][util.getCorreo()] = listaPersonas.get(x).getCorreo() + "";
			informacion[x][util.getDireccion()] = listaPersonas.get(x).getDireccion() + "";
			informacion[x][util.getCargo()] = listaPersonas.get(x).getCargo() + "";
			informacion[x][util.getSede()] = listaPersonas.get(x).getSede() + "";

		}
		return informacion;
	}

	private ArrayList<JComponent> cargarListaTXT() {
		ArrayList<JComponent> lista = new ArrayList<JComponent>();
		lista.add(txtCodigo);
		lista.add(txtNombre);
		lista.add(txtApellido);
		lista.add(txtDni);
		lista.add(txtEdad);
		lista.add(dCFechaNac);
		lista.add(cboGenero);
		lista.add(cboEstCivil);
		lista.add(txtCelular);
		lista.add(txtCorreo);
		lista.add(txtDireccion);
		lista.add(cboCargo);
		lista.add(cboSede);
		return lista;
	}

	private void mostrarData(int posFila) {
		ArrayList<JComponent> lista = cargarListaTXT();
		for (JComponent j : lista) {
			if (j instanceof JLabel) {

				((JLabel) j).setText(tbEmpleados.getValueAt(posFila, lista.indexOf(j)) + "");

			} else if (j instanceof JTextField) {

				((JTextField) j).setText(tbEmpleados.getValueAt(posFila, lista.indexOf(j)) + "");

			} else if (j instanceof JComboBox) {
				String item = tbEmpleados.getValueAt(posFila, lista.indexOf(j)) + "";
				switch ((j.getName() + "")) {

				case "comboCargo": {

					ArrayList<Cargos> cargo = gCargos.listarCargos();
					for (Cargos c : cargo) {
						if (c.getDescripcion().equalsIgnoreCase(item)) {

							((JComboBox) j).setSelectedItem(item);
						}
					}
					break;
				}
				case "comboSede": {

					ArrayList<Sedes> sede = gSedes.listarSedes();
					for (Sedes s : sede) {
						if (s.getDescripcion().equalsIgnoreCase(item)) {
							((JComboBox) j).setSelectedItem(item);
						}
					}
					break;
				}

				case "comboEstCivil": {

					ArrayList<EstadoCivil> estCivil = gEstCivil.listarEstadoCivil();

					for (EstadoCivil s : estCivil) {

						if (s.getDescripcion().equalsIgnoreCase(item)) {
							((JComboBox) j).setSelectedItem(item);

						}
					}
					break;
				}

				case "comboGenero": {

					ArrayList<Genero> genero = gGenero.listarGenero();

					for (Genero s : genero) {

						if (s.getDescripcion().equalsIgnoreCase(item)) {
							((JComboBox) j).setSelectedItem(item);

						}
					}
					break;
				}
				default:
					break;
				}

			} else if (j instanceof JDateChooser) {
				try {
					((JDateChooser) j).setDate(new SimpleDateFormat("yyyy-MM-dd")
							.parse(tbEmpleados.getValueAt(posFila, lista.indexOf(j)) + ""));
				} catch (ParseException e) {

					e.printStackTrace();
					System.out.println("Error con el JDateChooser");
				}
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCoberturaCargo) {
			do_lblCoberturaCargo_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaDireccion) {
			do_lblCoberturaDireccion_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaCorreo) {
			do_lblCoberturaCorreo_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaCelular) {
			do_lblCoberturaCelular_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaEstCivil) {
			do_lblCoberturaEstCivil_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaGenero) {
			do_lblCoberturaGenero_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaDni) {
			do_lblCoberturaDni_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaFecha) {
			do_lblCoberturaFecha_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaApellido) {
			do_lblCoberturaApellido_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaNombre) {
			do_lblCoberturaNombre_mouseClicked(e);
		}
		if (e.getSource() == lblCoberturaSede) {
			do_lblCoberturaSede_mouseClicked(e);
		}
		if (e.getSource() == tbEmpleados) {
			do_tbEmpleados_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_mouseEntered(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_mouseEntered(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_mouseEntered(e);
		}
		if (e.getSource() == btnRefresh) {
			do_btnRefresh_mouseEntered(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseEntered(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_mouseEntered(e);
		}
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_mouseExited(e);
		}

		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseExited(e);
		}

		if (e.getSource() == btnActualizar) {
			do_btnActualizar_mouseExited(e);
		}
		if (e.getSource() == btnRefresh) {
			do_btnRefresh_mouseExited(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_mouseExited(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_mouseExited(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_tbEmpleados_mouseClicked(MouseEvent e) {
		if (DataSelection) {
			mostrarData(tbEmpleados.getSelectedRow());
		}
	}

	protected void do_lblCoberturaSede_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaNombre_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaApellido_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaFecha_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaDni_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaGenero_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaEstCivil_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaCelular_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaCorreo_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaDireccion_mouseClicked(MouseEvent e) {
	}

	protected void do_lblCoberturaCargo_mouseClicked(MouseEvent e) {
	}

	public void focusGained(FocusEvent e) {
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == dCFechaNac) {
			do_dCFechaNac_focusLost(e);
		}
		if (e.getSource() == txtDireccion) {
			do_txtDireccion_focusLost(e);
		}
		if (e.getSource() == txtCorreo) {
			do_txtCorreo_focusLost(e);
		}
		if (e.getSource() == txtCelular) {
			do_txtCelular_focusLost(e);
		}
		if (e.getSource() == txtDni) {
			do_txtDni_focusLost(e);
		}
		if (e.getSource() == txtApellido) {
			do_txtApellido_focusLost(e);
		}
		if (e.getSource() == txtNombre) {
			do_txtNombre_focusLost(e);
		}
	}

	protected void do_txtNombre_focusLost(FocusEvent e) {

		if (txtNombre.getText().matches(Validaciones.NOM_APE)) {
			txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtApellido_focusLost(FocusEvent e) {

		if (txtApellido.getText().matches(Validaciones.NOM_APE)) {
			txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}
	}

	protected void do_txtDni_focusLost(FocusEvent e) {

		if (txtDni.getText().matches(Validaciones.DNI)) {
			txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtCelular_focusLost(FocusEvent e) {

		if (txtCelular.getText().matches(Validaciones.CELULAR)) {
			txtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtCorreo_focusLost(FocusEvent e) {

		if (txtCorreo.getText().matches(Validaciones.CORREO)) {
			txtCorreo.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtCorreo.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}
	}

	protected void do_txtDireccion_focusLost(FocusEvent e) {

		if (txtDireccion.getText().matches(Validaciones.DIRECCION)) {
			txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == dCFechaNac) {
			do_dCFechaNac_propertyChange(evt);
		}
	}

	protected void do_dCFechaNac_propertyChange(PropertyChangeEvent evt) {
		if (dCFechaNac.getDate() == null) {
			txtEdad.setText("");
		} else {
			txtEdad.setText(calcularEdad(dCFechaNac) + "");
		}
	}

	private int calcularEdad(JDateChooser calendario) {
		LocalDate nowDate = LocalDate.now();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		String FNacimiento_Texto = sdf.format(calendario.getDate());
		LocalDate FNacimiento = LocalDate.parse(FNacimiento_Texto);
		return Period.between(FNacimiento, nowDate).getYears();
	}

	private void validarModificar() {
		if (!txtNombre.getText().matches(Validaciones.NOM_APE)) {
			JOptionPane.showMessageDialog(txtNombre, "El nombre no cumple con el formato requerido");

		} else if (!txtApellido.getText().matches(Validaciones.NOM_APE)) {
			JOptionPane.showMessageDialog(txtApellido, "El Apellido no cumple con el formato requerido");

		} else if (!txtDni.getText().matches(Validaciones.DNI)) {
			JOptionPane.showMessageDialog(txtDni, "El DNI no cumple con el formato requerido");

		} else if ((Integer.parseInt(txtEdad.getText()) < 18) || (Integer.parseInt(txtEdad.getText()) > 80)) {
			if (Integer.parseInt(txtEdad.getText()) < 18) {
				JOptionPane.showMessageDialog(txtCelular, "No se aceptan menores de edad");
			}

			if (Integer.parseInt(txtEdad.getText()) > 80) {
				JOptionPane.showMessageDialog(txtCelular, "Nuestras Politicas no permiten mayores de 80 años");
			}

		} else if (!txtCelular.getText().matches(Validaciones.CELULAR)) {
			JOptionPane.showMessageDialog(txtCelular, "El Celular no cumple con el formato requerido");

		} else if (!txtCorreo.getText().matches(Validaciones.CORREO)) {
			JOptionPane.showMessageDialog(txtCorreo, "El Correo no cumple con el formato requerido");

		} else if (!txtDireccion.getText().matches(Validaciones.DIRECCION)) {
			JOptionPane.showMessageDialog(txtDireccion, "La Direccion no cumple con el formato requerido");

		} else if (cboGenero.getSelectedItem().equals("SELECCIONAR....")) {
			JOptionPane.showMessageDialog(txtDireccion, "No ha seleccionado un Genero");

		} else if (cboEstCivil.getSelectedItem().equals("SELECCIONAR....")) {
			JOptionPane.showMessageDialog(txtDireccion, "No ha seleccionado un Estado Civil");

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String fechaNac = sdf.format(dCFechaNac.getDate());
			Empleados temporal = new Empleados();
			int pos = tbEmpleados.getSelectedRow();
			temporal.setCodigo_(9999999);
			temporal.setCodigo(txtCodigo.getText());
			temporal.setNombre(txtNombre.getText());
			temporal.setApellido(txtApellido.getText());
			temporal.setDni(txtDni.getText());
			temporal.setEdad(Integer.parseInt(txtEdad.getText()));
			temporal.setFechaNac(fechaNac);
			temporal.setGenero(gGenero.buscarCodGenero(cboGenero.getSelectedItem() + ""));
			temporal.setEstadoCivil((gEstCivil.buscarCodEstCivil(cboEstCivil.getSelectedItem() + "")));
			temporal.setCelular(txtCelular.getText());
			temporal.setCorreo(txtCorreo.getText());
			temporal.setDireccion(txtDireccion.getText());
			temporal.setCargo(gCargos.buscarCodCargo(cboCargo.getSelectedItem() + ""));
			temporal.setSede(gSedes.buscarCodSede(cboSede.getSelectedItem() + ""));
			temporal.setUsuario(listaPersonas.get(pos).getUsuario());
			temporal.setClave(listaPersonas.get(pos).getClave());

			int result = gEmp.actualizarEmpleados(temporal);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "Modificado con exito...", "Proceso de modificación", 1);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo modificar", "Proceso de modificación", 1);
			}

			limpiarNuevo();
			editarVisible(true);
			tbEmpleados.setEnabled(true);
			construirTabla(numOrder);
			DataSelection = true;
			btnEliminar.setEnabled(true);
			btnNuevo.setEnabled(true);
			modificar = false;
			btnModificar.setVisible(false);
			btnCancelar.setVisible(false);
			btnActualizar.setVisible(true);
			btnRefresh.setVisible(true);
			btnActualizar.setEnabled(true);
			btnRefresh.setEnabled(true);
		}
	}

	public void validarRegistro() {
		if (!txtNombre.getText().matches(Validaciones.NOM_APE)) {
			JOptionPane.showMessageDialog(txtNombre, "El nombre no cumple con el formato requerido ");

		} else if (!txtApellido.getText().matches(Validaciones.NOM_APE)) {
			JOptionPane.showMessageDialog(txtApellido, "El Apellido no cumple con el formato requerido");

		} else if (!txtDni.getText().matches(Validaciones.DNI)) {
			JOptionPane.showMessageDialog(txtDni, "El DNI no cumple con el formato requerido");

		} else if ((Integer.parseInt(txtEdad.getText()) < 18) || (Integer.parseInt(txtEdad.getText()) > 80)) {
			if (Integer.parseInt(txtEdad.getText()) < 18) {
				JOptionPane.showMessageDialog(txtCelular, "No se aceptan menores de edad");
			}
			if (Integer.parseInt(txtEdad.getText()) > 80) {
				JOptionPane.showMessageDialog(txtCelular, "Nuestras Politicas no permiten mayores de 80 años");
			}

		} else if (!txtCelular.getText().matches(Validaciones.CELULAR)) {
			JOptionPane.showMessageDialog(txtCelular, "El Celular no cumple con el formato requerido");

		} else if (!txtCorreo.getText().matches(Validaciones.CORREO)) {
			JOptionPane.showMessageDialog(txtCorreo, "El Correo no cumple con el formato requerido");

		} else if (!txtDireccion.getText().matches(Validaciones.DIRECCION)) {
			JOptionPane.showMessageDialog(txtDireccion, "La Direccion no cumple con el formato requerido");

		} else if (cboGenero.getSelectedItem().equals("SELECCIONAR....")) {
			JOptionPane.showMessageDialog(txtDireccion, "No ha seleccionado un Genero");

		} else if (cboEstCivil.getSelectedItem().equals("SELECCIONAR....")) {
			JOptionPane.showMessageDialog(txtDireccion, "No ha seleccionado un Estado Civil");

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String fechaNac = sdf.format(dCFechaNac.getDate());
			Empleados temporal = new Empleados();
			temporal.setCodigo_(9999999);
			temporal.setCodigo(generarCodigoEmpleado());
			temporal.setNombre(txtNombre.getText());
			temporal.setApellido(txtApellido.getText());
			temporal.setDni(txtDni.getText());
			temporal.setEdad(Integer.parseInt(txtEdad.getText()));
			temporal.setFechaNac(fechaNac);
			temporal.setGenero(gGenero.buscarCodGenero(cboGenero.getSelectedItem() + ""));
			temporal.setEstadoCivil((gEstCivil.buscarCodEstCivil(cboEstCivil.getSelectedItem() + "")));
			temporal.setCelular(txtCelular.getText());
			temporal.setCorreo(txtCorreo.getText());
			temporal.setDireccion(txtDireccion.getText());
			temporal.setCargo(gCargos.buscarCodCargo(cboCargo.getSelectedItem() + ""));
			temporal.setSede(gSedes.buscarCodSede(cboSede.getSelectedItem() + ""));
			temporal.setUsuario(generarUsuarioEmpleado());
			temporal.setClave(generarClaveEmpleado());

			int result = gEmp.registrarEmpleados(temporal);
			if (result != 0) {
				registro = true;
				JOptionPane.showMessageDialog(null, "NUEVO USUARIO GENERADO: " + temporal.getUsuario()
						+ "\nNUEVA CLAVE GENERADA: " + temporal.getClave(), "EMPLEADO REGISTRADO EXITOSAMENTE", 1);
			}
		}
	}

	private String generarCodigoEmpleado() {
		String codEmpleado = "EM";
		int numEmpleado = listaPersonas.get(listaPersonas.size() - 1).getCodigo_() + 1;

		if (numEmpleado < 10) {
			codEmpleado += "00" + numEmpleado;

		} else if (numEmpleado < 100) {
			codEmpleado += "0" + numEmpleado;

		} else if (numEmpleado < 1000) {
			codEmpleado += numEmpleado;
		}
		return codEmpleado;
	}

	private String generarUsuarioEmpleado() {
		String userEmpleado = "U";
		int numEmpleado = listaPersonas.get(listaPersonas.size() - 1).getCodigo_() + 1;

		if (numEmpleado < 10) {
			userEmpleado += "00" + numEmpleado;

		} else if (numEmpleado < 100) {
			userEmpleado += "0" + numEmpleado;

		} else if (numEmpleado < 1000) {
			userEmpleado += numEmpleado;
		}
		return userEmpleado;
	}

	private String generarClaveEmpleado() {
		String[] listaLetras = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		String user = "";
		int min = 0;
		int max = listaLetras.length - 1;
		for (int i = 0; i < 6; i++) {
			int random = (int) (Math.random() * (max - min)) + min;
			if (((int) (Math.random() * (4 - 0)) + 0) > 2) {
				user += listaLetras[random].toUpperCase();
			} else {
				user += listaLetras[random];
			}

		}
		return user;
	}

	protected void do_dCFechaNac_focusLost(FocusEvent e) {
		int ed = Integer.parseInt(txtEdad.getText());
		if (ed < 18 || ed > 80) {
			lblBorderFecha.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
			txtEdad.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		} else {
			lblBorderFecha.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
			txtEdad.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		}
	}

	public void internalFrameActivated(InternalFrameEvent e) {
		if (e.getSource() == this) {
			do_this_internalFrameActivated(e);
		}
	}

	public void internalFrameClosed(InternalFrameEvent e) {
	}

	public void internalFrameClosing(InternalFrameEvent e) {
	}

	public void internalFrameDeactivated(InternalFrameEvent e) {
	}

	public void internalFrameDeiconified(InternalFrameEvent e) {
	}

	public void internalFrameIconified(InternalFrameEvent e) {
	}

	public void internalFrameOpened(InternalFrameEvent e) {
	}

	protected void do_this_internalFrameActivated(InternalFrameEvent e) {
		editarVisible(true);
		construirTabla(numOrder);
		cargarCargos();
		cargarSedes();
		cargarEstCivil();
		cargarGenero();
		activarRestrinccionesCargo();
	}

	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		limpiarNuevo();
		tbEmpleados.setEnabled(false);
		DataSelection = false;
		editarVisible(false);
		btnEliminar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnRefresh.setEnabled(false);
		btnRegistrar.setVisible(true);
		btnCancelar.setVisible(true);
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		int pos = tbEmpleados.getSelectedRow();
		if (pos != -1) {
			int OK = JOptionPane.showConfirmDialog(null, "Se Eliminaran los datos\n>>ACCION NO REVERSIBLE<<",
					"¿Desea continuar?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (OK == 0) {
				Empleados temporal = new Empleados();
				temporal.setCodigo((String) tbEmpleados.getValueAt(pos, 0));
				temporal.setNombre((String) tbEmpleados.getValueAt(pos, 1));
				temporal.setApellido((String) tbEmpleados.getValueAt(pos, 2));
				gEmp.EliminarEmpleado(temporal);
				JOptionPane.showMessageDialog(null, "Los datos del empleado " + temporal.getNombre() + " "
						+ temporal.getApellido() + " \nhan sido elimidados exitosamente");
				construirTabla(numOrder);
			}

		}
	}

	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		if (tbEmpleados.getSelectedRow() != -1) {
			tbEmpleados.setEnabled(false);
			DataSelection = false;
			editarVisible(false);
			btnEliminar.setEnabled(false);
			btnActualizar.setEnabled(false);
			btnNuevo.setEnabled(false);
			btnRefresh.setEnabled(false);
			btnModificar.setVisible(true);
			btnCancelar.setVisible(true);
		}
	}

	protected void do_btnNuevo_mouseEntered(MouseEvent e) {
		if (btnNuevo.isEnabled()) {
			btnNuevo.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnNuevo_mouseExited(MouseEvent e) {
		if (btnNuevo.isEnabled()) {
			btnNuevo.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnEliminar_mouseEntered(MouseEvent e) {
		if (btnEliminar.isEnabled()) {
			btnEliminar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnEliminar_mouseExited(MouseEvent e) {
		if (btnEliminar.isEnabled()) {
			btnEliminar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnActualizar_mouseEntered(MouseEvent e) {
		if (btnActualizar.isEnabled()) {
			btnActualizar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnActualizar_mouseExited(MouseEvent e) {
		if (btnActualizar.isEnabled()) {
			btnActualizar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnRefresh_mouseEntered(MouseEvent e) {
		if (btnRefresh.isEnabled()) {
			btnRefresh.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnRefresh_mouseExited(MouseEvent e) {
		if (btnRefresh.isEnabled()) {
			btnRefresh.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnRegistrar_mouseEntered(MouseEvent e) {
		if (btnRegistrar.isEnabled()) {
			btnRegistrar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnRegistrar_mouseExited(MouseEvent e) {
		if (btnRegistrar.isEnabled()) {
			btnRegistrar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnCancelar_mouseEntered(MouseEvent e) {
		if (btnCancelar.isEnabled()) {
			btnCancelar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnCancelar_mouseExited(MouseEvent e) {
		if (btnCancelar.isEnabled()) {
			btnCancelar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnModificar_mouseEntered(MouseEvent e) {
		if (btnModificar.isEnabled()) {
			btnModificar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnModificar_mouseExited(MouseEvent e) {
		if (btnModificar.isEnabled()) {
			btnModificar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	void activarRestrinccionesCargo() {

		if (frmPrincipal.trabajador != null) {
			trabajador = frmPrincipal.trabajador;
			if (!trabajador.getCargo().equals("Supervisor")) {
				System.out.println("El empleado es: " + "\n" + trabajador.getCargo());
				btnNuevo.setEnabled(false);
				btnNuevo.setToolTipText("ACCESO RESTRINGIDO\nNO CUMPLE CON EL RANGO NECESARIO");

				btnEliminar.setEnabled(false);
				btnEliminar.setToolTipText("ACCESO RESTRINGIDO\nNO CUMPLE CON EL RANGO NECESARIO");

				btnActualizar.setEnabled(false);
				btnActualizar.setToolTipText("ACCESO RESTRINGIDO\nNO CUMPLE CON EL RANGO NECESARIO");
			} else {
				btnNuevo.setEnabled(true);
				btnNuevo.setToolTipText("");

				btnEliminar.setEnabled(true);
				btnEliminar.setToolTipText("");

				btnActualizar.setEnabled(true);
				btnActualizar.setToolTipText("");
			}

		}
	}
}
