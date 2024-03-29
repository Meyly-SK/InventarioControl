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
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.awt.event.ContainerListener;
import java.awt.event.ContainerEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.JToggleButton;

public class consultarEmpleado extends JInternalFrame implements ActionListener, MouseListener, FocusListener,
		PropertyChangeListener, ContainerListener, InternalFrameListener {

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
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtCelular;
	private JTextField txtCorreo;
	private JComboBox cboSede;
	private JComboBox cboCargo;
	private JLabel lblNewLabel_10;
	private JTextField txtEdad;
	private JDateChooser dCFechaNac;

	GestionCargosDAO gCargos = new GestionCargosDAO();
	GestionSedesDAO gSedes = new GestionSedesDAO();
	GestionEstadoCivilDAO gEstCivil = new GestionEstadoCivilDAO();
	GestionGeneroDAO gGenero = new GestionGeneroDAO();
	GestionEmpleadoDAO gEmp = new GestionEmpleadoDAO();
	private DefaultTableModel model = new DefaultTableModel();
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
	private JPanel pTxts13;
	private JPanel pTxts14;
	private JPanel pTxts000;
	private JPanel pTxtsFilter;
	private JComboBox cboEstCivil;
	private JComboBox cboGenero;

	boolean DataSelection = true;
	boolean registro = false;
	boolean modificar = false;
	String searchFilter = "";
	int numVisibleComponent = 0;

	boolean conditionOrder = true;
	int numOrder = 0;
	ArrayList<String> listaFiltro = new ArrayList<String>();

	private JLabel lblBorderFecha;
	private JLabel lblNewLabel_13;
	private JPanel pEast;
	private JPanel pFiltros;
	private JCheckBox chckbxCodigo;
	private JCheckBox chckbxNombre;
	private JCheckBox chckbxApellido;
	private JCheckBox chckbxDni;
	private JCheckBox chckbxFechaNacimiento;
	private JCheckBox chckbxEdad;
	private JCheckBox chckbxGenero;
	private JCheckBox chckbxEstCivil;
	private JCheckBox chckbxCelular;
	private JCheckBox chckbxCorreo;
	private JCheckBox chckbxDireccion;
	private JCheckBox chckbxCargo;
	private JCheckBox chckbxSede;
	private JButton btnFiltros;
	private JPanel pTxts16;
	private JLabel lblEdad;
	private JTextField txtEdadRangoMAX;
	private JTextField txtEdadRangoMIN;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JPanel pTxts17;
	private JLabel lblFecha;
	private JLabel lblNewLabel_17;
	private JDateChooser dCFechaRangoComienzo;
	private JDateChooser dCFechaRangoFin;
	private JCheckBox chckbxEdadRango;
	private JCheckBox chckbxFechaNacRango;
	private JPanel panel;
	private JLabel lblCountEmp;
	private JPanel panel_2;
	private JButton btnConsultar;
	frmPrincipal principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consultarEmpleado frame = new consultarEmpleado();
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

	public consultarEmpleado(frmPrincipal principal) {
		this();
		this.principal = principal;
	}

	public consultarEmpleado() {

		addInternalFrameListener(this);
		setTitle("Consultar Empleados");
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
		pPrincipal.add(pTable);
		pTable.setLayout(new BorderLayout(5, 1));

		scrollPane = new JScrollPane();
		pTable.add(scrollPane);

		tbEmpleados = new JTable();
		tbEmpleados = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tbEmpleados.addMouseListener(this);
		scrollPane.setViewportView(tbEmpleados);

		panel = new JPanel();
		panel.setOpaque(false);
		pTable.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(20, 0));

		lblCountEmp = new JLabel("Numero de Empleados Registrados:  ");
		panel.add(lblCountEmp, BorderLayout.EAST);

		pEast = new JPanel();
		pEast.setOpaque(false);
		contentPanel.add(pEast, BorderLayout.EAST);
		pEast.setLayout(new BorderLayout(0, 0));

		pText = new JPanel();
		pText.setBackground(new Color(224, 255, 255));
		pText.setBorder(null);
		pText.addContainerListener(this);
		pText.setPreferredSize(new Dimension(240, 450));
		FlowLayout fl_pText = new FlowLayout(FlowLayout.CENTER, 5, 1);
		pText.setLayout(fl_pText);
		pEast.add(pText, BorderLayout.CENTER);

		pTxts000 = new JPanel();
		pTxts000.setPreferredSize(new Dimension(240, 30));
		pTxts000.addContainerListener(this);
		pTxts000.setOpaque(false);
		pTxts000.setLayout(null);
		pTxts000.setBackground(Color.DARK_GRAY);
		pText.add(pTxts000);

		lblNewLabel_13 = new JLabel("FILTRAR EMPLEADOS");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(20, 4, 199, 22);
		pTxts000.add(lblNewLabel_13);

		pTxtsFilter = new JPanel();
		pTxtsFilter.setPreferredSize(new Dimension(240, 30));
		pTxtsFilter.setOpaque(false);
		pTxtsFilter.setLayout(null);
		pTxtsFilter.setBackground(Color.DARK_GRAY);
		pText.add(pTxtsFilter);
		pTxtsFilter.setBorder(null);

		btnFiltros = new JButton("Filtros");
		btnFiltros.addMouseListener(this);
		btnFiltros.setFocusable(false);
		btnFiltros.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnFiltros.setContentAreaFilled(false);
		btnFiltros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFiltros.addActionListener(this);
		btnFiltros.setBounds(62, 3, 115, 23);
		pTxtsFilter.add(btnFiltros);

		pTxts2 = new JPanel();
		pTxts2.setPreferredSize(new Dimension(240, 30));
		pTxts2.setOpaque(false);
		pTxts2.setBackground(Color.LIGHT_GRAY);
		pTxts2.setLayout(null);

		lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(10, 5, 73, 20);
		pTxts2.add(lblNewLabel_1);

		txtNombre = new JTextField();
		txtNombre.setName("nombre");
		txtNombre.addFocusListener(this);
		txtNombre.setAutoscrolls(false);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(93, 5, 137, 20);
		pTxts2.add(txtNombre);
		txtNombre.setColumns(10);

		pTxts3 = new JPanel();
		pTxts3.setPreferredSize(new Dimension(240, 30));
		pTxts3.setOpaque(false);
		pTxts3.setBackground(Color.LIGHT_GRAY);
		pTxts3.setLayout(null);

		lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setBounds(10, 5, 73, 20);
		pTxts3.add(lblNewLabel_2);

		txtApellido = new JTextField();
		txtApellido.setName("apellido");
		txtApellido.addFocusListener(this);
		txtApellido.setAutoscrolls(false);
		txtApellido.setOpaque(false);
		txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellido.setBounds(93, 5, 137, 20);
		pTxts3.add(txtApellido);
		txtApellido.setColumns(10);

		pTxts4 = new JPanel();
		pTxts4.setPreferredSize(new Dimension(240, 30));
		pTxts4.setOpaque(false);
		pTxts4.setBackground(Color.LIGHT_GRAY);
		pTxts4.setLayout(null);

		lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(10, 5, 73, 20);
		pTxts4.add(lblNewLabel_3);

		txtDni = new JTextField();
		txtDni.setName("dni");
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
		pTxts6.setLayout(null);

		lblNewLabel_10 = new JLabel("FECHA NAC.");
		lblNewLabel_10.setBounds(10, 8, 73, 14);
		pTxts6.add(lblNewLabel_10);

		dCFechaNac = new JDateChooser();
		dCFechaNac.setName("fechaNacInicio");
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
		pTxts5.setLayout(null);

		lblNewLabel_4 = new JLabel("EDAD");
		lblNewLabel_4.setBounds(10, 5, 73, 20);
		pTxts5.add(lblNewLabel_4);

		txtEdad = new JTextField("");
		txtEdad.setOpaque(false);
		txtEdad.setName("edad");
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEdad.setBounds(93, 5, 137, 20);
		pTxts5.add(txtEdad);

		pTxts7 = new JPanel();
		pTxts7.setOpaque(false);
		pTxts7.setBackground(Color.LIGHT_GRAY);
		pTxts7.setLayout(null);

		lblNewLabel_11 = new JLabel("GENERO");
		lblNewLabel_11.setBounds(10, 5, 73, 20);
		pTxts7.add(lblNewLabel_11);

		cboGenero = new JComboBox();
		cboGenero.addActionListener(this);
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
		pTxts8.setLayout(null);

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

		lblNewLabel_6 = new JLabel("CELULAR");
		lblNewLabel_6.setBounds(10, 5, 73, 20);
		pTxts9.add(lblNewLabel_6);

		txtCelular = new JTextField();
		txtCelular.setName("celular");
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

		lblNewLabel_7 = new JLabel("CORREO");
		lblNewLabel_7.setBounds(10, 5, 73, 20);
		pTxts11.add(lblNewLabel_7);

		txtCorreo = new JTextField();
		txtCorreo.setName("correo");
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

		lblNewLabel_5 = new JLabel("DIRECCION");
		lblNewLabel_5.setBounds(10, 5, 73, 20);
		pTxts10.add(lblNewLabel_5);

		txtDireccion = new JTextField();
		txtDireccion.setName("direccion");
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

		pFiltros = new JPanel();
		pFiltros.setMinimumSize(new Dimension(80, 40));
		pFiltros.setBackground(new Color(224, 255, 255));
		pEast.add(pFiltros, BorderLayout.EAST);
		pFiltros.setLayout(new BoxLayout(pFiltros, BoxLayout.Y_AXIS));
		pFiltros.setVisible(false);

		chckbxCodigo = new JCheckBox("Codigo");
		chckbxCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxCodigo.setOpaque(false);
		chckbxCodigo.addActionListener(this);
		pFiltros.add(chckbxCodigo);

		chckbxNombre = new JCheckBox("Nombre");
		chckbxNombre.setOpaque(false);
		chckbxNombre.addActionListener(this);
		pFiltros.add(chckbxNombre);

		chckbxApellido = new JCheckBox("Apellido");
		chckbxApellido.setOpaque(false);
		chckbxApellido.addActionListener(this);
		pFiltros.add(chckbxApellido);

		chckbxDni = new JCheckBox("DNI");
		chckbxDni.setOpaque(false);
		chckbxDni.addActionListener(this);
		pFiltros.add(chckbxDni);

		chckbxFechaNacimiento = new JCheckBox("Fecha Nacimiento");
		chckbxFechaNacimiento.setOpaque(false);
		chckbxFechaNacimiento.addActionListener(this);
		pFiltros.add(chckbxFechaNacimiento);

		chckbxEdad = new JCheckBox("Edad");
		chckbxEdad.setOpaque(false);
		chckbxEdad.addActionListener(this);
		pFiltros.add(chckbxEdad);

		chckbxFechaNacRango = new JCheckBox("Rango");
		chckbxFechaNacRango.addActionListener(this);
		chckbxFechaNacRango.setSize(new Dimension(80, 40));
		chckbxFechaNacRango.setPreferredSize(new Dimension(80, 23));
		chckbxFechaNacRango.setOpaque(false);
		chckbxFechaNacRango.setMargin(new Insets(2, 20, 2, 2));
		chckbxFechaNacRango.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxFechaNacRango.setContentAreaFilled(false);

		chckbxGenero = new JCheckBox("Genero");
		chckbxGenero.setOpaque(false);
		chckbxGenero.addActionListener(this);
		pFiltros.add(chckbxGenero);

		chckbxEdadRango = new JCheckBox("Rango");
		chckbxEdadRango.addActionListener(this);
		chckbxEdadRango.setSize(new Dimension(80, 40));
		chckbxEdadRango.setPreferredSize(new Dimension(80, 23));
		chckbxEdadRango.setContentAreaFilled(false);
		chckbxEdadRango.setMargin(new Insets(2, 20, 2, 2));
		chckbxEdadRango.setOpaque(false);
		chckbxEdadRango.setHorizontalAlignment(SwingConstants.LEFT);

		chckbxEstCivil = new JCheckBox("Est. Civil");
		chckbxEstCivil.setOpaque(false);
		chckbxEstCivil.addActionListener(this);
		pFiltros.add(chckbxEstCivil);

		chckbxCelular = new JCheckBox("Celular");
		chckbxCelular.setOpaque(false);
		chckbxCelular.addActionListener(this);
		pFiltros.add(chckbxCelular);

		chckbxCorreo = new JCheckBox("Correo");
		chckbxCorreo.setOpaque(false);
		chckbxCorreo.addActionListener(this);
		pFiltros.add(chckbxCorreo);

		chckbxDireccion = new JCheckBox("Direcci\u00F3n");
		chckbxDireccion.setOpaque(false);
		chckbxDireccion.addActionListener(this);
		pFiltros.add(chckbxDireccion);

		chckbxCargo = new JCheckBox("Cargo");
		chckbxCargo.setOpaque(false);
		chckbxCargo.addActionListener(this);
		pFiltros.add(chckbxCargo);

		chckbxSede = new JCheckBox("Sede");
		chckbxSede.setOpaque(false);
		chckbxSede.addActionListener(this);
		pFiltros.add(chckbxSede);

		pTxts1 = new JPanel();
		pTxts1.setOpaque(false);
		pTxts1.setBackground(Color.LIGHT_GRAY);
		pTxts1.setLayout(null);

		lblNewLabel = new JLabel("CODIGO");
		lblNewLabel.setBounds(10, 5, 73, 20);
		pTxts1.add(lblNewLabel);

		txtCodigo = new JTextField("");
		txtCodigo.setName("codigo");
		txtCodigo.setOpaque(false);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCodigo.setBounds(93, 5, 137, 20);
		pTxts1.add(txtCodigo);

		pTxts16 = new JPanel();
		pTxts16.setLayout(null);
		pTxts16.setPreferredSize(new Dimension(240, 30));
		pTxts16.setOpaque(false);
		pTxts16.setBackground(Color.LIGHT_GRAY);

		lblEdad = new JLabel("EDAD");
		lblEdad.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdad.setBounds(6, 5, 39, 20);
		pTxts16.add(lblEdad);

		txtEdadRangoMAX = new JTextField("");
		txtEdadRangoMAX.setOpaque(false);
		txtEdadRangoMAX.setName("edadRangoMAX");
		txtEdadRangoMAX.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadRangoMAX.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEdadRangoMAX.setBounds(175, 5, 56, 20);
		pTxts16.add(txtEdadRangoMAX);

		txtEdadRangoMIN = new JTextField("");
		txtEdadRangoMIN.setOpaque(false);
		txtEdadRangoMIN.setName("edadRangoMIN");
		txtEdadRangoMIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadRangoMIN.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEdadRangoMIN.setBounds(82, 5, 56, 20);
		pTxts16.add(txtEdadRangoMIN);

		lblNewLabel_14 = new JLabel("MIN");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(51, 2, 25, 25);
		pTxts16.add(lblNewLabel_14);

		lblNewLabel_15 = new JLabel("MAX");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_15.setBounds(144, 2, 30, 25);
		pTxts16.add(lblNewLabel_15);

		pTxts17 = new JPanel();
		pTxts17.setLayout(null);
		pTxts17.setPreferredSize(new Dimension(240, 65));
		pTxts17.setOpaque(false);
		pTxts17.setBackground(Color.LIGHT_GRAY);

		lblFecha = new JLabel("FECHA COMIENZO");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setBounds(10, 8, 101, 20);
		pTxts17.add(lblFecha);

		lblNewLabel_17 = new JLabel("FECHA FIN");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_17.setBounds(10, 36, 101, 20);
		pTxts17.add(lblNewLabel_17);

		dCFechaRangoComienzo = new JDateChooser();
		dCFechaRangoComienzo.setName("fechaRangoComienzo");
		dCFechaRangoComienzo.setDateFormatString("YYYY-MM-dd");
		dCFechaRangoComienzo.setBounds(121, 8, 109, 20);
		pTxts17.add(dCFechaRangoComienzo);

		dCFechaRangoFin = new JDateChooser();
		dCFechaRangoFin.setDateFormatString("YYYY-MM-dd");
		dCFechaRangoFin.setName("fechaRangoFin");
		dCFechaRangoFin.setBounds(121, 36, 109, 20);
		pTxts17.add(dCFechaRangoFin);

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setSize(new Dimension(80, 20));
		pEast.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(this);
		btnConsultar.setFocusable(false);
		btnConsultar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setPreferredSize(new Dimension(79, 20));
		btnConsultar.addActionListener(this);
		panel_2.add(btnConsultar);

	}

	private void cargarC() {
		pText.add(pTxts1);
		pTxts1.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts2);
		pTxts2.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts3);
		pTxts3.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts4);
		pTxts4.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts5);
		pTxts5.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts6);
		pTxts6.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts7);
		pTxts7.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts8);
		pTxts8.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts9);
		pTxts9.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts10);
		pTxts10.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts11);
		pTxts11.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts13);
		pTxts13.setPreferredSize(new Dimension(240, 30));
		pText.add(pTxts14);
		pTxts14.setPreferredSize(new Dimension(240, 30));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(e);
		}
		if (e.getSource() == chckbxFechaNacRango) {
			do_chckbxFechaNacRango_actionPerformed(e);
		}
		if (e.getSource() == chckbxEdadRango) {
			do_chckbxEdadRango_actionPerformed(e);
		}
		if (e.getSource() == btnFiltros) {
			do_btnFiltros_actionPerformed(e);
		}
		if (e.getSource() == chckbxSede) {
			do_chckbxSede_actionPerformed(e);
		}
		if (e.getSource() == chckbxDireccion) {
			do_chckbxDireccion_actionPerformed(e);
		}
		if (e.getSource() == chckbxCargo) {
			do_chckbxCargo_actionPerformed(e);
		}
		if (e.getSource() == chckbxCorreo) {
			do_chckbxCorreo_actionPerformed(e);
		}
		if (e.getSource() == chckbxEstCivil) {
			do_chckbxEstCivil_actionPerformed(e);
		}
		if (e.getSource() == chckbxGenero) {
			do_chckbxGenero_actionPerformed(e);
		}
		if (e.getSource() == chckbxCelular) {
			do_chckbxCelular_actionPerformed(e);
		}
		if (e.getSource() == chckbxFechaNacimiento) {
			do_chckbxFechaNacimiento_actionPerformed(e);
		}
		if (e.getSource() == chckbxEdad) {
			do_chckbxEdad_actionPerformed(e);
		}
		if (e.getSource() == chckbxDni) {
			do_chckbxDni_actionPerformed(e);
		}
		if (e.getSource() == chckbxApellido) {
			do_chckbxApellido_actionPerformed(e);
		}
		if (e.getSource() == chckbxNombre) {
			do_chckbxNombre_actionPerformed(e);
		}
		if (e.getSource() == chckbxCodigo) {
			do_chckbxCodigo_actionPerformed(e);
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
		lista.add(" ");
		return lista;
	}

	private ArrayList<Empleados> cargarEmpleados(int nume) {
		ArrayList<Empleados> lista = gEmp.leerEmpleados(nume, conditionOrder);
		return lista;
	}

	private ArrayList<Empleados> cargarEmpleados(String filtro) {
		ArrayList<Empleados> lista = gEmp.buscarEmpleados(filtro, numVisibleComponent, listaFiltro);
		return lista;
	}

	private void construirTablaFiltro() {
		listaPersonas = cargarEmpleados(generarFiltro());
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Empleados");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
		lblCountEmp.setText("Numero de Empleados Encontrados:  " + tbEmpleados.getRowCount() + "   ");
	}

	private void construirTabla(int nume) {
		listaPersonas = cargarEmpleados(nume);
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Empleados");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
		lblCountEmp.setText("Numero de Empleados Encontrados:  " + tbEmpleados.getRowCount() + "   ");
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
		tbEmpleados.getColumnModel().getColumn(util.getIr_a()).setCellRenderer(new editCells("icono"));

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
		tbEmpleados.getColumnModel().getColumn(util.getIr_a()).setPreferredWidth(30);

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
			informacion[x][util.getIr_a()] = "IR_A";

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
		lista.add(txtEdadRangoMIN);
		lista.add(dCFechaRangoComienzo);
		return lista;
	}

	private String generarFiltro() {
		int count = 0;
		numVisibleComponent = 0;
		listaFiltro.clear();
		searchFilter = "";
		ArrayList<JComponent> lista = cargarListaTXT();
		for (JComponent j : lista) {

			if (j.isShowing()) {
				numVisibleComponent++;
			}
		}

		for (JComponent j : lista) {

			if (j.isShowing()) {

				if (j instanceof JTextField) {

					if (((JTextField) j).isShowing()) {
						switch ((j.getName() + "")) {

						case "codigo": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.codigo LIKE '" + txtCodigo.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.codigo LIKE '" + txtCodigo.getText() + "%'";
								}
							}
							break;
						}

						case "nombre": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.nombre LIKE '" + txtNombre.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.nombre LIKE '" + txtNombre.getText() + "%'";
								}
							}
							break;
						}

						case "apellido": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.apellido LIKE '" + txtApellido.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.apellido LIKE '" + txtApellido.getText() + "%'";
								}
							}
							break;
						}

						case "dni": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.dni LIKE '" + txtDni.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.dni LIKE '" + txtDni.getText() + "%'";
								}
							}
							break;
						}

						case "edad": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.edad LIKE '" + txtEdad.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.edad LIKE '" + txtEdad.getText() + "%'";
								}
							}
							break;
						}

						case "celular": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.celular LIKE '" + txtCelular.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.celular LIKE '" + txtCelular.getText() + "%'";
								}
							}
							break;
						}

						case "direccion": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.direccion LIKE '" + txtDireccion.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.direccion LIKE '" + txtDireccion.getText() + "%'";
								}
							}
							break;
						}

						case "correo": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "e.correo LIKE '" + txtCorreo.getText() + "%'" + " AND ";
								} else {
									searchFilter += "e.correo LIKE '" + txtCorreo.getText() + "%'";
								}
							}
							break;
						}

						case "edadRangoMIN": {
							if (numVisibleComponent != 0) {
								try {
									count++;
									int min = Integer.parseInt(txtEdadRangoMIN.getText());
									int max = Integer.parseInt(txtEdadRangoMAX.getText());
									if (count < numVisibleComponent) {
										searchFilter += "e.edad between " + min + " AND " + max + " AND ";
									} else {
										searchFilter += "e.edad between " + min + " AND " + max;
									}
								} catch (NumberFormatException e) {

								}

							}
							break;
						}

						}
					}

				} else if (j instanceof JComboBox) {

					if (((JComboBox) j).isShowing()) {

						switch ((j.getName() + "")) {

						case "comboCargo": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "c.descripcion = ?" + " AND ";
									listaFiltro.add(cboCargo.getSelectedItem() + "");
								} else {
									searchFilter += "c.descripcion = ?";
									listaFiltro.add(cboCargo.getSelectedItem() + "");
								}
							}
							break;
						}
						case "comboSede": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "s.descripcion = ?" + " AND ";
									listaFiltro.add(cboSede.getSelectedItem() + "");
								} else {
									searchFilter += "s.descripcion = ?";
									listaFiltro.add(cboSede.getSelectedItem() + "");
								}
							}
							break;
						}

						case "comboEstCivil": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "est.descripcion = ?" + " AND ";
									listaFiltro.add(cboEstCivil.getSelectedItem() + "");
								} else {
									searchFilter += "est.descripcion = ?";
									listaFiltro.add(cboEstCivil.getSelectedItem() + "");
								}
							}
							break;
						}

						case "comboGenero": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "g.descripcion = ?" + " AND ";
									listaFiltro.add(cboGenero.getSelectedItem() + "");
								} else {
									searchFilter += "g.descripcion = ?";
									listaFiltro.add(cboGenero.getSelectedItem() + "");
								}
							}
							break;
						}

						}

					}
				} else if (j instanceof JDateChooser) {
					if (((JDateChooser) j).isShowing()) {
						String fecha = null;
						SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
						Date date = dCFechaNac.getDate();
						if (!(date == null)) {
							fecha = sdf.format(date);
						}

						switch ((j.getName() + "")) {

						case "fechaNacInicio": {
							if (numVisibleComponent != 0) {
								count++;
								if (count < numVisibleComponent) {
									searchFilter += "fechaNacimiento = ?" + " AND ";
									listaFiltro.add(fecha + "");
								} else {
									searchFilter += "fechaNacimiento = ?";
									listaFiltro.add(fecha + "");
								}
							}

							break;
						}

						case "fechaRangoComienzo": {
							if (numVisibleComponent != 0) {
								try {
									count++;
									String comienzo = "";
									String fin = "";
									if (!(dCFechaRangoComienzo.getDate() == null)
											|| !(dCFechaRangoFin.getDate() == null)) {
										comienzo = sdf.format(dCFechaRangoComienzo.getDate());
										fin = sdf.format(dCFechaRangoFin.getDate());
									}
									if (count < numVisibleComponent) {
										searchFilter += "fechaNacimiento between '" + comienzo + "' AND '" + fin
												+ "' AND ";
									} else {
										searchFilter += "fechaNacimiento between '" + comienzo + "' AND '" + fin + "'";
									}
								} catch (NumberFormatException e) {

								}

							}
							break;
						}
						}

					}

				}
			}
		}

		searchFilter += ";";
		return searchFilter;
	}

	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == tbEmpleados) {
			do_tbEmpleados_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnFiltros) {
			do_btnFiltros_mouseEntered(e);
		}
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnFiltros) {
			do_btnFiltros_mouseExited(e);
		}
		if (e.getSource() == btnConsultar) {
			do_btnConsultar_mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_tbEmpleados_mouseClicked(MouseEvent e) {
		int fila = tbEmpleados.rowAtPoint(e.getPoint());
		int columna = tbEmpleados.columnAtPoint(e.getPoint());
		tbEmpleados.changeSelection(fila, columna, false, false);
		String code = (String) tbEmpleados.getValueAt(tbEmpleados.getSelectedRow(), 0);
		Object[] obj = { fila, columna, code };

		if (columna == 13) {
			principal.modi(obj, "regiEmp");
		}
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

		if (txtNombre.getText().matches(Validaciones.TEXTO)) {
			txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtApellido_focusLost(FocusEvent e) {

		if (txtApellido.getText().matches(Validaciones.TEXTO)) {
			txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}
	}

	protected void do_txtDni_focusLost(FocusEvent e) {

		if (txtDni.getText().matches(Validaciones.DNI_CONSULTA)) {
			txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtCelular_focusLost(FocusEvent e) {

		if (txtCelular.getText().matches(Validaciones.CELULAR_CONSULTA)) {
			txtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}

	}

	protected void do_txtCorreo_focusLost(FocusEvent e) {

		if (txtCorreo.getText().matches(Validaciones.TEXTO)) {
			txtCorreo.setBorder(new MatteBorder(0, 0, 1, 0, (Color.BLACK)));
		} else {
			txtCorreo.setBorder(new MatteBorder(0, 0, 1, 0, (Color.RED)));
		}
	}

	protected void do_txtDireccion_focusLost(FocusEvent e) {

		if (txtDireccion.getText().matches(Validaciones.DIRECCION_CONSULTA)) {
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

	protected void do_chckbxCodigo_actionPerformed(ActionEvent e) {
		if (chckbxCodigo.isSelected()) {
			pText.add(pTxts1);
			pTxts1.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts1);
			pText.updateUI();
		}
	}

	protected void do_chckbxNombre_actionPerformed(ActionEvent e) {
		if (chckbxNombre.isSelected()) {
			pText.add(pTxts2);
			pTxts2.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts2);
			pText.updateUI();
		}
	}

	protected void do_chckbxApellido_actionPerformed(ActionEvent e) {
		if (chckbxApellido.isSelected()) {
			pText.add(pTxts3);
			pTxts3.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts3);
			pText.updateUI();
		}
	}

	protected void do_chckbxDni_actionPerformed(ActionEvent e) {
		if (chckbxDni.isSelected()) {
			pText.add(pTxts4);
			pTxts4.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts4);
			pText.updateUI();
		}
	}

	protected void do_chckbxEdad_actionPerformed(ActionEvent e) {
		if (chckbxEdad.isSelected()) {
			pText.add(pTxts5);
			pTxts5.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
			pFiltros.add(chckbxEdadRango, (chckbxFechaNacRango.isShowing()) ? 7 : 6);
			pFiltros.updateUI();
		} else {
			pFiltros.remove(chckbxEdadRango);
			pText.remove(pTxts16);
			pText.remove(pTxts5);
			pText.updateUI();
		}
	}

	protected void do_chckbxEdadRango_actionPerformed(ActionEvent e) {
		if (chckbxEdadRango.isSelected()) {
			pText.remove(pTxts5);
			pText.add(pTxts16);
			pTxts16.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts16);
			pText.add(pTxts5);
			pTxts5.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		}
	}

	protected void do_chckbxFechaNacimiento_actionPerformed(ActionEvent e) {
		if (chckbxFechaNacimiento.isSelected()) {
			pText.add(pTxts6);
			pTxts6.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
			pFiltros.add(chckbxFechaNacRango, 5);
			pFiltros.updateUI();
		} else {
			pFiltros.remove(chckbxFechaNacRango);
			pText.remove(pTxts6);
			pText.remove(pTxts17);
			pText.updateUI();
		}
	}

	protected void do_chckbxFechaNacRango_actionPerformed(ActionEvent e) {
		if (chckbxFechaNacRango.isSelected()) {
			pText.remove(pTxts6);
			pText.add(pTxts17);
			pTxts17.setPreferredSize(new Dimension(pText.getWidth(), 65));
			pText.updateUI();
		} else {
			pText.remove(pTxts17);
			pText.add(pTxts6);
			pTxts6.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		}
	}

	protected void do_chckbxGenero_actionPerformed(ActionEvent e) {
		if (chckbxGenero.isSelected()) {
			pText.add(pTxts7);
			pTxts7.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts7);
			pText.updateUI();
		}
	}

	protected void do_chckbxEstCivil_actionPerformed(ActionEvent e) {
		if (chckbxEstCivil.isSelected()) {
			pText.add(pTxts8);
			pTxts8.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts8);
			pText.updateUI();
		}
	}

	protected void do_chckbxCelular_actionPerformed(ActionEvent e) {
		if (chckbxCelular.isSelected()) {
			pText.add(pTxts9);
			pTxts9.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts9);
			pText.updateUI();
		}
	}

	protected void do_chckbxCorreo_actionPerformed(ActionEvent e) {
		if (chckbxCorreo.isSelected()) {
			pText.add(pTxts11);
			pTxts11.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts11);
			pText.updateUI();
		}
	}

	protected void do_chckbxDireccion_actionPerformed(ActionEvent e) {
		if (chckbxDireccion.isSelected()) {
			pText.add(pTxts10);
			pTxts10.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts10);
			pText.updateUI();
		}
	}

	protected void do_chckbxCargo_actionPerformed(ActionEvent e) {
		if (chckbxCargo.isSelected()) {
			pText.add(pTxts13);
			pTxts13.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts13);
			pText.updateUI();
		}
	}

	protected void do_chckbxSede_actionPerformed(ActionEvent e) {
		if (chckbxSede.isSelected()) {
			pText.add(pTxts14);
			pTxts14.setPreferredSize(new Dimension(pText.getWidth(), 30));
			pText.updateUI();
		} else {
			pText.remove(pTxts14);
			pText.updateUI();
		}
	}

	public void componentAdded(ContainerEvent e) {
		if (e.getSource() == pTxts000) {
			do_pTxts000_componentAdded(e);
		}
	}

	public void componentRemoved(ContainerEvent e) {
	}

	protected void do_pTxts000_componentAdded(ContainerEvent e) {
		pTxts000.setPreferredSize(new Dimension(pText.getWidth(), 30));
	}

	protected void do_btnFiltros_actionPerformed(ActionEvent e) {
		if (pFiltros.isVisible()) {
			pFiltros.setVisible(false);

		} else {
			pFiltros.setVisible(true);
			pFiltros.updateUI();
		}

	}

	public void internalFrameActivated(InternalFrameEvent e) {
		if (e.getSource() == this) {
			do_this_internalFrameActivated(e);
		}

	}

	private void do_this_internalFrameActivated(InternalFrameEvent e) {
		cargarCargos();
		cargarSedes();
		cargarEstCivil();
		cargarGenero();
		construirTabla(numOrder);
		// cargarC();

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
		if (e.getSource() == this) {
			do_this_internalFrameOpened(e);
		}
	}

	protected void do_this_internalFrameOpened(InternalFrameEvent e) {
		ModifyThread mT = new ModifyThread(pTxts000, pTxtsFilter, pText, "allComponetResize");
		Thread ttt = new Thread(mT);
		ttt.start();
	}

	protected void do_btnConsultar_actionPerformed(ActionEvent e) {
		validarConsulta();
	}

	void validarConsulta() {
		boolean ingreso = true;
		ArrayList<JComponent> cList = cargarListaTXT();
		for (JComponent j : cList) {
			if (j.isShowing()) {

				if (j instanceof JTextField) {
					if (((JTextField) j).getText().equals("")) {
						JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Error en la consulta",
								JOptionPane.WARNING_MESSAGE);
						ingreso = false;
						break;
					}
				} else if (j instanceof JComboBox) {
					if (((JComboBox) j).getSelectedItem().equals("SELECCIONAR....")) {
						JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Error en la consulta",
								JOptionPane.WARNING_MESSAGE);
						ingreso = false;
						break;
					}

				} else if (j instanceof JDateChooser) {
					if (((JDateChooser) j).getDate() == null) {
						JOptionPane.showMessageDialog(null, "No puede dejar campos vacios", "Error en la consulta",
								JOptionPane.WARNING_MESSAGE);
						ingreso = false;
						break;
					}
				}
			}

		}

		if (ingreso) {
			construirTablaFiltro();
		}
	}

	protected void do_btnConsultar_mouseEntered(MouseEvent e) {
		if (btnConsultar.isEnabled()) {
			btnConsultar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnConsultar_mouseExited(MouseEvent e) {
		if (btnConsultar.isEnabled()) {
			btnConsultar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnFiltros_mouseEntered(MouseEvent e) {
		if (btnFiltros.isEnabled()) {
			btnFiltros.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnFiltros_mouseExited(MouseEvent e) {
		if (btnFiltros.isEnabled()) {
			btnFiltros.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}
}
