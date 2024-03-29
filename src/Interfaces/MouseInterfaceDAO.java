package Interfaces;

import java.util.ArrayList;

import Entidad.Mouse;
public interface MouseInterfaceDAO {
	public int registrarMouse(Mouse m);
	public int EliminarMouse(Mouse m);
	public int actualizarMouse(Mouse m);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Mouse> buscarMouse(String name);
	public ArrayList<Mouse> leerMouse();
}
