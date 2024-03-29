package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Entidad.Sedes;
import Interfaces.SedeInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionSedesDAO implements SedeInterfaceDAO{

	@Override
	public ArrayList<Sedes> listarSedes() {
		ArrayList<Sedes> lista = new ArrayList<Sedes>();
		Sedes sede;
		
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		
		
		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "select * from tb_sede;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			//paso 6 bucle para recorrer el objeto res
			
			while (res.next()) {
				
				//creo un objeto de tipo TipoUsuario
				sede = new Sedes();
	
				sede.setCodigo(res.getString(1));
				sede.setDescripcion(res.getString(2));

				//añadir el objeto tipUser al arreglo
				lista.add(sede);
								
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
	public String buscarCodSede(String s) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String sede = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select codigo from tb_sede where descripcion = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, s);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				sede = res.getString(1);

			}
			return sede;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL buscar codigo genero " + e.getMessage());
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
		return sede;

	}

}
