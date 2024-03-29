package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Audifonos;
import Entidad.SillaG;
import Interfaces.SillaGamerInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionSillaGamerDAO implements SillaGamerInterfaceDAO{

	@Override
	public int registrarSillaGamer(SillaG s) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_sillagamer values (null,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, s.getCodigo());
			pstn.setString(2, s.getMarca());
			pstn.setString(3, s.getModelo());
			pstn.setString(4, s.getDescripcion());
			pstn.setDouble(5, s.getPrecio());
			pstn.setInt(6, s.getStock());
			pstn.setString(7, s.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL REGISTRAR SILLA GAMER " + ex.getMessage());
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
	public int EliminarSillaGamer(SillaG s) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_sillagamer where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, s.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ELIMINAR SILLA GAMER " + ex.getMessage());
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
	public int actualizarSillaGamer(SillaG s) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarSillaGamer(?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, s.getMarca());
			pstn.setString(2, s.getModelo());
			pstn.setString(3, s.getDescripcion());
			pstn.setDouble(4, s.getPrecio());
			pstn.setInt(5, s.getStock());
			pstn.setString(6, s.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR SILLA GAMER " + ex.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_sillagamer;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS SILLA GAMER " + e.getMessage());
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
	public ArrayList<SillaG> buscarSillaGamer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SillaG> leerSillaGamer() {

		ArrayList<SillaG> lista = new ArrayList<SillaG>();
		SillaG sillaG;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarSillaGamer()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				sillaG = new SillaG();
				sillaG.setCodigo_(res.getInt(1));
				sillaG.setCodigo(res.getString(2));
				sillaG.setMarca(res.getString(3));
				sillaG.setModelo(res.getString(4));
				sillaG.setDescripcion(res.getString(5));
				sillaG.setPrecio(res.getDouble(6));
				sillaG.setStock(res.getInt(7));
				sillaG.setCategoria(res.getString(8));

				lista.add(sillaG);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER SILLA GAMER " + e.getMessage());
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
