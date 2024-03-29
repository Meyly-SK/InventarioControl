package Interfaces;

import java.util.ArrayList;

import Entidad.SillaG;


public interface SillaGamerInterfaceDAO {
	
	public int registrarSillaGamer(SillaG s);
	public int EliminarSillaGamer(SillaG s);
	public int actualizarSillaGamer(SillaG s);
	public ArrayList<Object> leerColumnas();
	public ArrayList<SillaG> buscarSillaGamer(String name);
	public ArrayList<SillaG> leerSillaGamer();

}
