package Interfaces;

import java.util.ArrayList;

import Entidad.PCEscritorio;

public interface PCEscritorioInterfaceDAO {
	public int registrarPCEscritorio(PCEscritorio p);
	public int EliminarPCEscritorio(PCEscritorio p);
	public int actualizarPCEscritorio(PCEscritorio p);
	public ArrayList<Object> leerColumnas();
	public ArrayList<PCEscritorio> buscarPCEscritorio(String name);
	public ArrayList<PCEscritorio> leerPCEscritorio();

}
