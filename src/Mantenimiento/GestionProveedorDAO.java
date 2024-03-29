package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Clientes;
import Entidad.Empleados;
import Entidad.Proveedor;
import Interfaces.ProveedorInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionProveedorDAO implements ProveedorInterfaceDAO{

	@Override
	public ArrayList<Object> leerColumnas() {
		ArrayList<Object> lista = new ArrayList<Object>();

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_proveedor;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {

				lista.add(res.getString(1));

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Leer Columnas Proveedor " + e.getMessage());
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
		lista.remove(lista.indexOf("codigo_"));
		return lista;
	}

	@Override
	public ArrayList<Proveedor> leerProveedor() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Proveedor pro;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL
			String sql = "{call listarProveedor()};";


			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				pro = new Proveedor();
				pro.setCodigo_(res.getInt(1));
				pro.setCodigo(res.getString(2));
				pro.setRazonSocial(res.getString(3));
				pro.setRuc(res.getString(4));
				pro.setContacto(res.getString(5));
				pro.setCorreo(res.getString(6));
				pro.setDireccion(res.getString(7));
				pro.setSede(res.getString(8));

				lista.add(pro);

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Leer Proveedor " + e.getMessage());
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
	public ArrayList<Proveedor> busquedaPorCodigo(String code) {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Proveedor pro;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();
			
			// PASO 2: establecer la instruccion SQL registrar
			String sql = "{call busquedaPorCodigoProveedor(?)};";
			
			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);
			
			// PAso 4: Parametros -------> No hay
			pstm.setString(1, code);
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			// paso 6
			while (res.next()) {
				pro = new Proveedor();
				pro.setCodigo_(res.getInt(1));
				pro.setCodigo(res.getString(2));
				pro.setRazonSocial(res.getString(3));
				pro.setRuc(res.getString(4));
				pro.setContacto(res.getString(5));
				pro.setCorreo(res.getString(6));
				pro.setDireccion(res.getString(7));
				pro.setSede(res.getString(8));

				lista.add(pro);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR PROVEEDOR POR CODIGO " + e.getMessage());
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

}
