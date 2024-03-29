package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Juegos;
import Entidad.Mandos;
import Interfaces.JuegoInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionJuegosDAO implements JuegoInterfaceDAO{

	@Override
	public int registrarJuegos(Juegos j) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_juego values (null,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, j.getCodigo());
			pstn.setString(2, j.getNombre());
			pstn.setString(3, j.getDesarrolladora());
			pstn.setString(4, j.getPlataforma());
			pstn.setDouble(5, j.getPrecio());
			pstn.setInt(6, j.getStock());
			pstn.setString(7, j.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL REGISTRAR JUEGO " + a.getMessage());
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
	public int EliminarJuegos(Juegos j) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_juego where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, j.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ELIMINAR JUEGO " + a.getMessage());
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
	public int actualizarJuegos(Juegos j) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarJuego(?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, j.getNombre());
			pstn.setString(2, j.getDesarrolladora());
			pstn.setString(3, j.getPlataforma());
			pstn.setDouble(4, j.getPrecio());
			pstn.setInt(5, j.getStock());
			pstn.setString(6, j.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR JUEGO " + a.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_juego;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS JUEGOS " + e.getMessage());
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
	public ArrayList<Juegos> buscarJuegos(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Juegos> leerJuegos() {

		ArrayList<Juegos> lista = new ArrayList<Juegos>();
		Juegos juegos;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarJuegos()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				juegos = new Juegos();
				juegos.setCodigo_(res.getInt(1));
				juegos.setCodigo(res.getString(2));
				juegos.setNombre(res.getString(3));
				juegos.setPlataforma(res.getString(4));
				juegos.setDesarrolladora(res.getString(5));
				juegos.setPrecio(res.getDouble(6));
				juegos.setStock(res.getInt(7));
				juegos.setCategoria(res.getString(8));

				lista.add(juegos);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER JUEGOS " + e.getMessage());
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
