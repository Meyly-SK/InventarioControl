package Interfaces;

import java.util.ArrayList;

import Entidad.CamaraWeb;


public interface CamaraWebInterfaceDAO {
	public int registrarCamaraWeb(CamaraWeb c);
	public int EliminarCamaraWeb(CamaraWeb c);
	public int actualizarCamaraWeb(CamaraWeb c);
	public ArrayList<Object> leerColumnas();
	public ArrayList<CamaraWeb> buscarCamaraWeb(String name);
	public ArrayList<CamaraWeb> leerCamaraWeb();

}
