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

import Entidad.Clientes;
import Mantenimiento.GestionClienteDAO;
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

public class seleccionarCliente extends JDialog implements ActionListener, WindowListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbClientes;
	private GestionClienteDAO gCliente = new GestionClienteDAO();
	private ArrayList<Clientes> listaPersonas = new ArrayList<Clientes>();
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
			seleccionarCliente dialog = new seleccionarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public seleccionarCliente() {
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
				tbClientes = new JTable();
				scrollPane.setViewportView(tbClientes);
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
					lblNewLabel = new JLabel("SELECCIONE EL CLIENTE COMPRADOR");
					buttonPane.add(lblNewLabel);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private ArrayList<String> cargarColumnas() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("CODIGO");
		lista.add("NOMBRE");
		lista.add("APELLIDO");
		lista.add("DNI");
		return lista;
	}

	private ArrayList<Clientes> cargarClientes(int nume) {
		ArrayList<Clientes> lista = gCliente.leerClientes(nume, true);
		return lista;
	}

	private void construirTabla(int nume) {
		listaPersonas = cargarClientes(nume);
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Clientes");

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
		tbClientes.setModel(modelo);

		// Se asigna el tipo de dato que tendra cada celda
		tbClientes.getColumnModel().getColumn(util.getCodigo()).setCellRenderer(new editCells("numerico"));
		tbClientes.getColumnModel().getColumn(util.getNombre()).setCellRenderer(new editCells("texto"));
		tbClientes.getColumnModel().getColumn(util.getApellido()).setCellRenderer(new editCells("texto"));
		tbClientes.getColumnModel().getColumn(util.getDni()).setCellRenderer(new editCells("numerico"));

		tbClientes.getColumnModel().getColumn(util.getCodigo()).setPreferredWidth(75);
		tbClientes.getColumnModel().getColumn(util.getNombre()).setPreferredWidth(150);
		tbClientes.getColumnModel().getColumn(util.getApellido()).setPreferredWidth(150);
		tbClientes.getColumnModel().getColumn(util.getDni()).setPreferredWidth(115);

		tbClientes.getTableHeader().setReorderingAllowed(false);
		tbClientes.setRowHeight(25);
		tbClientes.setGridColor(new Color(0, 0, 0));

		JTableHeader jtableheader = tbClientes.getTableHeader();
		jtableheader.setDefaultRenderer(new editColumns());
		tbClientes.setTableHeader(jtableheader);

	}

	private Object[][] obtenerMatrizDatos(ArrayList<String> listaTitulos2, typeUtility util) {
		String informacion[][] = new String[listaPersonas.size()][listaTitulos.size()];

		for (int x = 0; x < informacion.length; x++) {

			informacion[x][util.getCodigo()] = listaPersonas.get(x).getCodigo() + "";
			informacion[x][util.getNombre()] = listaPersonas.get(x).getNombre() + "";
			informacion[x][util.getApellido()] = listaPersonas.get(x).getApellido() + "";
			informacion[x][util.getDni()] = listaPersonas.get(x).getDni() + "";

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
		if (tbClientes.getSelectedRow() != -1) {
			String code = tbClientes.getValueAt(tbClientes.getSelectedRow(), 0) + "";
			ArrayList<Clientes> cli = gCliente.busquedaPorCodigo(code);
			frmPrincipal.cliente = cli.get(0);
			generarVenta.cargarCliente();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente");
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
		construirTabla(0);
	}
}
