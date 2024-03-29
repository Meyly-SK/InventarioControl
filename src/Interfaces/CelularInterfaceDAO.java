package Interfaces;

import java.util.ArrayList;

import Entidad.Celular;


public interface CelularInterfaceDAO {
	public int registrarCelular(Celular c);
	public int EliminarCelular(Celular c);
	public int actualizarCelular(Celular c);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Celular> buscarCelular(String name);
	public ArrayList<Celular> leerCelular();

}
