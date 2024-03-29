package Interfaces;

import java.util.ArrayList;

import Entidad.Teclados;

public interface TecladoInterfaceDAO {
	public int registrarTeclado(Teclados t);
	public int EliminarTeclado(Teclados t);
	public int actualizarTeclado(Teclados t);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Teclados> buscarTeclado(String name);
	public ArrayList<Teclados> leerTeclado();

}
