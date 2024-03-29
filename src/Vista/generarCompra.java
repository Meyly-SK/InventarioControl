package Vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.text.pdf.codec.TiffImage;

import Entidad.Audifonos;
import Entidad.AudifonosG;
import Entidad.Boleta;
import Entidad.CamaraWeb;
import Entidad.Celular;
import Entidad.Consolas;
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
import Entidad.Proveedor;
import Entidad.SillaG;
import Entidad.Tablet;
import Entidad.TecladoG;
import Entidad.Teclados;
import Entidad.Televisor;
import Mantenimiento.GestionAudifonosDAO;
import Mantenimiento.GestionAudifonosGamerDAO;
import Mantenimiento.GestionBoletaDAO;
import Mantenimiento.GestionCamaraWebDAO;
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
import Utils.cboProperties;
import Utils.editCells;
import Utils.editColumns;
import Utils.tableModel;
import Utils.typeUtility;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class generarCompra extends JInternalFrame
		implements ActionListener, MouseListener, InternalFrameListener, FocusListener, JRDataSource {
	private JTable tbProductos;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel pnProveedor;
	private JPanel panel;
	private JButton btnSelectProveedor;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private static JLabel lblCodProveedor;
	private static JLabel lblRazonSocial;
	private static JLabel lblRucProveedor;
	private JPanel panel_1;
	private JPanel panel_6;
	private JPanel pnEmpleado;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNewLabel_4;
	private JPanel panel_9;
	private JLabel lblNewLabel_5;
	private JLabel lblCodEmpleado;
	private JPanel panel_10;
	private JLabel lblNewLabel_6;
	private JLabel lblNomEmpleado;
	private JPanel panel_11;
	private JLabel lblNewLabel_7;
	private JLabel lblDniEmpleado;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel pnNORTH;
	private JPanel pnCENTER;
	private JPanel pnSOUTH;

	ArrayList listaProductos;
	ArrayList listaTitulos;

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

	private GestionBoletaDAO gBoleta = new GestionBoletaDAO();

	private tableModel modelo;
	private JPanel pnSeleccionarProductos;
	private JPanel panel_16;
	private JPanel pnCboProducto;
	private JComboBox cboProducto;
	private JPanel panel_18;
	private JPanel pnAdd;
	private JButton btnAddToCart;
	private JPanel panel_19;
	private JLabel lblNewLabel_10;
	private JButton btnCloseList;
	private JTextArea txtadded;
	private JScrollPane scrollPane_1;

	private DefaultTableModel modeling = new DefaultTableModel();
	private ArrayList<Object[]> modelingRows = new ArrayList<Object[]>();
	private int numProd = 0;
	private int index = -1;
	private ArrayList<Object[]> detPdf;

	private JPanel panel_15;
	private JPanel pnListadoProductos;
	private JTable tbListado;
	private JLabel lblNewLabel_11;
	private JPanel pnListProductos;
	private JPanel panel_14;
	private JLabel lblNewLabel_12;
	private JPanel panel_17;
	private JPanel pnAdd_1;
	private JButton btnOpenInventory;
	private JButton btnProceder;
	private JPanel panel_20;
	private JPanel pnCboProducto_1;
	private JLabel lblNewLabel_14;
	private JScrollPane scrollPane_2;
	private JTable tbList;
	private JLabel lblImporteTotal;
	private JButton btnEliminar;

	private ActionListener actionImporte = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			calcularImporte();

		}

	};

	private Timer timeImport = new Timer(700, actionImporte);
	private JButton btnEmpty;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generarCompra frame = new generarCompra();
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
	public generarCompra() {
		setClosable(true);
		setIconifiable(true);
		setTitle("COMPRA PRODUCTOS");
		getContentPane().setBackground(new Color(224, 255, 255));
		addInternalFrameListener(this);
		setBounds(100, 100, 887, 489);
		getContentPane().setLayout(new BorderLayout(0, 0));

		pnCENTER = new JPanel();
		pnCENTER.setOpaque(false);
		getContentPane().add(pnCENTER, BorderLayout.CENTER);
		pnCENTER.setLayout(new BorderLayout(0, 0));

		pnListProductos = new JPanel();
		pnListProductos.setOpaque(false);
		pnCENTER.add(pnListProductos, BorderLayout.CENTER);
		pnListProductos.setLayout(new BorderLayout(0, 0));

		tbListado = new JTable();
		pnListProductos.add(tbListado);

		lblNewLabel_11 = new JLabel("");
		pnListProductos.add(lblNewLabel_11);

		panel_14 = new JPanel();
		panel_14.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout_2 = (FlowLayout) panel_14.getLayout();
		flowLayout_2.setVgap(3);
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_14.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		pnListProductos.add(panel_14, BorderLayout.NORTH);

		lblNewLabel_12 = new JLabel("Carrito de Productos     \u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		panel_14.add(lblNewLabel_12);

		btnEmpty = new JButton(" VACIAR CARRITO ");
		btnEmpty.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEmpty.setMargin(new Insets(1, 14, 1, 14));
		btnEmpty.addMouseListener(this);
		btnEmpty.addActionListener(this);

		lblNewLabel_8 = new JLabel(">>>");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.RED);
		panel_14.add(lblNewLabel_8);
		btnEmpty.setFocusable(false);
		btnEmpty.setBorder(null);
		btnEmpty.setContentAreaFilled(false);
		panel_14.add(btnEmpty);

		lblNewLabel_9 = new JLabel("<<<");
		lblNewLabel_9.setForeground(Color.RED);
		panel_14.add(lblNewLabel_9);

		panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_17.setSize(new Dimension(50, 0));
		panel_17.setPreferredSize(new Dimension(210, 10));
		pnListProductos.add(panel_17, BorderLayout.EAST);
		panel_17.setLayout(new BorderLayout(0, 0));

		pnAdd_1 = new JPanel();
		pnAdd_1.setOpaque(false);
		pnAdd_1.setBackground(Color.LIGHT_GRAY);
		panel_17.add(pnAdd_1, BorderLayout.SOUTH);
		pnAdd_1.setLayout(new GridLayout(0, 1, 0, 3));

		btnOpenInventory = new JButton("\u2500\u2500 ABRIR CATALOGO \u2500\u2500");
		btnOpenInventory.addMouseListener(this);
		btnOpenInventory.addActionListener(this);
		btnOpenInventory.setFocusable(false);
		btnOpenInventory.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnOpenInventory.setContentAreaFilled(false);
		pnAdd_1.add(btnOpenInventory);

		btnEliminar = new JButton("\u2500\u2500 ELIMINAR PRODUCTO \u2500\u2500");
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setFocusable(false);
		btnEliminar.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnEliminar.setContentAreaFilled(false);
		pnAdd_1.add(btnEliminar);

		btnProceder = new JButton("\u2500\u2500 PROCEDER CON LA COMPRA \u2500\u2500");
		btnProceder.addActionListener(this);
		btnProceder.addMouseListener(this);
		btnProceder.setFocusable(false);
		btnProceder.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnProceder.setContentAreaFilled(false);
		pnAdd_1.add(btnProceder);

		panel_20 = new JPanel();
		panel_20.setOpaque(false);
		panel_20.setBackground(Color.LIGHT_GRAY);
		panel_17.add(panel_20, BorderLayout.CENTER);

		pnCboProducto_1 = new JPanel();
		pnCboProducto_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pnCboProducto_1.setOpaque(false);
		panel_20.add(pnCboProducto_1);

		lblNewLabel_14 = new JLabel("IMPORTE TOTAL   ");
		pnCboProducto_1.add(lblNewLabel_14);

		lblImporteTotal = new JLabel("");
		pnCboProducto_1.add(lblImporteTotal);

		scrollPane_2 = new JScrollPane();
		pnListProductos.add(scrollPane_2, BorderLayout.CENTER);

		tbList = new JTable();
		tbList.addFocusListener(this);
		tbList.addMouseListener(this);
		tbList.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(tbList);

		pnSeleccionarProductos = new JPanel();
		pnSeleccionarProductos.setOpaque(false);
		// pnCENTER.add(pnSeleccionarProductos);
		pnSeleccionarProductos.setLayout(new BorderLayout(0, 0));

		panel_19 = new JPanel();
		panel_19.setBackground(Color.LIGHT_GRAY);
		panel_19.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panel_19.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnSeleccionarProductos.add(panel_19, BorderLayout.NORTH);

		lblNewLabel_10 = new JLabel("Seleccione los productos   \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		panel_19.add(lblNewLabel_10);

		panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_16.setPreferredSize(new Dimension(200, 10));
		panel_16.setSize(new Dimension(50, 0));
		pnSeleccionarProductos.add(panel_16, BorderLayout.EAST);
		panel_16.setLayout(new BorderLayout(0, 0));

		pnAdd = new JPanel();
		pnAdd.setOpaque(false);
		pnAdd.setBackground(Color.LIGHT_GRAY);
		panel_16.add(pnAdd, BorderLayout.SOUTH);
		pnAdd.setLayout(new GridLayout(0, 1, 0, 3));
		pnAdd.setVisible(true);

		btnAddToCart = new JButton("A\u00D1ADIR AL CARRITO");
		btnAddToCart.addMouseListener(this);
		btnAddToCart.addActionListener(this);
		btnAddToCart.setFocusable(false);
		btnAddToCart.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnAddToCart.setContentAreaFilled(false);
		btnAddToCart.setVisible(false);
		pnAdd.add(btnAddToCart);

		btnCloseList = new JButton("CERRAR LISTADO");
		btnCloseList.addMouseListener(this);
		btnCloseList.addActionListener(this);
		btnCloseList.setFocusable(false);
		btnCloseList.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnCloseList.setContentAreaFilled(false);
		pnAdd.add(btnCloseList);

		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_18.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_18.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_16.add(panel_18);

		pnCboProducto = new JPanel();
		pnCboProducto.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Productos",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCboProducto.setOpaque(false);
		panel_18.add(pnCboProducto);

		cboProducto = new JComboBox();
		cboProducto.addActionListener(this);
		cboProducto.setOpaque(false);
		cboProducto.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		cboProducto.setBackground(new Color(224, 255, 255));
		cboProducto.setUI(cboProperties.createUI(rootPane));
		cboProducto.setModel(new DefaultComboBoxModel(new String[] { "SELECCIONAR...." }));
		pnCboProducto.add(cboProducto);

		scrollPane = new JScrollPane();
		pnSeleccionarProductos.add(scrollPane, BorderLayout.CENTER);

		tbProductos = new JTable();
		tbProductos.addMouseListener(this);
		tbProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbProductos);

		pnNORTH = new JPanel();
		pnNORTH.setOpaque(false);
		getContentPane().add(pnNORTH, BorderLayout.NORTH);
		pnNORTH.setLayout(new BorderLayout(0, 0));

		panel_15 = new JPanel();
		panel_15.setOpaque(false);
		pnNORTH.add(panel_15, BorderLayout.WEST);

		pnProveedor = new JPanel();
		panel_15.add(pnProveedor);
		pnProveedor.setPreferredSize(new Dimension(280, 207));
		pnProveedor.setSize(new Dimension(280, 207));
		pnProveedor.setBackground(Color.GRAY);
		pnProveedor.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Proveedor",
				TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnProveedor.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		pnProveedor.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1);

		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("PROVEEDOR");
		lblNewLabel.setBounds(7, 8, 94, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(lblNewLabel);

		btnSelectProveedor = new JButton("SELECCIONAR....");
		btnSelectProveedor.addActionListener(this);
		btnSelectProveedor.addMouseListener(this);
		btnSelectProveedor.setBounds(88, 4, 145, 23);
		btnSelectProveedor.setFocusable(false);
		btnSelectProveedor.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		btnSelectProveedor.setContentAreaFilled(false);
		panel_2.add(btnSelectProveedor);
		btnSelectProveedor.setMargin(new Insets(2, 2, 2, 2));

		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_1 = new JLabel("CODIGO");
		lblNewLabel_1.setBounds(7, 8, 44, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(lblNewLabel_1);

		lblCodProveedor = new JLabel("");
		lblCodProveedor.setBounds(88, 4, 145, 22);
		lblCodProveedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_3.add(lblCodProveedor);

		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);

		lblNewLabel_2 = new JLabel("RAZON S.");
		lblNewLabel_2.setBounds(7, 8, 71, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_4.add(lblNewLabel_2);

		lblRazonSocial = new JLabel("");
		lblRazonSocial.setBounds(88, 4, 145, 22);
		lblRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_4.add(lblRazonSocial);

		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_3 = new JLabel("RUC");
		lblNewLabel_3.setBounds(7, 8, 71, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_5.add(lblNewLabel_3);

		lblRucProveedor = new JLabel("");
		lblRucProveedor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRucProveedor.setBounds(88, 4, 145, 22);
		panel_5.add(lblRucProveedor);

		panel_6 = new JPanel();
		panel.add(panel_6);

		pnEmpleado = new JPanel();
		panel_15.add(pnEmpleado);
		pnEmpleado.setPreferredSize(new Dimension(280, 207));
		pnEmpleado.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Empleado",
				TitledBorder.LEFT, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		pnEmpleado.setBackground(Color.GRAY);
		pnEmpleado.setLayout(new BorderLayout(0, 0));

		panel_7 = new JPanel();
		pnEmpleado.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		panel_13 = new JPanel();
		panel_7.add(panel_13);

		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_7.add(panel_8);

		lblNewLabel_4 = new JLabel(
				"EMPLEADO         \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(7, 8, 251, 14);
		panel_8.add(lblNewLabel_4);

		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_7.add(panel_9);

		lblNewLabel_5 = new JLabel("CODIGO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(7, 8, 44, 14);
		panel_9.add(lblNewLabel_5);

		lblCodEmpleado = new JLabel("C001");
		lblCodEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodEmpleado.setBounds(93, 4, 145, 22);
		panel_9.add(lblCodEmpleado);

		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_7.add(panel_10);

		lblNewLabel_6 = new JLabel("NOMBRE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(7, 8, 46, 14);
		panel_10.add(lblNewLabel_6);

		lblNomEmpleado = new JLabel("SANTIAGO SANTIAGO");
		lblNomEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomEmpleado.setBounds(93, 4, 145, 22);
		panel_10.add(lblNomEmpleado);

		panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_7.add(panel_11);

		lblNewLabel_7 = new JLabel("DNI");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(7, 8, 20, 14);
		panel_11.add(lblNewLabel_7);

		lblDniEmpleado = new JLabel("002276402");
		lblDniEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDniEmpleado.setBounds(93, 4, 145, 22);
		panel_11.add(lblDniEmpleado);

		panel_12 = new JPanel();
		panel_7.add(panel_12);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(280, 207));
		pnNORTH.add(scrollPane_1);

		txtadded = new JTextArea();
		txtadded.setBorder(new MatteBorder(0, 5, 0, 0, (Color) new Color(0, 0, 0)));
		txtadded.setEditable(false);
		txtadded.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane_1.setViewportView(txtadded);

		pnSOUTH = new JPanel();
		getContentPane().add(pnSOUTH, BorderLayout.SOUTH);

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
	}

	private void construirTabla(String[] titulos, Object[][] data, String name, typeUtility util) {
		int num = titulos.length;

		boolean[] columEdit = new boolean[num];

		for (int i = 0; i < num; i++) {
			if (i == num - 1) {
				columEdit[i] = true;
			} else {
				columEdit[i] = false;
			}
		}

		Class[] tipoEdit = new Class[num];

		for (int i = 0; i < num; i++) {
			if (i == num - 1) {
				tipoEdit[i] = java.lang.Boolean.class;
			} else {
				tipoEdit[i] = java.lang.Object.class;
			}
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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getColor()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDesarrolladora()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlataforma()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getSize()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDiscoduro()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getPlacamadre()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getFuentepoder()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getRefrigeracion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTarjetavideo()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPantalla()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getProcesador()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

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
			tbProductos.getColumnModel().getColumn(util.getCheck()).setCellRenderer(new editCells("check"));

			tbProductos.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
			tbProductos.getColumnModel().getColumn(util.getMarca()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getModelo()).setPreferredWidth(150);
			tbProductos.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getTipoconex()).setPreferredWidth(115);
			tbProductos.getColumnModel().getColumn(util.getPrecio()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getStock()).setPreferredWidth(55);
			tbProductos.getColumnModel().getColumn(util.getCheck()).setPreferredWidth(30);

			tbProductos.getTableHeader().setReorderingAllowed(false);
			tbProductos.setRowHeight(25);
			tbProductos.setGridColor(new Color(0, 0, 0));

			JTableHeader jtableheader = tbProductos.getTableHeader();
			jtableheader.setDefaultRenderer(new editColumns());
			tbProductos.setTableHeader(jtableheader);

		} else {
			JOptionPane.showMessageDialog(null, "ERROR EN CONSTRUIR TABLA TITULOS");
		}
	}

	private Object[][] obtenerMatrizDatos(ArrayList<Object> listaTitulos2, String name, typeUtility util) {

		if (name.equalsIgnoreCase("consolas")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {
				informacion[x][util.getCodigo()] = ((Consolas) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Consolas) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getModelo()] = ((Consolas) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getColor()] = ((Consolas) listaProductos.get(x)).getColor() + "";
				informacion[x][util.getPrecio()] = ((Consolas) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Consolas) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("juegos")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Juegos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Juegos) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getDesarrolladora()] = ((Juegos) listaProductos.get(x)).getDesarrolladora() + "";
				informacion[x][util.getPlataforma()] = ((Juegos) listaProductos.get(x)).getPlataforma() + "";
				informacion[x][util.getPrecio()] = ((Juegos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Juegos) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mandos")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Mandos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getNombre()] = ((Mandos) listaProductos.get(x)).getNombre() + "";
				informacion[x][util.getMarca()] = ((Mandos) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getTipoconex()] = ((Mandos) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Mandos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Mandos) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("audifonosgamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((AudifonosG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((AudifonosG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((AudifonosG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((AudifonosG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((AudifonosG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((AudifonosG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((AudifonosG) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("sillasgamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((SillaG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((SillaG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((SillaG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((SillaG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((SillaG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((SillaG) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("pcgamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((PCGamer) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getProcesador()] = ((PCGamer) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getDiscoduro()] = ((PCGamer) listaProductos.get(x)).getDiscoduro() + "";
				informacion[x][util.getPlacamadre()] = ((PCGamer) listaProductos.get(x)).getPlacamadre() + "";
				informacion[x][util.getTarjetavideo()] = ((PCGamer) listaProductos.get(x)).getTarjVideo() + "";
				informacion[x][util.getFuentepoder()] = ((PCGamer) listaProductos.get(x)).getFuentePoder() + "";
				informacion[x][util.getRefrigeracion()] = ((PCGamer) listaProductos.get(x)).getRefrigeracion() + "";
				informacion[x][util.getPrecio()] = ((PCGamer) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((PCGamer) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;
		} else if (name.equalsIgnoreCase("laptopgamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((LaptopG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((LaptopG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((LaptopG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((LaptopG) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getTarjetavideo()] = ((LaptopG) listaProductos.get(x)).getTarjVideo() + "";
				informacion[x][util.getSize()] = ((LaptopG) listaProductos.get(x)).getSize() + "";
				informacion[x][util.getPrecio()] = ((LaptopG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((LaptopG) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mousegamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((MouseG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((MouseG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((MouseG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((MouseG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((MouseG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((MouseG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((MouseG) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("tecladosgamer")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((TecladoG) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((TecladoG) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((TecladoG) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((TecladoG) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((TecladoG) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((TecladoG) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((TecladoG) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("celulares")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Celular) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Celular) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Celular) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Celular) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Celular) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Celular) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("televisores")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Televisor) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Televisor) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Televisor) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Televisor) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Televisor) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Televisor) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("parlantes")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Parlantes) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Parlantes) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Parlantes) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Parlantes) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Parlantes) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Parlantes) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Parlantes) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("audifonos")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Audifonos) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Audifonos) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Audifonos) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Audifonos) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Audifonos) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Audifonos) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Audifonos) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("pc")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

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
				informacion[x][util.getStock()] = ((PCEscritorio) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("laptop")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Laptop) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Laptop) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Laptop) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((Laptop) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getTarjetavideo()] = ((Laptop) listaProductos.get(x)).getTarjetavideo() + "";
				informacion[x][util.getPantalla()] = ((Laptop) listaProductos.get(x)).getPantalla() + "";
				informacion[x][util.getPrecio()] = ((Laptop) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Laptop) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("tablet")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Tablet) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Tablet) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Tablet) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getProcesador()] = ((Tablet) listaProductos.get(x)).getProcesador() + "";
				informacion[x][util.getDescripcion()] = ((Tablet) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getPrecio()] = ((Tablet) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Tablet) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("mouse")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Mouse) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Mouse) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Mouse) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Mouse) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Mouse) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Mouse) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Mouse) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("microfonos")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((Microfono) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Microfono) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Microfono) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getTipoconex()] = ((Microfono) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Microfono) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Microfono) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("camaraweb")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {

				informacion[x][util.getCodigo()] = ((CamaraWeb) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((CamaraWeb) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((CamaraWeb) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getTipoconex()] = ((CamaraWeb) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((CamaraWeb) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((CamaraWeb) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
			}
			return informacion;

		} else if (name.equalsIgnoreCase("teclados")) {
			Object informacion[][] = new Object[listaProductos.size()][listaTitulos.size()];

			for (int x = 0; x < informacion.length; x++) {
				informacion[x][util.getCodigo()] = ((Teclados) listaProductos.get(x)).getCodigo() + "";
				informacion[x][util.getMarca()] = ((Teclados) listaProductos.get(x)).getMarca() + "";
				informacion[x][util.getModelo()] = ((Teclados) listaProductos.get(x)).getModelo() + "";
				informacion[x][util.getDescripcion()] = ((Teclados) listaProductos.get(x)).getDescripcion() + "";
				informacion[x][util.getTipoconex()] = ((Teclados) listaProductos.get(x)).getTipoconex() + "";
				informacion[x][util.getPrecio()] = ((Teclados) listaProductos.get(x)).getPrecio() + "";
				informacion[x][util.getStock()] = ((Teclados) listaProductos.get(x)).getStock() + ((int) (Math.random()*((12000-3000))+3000)) + "";
				informacion[x][util.getCheck()] = false;
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
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("juegos")) {
			ArrayList<Object> lista = gJuegos.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("mandos")) {
			ArrayList<Object> lista = gMandos.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("audifonosgamer")) {
			ArrayList<Object> lista = gAudGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("sillasgamer")) {
			ArrayList<Object> lista = gSillaGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("pcgamer")) {
			ArrayList<Object> lista = gPcGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("laptopgamer")) {
			ArrayList<Object> lista = gLapGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("mousegamer")) {
			ArrayList<Object> lista = gMouseGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("tecladosgamer")) {
			ArrayList<Object> lista = gTecGamer.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("celulares")) {
			ArrayList<Object> lista = gCelular.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("televisores")) {
			ArrayList<Object> lista = gTelevisor.leerColumnas();
			lista.add("");
			return lista;
		} else if (prod.equalsIgnoreCase("parlantes")) {
			ArrayList<Object> lista = gParlante.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("audifonos")) {
			ArrayList<Object> lista = gAudifonos.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("pc")) {
			ArrayList<Object> lista = gPcEscritorio.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("laptop")) {
			ArrayList<Object> lista = gLaptop.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("tablet")) {
			ArrayList<Object> lista = gTablet.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("mouse")) {
			ArrayList<Object> lista = gMouse.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("microfonos")) {
			ArrayList<Object> lista = gMicrofono.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("camaraweb")) {
			ArrayList<Object> lista = gCamWeb.leerColumnas();
			lista.add("");
			return lista;

		} else if (prod.equalsIgnoreCase("teclados")) {
			ArrayList<Object> lista = gTeclado.leerColumnas();
			lista.add("");
			return lista;
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProceder) {
			do_btnProceder_actionPerformed(e);
		}
		if (e.getSource() == btnSelectProveedor) {
			do_btnSelectProveedor_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnCloseList) {
			do_btnCloseList_actionPerformed(e);
		}
		if (e.getSource() == btnOpenInventory) {
			do_btnOpenInventory_actionPerformed(e);
		}
		if (e.getSource() == btnAddToCart) {
			do_btnAddToCart_actionPerformed(e);
		}
		if (e.getSource() == cboProducto) {
			do_cboProductos_actionPerformed(e);
		}
		if (e.getSource() == btnEmpty) {
			do_btnEmpty_actionPerformed(e);
		}

	}

	private void do_btnEmpty_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Se vaciará el carrito de compras\n¿Deasea Continuar?",
				"Advertencia", JOptionPane.YES_NO_OPTION);
		if (result == 0) {
			modeling.setRowCount(0);
			modelingRows.clear();
			tbList.setModel(modeling);
		}

	}

	private void do_cboProductos_actionPerformed(ActionEvent e) {
		if (cboProducto.getSelectedIndex() == 0) {
			btnAddToCart.setVisible(false);
		} else {
			btnAddToCart.setVisible(true);
		}
		String prod = (cboProducto.getSelectedItem() + "").toLowerCase();
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
		if (e.getSource() == tbList) {
			do_tbList_mouseClicked(e);
		}
		if (e.getSource() == tbProductos) {
			do_tbProductos_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnOpenInventory) {
			do_btnOpenInventory_mouseEntered(e);
		}
		if (e.getSource() == btnSelectProveedor) {
			do_btnSelectProveedor_mouseEntered(e);
		}

		if (e.getSource() == btnAddToCart) {
			do_btnAddToCart_mouseEntered(e);
		}

		if (e.getSource() == btnCloseList) {
			do_btnCloseList_mouseEntered(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseEntered(e);
		}
		if (e.getSource() == btnProceder) {
			do_btnProceder_mouseEntered(e);
		}
		if (e.getSource() == btnEmpty) {
			do_btnEmpty_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnSelectProveedor) {
			do_btnSelectProveedor_mouseExited(e);
		}

		if (e.getSource() == btnAddToCart) {
			do_btnAddToCart_mouseExited(e);
		}

		if (e.getSource() == btnCloseList) {
			do_btnCloseList_mouseExited(e);
		}
		if (e.getSource() == btnOpenInventory) {
			do_btnOpenInventory_mouseExited(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_mouseExited(e);
		}
		if (e.getSource() == btnProceder) {
			do_btnProceder_mouseExited(e);
		}
		if (e.getSource() == btnEmpty) {
			do_btnEmpty_mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_tbProductos_mouseClicked(MouseEvent e) {

	}

	protected void do_btnOpenInventory_mouseEntered(MouseEvent e) {
		if (btnOpenInventory.isEnabled()) {
			btnOpenInventory.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnOpenInventory_mouseExited(MouseEvent e) {
		if (btnOpenInventory.isEnabled()) {
			btnOpenInventory.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
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

	protected void do_btnProceder_mouseEntered(MouseEvent e) {
		if (btnProceder.isEnabled()) {
			btnProceder.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnProceder_mouseExited(MouseEvent e) {
		if (btnProceder.isEnabled()) {
			btnProceder.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnSelectProveedor_mouseEntered(MouseEvent e) {
		if (btnSelectProveedor.isEnabled()) {
			btnSelectProveedor.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnSelectProveedor_mouseExited(MouseEvent e) {
		if (btnSelectProveedor.isEnabled()) {
			btnSelectProveedor.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnAddToCart_mouseEntered(MouseEvent e) {
		if (btnAddToCart.isEnabled()) {
			btnAddToCart.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnAddToCart_mouseExited(MouseEvent e) {
		if (btnAddToCart.isEnabled()) {
			btnAddToCart.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnCloseList_mouseEntered(MouseEvent e) {
		if (btnCloseList.isEnabled()) {
			btnCloseList.setBorder(new MatteBorder(1, 0, 1, 0, (Color.GREEN)));
		}
	}

	private void do_btnCloseList_mouseExited(MouseEvent e) {
		if (btnCloseList.isEnabled()) {
			btnCloseList.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		}
	}

	protected void do_btnEmpty_mouseEntered(MouseEvent e) {
		if (btnEmpty.isEnabled()) {

			btnEmpty.setForeground(Color.WHITE);
		}
	}

	private void do_btnEmpty_mouseExited(MouseEvent e) {
		if (btnEmpty.isEnabled()) {

			btnEmpty.setForeground(Color.BLACK);
		}
	}

	protected void do_btnAddToCart_actionPerformed(ActionEvent e) {

		int col = tbProductos.getColumnCount() - 1;
		boolean verificacion = false;
		for (int i = 0; i < tbProductos.getRowCount(); i++) {
			verificacion = (boolean) tbProductos.getValueAt(i, col);
			if (verificacion) {
				break;
			}
		}
		if (!verificacion) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Error!!", JOptionPane.WARNING_MESSAGE);
		} else {
			for (int i = 0; i < tbProductos.getRowCount(); i++) {
				boolean continuar = true;
				boolean check = (boolean) tbProductos.getValueAt(i, col);
				if (check) {
					Object[] row = new Object[col + 1];
					row[0] = tbProductos.getValueAt(i, 0);
					for (Object[] lt : modelingRows) {
						if (lt[0].equals(row[0])) {
							txtadded.append("\n >> Este producto ya ha sido agregado anteriormente  <<");
							continuar = false;
						}
					}
					if (continuar) {
						row[1] = (String.valueOf(tbProductos.getValueAt(i, 1)) + " "
								+ String.valueOf(tbProductos.getValueAt(i, 2))).toUpperCase();
						row[2] = tbProductos.getValueAt(i, col - 2);
						row[3] = tbProductos.getValueAt(i, col - 1);
						row[4] = "";
						row[5] = "";
						modelingRows.add(row);
						txtadded.append("\n  - " + row[0] + " " + row[1] + " AGREGADO!");
					}
				}
			}
		}
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		if (modeling.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "El carrito de compras esta vacio!", "Error!",
					JOptionPane.WARNING_MESSAGE);
		} else if (tbList.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Error!", JOptionPane.WARNING_MESSAGE);
		} else {
			int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar?", "Advertencia",
					JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
				Object[] row = new Object[1];
				row[0] = tbList.getValueAt(tbList.getSelectedRow(), 0);
				int pos = -1;
				for (Object[] lt : modelingRows) {
					if (lt[0].equals(row[0])) {
						pos = modelingRows.indexOf(lt);
					}
				}
				if (pos != -1) {
					modelingRows.remove(pos);
					txtadded.append("\n |-- " + row[0] + " Ha sido eliminado de la lista exitosamente --|");
					modeling.removeRow(pos);
					tbList.setModel(modeling);
				}

			}

		}
	}

	protected void do_btnOpenInventory_actionPerformed(ActionEvent e) {
		if (pnListProductos.isShowing()) {
			if (!lblCodProveedor.getText().trim().equals("")) {
				if (lblCodProveedor.getText().trim().equals("PRO01")) {
					cboProducto.removeAllItems();
					cboProducto.addItem("SELECCIONAR....");
					cboProducto.addItem("CONSOLAS");
					cboProducto.addItem("JUEGOS");
					cboProducto.addItem("MANDOS");
					pnCboProducto.setVisible(true);
				} else if (lblCodProveedor.getText().trim().equals("PRO02")) {
					cboProducto.removeAllItems();
					cboProducto.addItem("SELECCIONAR....");
					cboProducto.addItem("AUDIFONOSGAMER");
					cboProducto.addItem("SILLASGAMER");
					cboProducto.addItem("PCGAMER");
					cboProducto.addItem("LAPTOPGAMER");
					cboProducto.addItem("MOUSEGAMER");
					cboProducto.addItem("TECLADOSGAMER");
					pnCboProducto.setVisible(true);

				} else if (lblCodProveedor.getText().trim().equals("PRO03")) {
					cboProducto.removeAllItems();
					cboProducto.addItem("SELECCIONAR....");
					cboProducto.addItem("CELULARES");
					cboProducto.addItem("TELEVISORES");
					cboProducto.addItem("PARLANTES");
					cboProducto.addItem("AUDIFONOS");
					cboProducto.addItem("PC");
					cboProducto.addItem("LAPTOP");
					cboProducto.addItem("TABLET");
					cboProducto.addItem("MOUSE");
					cboProducto.addItem("MICROFONOS");
					cboProducto.addItem("CAMARAWEB");
					cboProducto.addItem("TECLADOS");
					pnCboProducto.setVisible(true);
				}
				pnCENTER.remove(pnListProductos);
				pnCENTER.add(pnSeleccionarProductos, BorderLayout.CENTER);
			} else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor");
			}
		} else {
			pnCENTER.remove(pnSeleccionarProductos);
			pnCENTER.add(pnListProductos, BorderLayout.CENTER);
		}
		pnCENTER.updateUI();
	}

	protected void do_btnCloseList_actionPerformed(ActionEvent e) {
		if (pnListProductos.isShowing()) {
			pnCENTER.remove(pnListProductos);
			pnCENTER.add(pnSeleccionarProductos, BorderLayout.CENTER);
		} else {
			DefaultTableModel mo = new DefaultTableModel();
			tbProductos.setModel(mo);
			pnCENTER.remove(pnSeleccionarProductos);
			pnCENTER.add(pnListProductos, BorderLayout.CENTER);
		}

		boolean[] columEdit = new boolean[6];

		for (int i = 0; i < 6; i++) {
			if (i == 4) {
				columEdit[i] = true;
			} else {
				columEdit[i] = false;
			}
		}

		Class[] tipoEdit = new Class[6];

		for (int i = 0; i < 6; i++) {

			tipoEdit[i] = java.lang.Object.class;

		}

		modeling = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return columEdit[col];
			}

			public Class getColumnClass(int index) {
				return tipoEdit[index];
			}
		};
		modeling.addColumn("CODIGO");
		modeling.addColumn("PRODUCTO");
		modeling.addColumn("PRECIO");
		modeling.addColumn("STOCK");
		modeling.addColumn("CANTIDAD");
		modeling.addColumn("IMPORTE");

		for (Object[] mr : modelingRows) {
			modeling.addRow(mr);
		}

		tbList.setModel(modeling);

		tbList.getColumnModel().getColumn(0).setCellRenderer(new editCells("numerico"));
		tbList.getColumnModel().getColumn(1).setCellRenderer(new editCells("texto"));
		tbList.getColumnModel().getColumn(2).setCellRenderer(new editCells("numerico"));
		tbList.getColumnModel().getColumn(3).setCellRenderer(new editCells("stock"));
		tbList.getColumnModel().getColumn(4).setCellRenderer(new editCells("cantidad"));
		tbList.getColumnModel().getColumn(5).setCellRenderer(new editCells("numerico"));

		tbList.getColumnModel().getColumn(0).setPreferredWidth(75);
		tbList.getColumnModel().getColumn(1).setPreferredWidth(300);
		tbList.getColumnModel().getColumn(2).setPreferredWidth(75);
		tbList.getColumnModel().getColumn(3).setPreferredWidth(75);
		tbList.getColumnModel().getColumn(4).setPreferredWidth(80);
		tbList.getColumnModel().getColumn(5).setPreferredWidth(80);

		tbList.getTableHeader().setReorderingAllowed(false);
		tbList.setRowHeight(25);
		tbList.setGridColor(new Color(0, 0, 0));

		JTableHeader jtableheader = tbList.getTableHeader();
		jtableheader.setDefaultRenderer(new editColumns());
		tbList.setTableHeader(jtableheader);

		pnCENTER.updateUI();

	}

	private void calcularImporte() {
		double impT = 0;
		double imp = 0;
		int rowsCount = tbList.getRowCount();
		for (int i = 0; i < rowsCount; i++) {
			try {
				String datoDouble = tbList.getValueAt(i, 2) + "";
				double precio = Double.parseDouble(datoDouble);
				int cant = -1;
				String datoInt = null;
				String datoStock = tbList.getValueAt(i, 3) + "";
				int stock = Integer.parseInt(datoStock);
				if (!(tbList.getValueAt(i, 4) == null) || !(String.valueOf(tbList.getValueAt(i, 4)).equals(""))) {
					datoInt = tbList.getValueAt(i, 4) + "";
					cant = Integer.parseInt(datoInt);
				}
				if (cant <= stock && cant > 0) {
					if (cant != -1) {
						imp = cant * precio;
						tbList.setValueAt(imp, i, 5);
						impT += imp;
					}
				} else {
					tbList.setValueAt("", i, 5);
				}

			} catch (Exception e) {

			}
		}
		lblImporteTotal.setText(impT + "");

	}

	protected void do_tbList_mouseClicked(MouseEvent e) {
		numProd = tbList.getSelectedRow();
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
		timeImport.start();
		lblCodEmpleado.setText(frmPrincipal.trabajador.getCodigo());
		lblNomEmpleado.setText(
				(frmPrincipal.trabajador.getNombre() + " " + frmPrincipal.trabajador.getApellido()).toUpperCase());
		lblDniEmpleado.setText(frmPrincipal.trabajador.getDni());
	}

	public static void cargarProveedor() {
		Proveedor proveedor = frmPrincipal.proveedor;
		lblCodProveedor.setText(proveedor.getCodigo());
		lblRazonSocial.setText((proveedor.getRazonSocial()).toUpperCase());
		lblRucProveedor.setText(proveedor.getRuc());
	}

	protected void do_btnSelectProveedor_actionPerformed(ActionEvent e) {
		if (!pnSeleccionarProductos.isShowing()) {
			if (lblCodProveedor.getText().trim().equals("")) {
				seleccionarProveedor sP = new seleccionarProveedor();
				sP.setVisible(true);
			} else {
				if (modelingRows.size() > 0) {
					int result = JOptionPane.showConfirmDialog(null,
							"Si cambiará de proveedor se vaciará\n el carrito de compras actual\n¿Desea Continuar?");
					modelingRows.clear();
					modeling.setRowCount(0);
					tbList.setModel(modeling);
					txtadded.setText("");
					seleccionarProveedor sP = new seleccionarProveedor();
					sP.setVisible(true);
				} else {
					seleccionarProveedor sP = new seleccionarProveedor();
					sP.setVisible(true);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Antes de cambiar de proveedor\nCierre el listado de productos",
					"Error!", JOptionPane.WARNING_MESSAGE);
		}

	}

	protected void do_btnProceder_actionPerformed(ActionEvent e) {
		if (!lblCodProveedor.getText().trim().equals("")) {
			boolean continuar = true;
			if (modeling.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "El carrito de compras esta vacio!", "Error!",
						JOptionPane.WARNING_MESSAGE);
				continuar = false;
			} else {
				for (int i = 0; i < tbList.getRowCount(); i++) {
					String detalle = String.valueOf(tbList.getValueAt(i, 4));
					if (detalle.equals("")) {
						continuar = false;
					}
				}

				if (continuar) {
					ArrayList<String[]> detList = detalleListaProductos();
					detPdf = generarListaDetallesPDF();
					Boleta bol = new Boleta();
					if (detList != null && !(detPdf.size() == 0)) {
						String coding = generarNumBoleta();
						bol.setCodBoleta("N - " + coding);
						bol.setCod_Empleado(frmPrincipal.trabajador.getCodigo_() + "");
						bol.setCod_Cli_Prov(frmPrincipal.proveedor.getCodigo_() + "");
						SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
						Date date = new Date();
						bol.setFechaVenta(sdf.format(date));
						bol.setDescripcion(generarDescripcion());
						bol.setImporte(Double.parseDouble(lblImporteTotal.getText()));

						try {
							int result = gBoleta.registrarBoleta(bol, detList, "compra");
							if (result != 0) {
								String nombPDF = "Reportes/ReporteCompra/Compra_" + frmPrincipal.trabajador.getCodigo()
										+ "_" + coding + ".pdf";
								JasperReport report = (JasperReport) JRLoader
										.loadObjectFromFile("PlantillasJasper/Reporte_Compra_Venta.jasper");
								JasperPrint jPrint = JasperFillManager.fillReport(report, null, this);
								JasperExportManager.exportReportToPdfFile(jPrint, nombPDF);
								int resultado = JOptionPane.showConfirmDialog(null,
										"Compra Realizada Satisfactoriamente\nSe ha creado y registrado una boleta\nvirtual con exito!\n\n¿Desea Visualizarla?",
										"Confirmacion", JOptionPane.YES_NO_OPTION);
								index = -1;
								if (resultado == 0) {
									Desktop.getDesktop().open(new File(nombPDF));
								}
							} else {
								JOptionPane.showMessageDialog(null, "Ha ocurrido un error con la compra", "Informacion",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception ex) {
							System.out.println("ERROR AL GENERAR PDF: \n" + ex);
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos CANTIDAD!", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debe Seleccionar un proveedor", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private ArrayList<String[]> detalleListaProductos() {
		boolean val = false;
		ArrayList<String[]> listaP = new ArrayList<>();
		int rowsCount = tbList.getRowCount();
		for (int i = 0; i < rowsCount; i++) {
			String[] row = new String[2];
			row[0] = String.valueOf(tbList.getValueAt(i, 0));
			int suma = Integer.parseInt(tbList.getValueAt(i, 3) + "") + Integer.parseInt(tbList.getValueAt(i, 4) + "");

			row[1] = String.valueOf(suma);
			val = true;
			listaP.add(row);

		}
		if (val) {
			return listaP;
		} else {
			return null;
		}
	}

	private String generarNumBoleta() {
		SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("YY");
		Date hoy = new Date();
		String num_boleta = "";
		for (int i = 0; i < 4; i++) {
			int num = ((int) (Math.random() * 10));
			num_boleta += num;
		}
		int num1 = ((int) (Math.random() * 10));
		num_boleta += sdfDia.format(hoy);
		num_boleta += num1;

		int num2 = ((int) (Math.random() * 10));
		num_boleta += sdfMes.format(hoy);
		num_boleta += num2;

		int num3 = ((int) (Math.random() * 10));
		num_boleta += sdfAno.format(hoy);
		num_boleta += num3;
		SimpleDateFormat sdfTime = new SimpleDateFormat("HHmmss");
		num_boleta += sdfTime.format(hoy);
		return num_boleta;
	}

	private String generarDescripcion() {
		String des = "";
		int rowsCount = tbList.getRowCount();
		for (int i = 0; i < rowsCount; i++) {
			String codigo = tbList.getValueAt(i, 0) + "";
			String producto = tbList.getValueAt(i, 1) + "";
			String precio = tbList.getValueAt(i, 2) + "";
			String cantidad = tbList.getValueAt(i, 4) + "";
			String importe = tbList.getValueAt(i, 5) + "";
			des += "Producto N-" + (i + 1) + " " + codigo + " " + producto + " Precio: " + precio + " Cantidad: "
					+ cantidad + " Importe: " + importe + "\n";
		}
		return des;
	}

	private ArrayList<Object[]> generarListaDetallesPDF() {
		ArrayList<Object[]> des = new ArrayList<Object[]>();
		int rowsCount = tbList.getRowCount();
		for (int i = 0; i < rowsCount; i++) {
			Object[] linea = new String[5];
			linea[0] = tbList.getValueAt(i, 0) + "";
			linea[1] = tbList.getValueAt(i, 1) + "";
			linea[2] = tbList.getValueAt(i, 4) + "";
			linea[3] = tbList.getValueAt(i, 2) + "";
			linea[4] = tbList.getValueAt(i, 5) + "";
			des.add(linea);
		}
		return des;
	}

	public void focusGained(FocusEvent e) {
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == tbList) {
			do_tbList_focusLost(e);
		}
	}

	protected void do_tbList_focusLost(FocusEvent e) {

	}

	@Override
	public Object getFieldValue(JRField jrf) throws JRException {
		Object value = null;
		String fieldName = jrf.getName();
		switch (fieldName) {
		case "codigo":
			return value = String.valueOf(detPdf.get(index)[0]);

		case "producto":
			return value = String.valueOf(detPdf.get(index)[1]);

		case "cantidad":
			return value = Integer.parseInt(String.valueOf(detPdf.get(index)[2]));

		case "precio":
			return value = Double.parseDouble(String.valueOf(detPdf.get(index)[3]));

		case "importe":
			return value = Double.parseDouble(String.valueOf(detPdf.get(index)[4]));

		case "externoDato":
			return value = (frmPrincipal.proveedor.getRazonSocial()).toUpperCase();

		case "externoNombre":
			return value = "PROVEEDOR";

		case "identidadNum":
			return value = frmPrincipal.proveedor.getRuc();

		case "identidadNombre":
			return value = "RUC";

		case "Subtitulo":
			return value = "REPORTE DE COMPRA";

		default:
			return null;
		}
	}

	@Override
	public boolean next() throws JRException {
		index++;
		return (index < detPdf.size());
	}
}
