package Interfaces;

import java.util.ArrayList;

import Entidad.MouseG;


public interface MouseGamerInterfaceDAO {
	public int registrarMouseGamer(MouseG m);
	public int EliminarMouseGamer(MouseG m);
	public int actualizarMouseGamer(MouseG m);
	public ArrayList<Object> leerColumnas();
	public ArrayList<MouseG> buscarMouseGamer(String name);
	public ArrayList<MouseG> leerMouseGamer();

}
