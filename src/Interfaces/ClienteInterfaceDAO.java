package Interfaces;

import java.util.ArrayList;

import Entidad.Clientes;

public interface ClienteInterfaceDAO {
	public int registrarClientes(Clientes e);
	public int EliminarClientes(Clientes e);
	public int actualizarClientes(Clientes e);
	public ArrayList<Object> leerColumnas();
	public String buscarGenero(String s);
	public String buscarEstCivil(String s);
	public ArrayList<Clientes> buscarClientes(String filter, int num, ArrayList<String> lista);
	public ArrayList<Clientes> leerClientes(int column, boolean condition);
	public ArrayList<Clientes> busquedaPorCodigo(String string);

}
