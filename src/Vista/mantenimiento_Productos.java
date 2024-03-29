package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import Entidad.Audifonos;
import Entidad.AudifonosG;
import Entidad.CamaraWeb;
import Entidad.Celular;
import Entidad.Clientes;
import Entidad.Consolas;
import Entidad.Empleados;
import Entidad.Juegos;
import Entidad.Laptop;
import Entidad.LaptopG;
import Entidad.Mandos;
import Entidad.Microfono;
import Entidad.Mouse;
import Entidad.MouseG;
import Entidad.PCEscritorio;
import Entidad.PCGamer;
import Entidad.Parlantes;
import Entidad.SillaG;
import Entidad.Tablet;
import Entidad.TecladoG;
import Entidad.Teclados;
import Entidad.Televisor;
import Mantenimiento.GestionAudifonosDAO;
import Mantenimiento.GestionAudifonosGamerDAO;
import Mantenimiento.GestionCamaraWebDAO;
import Mantenimiento.GestionCategoriaDAO;
import Mantenimiento.GestionCelularDAO;
import Mantenimiento.GestionConsolasDAO;
import Mantenimiento.GestionJuegosDAO;
import Mantenimiento.GestionLaptopDAO;
import Mantenimiento.GestionLaptopGamerDAO;
import Mantenimiento.GestionMandosDAO;
import Mantenimiento.GestionMicrofonoDAO;
import Mantenimiento.GestionMouseDAO;
import Mantenimiento.GestionMouseGamerDAO;
import Mantenimiento.GestionPCEscritorioDAO;
import Mantenimiento.GestionPCGamerDAO;
import Mantenimiento.GestionParlanteDAO;
import Mantenimiento.GestionSillaGamerDAO;
import Mantenimiento.GestionTabletDAO;
import Mantenimiento.GestionTecladoDAO;
import Mantenimiento.GestionTecladoGamerDAO;
import Mantenimiento.GestionTelevisorDAO;
import Utils.ModifyThread;
import Utils.cboProperties;
import Utils.editCells;
import Utils.editColumns;
import Utils.tableModel;
import Utils.typeUtility;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.event.InternalFrameListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.event.InternalFrameEvent;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class mantenimiento_Productos extends JInternalFrame
		implements ActionListener, InternalFrameListener, MouseListener {
	private JPanel panelCbo;
	private JPanel panelTabla;
	private JPanel panelEAST;
	private JLabel lblNewLabel;
	private JComboBox cboCategoria;
	private JLabel lblNewLabel_1;
	private JLabel lblProductos;
	private JComboBox cboProductos;
	private JPanel panelNorth;
	private JPanel panelButtons;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTable tbProductos;
	private JScrollPane scrollPane;

	private Empleados trabajador;

	private tableModel modelo;
	private String opcionAceptar = "";

	private ArrayList<Object> listaTitulos;
	private ArrayList listaProductos;

	private GestionConsolasDAO gConsolas = new GestionConsolasDAO();
	private GestionJuegosDAO gJuegos = new GestionJuegosDAO();
	private GestionMandosDAO gMandos = new GestionMandosDAO();

	private GestionAudifonosGamerDAO gAudGamer = new GestionAudifonosGamerDAO();
	private GestionSillaGamerDAO gSillaGamer = new GestionSillaGamerDAO();
	private GestionPCGamerDAO gPcGamer = new GestionPCGamerDAO();
	private GestionLaptopGamerDAO gLapGamer = new GestionLaptopGamerDAO();
	private GestionMouseGamerDAO gMouseGamer = new GestionMouseGamerDAO();
	private GestionTecladoGamerDAO gTecGamer = new GestionTecladoGamerDAO();

	private GestionCelularDAO gCelular = new GestionCelularDAO();
	private GestionTelevisorDAO gTelevisor = new GestionTelevisorDAO();
	private GestionParlanteDAO gParlante = new GestionParlanteDAO();
	private GestionAudifonosDAO gAudifonos = new GestionAudifonosDAO();
	private GestionPCEscritorioDAO gPcEscritorio = new GestionPCEscritorioDAO();
	private GestionLaptopDAO gLaptop = new GestionLaptopDAO();
	private GestionTabletDAO gTablet = new GestionTabletDAO();
	private GestionMouseDAO gMouse = new GestionMouseDAO();
	private GestionMicrofonoDAO gMicrofono = new GestionMicrofonoDAO();
	private GestionCamaraWebDAO gCamWeb = new GestionCamaraWebDAO();
	private GestionTecladoDAO gTeclado = new GestionTecladoDAO();

	private JPanel panelSouth;
	private JLabel lblCountEmp;
	private JPanel totalPanel;
	private JPanel panelEAST_CENTER;
	private JPanel CENTERCENTER;
	private JPanel pnCodigo;
	private JPanel pnPantalla;
	private JLabel lblNewLabel_356;
	private JLabel lblNewLabel_3;
	private JLabel txtCodigo;
	private JTextField txtPantalla;
	private JPanel pnNombre;
	private JLabel lblNewLabel_4;
	private JTextField txtNombre;
	private JPanel pnModelo;
	private JLabel lblNewLabel_5;
	private JTextField txtModelo;
	private JPanel pnColor;
	private JLabel lblNewLabel_6;
	private JTextField txtColor;
	private JPanel pnPrecio;
	private JLabel lblNewLabel_7;
	private JTextField txtPrecio;
	private JPanel pnPlataforma;
	private JLabel lblNewLabel_8;
	private JTextField txtPlataforma;
	private JPanel pnStock;
	private JLabel lblNewLabel_9;
	private JTextField txtStock;
	private JPanel pnDesarrolladora;
	private JLabel lblNewLabel_10;
	private JTextField txtDesarrolladora;
	private JPanel pnMarca;
	private JLabel lblNewLabel_11;
	private JTextField txtMarca;
	private JPanel pnTipoConex;
	private JLabel lblNewLabel_12;
	private JTextField txtTipoConexion;
	private JPanel pnDescripcion;
	private JLabel lblNewLabel_13;
	private JTextField txtDescripcion;
	private JPanel pnProcesador;
	private JLabel lblNewLabel_14;
	private JTextField txtProcesador;
	private JPanel pnDiscoDuro;
	private JLabel lblNewLabel_15;
	private JTextField txtDiscoDuro;
	private JPanel pnPlacaMadre;
	private JLabel lblNewLabel_16;
	private JTextField txtPlacaMadre;
	private JPanel pnTarjVideo;
	private JLabel lblNewLabel_17;
	private JTextField txtTarjetaVideo;
	private JPanel pnFuentePoder;
	private JLabel lblNewLabel_18;
	private JTextField txtFuentePoder;
	private JPanel pnRefrigeracion;
	private JLabel lblNewLabel_19;
	private JTextField txtRefrigeracion;
	private JPanel pnSize;
	private JLabel lblNewLabel_20;
	private JTextField txtSize;
	private JPanel pnButtons;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mantenimiento_Productos frame = new mantenimiento_Productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mantenimiento_Productos() {
		addInternalFrameListener(this);
		setClosable(true);
		setTitle("Mantenimiento Productos");
		setIconifiable(true);
		setBounds(100, 100, 774, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(new Color(224, 255, 255));

		totalPanel = new JPanel();
		totalPanel.setBackground(new Color(224, 255, 255));
		getContentPane().add(totalPanel, BorderLayout.CENTER);
		totalPanel.setLayout(new BorderLayout(0, 0));

		panelNorth = new JPanel();
		panelNorth.setOpaque(false);
		totalPanel.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));

		panelCbo = new JPanel();
		panelCbo.setOpaque(false);
		panelCbo.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 6));
		panelNorth.add(panelCbo);

		lblNewLabel = new JLabel("CATEGOR\u00CDA");
		panelCbo.add(lblNewLabel);

		cboCategoria = new JComboBox();
		cboCategoria.addActionListener(this);
		cboCategoria.setOpaque(false);
		cboCategoria.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboCategoria.setBackground(new Color(224, 255, 255));
		cboCategoria.setUI(cboProperties.createUI(rootPane));
		cboCategoria.setModel(
				new DefaultComboBoxModel(new String[] { "SELECCIONAR....", "VIDEOJUEGOS", "GAMING", "ELECTRONICA" }));
		panelCbo.add(cboCategoria);

		lblNewLabel_1 = new JLabel("   ");
		panelCbo.add(lblNewLabel_1);

		lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setVisible(false);
		panelCbo.add(lblProductos);

		cboProductos = new JComboBox();
		cboProductos.addActionListener(this);
		cboProductos.setOpaque(false);
		cboProductos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboProductos.setBackground(new Color(224, 255, 255));
		cboProductos.setUI(cboProperties.createUI(rootPane));
		cboProductos.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));
		cboProductos.setVisible(false);
		panelCbo.add(cboProductos);

		panelTabla = new JPanel();
		panelTabla.setOpaque(false);
		totalPanel.add(panelTabla, BorderLayout.CENTER);
		panelTabla.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		panelTabla.add(scrollPane);

		tbProductos = new JTable();
		tbProductos = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};

		tbProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbProductos);

		panelSouth = new JPanel();
		panelSouth.setOpaque(false);
		panelTabla.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new BorderLayout(0, 0));

		lblCountEmp = new JLabel("");
		panelSouth.add(lblCountEmp, BorderLayout.EAST);

		panelEAST = new JPanel();
		panelEAST.setOpaque(false);
		totalPanel.add(panelEAST, BorderLayout.EAST);
		panelEAST.setLayout(new BorderLayout(5, 5));

		panelEAST_CENTER = new JPanel();
		panelEAST_CENTER.setOpaque(false);
		panelEAST.add(panelEAST_CENTER, BorderLayout.CENTER);
		panelEAST_CENTER.setLayout(new BorderLayout(0, 0));

		panelButtons = new JPanel();
		panelButtons.setOpaque(false);
		panelButtons.setVisible(false);
		panelButtons.setLayout(new GridLayout(0, 1, 0, 2));
		panelEAST_CENTER.add(panelButtons, BorderLayout.NORTH);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(this);
		btnNuevo.addActionListener(this);
		btnNuevo.setFocusable(false);
		btnNuevo.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnNuevo.setContentAreaFilled(false);
		panelButtons.add(btnNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFocusable(false);
		btnModificar.addMouseListener(this);
		btnModificar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnModificar.setContentAreaFilled(false);
		panelButtons.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFocusable(false);
		btnEliminar.addMouseListener(this);
		btnEliminar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnEliminar.setContentAreaFilled(false);
		panelButtons.add(btnEliminar);

		CENTERCENTER = new JPanel();
		CENTERCENTER.setOpaque(false);
		CENTERCENTER.setPreferredSize(new Dimension(120, 10));
		panelEAST_CENTER.add(CENTERCENTER, BorderLayout.CENTER);
		CENTERCENTER.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));

		pnCodigo = new JPanel();
		pnCodigo.setPreferredSize(new Dimension(230, 30));
		pnCodigo.setAlignmentY(Component.TOP_ALIGNMENT);
		pnCodigo.setOpaque(false);
		pnCodigo.setLayout(null);

		lblNewLabel_3 = new JLabel("CODIGO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(5, 2, 86, 25);
		pnCodigo.add(lblNewLabel_3);

		txtCodigo = new JLabel();
		txtCodigo.setBounds(120, 2, 105, 25);
		pnCodigo.add(txtCodigo);

		pnPantalla = new JPanel();
		pnPantalla.setPreferredSize(new Dimension(230, 30));
		pnPantalla.setAlignmentY(Component.TOP_ALIGNMENT);
		pnPantalla.setOpaque(false);
		pnPantalla.setLayout(null);

		lblNewLabel_356 = new JLabel("PANTALLA");
		lblNewLabel_356.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_356.setBounds(5, 2, 86, 25);
		pnPantalla.add(lblNewLabel_356);

		txtPantalla = new JTextField();
		txtPantalla.setBounds(120, 2, 105, 25);
		pnPantalla.add(txtPantalla);

		pnButtons = new JPanel();
		pnButtons.setLayout(null);
		pnButtons.setPreferredSize(new Dimension(230, 30));
		pnButtons.setOpaque(false);
		pnButtons.setAlignmentY(0.0f);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.addMouseListener(this);
		btnCancelar.setBounds(118, 3, 106, 23);
		btnCancelar.setFocusable(false);
		btnCancelar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setOpaque(false);
		pnButtons.add(btnCancelar);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnAceptar.setBounds(6, 3, 106, 23);
		btnAceptar.setFocusable(false);
		btnAceptar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnAceptar.setContentAreaFilled(false);

		pnButtons.add(btnAceptar);

		pnNombre = new JPanel();
		pnNombre.setPreferredSize(new Dimension(230, 30));
		pnNombre.setAlignmentY(0.0f);
		pnNombre.setOpaque(false);
		pnNombre.setLayout(null);

		lblNewLabel_4 = new JLabel("NOMBRE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(5, 2, 86, 25);
		pnNombre.add(lblNewLabel_4);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 2, 105, 25);
		txtNombre.setColumns(10);
		pnNombre.add(txtNombre);

		pnModelo = new JPanel();
		pnModelo.setLayout(null);
		pnModelo.setPreferredSize(new Dimension(230, 30));
		pnModelo.setOpaque(false);
		pnModelo.setAlignmentY(0.0f);

		lblNewLabel_5 = new JLabel("MODELO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(5, 2, 86, 25);
		pnModelo.add(lblNewLabel_5);

		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(120, 2, 105, 25);
		pnModelo.add(txtModelo);

		pnColor = new JPanel();
		pnColor.setLayout(null);
		pnColor.setPreferredSize(new Dimension(230, 30));
		pnColor.setOpaque(false);
		pnColor.setAlignmentY(0.0f);

		lblNewLabel_6 = new JLabel("COLOR");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(5, 2, 86, 25);
		pnColor.add(lblNewLabel_6);

		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(120, 2, 105, 25);
		pnColor.add(txtColor);

		pnPrecio = new JPanel();
		pnPrecio.setLayout(null);
		pnPrecio.setPreferredSize(new Dimension(230, 30));
		pnPrecio.setOpaque(false);
		pnPrecio.setAlignmentY(0.0f);

		lblNewLabel_7 = new JLabel("PRECIO");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(5, 2, 86, 25);
		pnPrecio.add(lblNewLabel_7);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(120, 2, 105, 25);
		pnPrecio.add(txtPrecio);

		pnStock = new JPanel();
		pnStock.setLayout(null);
		pnStock.setPreferredSize(new Dimension(230, 30));
		pnStock.setOpaque(false);
		pnStock.setAlignmentY(0.0f);

		lblNewLabel_9 = new JLabel("STOCK");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_9.setBounds(5, 2, 86, 25);
		pnStock.add(lblNewLabel_9);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(120, 2, 105, 25);
		pnStock.add(txtStock);

		pnDesarrolladora = new JPanel();
		pnDesarrolladora.setLayout(null);
		pnDesarrolladora.setPreferredSize(new Dimension(230, 30));
		pnDesarrolladora.setOpaque(false);
		pnDesarrolladora.setAlignmentY(0.0f);

		lblNewLabel_10 = new JLabel("DESARROLLADORA");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(5, 2, 110, 25);
		pnDesarrolladora.add(lblNewLabel_10);

		txtDesarrolladora = new JTextField();
		txtDesarrolladora.setColumns(10);
		txtDesarrolladora.setBounds(120, 2, 105, 25);
		pnDesarrolladora.add(txtDesarrolladora);

		pnPlataforma = new JPanel();
		pnPlataforma.setLayout(null);
		pnPlataforma.setPreferredSize(new Dimension(230, 30));
		pnPlataforma.setOpaque(false);
		pnPlataforma.setAlignmentY(0.0f);

		lblNewLabel_8 = new JLabel("PLATAFORMA");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(5, 2, 86, 25);
		pnPlataforma.add(lblNewLabel_8);

		txtPlataforma = new JTextField();
		txtPlataforma.setColumns(10);
		txtPlataforma.setBounds(120, 2, 105, 25);
		pnPlataforma.add(txtPlataforma);

		pnMarca = new JPanel();
		pnMarca.setLayout(null);
		pnMarca.setPreferredSize(new Dimension(230, 30));
		pnMarca.setOpaque(false);
		pnMarca.setAlignmentY(0.0f);

		lblNewLabel_11 = new JLabel("MARCA");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_11.setBounds(5, 2, 86, 25);
		pnMarca.add(lblNewLabel_11);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(120, 2, 105, 25);
		pnMarca.add(txtMarca);

		pnTipoConex = new JPanel();
		pnTipoConex.setLayout(null);
		pnTipoConex.setPreferredSize(new Dimension(230, 30));
		pnTipoConex.setOpaque(false);
		pnTipoConex.setAlignmentY(0.0f);

		lblNewLabel_12 = new JLabel("TIPO CONEXION");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(5, 2, 86, 25);
		pnTipoConex.add(lblNewLabel_12);

		txtTipoConexion = new JTextField();
		txtTipoConexion.setColumns(10);
		txtTipoConexion.setBounds(120, 2, 105, 25);
		pnTipoConex.add(txtTipoConexion);

		pnDescripcion = new JPanel();
		pnDescripcion.setLayout(null);
		pnDescripcion.setPreferredSize(new Dimension(230, 30));
		pnDescripcion.setOpaque(false);
		pnDescripcion.setAlignmentY(0.0f);

		lblNewLabel_13 = new JLabel("DESCRIPCION");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_13.setBounds(5, 2, 86, 25);
		pnDescripcion.add(lblNewLabel_13);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(120, 2, 105, 25);
		pnDescripcion.add(txtDescripcion);

		pnProcesador = new JPanel();
		pnProcesador.setLayout(null);
		pnProcesador.setPreferredSize(new Dimension(230, 30));
		pnProcesador.setOpaque(false);
		pnProcesador.setAlignmentY(0.0f);

		lblNewLabel_14 = new JLabel("PROCESADOR");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_14.setBounds(5, 2, 86, 25);
		pnProcesador.add(lblNewLabel_14);

		txtProcesador = new JTextField();
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(120, 2, 105, 25);
		pnProcesador.add(txtProcesador);

		pnDiscoDuro = new JPanel();
		pnDiscoDuro.setLayout(null);
		pnDiscoDuro.setPreferredSize(new Dimension(230, 30));
		pnDiscoDuro.setOpaque(false);
		pnDiscoDuro.setAlignmentY(0.0f);

		lblNewLabel_15 = new JLabel("DISCO DURO");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_15.setBounds(5, 2, 86, 25);
		pnDiscoDuro.add(lblNewLabel_15);

		txtDiscoDuro = new JTextField();
		txtDiscoDuro.setColumns(10);
		txtDiscoDuro.setBounds(120, 2, 105, 25);
		pnDiscoDuro.add(txtDiscoDuro);

		pnPlacaMadre = new JPanel();
		pnPlacaMadre.setLayout(null);
		pnPlacaMadre.setPreferredSize(new Dimension(230, 30));
		pnPlacaMadre.setOpaque(false);
		pnPlacaMadre.setAlignmentY(0.0f);

		lblNewLabel_16 = new JLabel("PLACA MADRE");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_16.setBounds(5, 2, 86, 25);
		pnPlacaMadre.add(lblNewLabel_16);

		txtPlacaMadre = new JTextField();
		txtPlacaMadre.setColumns(10);
		txtPlacaMadre.setBounds(120, 2, 105, 25);
		pnPlacaMadre.add(txtPlacaMadre);

		pnTarjVideo = new JPanel();
		pnTarjVideo.setLayout(null);
		pnTarjVideo.setPreferredSize(new Dimension(230, 30));
		pnTarjVideo.setOpaque(false);
		pnTarjVideo.setAlignmentY(0.0f);

		lblNewLabel_17 = new JLabel("TARJ. VIDEO");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_17.setBounds(5, 2, 86, 25);
		pnTarjVideo.add(lblNewLabel_17);

		txtTarjetaVideo = new JTextField();
		txtTarjetaVideo.setColumns(10);
		txtTarjetaVideo.setBounds(120, 2, 105, 25);
		pnTarjVideo.add(txtTarjetaVideo);

		pnFuentePoder = new JPanel();
		pnFuentePoder.setLayout(null);
		pnFuentePoder.setPreferredSize(new Dimension(230, 30));
		pnFuentePoder.setOpaque(false);
		pnFuentePoder.setAlignmentY(0.0f);

		lblNewLabel_18 = new JLabel("FUENTE PODER");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_18.setBounds(5, 2, 86, 25);
		pnFuentePoder.add(lblNewLabel_18);

		txtFuentePoder = new JTextField();
		txtFuentePoder.setColumns(10);
		txtFuentePoder.setBounds(120, 2, 105, 25);
		pnFuentePoder.add(txtFuentePoder);

		pnRefrigeracion = new JPanel();
		pnRefrigeracion.setLayout(null);
		pnRefrigeracion.setPreferredSize(new Dimension(230, 30));
		pnRefrigeracion.setOpaque(false);
		pnRefrigeracion.setAlignmentY(0.0f);

		lblNewLabel_19 = new JLabel("REFRIGERACION");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_19.setBounds(5, 2, 86, 25);
		pnRefrigeracion.add(lblNewLabel_19);

		txtRefrigeracion = new JTextField();
		txtRefrigeracion.setColumns(10);
		txtRefrigeracion.setBounds(120, 2, 105, 25);
		pnRefrigeracion.add(txtRefrigeracion);

		pnSize = new JPanel();
		pnSize.setLayout(null);
		pnSize.setPreferredSize(new Dimension(230, 30));
		pnSize.setOpaque(false);
		pnSize.setAlignmentY(0.0f);

		lblNewLabel_20 = new JLabel("SIZE");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_20.setBounds(5, 2, 86, 25);
		pnSize.add(lblNewLabel_20);

		txtSize = new JTextField();
		txtSize.setColumns(10);
		txtSize.setBounds(120, 2, 105, 25);
		pnSize.add(txtSize);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == cboProductos) {
			do_cboProductos_actionPerformed(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_actionPerformed(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_actionPerformed(e);
		}
		if (e.getSource() == cboCategoria) {
			do_cboCategoria_actionPerformed(e);
		}
	}

	protected void do_cboCategoria_actionPerformed(ActionEvent e) {
		String categoria = cboCategoria.getSelectedItem() + "";
		if (categoria.equals("SELECCIONAR....")) {
			cboProductos.removeAllItems();
			lblProductos.setVisible(false);
			cboProductos.setVisible(false);
		} else {

			switch (categoria) {

			case "VIDEOJUEGOS":
				cboProductos.removeAllItems();
				cboProductos.addItem("SELECCIONAR....");
				cboProductos.addItem("CONSOLAS");
				cboProductos.addItem("JUEGOS");
				cboProductos.addItem("MANDOS");
				lblProductos.setVisible(true);
				cboProductos.setVisible(true);
				break;

			case "GAMING":
				cboProductos.removeAllItems();
				cboProductos.addItem("SELECCIONAR....");
				cboProductos.addItem("AUDIFONOSGAMER");
				cboProductos.addItem("SILLASGAMER");
				cboProductos.addItem("PCGAMER");
				cboProductos.addItem("LAPTOPGAMER");
				cboProductos.addItem("MOUSEGAMER");
				cboProductos.addItem("TECLADOSGAMER");
				lblProductos.setVisible(true);
				cboProductos.setVisible(true);
				break;

			case "ELECTRONICA":
				cboProductos.removeAllItems();
				cboProductos.addItem("SELECCIONAR....");
				cboProductos.addItem("CELULARES");
				cboProductos.addItem("TELEVISORES");
				cboProductos.addItem("PARLANTES");
				cboProductos.addItem("AUDIFONOS");
				cboProductos.addItem("PC");
				cboProductos.addItem("LAPTOP");
				cboProductos.addItem("TABLET");
				cboProductos.addItem("MOUSE");
				cboProductos.addItem("MICROFONOS");
				cboProductos.addItem("CAMARAWEB");
				cboProductos.addItem("TECLADOS");
				lblProductos.setVisible(true);
				cboProductos.setVisible(true);
				break;

			default:
				break;
			}
		}
	}

	private void construirTabla(String name) {
		listaProductos = cargarProductos(name);
		listaTitulos = cargarColumnas(name);

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility(name);

		Object[][] data = obtenerMatrizDatos(listaTitulos, name, util);

		construirTabla(titulos, data, name, util);
		lblCountEmp.setText("Numero de " + name + " Encontrados:  " + tbProductos.getRowCount() + "   ");
	}

	private void construirTabla(String[] titulos, Object[][] data, String name, typeUtility util) {
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
		tbProductos.setModel(modelo);

		// Se asigna el tipo de dato que tendra cada celda
		if (name.equalsIgnoreCase("consolas")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getNombre()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getColor()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getColor()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("juegos")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getNombre()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDesarrolladora()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPlataforma()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDesarrolladora()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlataforma()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("mandos")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getNombre()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("audifonosgamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("sillasgamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("pcgamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("laptopgamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getSize()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getSize()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("mousegamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("tecladosgamer")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("celulares")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("televisores")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("parlantes")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("audifonos")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("pc")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("laptop")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPantalla()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPantalla()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("tablet")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("mouse")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		}

		else if (name.equalsIgnoreCase("microfonos")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		}

		else if (name.equalsIgnoreCase("camaraweb")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else if (name.equalsIgnoreCase("teclados")) {

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getMarca()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getModelo()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setCellRenderer(new editCells("texto"));
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setCellRenderer(new editCells("numerico"));
			tbProductos.getColumnModel().getColumn(util.getStock()).setCellRenderer(new editCells("numerico"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else {
			JOptionPane.showMessageDialog(null, "ERROR EN CONTRUIR TABLA TITULOS");
		}
	}

	private Object[][] obtenerMatrizDatos(ArrayList<Object> listaTitulos2, String name, typeUtility util) {

		if (name.equalsIgnoreCase("consolas")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Consolas) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Consolas) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getModelo()] = ((Consolas) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getColor()] = ((Consolas) listaProductos.get(x)).getColor() + "";
				informacion[x][util.getPrecio()] = ((Consolas) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Consolas) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("juegos")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Juegos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Juegos) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getDesarrolladora()] = ((Juegos) listaProductos.get(x)).getDesarrolladora() + "";
				informacion[x][util.getPlataforma()] = ((Juegos) listaProductos.get(x)).getPlataforma() + "";
				informacion[x][util.getPrecio()] = ((Juegos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Juegos) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mandos")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Mandos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Mandos) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getMarca()] = ((Mandos) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getTipoconex()] = ((Mandos) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Mandos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Mandos) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("audifonosgamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((AudifonosG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((AudifonosG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((AudifonosG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((AudifonosG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((AudifonosG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((AudifonosG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((AudifonosG) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("sillasgamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((SillaG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((SillaG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((SillaG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((SillaG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((SillaG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((SillaG) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("pcgamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((PCGamer) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getProcesador()] = ((PCGamer) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getDiscoduro()] = ((PCGamer) listaProductos.get(x)).getDiscoduro() + "";
				informacion[x][util.getPlacamadre()] = ((PCGamer) listaProductos.get(x)).getPlacamadre() + "";
				informacion[x][util.getTarjetavideo()] = ((PCGamer) listaProductos.get(x)).getTarjVideo() + "";
				informacion[x][util.getFuentepoder()] = ((PCGamer) listaProductos.get(x)).getFuentePoder() + "";
				informacion[x][util.getRefrigeracion()] = ((PCGamer) listaProductos.get(x)).getRefrigeracion() + "";
				informacion[x][util.getPrecio()] = ((PCGamer) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((PCGamer) listaProductos.get(x)).getStock() + "";
			}
			return informacion;
		} else if (name.equalsIgnoreCase("laptopgamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((LaptopG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((LaptopG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((LaptopG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((LaptopG) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getTarjetavideo()] = ((LaptopG) listaProductos.get(x)).getTarjVideo() + "";
				informacion[x][util.getSize()] = ((LaptopG) listaProductos.get(x)).getSize() + "";
				informacion[x][util.getPrecio()] = ((LaptopG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((LaptopG) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mousegamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((MouseG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((MouseG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((MouseG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((MouseG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((MouseG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((MouseG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((MouseG) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("tecladosgamer")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((TecladoG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((TecladoG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((TecladoG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((TecladoG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((TecladoG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((TecladoG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((TecladoG) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("celulares")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Celular) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Celular) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Celular) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Celular) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Celular) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Celular) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("televisores")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Televisor) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Televisor) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Televisor) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Televisor) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Televisor) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Televisor) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("parlantes")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Parlantes) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Parlantes) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Parlantes) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Parlantes) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Parlantes) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Parlantes) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Parlantes) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("audifonos")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Audifonos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Audifonos) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Audifonos) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Audifonos) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Audifonos) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Audifonos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Audifonos) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("pc")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((PCEscritorio) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getProcesador()] = ((PCEscritorio) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getDiscoduro()] = ((PCEscritorio) listaProductos.get(x)).getDiscoduro() + "";
				informacion[x][util.getPlacamadre()] = ((PCEscritorio) listaProductos.get(x)).getPlacamadre() + "";
				informacion[x][util.getTarjetavideo()] = ((PCEscritorio) listaProductos.get(x)).getTarjetavideo() + "";
				informacion[x][util.getFuentepoder()] = ((PCEscritorio) listaProductos.get(x)).getFuentepoder() + "";
				informacion[x][util.getRefrigeracion()] = ((PCEscritorio) listaProductos.get(x)).getRefrigeracion()
						+ "";
				informacion[x][util.getPrecio()] = ((PCEscritorio) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((PCEscritorio) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("laptop")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Laptop) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Laptop) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Laptop) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((Laptop) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getTarjetavideo()] = ((Laptop) listaProductos.get(x)).getTarjetavideo() + "";
				informacion[x][util.getPantalla()] = ((Laptop) listaProductos.get(x)).getPantalla() + "";
				informacion[x][util.getPrecio()] = ((Laptop) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Laptop) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("tablet")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Tablet) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Tablet) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Tablet) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((Tablet) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getDescripcion()] = ((Tablet) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Tablet) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Tablet) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mouse")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Mouse) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Mouse) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Mouse) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Mouse) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Mouse) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Mouse) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Mouse) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("microfonos")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Microfono) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Microfono) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Microfono) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getTipoconex()] = ((Microfono) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Microfono) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Microfono) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("camaraweb")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((CamaraWeb) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((CamaraWeb) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((CamaraWeb) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getTipoconex()] = ((CamaraWeb) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((CamaraWeb) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((CamaraWeb) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else if (name.equalsIgnoreCase("teclados")) {
			String informacion[][] = new String[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Teclados) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Teclados) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Teclados) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Teclados) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Teclados) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Teclados) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Teclados) listaProductos.get(x)).getStock() + "";
			}
			return informacion;

		} else {
			JOptionPane.showMessageDialog(null, "ERROR EN OBTENER MATRIZ PRODUCTO NO ENCONTRADO");
		}
		return null;
	}

	private ArrayList<Object> cargarColumnas(String prod) {
		if (prod.equalsIgnoreCase("consolas")) {
			ArrayList<Object> lista = gConsolas.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("juegos")) {
			ArrayList<Object> lista = gJuegos.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("mandos")) {
			ArrayList<Object> lista = gMandos.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("audifonosgamer")) {
			ArrayList<Object> lista = gAudGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("sillasgamer")) {
			ArrayList<Object> lista = gSillaGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("pcgamer")) {
			ArrayList<Object> lista = gPcGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("laptopgamer")) {
			ArrayList<Object> lista = gLapGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("mousegamer")) {
			ArrayList<Object> lista = gMouseGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("tecladosgamer")) {
			ArrayList<Object> lista = gTecGamer.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("celulares")) {
			ArrayList<Object> lista = gCelular.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("televisores")) {
			ArrayList<Object> lista = gTelevisor.leerColumnas();
			return lista;
		} else if (prod.equalsIgnoreCase("parlantes")) {
			ArrayList<Object> lista = gParlante.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("audifonos")) {
			ArrayList<Object> lista = gAudifonos.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("pc")) {
			ArrayList<Object> lista = gPcEscritorio.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("laptop")) {
			ArrayList<Object> lista = gLaptop.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("tablet")) {
			ArrayList<Object> lista = gTablet.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("mouse")) {
			ArrayList<Object> lista = gMouse.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("microfonos")) {
			ArrayList<Object> lista = gMicrofono.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("camaraweb")) {
			ArrayList<Object> lista = gCamWeb.leerColumnas();
			return lista;

		} else if (prod.equalsIgnoreCase("teclados")) {
			ArrayList<Object> lista = gTeclado.leerColumnas();
			return lista;
		}
		return null;
	}

	private ArrayList cargarProductos(String prod) {
		if (prod.equalsIgnoreCase("consolas")) {
			ArrayList<Consolas> lista = gConsolas.leerConsolas();
			return lista;

		} else if (prod.equalsIgnoreCase("juegos")) {
			ArrayList<Juegos> lista = gJuegos.leerJuegos();
			return lista;

		} else if (prod.equalsIgnoreCase("mandos")) {
			ArrayList<Mandos> lista = gMandos.leerMandos();
			return lista;
		} else if (prod.equalsIgnoreCase("audifonosgamer")) {
			ArrayList<AudifonosG> lista = gAudGamer.leerAudifonosGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("sillasgamer")) {
			ArrayList<SillaG> lista = gSillaGamer.leerSillaGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("pcgamer")) {
			ArrayList<PCGamer> lista = gPcGamer.leerPCGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("laptopgamer")) {
			ArrayList<LaptopG> lista = gLapGamer.leerLaptopGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("mousegamer")) {
			ArrayList<MouseG> lista = gMouseGamer.leerMouseGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("tecladosgamer")) {
			ArrayList<TecladoG> lista = gTecGamer.leerTecladoGamer();
			return lista;

		} else if (prod.equalsIgnoreCase("celulares")) {
			ArrayList<Celular> lista = gCelular.leerCelular();
			return lista;

		} else if (prod.equalsIgnoreCase("televisores")) {
			ArrayList<Televisor> lista = gTelevisor.leerTelevisor();
			return lista;
		} else if (prod.equalsIgnoreCase("parlantes")) {
			ArrayList<Parlantes> lista = gParlante.leerParlante();
			return lista;

		} else if (prod.equalsIgnoreCase("audifonos")) {
			ArrayList<Audifonos> lista = gAudifonos.leerAudifono();
			return lista;

		} else if (prod.equalsIgnoreCase("pc")) {
			ArrayList<PCEscritorio> lista = gPcEscritorio.leerPCEscritorio();
			return lista;

		} else if (prod.equalsIgnoreCase("laptop")) {
			ArrayList<Laptop> lista = gLaptop.leerLaptop();
			return lista;

		} else if (prod.equalsIgnoreCase("tablet")) {
			ArrayList<Tablet> lista = gTablet.leerTablet();
			return lista;

		} else if (prod.equalsIgnoreCase("mouse")) {
			ArrayList<Mouse> lista = gMouse.leerMouse();
			return lista;

		} else if (prod.equalsIgnoreCase("microfonos")) {
			ArrayList<Microfono> lista = gMicrofono.leerMicrofono();
			return lista;

		} else if (prod.equalsIgnoreCase("camaraweb")) {
			ArrayList<CamaraWeb> lista = gCamWeb.leerCamaraWeb();
			return lista;

		} else if (prod.equalsIgnoreCase("teclados")) {
			ArrayList<Teclados> lista = gTeclado.leerTeclado();
			return lista;
		}
		return null;
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
		if (e.getSource() == this) {
			do_this_internalFrameOpened(e);
		}
	}

	private void do_this_internalFrameOpened(InternalFrameEvent e) {

	}

	protected void do_this_internalFrameActivated(InternalFrameEvent e) {
		activarRestrinccionesCargo();
	}

	// --------------------------------------------------------------
	protected void do_btnNuevo_actionPerformed(ActionEvent e) {
		if (cboProductos.getSelectedIndex() == 0 || !cboProductos.isEnabled()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de producto", "ERROR!!",
					JOptionPane.WARNING_MESSAGE);
		} else {
			opcionAceptar = "nuevo";
			CENTERCENTER.setPreferredSize(new Dimension(230, 10));
			cboCategoria.setEnabled(false);
			cboProductos.setEnabled(false);
			panelButtons.setVisible(false);
			tbProductos.setEnabled(false);
			cargarPnTxt((cboProductos.getSelectedItem() + "").toLowerCase());
			CENTERCENTER.updateUI();
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		if (cboProductos.getSelectedIndex() == 0 || !cboProductos.isEnabled()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de producto", "ERROR!!",
					JOptionPane.WARNING_MESSAGE);
		} else if (tbProductos.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "ERROR!!", JOptionPane.WARNING_MESSAGE);
		} else {
			opcionAceptar = "modificar";
			CENTERCENTER.setPreferredSize(new Dimension(230, 10));
			cboCategoria.setEnabled(false);
			cboProductos.setEnabled(false);
			panelButtons.setVisible(false);
			tbProductos.setEnabled(true);
			cargarPnTxt((cboProductos.getSelectedItem() + "").toLowerCase());
			CENTERCENTER.updateUI();
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {

		int pos = tbProductos.getSelectedRow();
		if (pos != -1) {
			int OK = JOptionPane.showConfirmDialog(null,
					"Se Eliminaran los datos seleccionados\n>>ACCION NO REVERSIBLE<<", "¿Desea continuar?",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (OK == 0) {
				String prod = (cboProductos.getSelectedItem() + "").toLowerCase().trim();

				switch (prod) {
				case "consolas":
					Consolas tempConsolas = new Consolas();
					tempConsolas.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gConsolas.EliminarConsolas(tempConsolas);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Consolas");
					break;

				case "juegos":
					Juegos tempJuegos = new Juegos();
					tempJuegos.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gJuegos.EliminarJuegos(tempJuegos);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Juegos");
					break;

				case "mandos":
					Mandos tempMandos = new Mandos();
					tempMandos.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gMandos.EliminarMandos(tempMandos);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Mandos");
					break;

				case "audifonosgamer":
					AudifonosG tempAudGamer = new AudifonosG();
					tempAudGamer.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gAudGamer.EliminarAudifonosGamer(tempAudGamer);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("AudifonosGamer");
					break;

				case "sillasgamer":
					SillaG tempSillaGamer = new SillaG();
					tempSillaGamer.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gSillaGamer.EliminarSillaGamer(tempSillaGamer);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("SillasGamer");
					break;

				case "pcgamer":
					PCGamer tempPcGamer = new PCGamer();
					tempPcGamer.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gPcGamer.EliminarPCGamer(tempPcGamer);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("PCGamer");
					break;

				case "laptopgamer":
					LaptopG tempLapGamer = new LaptopG();
					tempLapGamer.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gLapGamer.EliminarLaptopGamer(tempLapGamer);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("LaptopGamer");
					break;

				case "mousegamer":
					MouseG tempMouseG = new MouseG();
					tempMouseG.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gMouseGamer.EliminarMouseGamer(tempMouseG);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("MouseGamer");
					break;

				case "tecladosgamer":
					TecladoG tempTecGamer = new TecladoG();
					tempTecGamer.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gTecGamer.EliminarTecladoGamer(tempTecGamer);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("TecladosGamer");
					break;

				case "celulares":
					Celular tempCelu = new Celular();
					tempCelu.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gCelular.EliminarCelular(tempCelu);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Celulares");
					break;

				case "televisores":
					Televisor tempTelevisor = new Televisor();
					tempTelevisor.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gTelevisor.EliminarTelevisor(tempTelevisor);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Televisores");
					break;

				case "parlantes":
					Parlantes tempParlante = new Parlantes();
					tempParlante.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gParlante.EliminarParlante(tempParlante);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Parlantes");
					break;

				case "audifonos":
					Audifonos temAudifonos = new Audifonos();
					temAudifonos.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gAudifonos.EliminarAudifono(temAudifonos);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Audifonos");
					break;

				case "pc":
					PCEscritorio tempPc = new PCEscritorio();
					tempPc.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gPcEscritorio.EliminarPCEscritorio(tempPc);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("PC");
					break;

				case "laptop":
					Laptop tempLaptop = new Laptop();
					tempLaptop.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gLaptop.EliminarLaptop(tempLaptop);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Laptop");
					break;

				case "tablet":
					Tablet tempTablet = new Tablet();
					tempTablet.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gTablet.EliminarTablet(tempTablet);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Tablet");
					break;

				case "mouse":
					Mouse tempMouse = new Mouse();
					tempMouse.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gMouse.EliminarMouse(tempMouse);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Mouse");
					break;

				case "microfonos":
					Microfono tempMicro = new Microfono();
					tempMicro.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gMicrofono.EliminarMicrofono(tempMicro);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Microfonos");
					break;

				case "camaraweb":
					CamaraWeb tempCamWeb = new CamaraWeb();
					tempCamWeb.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gCamWeb.EliminarCamaraWeb(tempCamWeb);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("CamaraWeb");
					break;

				case "teclados":
					Teclados tempTeclados = new Teclados();
					tempTeclados.setCodigo((String) tbProductos.getValueAt(pos, 0));
					gTeclado.EliminarTeclado(tempTeclados);
					JOptionPane.showMessageDialog(null, "Los datos han sido elimidados exitosamente");
					construirTabla("Teclados");
					break;

				default:
					break;
				}

			}

		} else {
			JOptionPane.showMessageDialog(null, "Debe elegir un producto!", "ERROR!!", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void cargarPnTxt(String prod) {
		switch (prod) {

		case "consolas":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnNombre);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnColor);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtNombre.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtColor.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "juegos":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnNombre);
			CENTERCENTER.add(pnDesarrolladora);
			CENTERCENTER.add(pnPlataforma);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtNombre.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtDesarrolladora.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtPlataforma.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "mandos":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnNombre);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtNombre.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "audifonosgamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "sillasgamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "pcgamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnProcesador);
			CENTERCENTER.add(pnDiscoDuro);
			CENTERCENTER.add(pnPlacaMadre);
			CENTERCENTER.add(pnTarjVideo);
			CENTERCENTER.add(pnFuentePoder);
			CENTERCENTER.add(pnRefrigeracion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtProcesador.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtDiscoDuro.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtPlacaMadre.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTarjetaVideo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtFuentePoder.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtRefrigeracion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 7).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 8).toString());
			}
			break;

		case "laptopgamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnProcesador);
			CENTERCENTER.add(pnTarjVideo);
			CENTERCENTER.add(pnSize);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtProcesador.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTarjetaVideo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtSize.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 7).toString());
			}
			break;

		case "mousegamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "tecladosgamer":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "celulares":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "televisores":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "parlantes":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "audifonos":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "pc":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnProcesador);
			CENTERCENTER.add(pnDiscoDuro);
			CENTERCENTER.add(pnPlacaMadre);
			CENTERCENTER.add(pnTarjVideo);
			CENTERCENTER.add(pnFuentePoder);
			CENTERCENTER.add(pnRefrigeracion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtProcesador.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtDiscoDuro.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtPlacaMadre.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTarjetaVideo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtFuentePoder.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtRefrigeracion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 7).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 8).toString());
			}
			break;

		case "laptop":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnProcesador);
			CENTERCENTER.add(pnTarjVideo);
			CENTERCENTER.add(pnPantalla);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtProcesador.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTarjetaVideo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPantalla.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 7).toString());
			}
			break;

		case "tablet":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnProcesador);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtProcesador.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "mouse":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		case "microfonos":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "camaraweb":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
			}
			break;

		case "teclados":
			CENTERCENTER.removeAll();
			CENTERCENTER.add(pnCodigo);
			CENTERCENTER.add(pnMarca);
			CENTERCENTER.add(pnModelo);
			CENTERCENTER.add(pnDescripcion);
			CENTERCENTER.add(pnTipoConex);
			CENTERCENTER.add(pnPrecio);
			CENTERCENTER.add(pnStock);
			CENTERCENTER.add(pnButtons);
			if (opcionAceptar.equalsIgnoreCase("modificar")) {
				txtCodigo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 0).toString());
				txtMarca.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 1).toString());
				txtModelo.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 2).toString());
				txtDescripcion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 3).toString());
				txtTipoConexion.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 4).toString());
				txtPrecio.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 5).toString());
				txtStock.setText(tbProductos.getValueAt(tbProductos.getSelectedRow(), 6).toString());
			}
			break;

		default:
			throw new IllegalArgumentException("No se ha encontrado el producto en la carga de pn: " + prod);
		}
	}

	// -------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------
	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		limpiarTodo();
	}

	protected void do_btnAceptar_actionPerformed(ActionEvent e) {
		String prod = (cboProductos.getSelectedItem() + "").toLowerCase();

		if (opcionAceptar.equalsIgnoreCase("nuevo")) {
			switch (prod) {
			case "consolas":
				Consolas tempConsolas = new Consolas();
				tempConsolas.setCodigo(generarCodigoProducto(prod));
				tempConsolas.setNombre(txtNombre.getText());
				tempConsolas.setModelo(txtModelo.getText());
				tempConsolas.setColor(txtColor.getText());
				tempConsolas.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempConsolas.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat1 = new GestionCategoriaDAO();
				tempConsolas.setCategoria(
						gCat1.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result1 = gConsolas.registrarConsolas(tempConsolas);
				if (result1 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Consolas");
				}
				limpiarTodo();
				break;

			case "juegos":
				Juegos tempJuegos = new Juegos();
				tempJuegos.setCodigo(generarCodigoProducto(prod));
				tempJuegos.setNombre(txtNombre.getText());
				tempJuegos.setDesarrolladora(txtDesarrolladora.getText());
				tempJuegos.setPlataforma(txtPlataforma.getText());
				tempJuegos.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempJuegos.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat2 = new GestionCategoriaDAO();
				tempJuegos.setCategoria(
						gCat2.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result2 = gJuegos.registrarJuegos(tempJuegos);
				if (result2 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Juegos");
				}
				break;

			case "mandos":
				Mandos tempMandos = new Mandos();
				tempMandos.setCodigo(generarCodigoProducto(prod));
				tempMandos.setNombre(txtNombre.getText());
				tempMandos.setMarca(txtMarca.getText());
				tempMandos.setTipoconex(txtTipoConexion.getText());
				tempMandos.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempMandos.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat3 = new GestionCategoriaDAO();
				tempMandos.setCategoria(
						gCat3.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result3 = gMandos.registrarMandos(tempMandos);
				if (result3 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Mandos");
				}
				break;

			case "audifonosgamer": {
				AudifonosG tempAudGamer = new AudifonosG();
				tempAudGamer.setCodigo(generarCodigoProducto(prod));
				tempAudGamer.setMarca(txtMarca.getText());
				tempAudGamer.setModelo(txtModelo.getText());
				tempAudGamer.setDescripcion(txtDescripcion.getText());
				tempAudGamer.setTipoconex(txtTipoConexion.getText());
				tempAudGamer.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempAudGamer.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				tempAudGamer.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gAudGamer.registrarAudifonosGamer(tempAudGamer);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("AudifonosGamer");
				}
			}
				break;

			case "sillasgamer": {
				SillaG temporal = new SillaG();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gSillaGamer.registrarSillaGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("SillasGamer");
				}
			}
				break;

			case "pcgamer": {
				PCGamer temporal = new PCGamer();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDiscoduro(txtDiscoDuro.getText());
				temporal.setPlacamadre(txtPlacaMadre.getText());
				temporal.setTarjVideo(txtTarjetaVideo.getText());
				temporal.setFuentePoder(txtFuentePoder.getText());
				temporal.setRefrigeracion(txtRefrigeracion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gPcGamer.registrarPCGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("PCGamer");
				}
			}
				break;

			case "laptopgamer": {
				LaptopG temporal = new LaptopG();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setTarjVideo(txtTarjetaVideo.getText());
				temporal.setSize(txtSize.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gLapGamer.registrarLaptopGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("LaptopGamer");
				}
			}
				break;

			case "mousegamer": {
				MouseG temporal = new MouseG();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMouseGamer.registrarMouseGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("MouseGamer");
				}
			}
				break;

			case "tecladosgamer": {
				TecladoG temporal = new TecladoG();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTecGamer.registrarTecladoGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("TecladosGamer");
				}
			}
				break;

			case "celulares": {
				Celular temporal = new Celular();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gCelular.registrarCelular(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Celulares");
				}
			}
				break;

			case "televisores": {
				Televisor temporal = new Televisor();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTelevisor.registrarTelevisor(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Televisores");
				}
			}
				break;

			case "parlantes": {
				Parlantes temporal = new Parlantes();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gParlante.registrarParlante(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Parlantes");
				}
			}
				break;

			case "audifonos": {
				Audifonos temporal = new Audifonos();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gAudifonos.registrarAudifono(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Audifonos");
				}
			}
				break;

			case "pc": {
				PCEscritorio temporal = new PCEscritorio();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDiscoduro(txtDiscoDuro.getText());
				temporal.setPlacamadre(txtPlacaMadre.getText());
				temporal.setTarjetavideo(txtTarjetaVideo.getText());
				temporal.setFuentepoder(txtFuentePoder.getText());
				temporal.setRefrigeracion(txtRefrigeracion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gPcEscritorio.registrarPCEscritorio(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("PC");
				}
			}
				break;

			case "laptop": {
				Laptop temporal = new Laptop();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setTarjetavideo(txtTarjetaVideo.getText());
				temporal.setPantalla(txtPantalla.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gLaptop.registrarLaptop(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Laptop");
				}
			}
				break;

			case "tablet": {
				Tablet temporal = new Tablet();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTablet.registrarTablet(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Tablet");
				}
			}
				break;

			case "mouse": {
				Mouse temporal = new Mouse();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMouse.registrarMouse(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Mouse");
				}
			}
				break;

			case "microfonos": {
				Microfono temporal = new Microfono();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMicrofono.registrarMicrofono(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Microfonos");
				}
			}
				break;

			case "camaraweb": {
				CamaraWeb temporal = new CamaraWeb();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gCamWeb.registrarCamaraWeb(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("CamaraWeb");
				}
			}
				break;

			case "teclados": {
				Teclados temporal = new Teclados();
				temporal.setCodigo(generarCodigoProducto(prod));
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTeclado.registrarTeclado(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "NUEVO PRODUCTO REGISTRADO!!",
							"PRODUCTO REGISTRADO EXITOSAMENTE", 1);
					construirTabla("Teclados");
				}
			}
				break;

			default:
				JOptionPane.showMessageDialog(null, "ERROR!!", "PRODUCTO NO ENCONTRADO - ACCION REGISTRAR", 1);
				break;
			}

		} else if (opcionAceptar.equalsIgnoreCase("modificar")) {
			switch (prod) {

			case "consolas":
				Consolas tempConsolas = new Consolas();
				tempConsolas.setCodigo(txtCodigo.getText());
				tempConsolas.setNombre(txtNombre.getText());
				tempConsolas.setModelo(txtModelo.getText());
				tempConsolas.setColor(txtColor.getText());
				tempConsolas.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempConsolas.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat1 = new GestionCategoriaDAO();
				tempConsolas.setCategoria(
						gCat1.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result1 = gConsolas.actualizarConsolas(tempConsolas);
				if (result1 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Consolas");
				}
				limpiarTodo();
				break;

			case "juegos":
				Juegos tempJuegos = new Juegos();
				tempJuegos.setCodigo(txtCodigo.getText());
				tempJuegos.setNombre(txtNombre.getText());
				tempJuegos.setDesarrolladora(txtDesarrolladora.getText());
				tempJuegos.setPlataforma(txtPlataforma.getText());
				tempJuegos.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempJuegos.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat2 = new GestionCategoriaDAO();
				tempJuegos.setCategoria(
						gCat2.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result2 = gJuegos.actualizarJuegos(tempJuegos);
				if (result2 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Juegos");
				}
				break;

			case "mandos":
				Mandos tempMandos = new Mandos();
				tempMandos.setCodigo(txtCodigo.getText());
				tempMandos.setNombre(txtNombre.getText());
				tempMandos.setMarca(txtMarca.getText());
				tempMandos.setTipoconex(txtTipoConexion.getText());
				tempMandos.setPrecio(Double.parseDouble(txtPrecio.getText()));
				tempMandos.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat3 = new GestionCategoriaDAO();
				tempMandos.setCategoria(
						gCat3.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());
				int result3 = gMandos.actualizarMandos(tempMandos);
				if (result3 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Mandos");
				}
				break;

			case "audifonosgamer": {
				AudifonosG temporal = new AudifonosG();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gAudGamer.actualizarAudifonosGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("AudifonosGamer");
				}
			}
				break;

			case "sillasgamer": {
				SillaG temporal = new SillaG();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gSillaGamer.actualizarSillaGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("SillasGamer");
				}
			}
				break;

			case "pcgamer": {
				PCGamer temporal = new PCGamer();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDiscoduro(txtDiscoDuro.getText());
				temporal.setPlacamadre(txtPlacaMadre.getText());
				temporal.setTarjVideo(txtTarjetaVideo.getText());
				temporal.setFuentePoder(txtFuentePoder.getText());
				temporal.setRefrigeracion(txtRefrigeracion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gPcGamer.actualizarPCGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("PCGamer");
				}
			}
				break;

			case "laptopgamer": {
				LaptopG temporal = new LaptopG();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setTarjVideo(txtTarjetaVideo.getText());
				temporal.setSize(txtSize.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gLapGamer.actualizarLaptopGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("LaptopGamer");
				}
			}
				break;

			case "mousegamer": {
				MouseG temporal = new MouseG();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMouseGamer.actualizarMouseGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("MouseGamer");
				}
			}
				break;

			case "tecladosgamer": {
				TecladoG temporal = new TecladoG();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTecGamer.actualizarTecladoGamer(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("TecladosGamer");
				}
			}
				break;

			case "celulares": {
				Celular temporal = new Celular();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gCelular.actualizarCelular(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Celulares");
				}
			}
				break;

			case "televisores": {
				Televisor temporal = new Televisor();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTelevisor.actualizarTelevisor(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Televisores");
				}
			}
				break;

			case "parlantes": {
				Parlantes temporal = new Parlantes();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gParlante.actualizarParlante(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Parlantes");
				}
			}
				break;

			case "audifonos": {
				Audifonos temporal = new Audifonos();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gAudifonos.actualizarAudifono(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Audifonos");
				}
			}
				break;

			case "pc": {
				PCEscritorio temporal = new PCEscritorio();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDiscoduro(txtDiscoDuro.getText());
				temporal.setPlacamadre(txtPlacaMadre.getText());
				temporal.setTarjetavideo(txtTarjetaVideo.getText());
				temporal.setFuentepoder(txtFuentePoder.getText());
				temporal.setRefrigeracion(txtRefrigeracion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gPcEscritorio.actualizarPCEscritorio(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("PC");
				}
			}
				break;

			case "laptop": {
				Laptop temporal = new Laptop();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setTarjetavideo(txtTarjetaVideo.getText());
				temporal.setPantalla(txtPantalla.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gLaptop.actualizarLaptop(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Laptop");
				}
			}
				break;

			case "tablet": {
				Tablet temporal = new Tablet();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setProcesador(txtProcesador.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTablet.actualizarTablet(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Tablet");
				}
			}
				break;

			case "mouse": {
				Mouse temporal = new Mouse();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMouse.actualizarMouse(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Mouse");
				}
			}
				break;

			case "microfonos": {
				Microfono temporal = new Microfono();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gMicrofono.actualizarMicrofono(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Microfonos");
				}
			}
				break;

			case "camaraweb": {
				CamaraWeb temporal = new CamaraWeb();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gCamWeb.actualizarCamaraWeb(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("CamaraWeb");
				}
			}
				break;

			case "teclados": {
				Teclados temporal = new Teclados();
				temporal.setCodigo(txtCodigo.getText());
				temporal.setMarca(txtMarca.getText());
				temporal.setModelo(txtModelo.getText());
				temporal.setDescripcion(txtDescripcion.getText());
				temporal.setTipoconex(txtTipoConexion.getText());
				temporal.setPrecio(Double.parseDouble(txtPrecio.getText()));
				temporal.setStock(Integer.parseInt(txtStock.getText()));
				GestionCategoriaDAO gCat4 = new GestionCategoriaDAO();
				temporal.setCategoria(
						gCat4.buscarCodigoCategoria((cboCategoria.getSelectedItem() + "").toLowerCase()).getCodigo());

				int result4 = gTeclado.actualizarTeclado(temporal);
				if (result4 != 0) {
					JOptionPane.showMessageDialog(null, "PRODUCTO MODIFICADO CON EXITO!!", "MODIFICACION", 1);
					construirTabla("Teclados");
				}
			}
				break;

			default:
				JOptionPane.showMessageDialog(null, "ERROR!!", "PRODUCTO NO ENCONTRADO - ACCION MODIFICAR", 1);
				break;
			}
		}
	}

	private void limpiarTodo() {
		CENTERCENTER.removeAll();
		CENTERCENTER.setPreferredSize(new Dimension(120, 10));
		cboCategoria.setEnabled(true);
		cboProductos.setEnabled(true);
		panelButtons.setVisible(true);
		tbProductos.setEnabled(true);

		txtCodigo.setText("");
		txtColor.setText("");
		txtDesarrolladora.setText("");
		txtDescripcion.setText("");
		txtDiscoDuro.setText("");
		txtFuentePoder.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtNombre.setText("");
		txtPlacaMadre.setText("");
		txtPlataforma.setText("");
		txtPantalla.setText("");
		txtPrecio.setText("");
		txtProcesador.setText("");
		txtRefrigeracion.setText("");
		txtSize.setText("");
		txtStock.setText("");
		txtTarjetaVideo.setText("");
		txtTipoConexion.setText("");

	}

	private String generarCodigoProducto(String name) {
		int numProd = -1;
		String codProd = "";

		switch (name) {
		case "consolas":
			numProd = ((Consolas) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "CN";
			break;

		case "juegos":
			numProd = ((Juegos) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "JG";
			break;

		case "mandos":
			numProd = ((Mandos) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "MD";
			break;

		case "audifonosgamer":
			numProd = ((AudifonosG) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "AG";
			break;

		case "sillasgamer":
			numProd = ((SillaG) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "SG";
			break;

		case "pcgamer":
			numProd = ((PCGamer) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "PG";
			break;

		case "laptopgamer":
			numProd = ((LaptopG) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "LG";
			break;

		case "mousegamer":
			numProd = ((MouseG) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "MG";
			break;

		case "tecladosgamer":
			numProd = ((TecladoG) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "TG";
			break;

		case "celulares":
			numProd = ((Celular) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "CL";
			break;

		case "televisores":
			numProd = ((Televisor) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "TL";
			break;

		case "parlantes":
			numProd = ((Parlantes) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "PL";
			break;

		case "audifonos":
			numProd = ((Audifonos) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "AM";
			break;

		case "pc":
			numProd = ((PCEscritorio) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "PE";
			break;

		case "laptop":
			numProd = ((Laptop) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "LP";
			break;

		case "tablet":
			numProd = ((Tablet) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "TB";
			break;

		case "mouse":
			numProd = ((Mouse) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "MS";
			break;

		case "microfonos":
			numProd = ((Microfono) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "MC";
			break;

		case "camaraweb":
			numProd = ((CamaraWeb) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "CW";
			break;

		case "teclados":
			numProd = ((Teclados) listaProductos.get(listaProductos.size() - 1)).getCodigo_() + 1;
			codProd = "TO";
			break;

		default:
			numProd = -1;
			codProd = "";
			break;
		}

		if (numProd < 10) {
			codProd += "00" + numProd;

		} else if (numProd < 100) {
			codProd += "0" + numProd;

		} else if (numProd < 1000) {
			codProd += numProd;
		}
		return codProd;
	}
	// -------------------------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------------------------

	protected void do_cboProductos_actionPerformed(ActionEvent e) {
		if (cboProductos.getSelectedIndex() == 0) {
			panelButtons.setVisible(false);
		} else {
			panelButtons.setVisible(true);
		}
		String prod = (cboProductos.getSelectedItem() + "").toLowerCase();
		switch (prod) {
		case "consolas":
			construirTabla("Consolas");
			break;

		case "juegos":
			construirTabla("Juegos");
			break;

		case "mandos":
			construirTabla("Mandos");
			break;

		case "audifonosgamer":
			construirTabla("AudifonosGamer");
			break;

		case "sillasgamer":
			construirTabla("SillasGamer");
			break;

		case "pcgamer":
			construirTabla("PCGamer");
			break;

		case "laptopgamer":
			construirTabla("LaptopGamer");
			break;

		case "mousegamer":
			construirTabla("MouseGamer");
			break;

		case "tecladosgamer":
			construirTabla("TecladosGamer");
			break;

		case "celulares":
			construirTabla("Celulares");
			break;

		case "televisores":
			construirTabla("Televisores");
			break;

		case "parlantes":
			construirTabla("Parlantes");
			break;

		case "audifonos":
			construirTabla("Audifonos");
			break;

		case "pc":
			construirTabla("PC");
			break;

		case "laptop":
			construirTabla("Laptop");
			break;

		case "tablet":
			construirTabla("Tablet");
			break;

		case "mouse":
			construirTabla("Mouse");
			break;

		case "microfonos":
			construirTabla("Microfonos");
			break;

		case "camaraweb":
			construirTabla("CamaraWeb");
			break;

		case "teclados":
			construirTabla("Teclados");
			break;

		}
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_mouseEntered(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseEntered(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_mouseEntered(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_mouseEntered(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnNuevo) {
			do_btnNuevo_mouseExited(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseExited(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_mouseExited(e);
		}
		if (e.getSource() == btnCancelar) {
			do_btnCancelar_mouseExited(e);
		}
		if (e.getSource() == btnAceptar) {
			do_btnAceptar_mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
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

	protected void do_btnAceptar_mouseEntered(MouseEvent e) {
		if (btnAceptar.isEnabled()) {
			btnAceptar.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnAceptar_mouseExited(MouseEvent e) {
		if (btnAceptar.isEnabled()) {
			btnAceptar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	private void activarRestrinccionesCargo() {

		if (frmPrincipal.trabajador != null) {
			trabajador = frmPrincipal.trabajador;
			if (trabajador.getCargo().equals("Supervisor") || trabajador.getCargo().equals("Gerente")) {
				btnNuevo.setEnabled(true);
				btnNuevo.setToolTipText("");

				btnEliminar.setEnabled(true);
				btnEliminar.setToolTipText("");

				btnModificar.setEnabled(true);
				btnModificar.setToolTipText("");

			} else {
				btnNuevo.setEnabled(false);
				btnNuevo.setToolTipText("ACCESO RESTRINGIDO\n NO CUMPLE CON EL RANGO NECESARIO");

				btnEliminar.setEnabled(false);
				btnEliminar.setToolTipText("ACCESO RESTRINGIDO\n NO CUMPLE CON EL RANGO NECESARIO");

				btnModificar.setEnabled(false);
				btnModificar.setToolTipText("ACCESO RESTRINGIDO\n NO CUMPLE CON EL RANGO NECESARIO");
			}

		}
	}

}
