package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import Entidad.Clientes;
import Entidad.Empleados;
import Entidad.Proveedor;
import Mantenimiento.GestionEmpleadoDAO;
import Utils.ModifyThread;
import Utils.MySQLConexion8;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class frmPrincipal extends JFrame implements FocusListener, WindowStateListener, ActionListener, KeyListener,
		MouseListener, InternalFrameListener, WindowListener {
	private JDesktopPane contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnMantenimiento;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_5;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblSubUsuario;
	private JLabel lblSubPass;
	private JLabel lblGreenBackground;
	private JButton btnIngresar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panelSouth;
	private JLabel lblNewLabel_3;
	private JLabel lblServerStaus;
	private JPanel panel_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JPanel panelLogin;

	GestionEmpleadoDAO gEmp = new GestionEmpleadoDAO();
	public static int serverStatusMessage = 0;

	private static registrarEmpleado regiEmp = new registrarEmpleado();
	private static consultarEmpleado consuEmp = new consultarEmpleado();

	private static registrarCliente regiCliente = new registrarCliente();
	private static consultarCliente consuCliente = new consultarCliente();

	private static mantenimiento_Productos manProd;
	private static generarVenta genVenta;
	private static generarCompra genCompra;

	frmPrincipal miClase = this;

	public static Empleados trabajador = null;
	public static Clientes cliente = null;
	public static Proveedor proveedor = null;
	public static int stockEdit = -1;
	public static String errorConexion = "";
	private String HoraActual;

	private ActionListener serverStatusConection = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			serverStatus();

		}

	};

	private ActionListener timeNow = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			obtenerHora();

		}

	};

	private Timer timerServer = new Timer(3000, serverStatusConection);
	private Timer timerTime = new Timer(500, timeNow);
	private JPanel panelLblGreen;
	private static JPanel panelHome;
	private JLabel lblLogoHome;
	private JMenuItem mntmCerrarSesion;
	private JLabel lblNoConnection;
	private JPanel panelStatus;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmRegistrarEmpleado;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JPanel panelDataUser;
	private JPanel panel_2;
	private JLabel lblEmpleadoNorth;
	private JLabel lblCargoNorth;
	private JLabel lblHoraNorth;
	private JLabel lblNewLabel_2;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmGenerarVenta;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnNewMenu_6;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		addWindowListener(this);
		setResizable(false);
		addWindowStateListener(this);
		setTitle("UPMORBSLUCK");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmPrincipal.class.getResource("/IMG/Logo_Icon2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JDesktopPane();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);

		ImageIcon asd = new ImageIcon(getClass().getResource("/IMG/Logo_Icon2.png"));
		this.setIconImage(asd.getImage());
		contentPane.setLayout(new BorderLayout(0, 0));

		panelDataUser = new JPanel();
		panelDataUser.setLayout(new BorderLayout(0, 0));
		panelDataUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128)));
		panelDataUser.setBackground(new Color(0, 255, 127));
		contentPane.add(panelDataUser, BorderLayout.NORTH);

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panelDataUser.add(panel_2, BorderLayout.EAST);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.CENTER, 5, 7);
		panel_2.setLayout(fl_panel_2);

		lblHoraNorth = new JLabel("18 : 00 PM  ");
		lblHoraNorth.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(lblHoraNorth);

		lblEmpleadoNorth = new JLabel("Jheyson P. Castillo Figueroa");
		lblEmpleadoNorth.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_2.add(lblEmpleadoNorth);

		lblCargoNorth = new JLabel("Supervisor");
		panel_2.add(lblCargoNorth);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/user.png")));
		panel_2.add(lblNewLabel_2);

		menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(0, 255, 127));
		panelDataUser.add(menuBar, BorderLayout.WEST);

		mnNewMenu = new JMenu("Sistema");
		mnNewMenu.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/display.png")));
		mnNewMenu.addMouseListener(this);
		mnNewMenu.setOpaque(true);
		mnNewMenu.setBackground(new Color(0, 255, 127));
		menuBar.add(mnNewMenu);

		mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/leave_Sesion.png")));
		mntmCerrarSesion.addActionListener(this);
		mnNewMenu.add(mntmCerrarSesion);

		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/off.png")));
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/config.png")));
		mnMantenimiento.addMouseListener(this);
		mnMantenimiento.setMargin(new Insets(6, 2, 6, 2));
		mnMantenimiento.setOpaque(true);
		mnMantenimiento.setBackground(new Color(0, 255, 127));
		menuBar.add(mnMantenimiento);

		mnNewMenu_4 = new JMenu("Empleados");
		mnNewMenu_4.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/user_Face.png")));
		mnMantenimiento.add(mnNewMenu_4);

		mntmRegistrarEmpleado = new JMenuItem("Registrar");
		mntmRegistrarEmpleado.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/register.png")));
		mntmRegistrarEmpleado.addActionListener(this);
		mnNewMenu_4.add(mntmRegistrarEmpleado);

		mntmNewMenuItem_7 = new JMenuItem("Consultar");
		mntmNewMenuItem_7.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/search.png")));
		mntmNewMenuItem_7.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_7);

		mnNewMenu_5 = new JMenu("Clientes");
		mnNewMenu_5.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/user_Face.png")));
		mnMantenimiento.add(mnNewMenu_5);

		mntmNewMenuItem_1 = new JMenuItem("Registrar");
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/register.png")));
		mnNewMenu_5.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Consultar");
		mntmNewMenuItem_2.addActionListener(this);
		mntmNewMenuItem_2.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/search.png")));
		mnNewMenu_5.add(mntmNewMenuItem_2);

		mnNewMenu_2 = new JMenu("Inventario");
		mnNewMenu_2.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/inventory.png")));
		mnNewMenu_2.addMouseListener(this);
		mnNewMenu_2.setOpaque(true);
		mnNewMenu_2.setBackground(new Color(0, 255, 127));
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_3 = new JMenuItem("Mant. Producto");
		mntmNewMenuItem_3.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/box.png")));
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_3);

		mnNewMenu_3 = new JMenu("Ayuda");
		mnNewMenu_3.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/help.png")));
		mnNewMenu_3.addMouseListener(this);

		mnNewMenu_1 = new JMenu("Transacciones");
		mnNewMenu_1.addMouseListener(this);
		mnNewMenu_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/sell.png")));
		mnNewMenu_1.setOpaque(true);
		mnNewMenu_1.setBackground(new Color(0, 255, 127));
		menuBar.add(mnNewMenu_1);

		mntmGenerarVenta = new JMenuItem("Venta Productos");
		mntmGenerarVenta.addActionListener(this);
		mntmGenerarVenta.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/seller.png")));
		mnNewMenu_1.add(mntmGenerarVenta);
		
		mntmNewMenuItem_4 = new JMenuItem("Compra Productos");
		mntmNewMenuItem_4.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/buy.png")));
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mnNewMenu_6 = new JMenu("Reportes");
		mnNewMenu_6.addMouseListener(this);
		mnNewMenu_6.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/report.png")));
		mnNewMenu_6.setOpaque(true);
		mnNewMenu_6.setBackground(new Color(0, 255, 127));
		menuBar.add(mnNewMenu_6);
		
		mntmNewMenuItem_6 = new JMenuItem("Reportes de Ventas");
		mntmNewMenuItem_6.addActionListener(this);
		mntmNewMenuItem_6.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/sell_report.png")));
		mnNewMenu_6.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_8 = new JMenuItem("Reportes de Compras");
		mntmNewMenuItem_8.addActionListener(this);
		mntmNewMenuItem_8.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/buy_report.png")));
		mnNewMenu_6.add(mntmNewMenuItem_8);
		mnNewMenu_3.setOpaque(true);
		mnNewMenu_3.setBackground(new Color(0, 255, 127));
		menuBar.add(mnNewMenu_3);

		mntmNewMenuItem_5 = new JMenuItem("Guia de Usuario");
		mntmNewMenuItem_5.addActionListener(this);
		mntmNewMenuItem_5.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/guide.png")));
		mnNewMenu_3.add(mntmNewMenuItem_5);

		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(152, 251, 152));
		contentPane.add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(new GridLayout(0, 2, 0, 0));

		panel = new JPanel();
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBackground(new Color(152, 251, 152));
		panelLogin.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(81, 179, 287, 150);
		panel_1.setMaximumSize(new Dimension(300, 150));
		panel_1.setOpaque(false);
		panel_1.setPreferredSize(new Dimension(300, 150));
		panel_1.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.addFocusListener(this);
		txtUsuario.setBorder(null);
		txtUsuario.setOpaque(false);
		txtUsuario.setBounds(132, 11, 144, 22);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblSubUsuario = new JLabel("");
		lblSubUsuario.setBounds(132, 31, 144, 14);
		panel_1.add(lblSubUsuario);
		lblSubUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubUsuario.setFont(new Font("Tahoma", Font.PLAIN, 9));

		txtPass = new JPasswordField();
		txtPass.addKeyListener(this);
		txtPass.addFocusListener(this);
		txtPass.setBorder(null);
		txtPass.setOpaque(false);
		txtPass.setBounds(132, 61, 144, 22);
		panel_1.add(txtPass);

		lblSubPass = new JLabel("");
		lblSubPass.setBounds(132, 81, 144, 14);
		panel_1.add(lblSubPass);
		lblSubPass.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSubPass.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(23, 11, 86, 22);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 16));
		lblNewLabel.setLabelFor(txtUsuario);

		lblNewLabel_1 = new JLabel("CLAVE");
		lblNewLabel_1.setBounds(23, 61, 86, 22);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 16));

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addKeyListener(this);
		btnIngresar.setMnemonic(KeyEvent.VK_ENTER);
		btnIngresar.setEnabled(false);
		btnIngresar.addActionListener(this);
		btnIngresar.setFocusPainted(false);
		btnIngresar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(154, 205, 50));
		btnIngresar.setBorder(null);
		btnIngresar.setBounds(23, 106, 253, 23);
		panel_1.add(btnIngresar);
		panel_3.add(panel_1);
		setLocationRelativeTo(null);

		panelSouth = new JPanel();
		panelSouth.setOpaque(false);
		FlowLayout fl_panelSouth = (FlowLayout) panelSouth.getLayout();
		fl_panelSouth.setHgap(2);
		fl_panelSouth.setAlignment(FlowLayout.LEFT);
		fl_panelSouth.setVgap(0);
		contentPane.add(panelSouth, BorderLayout.SOUTH);

		panelStatus = new JPanel();
		panelStatus.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panelStatus.setOpaque(false);
		panelSouth.add(panelStatus);
		panelStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel_3 = new JLabel("Estado del Servidor:");
		panelStatus.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));

		lblServerStaus = new JLabel("");
		panelStatus.add(lblServerStaus);
		lblServerStaus.addMouseListener(this);
		lblServerStaus.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/error_server_status.png")));

		/*****************************************************************************************/
		SpringLayout springLayout1 = new SpringLayout();
		panel_3.setLayout(springLayout1);
		Spring miSpring1 = Spring.constant(30, 50, 300);
		springLayout1.putConstraint(SpringLayout.WEST, panel_1, miSpring1, SpringLayout.WEST, panel_3);
		springLayout1.putConstraint(SpringLayout.EAST, panel_3, miSpring1, SpringLayout.EAST, panel_1);
		springLayout1.putConstraint(SpringLayout.NORTH, panel_1, miSpring1, SpringLayout.NORTH, panel_3);
		springLayout1.putConstraint(SpringLayout.SOUTH, panel_3, miSpring1, SpringLayout.SOUTH, panel_1);

		/*****************************************************************************************/

		separator = new JSeparator();
		separator.setBounds(132, 31, 144, 2);
		panel_1.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(132, 81, 144, 2);
		panel_1.add(separator_1);

		lblNoConnection = new JLabel("No hay conexion con el servidor");
		lblNoConnection.setVisible(false);
		lblNoConnection.setForeground(Color.RED);
		lblNoConnection.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNoConnection.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoConnection.setBounds(78, 130, 144, 14);
		panel_1.add(lblNoConnection);

		panelLblGreen = new JPanel();
		panelLogin.add(panelLblGreen);
		panelLblGreen.setLayout(new BorderLayout(0, 0));

		lblGreenBackground = new JLabel("");
		lblGreenBackground.setSize(new Dimension(417, 565));
		lblGreenBackground.setPreferredSize(new Dimension(1, 1));
		panelLblGreen.add(lblGreenBackground, BorderLayout.CENTER);
		lblGreenBackground.setFocusable(false);
		lblGreenBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGreenBackground.setBorder(null);

		addImgLabel(lblGreenBackground, "/IMG/PanelGreen.png");

		panelHome = new JPanel();
		panelHome.setOpaque(false);
		panelHome.setLayout(null);

		lblLogoHome = new JLabel("");
		lblLogoHome.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/logoBanner_Transparent.png")));
		lblLogoHome.setBounds(0, 0, 250, 150);
		lblLogoHome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogoHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoHome.setVerticalTextPosition(SwingConstants.CENTER);
		lblLogoHome.setVerticalAlignment(SwingConstants.CENTER);
		panelHome.add(lblLogoHome);

		panelDataUser.setVisible(false);
		panelHome.setVisible(false);
		lblLogoHome.setBounds(0, 0, panelHome.getWidth(), panelHome.getHeight());

	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == txtPass) {
			do_txtPass_focusGained(e);
		}
		if (e.getSource() == txtUsuario) {
			do_txtUsuario_focusGained(e);
		}
	}

	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtPass) {
			do_txtPass_focusLost(e);
		}
		if (e.getSource() == txtUsuario) {
			do_txtUsuario_focusLost(e);
		}
	}

	protected void do_txtUsuario_focusGained(FocusEvent e) {
		lblSubUsuario.setText("");
	}

	protected void do_txtPass_focusGained(FocusEvent e) {
		lblSubPass.setText("");
	}

	protected void do_txtUsuario_focusLost(FocusEvent e) {
		if (txtUsuario.getText().equals("")) {
			lblSubUsuario.setText("Debe ingresar el usuario");
			lblSubUsuario.setForeground(Color.RED);
		}
		txtUsuario.setText(txtUsuario.getText().toUpperCase());

	}

	protected void do_txtPass_focusLost(FocusEvent e) {
		if (txtPass.getPassword().length == 0) {
			lblSubPass.setText("Debe ingresar la clave");
			lblSubPass.setForeground(Color.RED);
		}

	}

	private void addImgLabel(JLabel lbl, String img) {
		ImageIcon image = new ImageIcon(getClass().getResource(img));
		Icon IconImg = new ImageIcon(
				image.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));// Calidad de
																											// escalado
		lbl.setIcon(IconImg);
	}

	public void windowStateChanged(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowStateChanged(e);
		}
	}

	protected void do_this_windowStateChanged(WindowEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_5) {
			do_mntmNewMenuItem_5_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_8) {
			do_mntmNewMenuItem_8_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_6) {
			do_mntmNewMenuItem_6_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_4) {
			do_mntmNewMenuItem_4_actionPerformed(e);
		}
		if (e.getSource() == mntmGenerarVenta) {
			do_mntmGenerarVenta_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			do_mntmNewMenuItem_3_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			do_mntmNewMenuItem_2_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			do_mntmNewMenuItem_1_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_7) {
			do_mntmNewMenuItem_7_actionPerformed(e);
		}
		if (e.getSource() == mntmRegistrarEmpleado) {
			do_mntmRegistrarEmpleado_actionPerformed(e);
		}

		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
		if (e.getSource() == mntmCerrarSesion) {
			do_mntmCerrarSesion_actionPerformed(e);
		}
		if (e.getSource() == btnIngresar) {
			do_btnIngresar_actionPerformed(e);
		}
	}

	protected void do_btnIngresar_actionPerformed(ActionEvent e) {
		
		validarIngreso();

	}

	private String obtenerClave(char[] pass) {
		String text = "";
		for (int i = 0; i < pass.length; i++) {
			text += pass[i];
		}
		return text;

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER && btnIngresar.isEnabled()) {
			validarIngreso();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtUsuario) {
			do_txtUsuario_keyTyped(e);
		}

		ModifyThread mt = new ModifyThread(txtUsuario, txtPass, btnIngresar, "txtPass");
		Thread t = new Thread(mt);
		t.start();

	}

	private void serverStatus() {
		Connection con = MySQLConexion8.getConexion();

		if (con != null) {
			lblServerStaus.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/check_server_status.png")));
			lblServerStaus.setToolTipText("El servidor se encuentra activo");
			serverStatusMessage = 0;
			lblNoConnection.setVisible(false);
		} else {
			lblServerStaus.setIcon(new ImageIcon(frmPrincipal.class.getResource("/IMG/error_server_status.png")));
			lblServerStaus.setToolTipText("Hubo un error al conectar con el servidor");
			serverStatusMessage = 1;
			lblNoConnection.setVisible(true);
		}

	}

	protected void do_txtUsuario_keyTyped(KeyEvent e) {
	}

	private void validarIngreso() {
		String user = txtUsuario.getText();
		String password = obtenerClave(txtPass.getPassword());
		ArrayList<Empleados> empList = gEmp.buscarEmpleadoIngreso(password);
		boolean userOK = false;
		boolean passOK = false;
		boolean con = Utils.MySQLConexion8.getConexion() != null;

		for (Empleados emp : empList) {
			if (emp.getUsuario().equalsIgnoreCase(user)) {
				userOK = true;
				if (emp.getClave().equals(password)) {
					passOK = true;
					trabajador = emp;
				}
			}
		}
		if (userOK && passOK && con) {
			panelDataUser.setVisible(true);
			panelLogin.setVisible(false);
			txtPass.setText("");
			txtUsuario.setText("");
			contentPane.remove(panelLogin);
			contentPane.add(panelHome, BorderLayout.CENTER);
			panelHome.setVisible(true);
			this.setResizable(true);
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setResizable(false);

			lblEmpleadoNorth.setText(trabajador.getNombre() + " " + trabajador.getApellido() + "  ");
			lblCargoNorth.setText(trabajador.getCargo());

			ModifyThread mt = new ModifyThread(lblLogoHome, "lblLogoHome", panelHome);
			Thread t = new Thread(mt);
			t.start();
			panelDataUser.setVisible(true);

		} else if (con) {
			JOptionPane.showMessageDialog(panel_1, "Usuario o contraseña Incorrectos");
			txtUsuario.setText("");
			txtPass.setText("");
			txtUsuario.requestFocus();
		} else {
			JOptionPane.showMessageDialog(panel_1, "Ocurrio un Error al conectar con la Base de Datos");
			txtUsuario.setText("");
			txtPass.setText("");
			txtUsuario.requestFocus();
		}
	}

	protected void do_mntmCerrarSesion_actionPerformed(ActionEvent e) {
		panelHome.setVisible(false);
		panelDataUser.setVisible(false);
		contentPane.remove(panelHome);
		contentPane.add(panelLogin, BorderLayout.CENTER);
		panelLogin.setVisible(true);
		btnIngresar.setEnabled(false);
		this.setExtendedState(Frame.NORMAL);
		trabajador = null;
	}

	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblServerStaus) {
			do_lblServerStaus_mouseClicked(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == mnNewMenu_1) {
			do_mnNewMenu_1_mouseEntered(e);
		}
		if (e.getSource() == mnNewMenu_3) {
			do_mnNewMenu_3_mouseEntered(e);
		}
		if (e.getSource() == mnNewMenu_2) {
			do_mnNewMenu_2_mouseEntered(e);
		}
		if (e.getSource() == mnNewMenu) {
			do_mnNewMenu_mouseEntered(e);
		}
		if (e.getSource() == mnMantenimiento) {
			do_mnMantenimiento_mouseEntered(e);
		}
		if (e.getSource() == mnNewMenu_6) {
			do_mnNewMenu_6_mouseEntered(e);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == mnNewMenu_3) {
			do_mnNewMenu_3_mouseExited(e);
		}
		if (e.getSource() == mnNewMenu_2) {
			do_mnNewMenu_2_mouseExited(e);
		}
		if (e.getSource() == mnNewMenu) {
			do_mnNewMenu_mouseExited(e);
		}
		if (e.getSource() == mnMantenimiento) {
			do_mnMantenimiento_mouseExited(e);
		}
		if (e.getSource() == mnNewMenu_1) {
			do_mnNewMenu_1_mouseExited(e);
		}
		if (e.getSource() == mnNewMenu_6) {
			do_mnNewMenu_6_mouseExited(e);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void do_lblServerStaus_mouseClicked(MouseEvent e) {
		if (serverStatusMessage == 1) {
			mensajeReport msjError = new mensajeReport();
			msjError.setMessaje("Error Connection!!", errorConexion);
			msjError.setVisible(true);
		}

	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		if (e.getSource() == regiEmp) {
			do_regiEmp_internalFrameIconified(e);
		}

	}

	private void do_regiEmp_internalFrameIconified(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		if (e.getSource() == regiEmp) {
			do_regiEmp_internalFrameDeiconified(e);
		}

	}

	private void do_regiEmp_internalFrameDeiconified(InternalFrameEvent e) {
		panelHome.setComponentZOrder(regiEmp, 0);
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	protected void do_mntmRegistrarEmpleado_actionPerformed(ActionEvent e) {

		if (regiEmp.isVisible()) {
			try {
				regiEmp.setIcon(false);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		} else {
			regiEmp = new registrarEmpleado();
			panelHome.add(regiEmp, 0);
			try {
				regiEmp.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			regiEmp.setResizable(true);
			regiEmp.addInternalFrameListener(this);
			regiEmp.setVisible(true);

		}

	}

	protected void do_mnMantenimiento_mouseEntered(MouseEvent e) {
		mnMantenimiento.setBackground(new Color(76, 255, 0));
	}

	protected void do_mnNewMenu_mouseEntered(MouseEvent e) {
		mnNewMenu.setBackground(new Color(76, 255, 0));
	}

	protected void do_mnNewMenu_2_mouseEntered(MouseEvent e) {
		mnNewMenu_2.setBackground(new Color(76, 255, 0));
	}

	protected void do_mnNewMenu_3_mouseEntered(MouseEvent e) {
		mnNewMenu_3.setBackground(new Color(76, 255, 0));
	}
	
	protected void do_mnNewMenu_1_mouseEntered(MouseEvent e) {
		mnNewMenu_1.setBackground(new Color(76, 255, 0));
	}
	
	protected void do_mnNewMenu_6_mouseEntered(MouseEvent e) {
		mnNewMenu_6.setBackground(new Color(76, 255, 0));
	}

	private void do_mnMantenimiento_mouseExited(MouseEvent e) {
		mnMantenimiento.setBackground(new Color(0, 255, 127));
	}

	private void do_mnNewMenu_3_mouseExited(MouseEvent e) {
		mnNewMenu_3.setBackground(new Color(0, 255, 127));

	}

	private void do_mnNewMenu_2_mouseExited(MouseEvent e) {
		mnNewMenu_2.setBackground(new Color(0, 255, 127));

	}

	private void do_mnNewMenu_mouseExited(MouseEvent e) {
		mnNewMenu.setBackground(new Color(0, 255, 127));

	}
	
	protected void do_mnNewMenu_1_mouseExited(MouseEvent e) {
		mnNewMenu_1.setBackground(new Color(0, 255, 127));
	}
	
	protected void do_mnNewMenu_6_mouseExited(MouseEvent e) {
		mnNewMenu_6.setBackground(new Color(0, 255, 127));
	}
	
	

	public void windowActivated(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowActivated(e);
		}

	}

	private void do_this_windowActivated(WindowEvent e) {
		timerServer.start();
		timerTime.start();
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowDeiconified(e);
		}
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	protected void do_this_windowDeiconified(WindowEvent e) {
		if (!panelLogin.isVisible()) {
			this.setResizable(true);
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setResizable(false);
		}
	}

	protected void do_mntmNewMenuItem_7_actionPerformed(ActionEvent e) {

		if (consuEmp.isVisible()) {
			try {
				consuEmp.setIcon(false);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		} else {
			consuEmp = new consultarEmpleado(this);
			panelHome.add(consuEmp, 0);
			try {
				consuEmp.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			consuEmp.setResizable(true);
			consuEmp.addInternalFrameListener(this);
			consuEmp.setVisible(true);

		}
	}

	public static registrarEmpleado obtenerClaseVerificacionVisible(String clase) {
		if (clase.equals("MantenimientoEmpleado")) {
			return regiEmp;
		}
		return null;
	}

	public static JPanel obtenerPanelHome() {
		return panelHome;
	}

	public void modi(Object[] obj, String name) {
		if (name.equals("regiEmp")) {
			if (regiEmp.isVisible()) {
				try {
					consuEmp.setIcon(true);
					regiEmp.setIcon(false);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buscarEmpleado((String) obj[2], "Empleado");

			} else if (!regiEmp.isVisible()) {
				regiEmp = new registrarEmpleado();
				panelHome.add(regiEmp, 0);
				try {
					regiEmp.setMaximum(true);
					consuEmp.setIcon(true);
					regiEmp.setResizable(true);
					regiEmp.addInternalFrameListener(this);
					regiEmp.setVisible(true);
					buscarEmpleado((String) obj[2], "Empleado");
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (name.equals("regiCliente")) {

			if (regiCliente.isVisible()) {
				try {
					consuCliente.setIcon(true);
					regiCliente.setIcon(false);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buscarEmpleado((String) obj[2], "Cliente");

			} else if (!regiCliente.isVisible()) {
				regiCliente = new registrarCliente();
				panelHome.add(regiCliente, 0);
				try {
					regiCliente.setMaximum(true);
					consuCliente.setIcon(true);
					regiCliente.setResizable(true);
					regiCliente.addInternalFrameListener(this);
					regiCliente.setVisible(true);
					buscarEmpleado((String) obj[2], "Cliente");
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void buscarEmpleado(String code, String name) {
		if (name.equals("Empleado")) {
			System.out.println("Entro a empleado");
			regiEmp.construirTablaPorCodigo(code);
		} else if (name.equals("Cliente")) {
			System.out.println("Entro a cliente");
			regiCliente.construirTablaPorCodigo(code);
		}
	}

	private void obtenerHora() {
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("mm");

		String horas = dtf1.format(LocalDateTime.now());
		String minutos = dtf2.format(LocalDateTime.now());

		HoraActual = horas + " : " + minutos
				+ (Integer.parseInt(horas) > 11 && Integer.parseInt(horas) < 24 ? " PM  " : " AM  ");
		lblHoraNorth.setText(HoraActual);
	}

	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {

		if (regiCliente.isVisible()) {
			try {
				regiCliente.setIcon(false);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		} else {
			regiCliente = new registrarCliente();
			panelHome.add(regiCliente, 0);
			try {
				regiCliente.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			regiCliente.setResizable(true);
			regiCliente.addInternalFrameListener(this);
			regiCliente.setVisible(true);

		}

	}

	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {

		if (consuCliente.isVisible()) {
			try {
				consuCliente.setIcon(false);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		} else {
			consuCliente = new consultarCliente(this);
			panelHome.add(consuCliente, 0);
			try {
				consuCliente.setMaximum(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			consuCliente.setResizable(true);
			consuCliente.addInternalFrameListener(this);
			consuCliente.setVisible(true);

		}
	}

	protected void do_mntmNewMenuItem_3_actionPerformed(ActionEvent e) {
		manProd = new mantenimiento_Productos();
		panelHome.add(manProd, 0);
		manProd.setVisible(true);
		try {
			manProd.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void do_mntmGenerarVenta_actionPerformed(ActionEvent e) {
		genVenta = new generarVenta();
		panelHome.add(genVenta, 0);
		genVenta.setVisible(true);
		try {
			genVenta.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void do_mntmNewMenuItem_4_actionPerformed(ActionEvent e) {
		genCompra = new generarCompra();
		panelHome.add(genCompra, 0);
		genCompra.setVisible(true);
		try {
			genCompra.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	protected void do_mntmNewMenuItem_6_actionPerformed(ActionEvent e) {
		reportesVenta rV = new reportesVenta();
		rV.setVisible(true);
	}
	protected void do_mntmNewMenuItem_8_actionPerformed(ActionEvent e) {
		reportesCompra rC = new reportesCompra();
		rC.setVisible(true);
	}
	protected void do_mntmNewMenuItem_5_actionPerformed(ActionEvent e) {
		try {
			Desktop.getDesktop().open(new File("HELP/USER_GUIDE.pdf"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
