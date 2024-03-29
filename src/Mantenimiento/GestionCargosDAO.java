package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidad.Cargos;
import Interfaces.CargoInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionCargosDAO implements CargoInterfaceDAO{

	@Override
	public ArrayList<Cargos> listarCargos() {
		ArrayList<Cargos> lista = new ArrayList<Cargos>();
		Cargos cargo;
		
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		
		
		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "select * from tb_cargo;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			//paso 6 bucle para recorrer el objeto res
			
			while (res.next()) {
				
				//creo un objeto de tipo TipoUsuario
				cargo = new Cargos();
	
				cargo.setCodigo(res.getString(1));
				cargo.setDescripcion(res.getString(2));

				//añadir el objeto tipUser al arreglo
				lista.add(cargo);
								
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Eliminar " + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (con != null) {
					con.close();
				}
				
				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos--->" + e2.getMessage());
			}
		}
		return lista;
	}
	
	@Override
	public String buscarCodCargo(String c) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String cargo = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select codigo from tb_cargo where descripcion = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, c);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				cargo = res.getString(1);

			}
			return cargo;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL buscar codigo cargo " + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (con != null) {
					con.close();
				}

				if (res != null) {
					res.close();
				}
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos--->" + e2.getMessage());
			}
		}
		return cargo;

	}

}
