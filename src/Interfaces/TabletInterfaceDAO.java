package Interfaces;

import java.util.ArrayList;

import Entidad.Tablet;

public interface TabletInterfaceDAO {
	public int registrarTablet(Tablet t);
	public int EliminarTablet(Tablet t);
	public int actualizarTablet(Tablet t);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Tablet> buscarTablet(String name);
	public ArrayList<Tablet> leerTablet();
}
