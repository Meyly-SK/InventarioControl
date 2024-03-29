package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Genero;
import Interfaces.GeneroInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionGeneroDAO implements GeneroInterfaceDAO{

	@Override
	public ArrayList<Genero> listarGenero() {
		ArrayList<Genero> lista = new ArrayList<Genero>();
		Genero genero;
		
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		
		
		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "select * from tb_genero;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			//paso 6 bucle para recorrer el objeto res
			
			while (res.next()) {
				
				//creo un objeto de tipo Genero
				genero = new Genero();
	
				genero.setCodigo(res.getString(1));
				genero.setDescripcion(res.getString(2));

				//añadir el objeto tipUser al arreglo
				lista.add(genero);
								
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Listar Genero " + e.getMessage());
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
	public String buscarCodGenero(String g) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String genero = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select codigo from tb_genero where descripcion = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, g);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				genero = res.getString(1);

			}
			return genero;

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
		return genero;

	}

}
