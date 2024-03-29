package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.PCGamer;
import Entidad.SillaG;
import Interfaces.PCGamerInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionPCGamerDAO implements PCGamerInterfaceDAO{

	@Override
	public int registrarPCGamer(PCGamer p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_pcgamer values (null,?,?,?,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getCodigo());
			pstn.setString(2, p.getProcesador());
			pstn.setString(3, p.getDiscoduro());
			pstn.setString(4, p.getPlacamadre());
			pstn.setString(5, p.getTarjVideo());
			pstn.setString(6, p.getFuentePoder());
			pstn.setString(7, p.getRefrigeracion());
			pstn.setDouble(8, p.getPrecio());
			pstn.setInt(9, p.getStock());
			pstn.setString(10, p.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL REGISTRAR PC GAMER " + ex.getMessage());
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
	public int EliminarPCGamer(PCGamer p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_pcgamer where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ELIMINAR PC GAMER " + ex.getMessage());
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
	public int actualizarPCGamer(PCGamer p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarPCGamer(?,?,?,?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getProcesador());
			pstn.setString(2, p.getDiscoduro());
			pstn.setString(3, p.getPlacamadre());
			pstn.setString(4, p.getTarjVideo());
			pstn.setString(5, p.getFuentePoder());
			pstn.setString(6, p.getRefrigeracion());
			pstn.setDouble(7, p.getPrecio());
			pstn.setInt(8, p.getStock());
			pstn.setString(9, p.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR PC GAMER " + ex.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_pcgamer;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS PC GAMER " + e.getMessage());
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
	public ArrayList<PCGamer> buscarPCGamer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PCGamer> leerPCGamer() {

		ArrayList<PCGamer> lista = new ArrayList<PCGamer>();
		PCGamer pcGamer;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarPCGamer()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				pcGamer = new PCGamer();
				pcGamer.setCodigo_(res.getInt(1));
				pcGamer.setCodigo(res.getString(2));
				pcGamer.setProcesador(res.getString(3));
				pcGamer.setDiscoduro(res.getString(4));
				pcGamer.setPlacamadre(res.getString(5));
				pcGamer.setTarjVideo(res.getString(6));
				pcGamer.setFuentePoder(res.getString(7));
				pcGamer.setRefrigeracion(res.getString(8));
				pcGamer.setPrecio(res.getDouble(9));
				pcGamer.setStock(res.getInt(10));
				pcGamer.setCategoria(res.getString(11));

				lista.add(pcGamer);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER PC GAMER " + e.getMessage());
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
