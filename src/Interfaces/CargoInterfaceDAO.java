package Interfaces;

import java.util.ArrayList;

import Entidad.Cargos;

public interface CargoInterfaceDAO {
	
	//listar
	public ArrayList<Cargos> listarCargos();
	
	//Buscar Codigo Cargo
	String buscarCodCargo(String c);

}
