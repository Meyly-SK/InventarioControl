package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.MouseG;
import Entidad.TecladoG;
import Interfaces.TecladoGamerInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionTecladoGamerDAO implements TecladoGamerInterfaceDAO{

	@Override
	public int registrarTecladoGamer(TecladoG t) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_tecladogamer values (null,?,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, t.getCodigo());
			pstn.setString(2, t.getMarca());
			pstn.setString(3, t.getModelo());
			pstn.setString(4, t.getDescripcion());
			pstn.setString(5, t.getTipoconex());
			pstn.setDouble(6, t.getPrecio());
			pstn.setInt(7, t.getStock());
			pstn.setString(8, t.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL REGISTRAR TECLADO GAMER " + ex.getMessage());
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
	public int EliminarTecladoGamer(TecladoG t) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_tecladogamer where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, t.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ELIMINAR TECLADO GAMER " + ex.getMessage());
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
	public int actualizarTecladoGamer(TecladoG t) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarTecladoGamer(?,?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, t.getMarca());
			pstn.setString(2, t.getModelo());
			pstn.setString(3, t.getDescripcion());
			pstn.setString(4, t.getTipoconex());
			pstn.setDouble(5, t.getPrecio());
			pstn.setInt(6, t.getStock());
			pstn.setString(7, t.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR TECLADO GAMER " + ex.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_tecladogamer;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS TECLADO GAMER " + e.getMessage());
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
	public ArrayList<TecladoG> buscarTecladoGamer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TecladoG> leerTecladoGamer() {

		ArrayList<TecladoG> lista = new ArrayList<TecladoG>();
		TecladoG tGamer;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarTecladoGamer()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				tGamer = new TecladoG();
				tGamer.setCodigo_(res.getInt(1));
				tGamer.setCodigo(res.getString(2));
				tGamer.setMarca(res.getString(3));
				tGamer.setModelo(res.getString(4));
				tGamer.setDescripcion(res.getString(5));
				tGamer.setTipoconex(res.getString(6));
				tGamer.setPrecio(res.getDouble(7));
				tGamer.setStock(res.getInt(8));
				tGamer.setCategoria(res.getString(9));

				lista.add(tGamer);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER TECLADO GAMER " + e.getMessage());
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
