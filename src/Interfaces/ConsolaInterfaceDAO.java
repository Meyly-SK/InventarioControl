package Interfaces;

import java.util.ArrayList;

import Entidad.Consolas;

public interface ConsolaInterfaceDAO {
	public int registrarConsolas(Consolas c);
	public int EliminarConsolas(Consolas c);
	public int actualizarConsolas(Consolas c);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Consolas> buscarConsolas(String name);
	public ArrayList<Consolas> leerConsolas();
}
