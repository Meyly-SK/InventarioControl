package Interfaces;

import java.util.ArrayList;
import Entidad.Proveedor;

public interface ProveedorInterfaceDAO {
	public ArrayList<Object> leerColumnas();
	public ArrayList<Proveedor> leerProveedor();
	public ArrayList<Proveedor> busquedaPorCodigo(String code);

}
