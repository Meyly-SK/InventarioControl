package Interfaces;

import java.util.ArrayList;

import Entidad.Audifonos;


public interface AudifonoInterfaceDAO {
	public int registrarAudifono(Audifonos a);
	public int EliminarAudifono(Audifonos a);
	public int actualizarAudifono(Audifonos a);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Audifonos> buscarAudifono(String name);
	public ArrayList<Audifonos> leerAudifono();
}
