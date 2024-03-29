package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import Entidad.Proveedor;
import Mantenimiento.GestionProveedorDAO;
import Utils.editCells;
import Utils.editColumns;
import Utils.tableModel;
import Utils.typeUtility;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class seleccionarProveedor extends JDialog implements ActionListener, WindowListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbProveedor;
	private GestionProveedorDAO gProveedor = new GestionProveedorDAO();
	private ArrayList<Proveedor> listaPersonas = new ArrayList<Proveedor>();
	private ArrayList<String> listaTitulos = new ArrayList<String>();
	private tableModel modelo;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			seleccionarProveedor dialog = new seleccionarProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public seleccionarProveedor() {
		addWindowListener(this);
		setBounds(100, 100, 690, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				tbProveedor = new JTable();
				scrollPane.setViewportView(tbProveedor);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				{
					lblNewLabel = new JLabel("SELECCIONE EL PROVEEDOR AL QUE LE DESEA COMPRAR");
					buttonPane.add(lblNewLabel);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

	private ArrayList<String> cargarColumnas() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("CODIGO");
		lista.add("RAZON SOCIAL");
		lista.add("RUC");
		lista.add("CONTACTO");
		lista.add("CORREO");
		lista.add("DIRECCION");
		lista.add("SEDE");
		return lista;
	}

	private ArrayList<Proveedor> cargarProveedores() {
		ArrayList<Proveedor> lista = gProveedor.leerProveedor();
		return lista;
	}

	private void construirTabla() {
		listaPersonas = cargarProveedores();
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Proveedor");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
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
		tbProveedor.setModel(modelo);

		// Se asigna el tipo de dato que tendra cada celda
		tbProveedor.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
		tbProveedor.getColumnModel().getColumn(util.getRazonSocial()).setCellRenderer(new editCells("texto"));
		tbProveedor.getColumnModel().getColumn(util.getRuc()).setCellRenderer(new editCells("texto"));
		tbProveedor.getColumnModel().getColumn(util.getContacto()).setCellRenderer(new editCells("texto"));
		tbProveedor.getColumnModel().getColumn(util.getCorreo()).setCellRenderer(new editCells("texto"));
		tbProveedor.getColumnModel().getColumn(util.getDireccion()).setCellRenderer(new editCells("texto"));
		tbProveedor.getColumnModel().getColumn(util.getSede()).setCellRenderer(new editCells("texto"));

		tbProveedor.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
		tbProveedor.getColumnModel().getColumn(util.getRazonSocial()).setPreferredWidth(150);
		tbProveedor.getColumnModel().getColumn(util.getRuc()).setPreferredWidth(150);
		tbProveedor.getColumnModel().getColumn(util.getContacto()).setPreferredWidth(115);
		tbProveedor.getColumnModel().getColumn(util.getCorreo()).setPreferredWidth(115);
		tbProveedor.getColumnModel().getColumn(util.getDireccion()).setPreferredWidth(115);
		tbProveedor.getColumnModel().getColumn(util.getSede()).setPreferredWidth(115);

		tbProveedor.getTableHeader().setReorderingAllowed(false);
		tbProveedor.setRowHeight(25);
		tbProveedor.setGridColor(new Color(0, 0, 0));

		JTableHeader jtableheader = tbProveedor.getTableHeader();
		jtableheader.setDefaultRenderer(new editColumns());
		tbProveedor.setTableHeader(jtableheader);

	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> listaTitulos2, typeUtility util) {
		String informacion[][] = new String[listaPersonas.size()][listaTitulos.size()];

		for (int x = 0; x < informacion.length; x++) {

			informacion[x][util.getCodigo()] = listaPersonas.get(x).getCodigo() + "";
			informacion[x][util.getRazonSocial()] = listaPersonas.get(x).getRazonSocial() + "";
			informacion[x][util.getRuc()] = listaPersonas.get(x).getRuc() + "";
			informacion[x][util.getContacto()] = listaPersonas.get(x).getContacto() + "";
			informacion[x][util.getCorreo()] = listaPersonas.get(x).getCorreo() + "";
			informacion[x][util.getDireccion()] = listaPersonas.get(x).getDireccion() + "";
			informacion[x][util.getSede()] = listaPersonas.get(x).getSede() + "";

		}
		return informacion;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			do_cancelButton_actionPerformed(e);
		}
		if (e.getSource() == okButton) {
			do_okButton_actionPerformed(e);
		}
	}

	protected void do_okButton_actionPerformed(ActionEvent e) {
		if (tbProveedor.getSelectedRow() != -1) {
			String code = tbProveedor.getValueAt(tbProveedor.getSelectedRow(), 0) + "";
			ArrayList<Proveedor> proveedor = gProveedor.busquedaPorCodigo(code);
			frmPrincipal.proveedor = proveedor.get(0);
			generarCompra.cargarProveedor();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor");
		}
	}

	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	public void windowActivated(WindowEvent e) {
		if (e.getSource() == this) {
			do_this_windowActivated(e);
		}
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	protected void do_this_windowActivated(WindowEvent e) {
		construirTabla();
	}
}
