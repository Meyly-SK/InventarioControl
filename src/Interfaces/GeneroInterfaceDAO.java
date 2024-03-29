package Interfaces;

import java.util.ArrayList;

import Entidad.Genero;

public interface GeneroInterfaceDAO {
	// listar
	public ArrayList<Genero> listarGenero();

	// buscar codigo genero
	String buscarCodGenero(String g);
}
