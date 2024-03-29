package Interfaces;

import java.util.ArrayList;

import Entidad.EstadoCivil;

public interface EstCivilInterfaceDAO {
	// listar
	public ArrayList<EstadoCivil> listarEstadoCivil();

	//Buscar codigo Estado Civil
	String buscarCodEstCivil(String s);
}
