package Interfaces;

import java.util.ArrayList;

import Entidad.Sedes;

public interface SedeInterfaceDAO {
	
	//listar
	public ArrayList<Sedes> listarSedes();
	//Buscar Codigo Sede
	String buscarCodSede(String s);

}
