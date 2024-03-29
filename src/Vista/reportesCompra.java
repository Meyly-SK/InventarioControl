package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import Entidad.Boleta;
import Mantenimiento.GestionBoletaDAO;
import Utils.editCells;
import Utils.editColumns;
import Utils.tableModel;
import Utils.typeUtility;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class reportesCompra extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOpen;
	private JTable tbReports;
	private JTextField txtFecha;

	GestionBoletaDAO gBoleta = new GestionBoletaDAO();

	ArrayList<Boleta> listaBoleta;
	ArrayList<Object> listaTitulos;

	tableModel modelo;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JTextArea lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reportesCompra frame = new reportesCompra();
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
	public reportesCompra() {
		setResizable(false);
		setTitle("Reportes Compra");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		btnOpen = new JButton("");
		btnOpen.setToolTipText("Abrir");
		btnOpen.addActionListener(this);
		btnOpen.setIcon(new ImageIcon(reportesCompra.class.getResource("/IMG/open.png")));
		btnOpen.setBounds(10, 9, 40, 40);
		contentPane.add(btnOpen);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 614, 370);
		contentPane.add(scrollPane);

		tbReports = new JTable();
		tbReports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbReports);

		txtFecha = new JTextField();
		txtFecha.setBounds(426, 9, 148, 40);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(reportesCompra.class.getResource("/IMG/bigSearch.png")));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(584, 9, 40, 40);
		contentPane.add(btnBuscar);
		
		lblNewLabel = new JTextArea("Ingrese un fecha\r\nCompleta o parcialmente");
		lblNewLabel.setEditable(false);
		lblNewLabel.setOpaque(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(268, 9, 148, 40);
		contentPane.add(lblNewLabel);

		construirTabla();
	}

	private ArrayList<Object> cargarColumnas() {
		ArrayList<Object> lista = gBoleta.leerColumnas("compra");
		return lista;
	}

	private ArrayList<Boleta> cargarBoletas() {
		ArrayList<Boleta> lista = gBoleta.leerBoleta("compra");
		return lista;
	}

	public void construirTabla() {
		listaBoleta = cargarBoletas();
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Boleta");

		Object[][] data = obtenerMatrizDatos(listaTitulos, util);
		construirTabla(titulos, data, util);
	}
	
	public void construirTablaPorFecha(String fecha) {
		listaBoleta = gBoleta.buscarBoleta(fecha, "compra");
		listaTitulos = cargarColumnas();

		String[] titulos = new String[listaTitulos.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = (String) listaTitulos.get(i);
		}

		typeUtility util = new typeUtility("Boleta");

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
		tbReports.setModel(modelo);

		// Se asigna el tipo de dato que tendra cada celda
		tbReports.getColumnModel().getColumn(util.getNum()).setCellRenderer(new editCells("numerico"));
		tbReports.getColumnModel().getColumn(util.getCodBoleta()).setCellRenderer(new editCells("texto"));
		tbReports.getColumnModel().getColumn(util.getCod_Empleado()).setCellRenderer(new editCells("texto"));
		tbReports.getColumnModel().getColumn(util.getCod_Cli_Prov()).setCellRenderer(new editCells("numerico"));
		tbReports.getColumnModel().getColumn(util.getFechaVenta()).setCellRenderer(new editCells("numerico"));
		tbReports.getColumnModel().getColumn(util.getDescripcion()).setCellRenderer(new editCells("numerico"));
		tbReports.getColumnModel().getColumn(util.getImporte()).setCellRenderer(new editCells("numerico"));

		tbReports.getColumnModel().getColumn(util.getNum()).setPreferredWidth(75);
		tbReports.getColumnModel().getColumn(util.getCodBoleta()).setPreferredWidth(120);
		tbReports.getColumnModel().getColumn(util.getCod_Empleado()).setPreferredWidth(75);
		tbReports.getColumnModel().getColumn(util.getCod_Cli_Prov()).setPreferredWidth(75);
		tbReports.getColumnModel().getColumn(util.getFechaVenta()).setPreferredWidth(100);
		tbReports.getColumnModel().getColumn(util.getDescripcion()).setPreferredWidth(250);
		tbReports.getColumnModel().getColumn(util.getImporte()).setPreferredWidth(100);

		tbReports.getTableHeader().setReorderingAllowed(false);
		tbReports.setRowHeight(25);
		tbReports.setGridColor(new Color(0, 0, 0));

		JTableHeader jtableheader = tbReports.getTableHeader();
		jtableheader.setDefaultRenderer(new editColumns());
		tbReports.setTableHeader(jtableheader);

	}

	private Object[][] obtenerMatrizDatos(ArrayList<Object> listaTitulos2, typeUtility util) {
		String informacion[][] = new String[listaBoleta.size()][listaTitulos.size()];

		for (int x = 0; x < informacion.length; x++) {

			informacion[x][util.getNum()] = listaBoleta.get(x).getNum() + "";
			informacion[x][util.getCodBoleta()] = listaBoleta.get(x).getCodBoleta() + "";
			informacion[x][util.getCod_Empleado()] = listaBoleta.get(x).getCod_Empleado() + "";
			informacion[x][util.getCod_Cli_Prov()] = listaBoleta.get(x).getCod_Cli_Prov() + "";
			informacion[x][util.getFechaVenta()] = listaBoleta.get(x).getFechaVenta() + "";
			informacion[x][util.getDescripcion()] = listaBoleta.get(x).getDescripcion() + "";
			informacion[x][util.getImporte()] = listaBoleta.get(x).getImporte() + "";

		}
		return informacion;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			do_btnOpen_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		if(!txtFecha.getText().trim().equals("")) {
			construirTablaPorFecha(txtFecha.getText().trim());
			if(modelo.getRowCount()<1) {
				JOptionPane.showMessageDialog(null, "Sin Coincidencias");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Debe ingresar una fecha completa o parcial\nCon el formato YYYY-MM-dd");
		}
	}

	protected void do_btnOpen_actionPerformed(ActionEvent e) {
		boolean condicion = true;
		int rowNum = tbReports.getSelectedRow();
		if (rowNum != -1) {
			String codeIni = tbReports.getValueAt(rowNum, 1) + "";
			char[] codeArray = codeIni.toCharArray();
			String codeFinal = "";
			for (char uni : codeArray) {
				if (!String.valueOf(uni).equals("N") && !String.valueOf(uni).equals(" ")
						&& !String.valueOf(uni).equals("-")) {
					codeFinal += String.valueOf(uni);
				}
			}
			File carpeta = new File("Reportes/ReporteCompra");
			String[] filesList = carpeta.list();
			for (String fList : filesList) {
				if (fList.contains(codeFinal)) {
					try {
						condicion = false;
						Desktop.getDesktop().open(new File("Reportes/ReporteCompra/" + fList));
						
					} catch (Exception e1) {
					System.out.println("Error al abrir el archivo "+e1);
					}
					break;
				}
			}
			
			
			if(condicion) {
				int result = JOptionPane.showConfirmDialog(null,
						"No se ha encontrado el documento solicitado\n¿Desea visualizar la informacion en una ventana virtual?",
						"ERROR!", JOptionPane.YES_NO_OPTION);
				if(result == 0) {
					Boleta boleta = new Boleta();
					boleta.setNum(Integer.parseInt(tbReports.getValueAt(rowNum, 0)+""));
					boleta.setCodBoleta(tbReports.getValueAt(rowNum, 1)+"");
					boleta.setCod_Empleado(tbReports.getValueAt(rowNum, 2)+"");
					boleta.setCod_Cli_Prov(tbReports.getValueAt(rowNum, 3)+"");
					boleta.setFechaVenta(tbReports.getValueAt(rowNum, 4)+"");
					boleta.setDescripcion(tbReports.getValueAt(rowNum, 5)+"");
					boleta.setImporte(Double.parseDouble(tbReports.getValueAt(rowNum, 6)+""));
					
					mensajeReport mR = new mensajeReport();
					mR.setMessaje("Reporte Virtual",  
							"Num: "+boleta.getNum()+"\n"
							+ "Codigo Boleta: "+boleta.getCodBoleta()+"\n"
							+ "Codigo Empleado: "+boleta.getCod_Empleado()+"\n"
							+ "Codigo Proveedor: "+boleta.getCod_Cli_Prov()+"\n"
							+ "Fecha de Venta: "+boleta.getFechaVenta()+"\n"
							+ "Descripcion:\n"+boleta.getDescripcion()
							+ "Importe Total: "+boleta.getImporte());
					mR.setVisible(true);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un reporte!");
		}
		
	}
}
