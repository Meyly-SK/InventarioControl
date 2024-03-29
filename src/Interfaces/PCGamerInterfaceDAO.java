package Interfaces;

import java.util.ArrayList;

import Entidad.PCGamer;


public interface PCGamerInterfaceDAO {
	public int registrarPCGamer(PCGamer p);
	public int EliminarPCGamer(PCGamer p);
	public int actualizarPCGamer(PCGamer p);
	public ArrayList<Object> leerColumnas();
	public ArrayList<PCGamer> buscarPCGamer(String name);
	public ArrayList<PCGamer> leerPCGamer();

}
