package Utils;

import javax.swing.table.DefaultTableModel;

public class tableModel extends DefaultTableModel{

	String[] titulos;
	Object[][] datos;
	
	public tableModel( Object[][] datos, String[] titulos) {
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}

	
}
