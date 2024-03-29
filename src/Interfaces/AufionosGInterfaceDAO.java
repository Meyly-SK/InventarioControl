package Interfaces;

import java.util.ArrayList;

import Entidad.AudifonosG;


public interface AufionosGInterfaceDAO {
	public int registrarAudifonosGamer(AudifonosG a);
	public int EliminarAudifonosGamer(AudifonosG a);
	public int actualizarAudifonosGamer(AudifonosG a);
	public ArrayList<Object> leerColumnas();
	public ArrayList<AudifonosG> buscarAudifonosGamer(String name);
	public ArrayList<AudifonosG> leerAudifonosGamer();
}
