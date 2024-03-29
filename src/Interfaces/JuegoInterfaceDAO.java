package Interfaces;

import java.util.ArrayList;

import Entidad.Juegos;


public interface JuegoInterfaceDAO {
	public int registrarJuegos(Juegos j);
	public int EliminarJuegos(Juegos j);
	public int actualizarJuegos(Juegos j);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Juegos> buscarJuegos(String name);
	public ArrayList<Juegos> leerJuegos();
}
