package Interfaces;

import java.util.ArrayList;

import Entidad.LaptopG;


public interface LaptopGamerInterfaceDAO {
	public int registrarLaptopGamer(LaptopG a);
	public int EliminarLaptopGamer(LaptopG a);
	public int actualizarLaptopGamer(LaptopG a);
	public ArrayList<Object> leerColumnas();
	public ArrayList<LaptopG> buscarLaptopGamer(String name);
	public ArrayList<LaptopG> leerLaptopGamer();

}
