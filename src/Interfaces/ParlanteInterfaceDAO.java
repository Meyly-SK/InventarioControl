package Interfaces;

import java.util.ArrayList;

import Entidad.Parlantes;


public interface ParlanteInterfaceDAO {
	public int registrarParlante(Parlantes p);
	public int EliminarParlante(Parlantes p);
	public int actualizarParlante(Parlantes p);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Parlantes> buscarParlante(String name);
	public ArrayList<Parlantes> leerParlante();

}
