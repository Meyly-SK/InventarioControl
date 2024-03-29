package Interfaces;

import java.util.ArrayList;

import Entidad.Empleados;

public interface EmpleadoInterfaceDAO {
	
	public int registrarEmpleados(Empleados e);
	public int EliminarEmpleado(Empleados e);
	public int actualizarEmpleados(Empleados e);
	public ArrayList<Object> leerColumnas();
	public String buscarSede(String s);
	public String buscarCargo(String c);
	public String buscarGenero(String s);
	public String buscarEstCivil(String s);
	public ArrayList<Empleados> buscarEmpleados(String filter, int num, ArrayList<String> lista);
	public ArrayList<Empleados> buscarEmpleadoIngreso(String clave);
	public ArrayList<Empleados> leerEmpleados(int column, boolean condition);
	public ArrayList<Empleados> busquedaPorCodigo(String string);

}
