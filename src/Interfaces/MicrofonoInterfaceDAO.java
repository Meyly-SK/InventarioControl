package Interfaces;

import java.util.ArrayList;

import Entidad.Microfono;

public interface MicrofonoInterfaceDAO {
	public int registrarMicrofono(Microfono m);
	public int EliminarMicrofono(Microfono m);
	public int actualizarMicrofono(Microfono m);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Microfono> buscarMicrofono(String name);
	public ArrayList<Microfono> leerMicrofono();
}
