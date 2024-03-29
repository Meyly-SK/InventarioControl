package Interfaces;

import java.util.ArrayList;

import Entidad.Televisor;

public interface TelevisorInterfaceDAO {
	public int registrarTelevisor(Televisor t);
	public int EliminarTelevisor(Televisor t);
	public int actualizarTelevisor(Televisor t);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Televisor> buscarTelevisor(String name);
	public ArrayList<Televisor> leerTelevisor();

}
