package Interfaces;

import java.util.ArrayList;

import Entidad.Boleta;

public interface BoletaInterfaceDAO{

	public ArrayList<Boleta> leerBoleta(String tipo);
	public int registrarBoleta(Boleta bol, ArrayList<String[]> lista, String tipo);
	public ArrayList<Object> leerColumnas(String tipo);
	public ArrayList<Boleta> buscarBoleta(String fecha, String tipo);
}
