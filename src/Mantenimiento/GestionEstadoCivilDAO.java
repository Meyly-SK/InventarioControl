package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.EstadoCivil;
import Interfaces.EstCivilInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionEstadoCivilDAO implements EstCivilInterfaceDAO{

	@Override
	public ArrayList<EstadoCivil> listarEstadoCivil() {
		ArrayList<EstadoCivil> lista = new ArrayList<EstadoCivil>();
		EstadoCivil estCivil;
		
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		
		
		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "select * from tb_estadocivil;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			//paso 6 bucle para recorrer el objeto res
			
			while (res.next()) {
				
				//creo un objeto de tipo Genero
				estCivil = new EstadoCivil();
	
				estCivil.setCodigo(res.getString(1));
				estCivil.setDescripcion(res.getString(2));

				//añadir el objeto tipUser al arreglo
				lista.add(estCivil);
								
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Listar Estado Civil " + e.getMessage());
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
	public String buscarCodEstCivil(String s) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String est = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select codigo from tb_estadocivil where descripcion = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, s);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				est = res.getString(1);

			}
			return est;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR CODIGO ESTADO CIVIL " + e.getMessage());
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
		return est;

	}

}
