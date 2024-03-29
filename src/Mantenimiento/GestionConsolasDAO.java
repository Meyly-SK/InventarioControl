package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidad.Consolas;
import Interfaces.ConsolaInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionConsolasDAO implements ConsolaInterfaceDAO {

	@Override
	public int registrarConsolas(Consolas c) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_consola values (null,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, c.getCodigo());
			pstn.setString(2, c.getNombre());
			pstn.setString(3, c.getModelo());
			pstn.setString(4, c.getColor());
			pstn.setDouble(5, c.getPrecio());
			pstn.setInt(6, c.getStock());
			pstn.setString(7, c.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL REGISTRAR CONSOLA " + a.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstn != null)
					pstn.close();
			} catch (SQLException e2) {

			}
		}

		return res;
	}
	
	
	

	@Override
	public int EliminarConsolas(Consolas c) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_consola where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, c.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ELIMINAR CONSOLA " + a.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstn != null)
					pstn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

		return res;
	}

	@Override
	public int actualizarConsolas(Consolas c) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarConsola(?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, c.getNombre());
			pstn.setString(2, c.getModelo());
			pstn.setString(3, c.getColor());
			pstn.setDouble(4, c.getPrecio());
			pstn.setInt(5, c.getStock());
			pstn.setString(6, c.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR CONSOLA " + a.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstn != null)
					pstn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

		return res;
	}

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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_consola;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS CONSOLA " + e.getMessage());
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
		lista.remove(lista.indexOf("categoria"));
		return lista;
	}

	@Override
	public ArrayList<Consolas> buscarConsolas(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Consolas> leerConsolas() {

		ArrayList<Consolas> lista = new ArrayList<Consolas>();
		Consolas consolas;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarConsolas()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				consolas = new Consolas();
				consolas.setCodigo_(res.getInt(1));
				consolas.setCodigo(res.getString(2));
				consolas.setNombre(res.getString(3));
				consolas.setModelo(res.getString(4));
				consolas.setColor(res.getString(5));
				consolas.setPrecio(res.getDouble(6));
				consolas.setStock(res.getInt(7));
				consolas.setCategoria(res.getString(8));

				lista.add(consolas);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER CONSOLAS " + e.getMessage());
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
