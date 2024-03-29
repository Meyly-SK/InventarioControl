package Interfaces;

import java.util.ArrayList;

import Entidad.TecladoG;

public interface TecladoGamerInterfaceDAO {
	public int registrarTecladoGamer(TecladoG t);
	public int EliminarTecladoGamer(TecladoG t);
	public int actualizarTecladoGamer(TecladoG t);
	public ArrayList<Object> leerColumnas();
	public ArrayList<TecladoG> buscarTecladoGamer(String name);
	public ArrayList<TecladoG> leerTecladoGamer();

}
