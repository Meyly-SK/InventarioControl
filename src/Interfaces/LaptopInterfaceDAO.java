package Interfaces;

import java.util.ArrayList;

import Entidad.Laptop;

public interface LaptopInterfaceDAO {
	public int registrarLaptop(Laptop l);
	public int EliminarLaptop(Laptop l);
	public int actualizarLaptop(Laptop l);
	public ArrayList<Object> leerColumnas();
	public ArrayList<Laptop> buscarLaptop(String name);
	public ArrayList<Laptop> leerLaptop();
}
