package Interfaces;

import java.util.ArrayList;

import Entidad.Mandos;


public interface MandoInterfaceDAO {
	public int registrarMandos(Mandos j);
	public int EliminarMandos(Mandos j);
	public int actualizarMandos(Mandos j);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Mandos> buscarMandos(String name);
	public ArrayList<Mandos> leerMandos();
}
