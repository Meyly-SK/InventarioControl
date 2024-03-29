package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.PCEscritorio;
import Entidad.TecladoG;
import Interfaces.PCEscritorioInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionPCEscritorioDAO implements PCEscritorioInterfaceDAO{

	@Override
	public int registrarPCEscritorio(PCEscritorio p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_pcescritorio values (null,?,?,?,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getCodigo());
			pstn.setString(2, p.getProcesador());
			pstn.setString(3, p.getDiscoduro());
			pstn.setString(4, p.getPlacamadre());
			pstn.setString(5, p.getTarjetavideo());
			pstn.setString(6, p.getFuentepoder());
			pstn.setString(7, p.getRefrigeracion());
			pstn.setDouble(8, p.getPrecio());
			pstn.setInt(9, p.getStock());
			pstn.setString(10, p.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL REGISTRAR PC ESCRITORIO " + ex.getMessage());
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
	public int EliminarPCEscritorio(PCEscritorio p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_pcescritorio where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ELIMINAR PC ESCRITORIO " + ex.getMessage());
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
	public int actualizarPCEscritorio(PCEscritorio p) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarPCEscritorio(?,?,?,?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, p.getProcesador());
			pstn.setString(2, p.getDiscoduro());
			pstn.setString(3, p.getPlacamadre());
			pstn.setString(4, p.getTarjetavideo());
			pstn.setString(5, p.getFuentepoder());
			pstn.setString(6, p.getRefrigeracion());
			pstn.setDouble(7, p.getPrecio());
			pstn.setInt(8, p.getStock());
			pstn.setString(9, p.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR PC ESCRITORIO " + ex.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_pcescritorio;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS PC ESCRITORIO " + e.getMessage());
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
	public ArrayList<PCEscritorio> buscarPCEscritorio(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PCEscritorio> leerPCEscritorio() {

		ArrayList<PCEscritorio> lista = new ArrayList<PCEscritorio>();
		PCEscritorio pcEscritorio;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarPCEscritorio()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				pcEscritorio = new PCEscritorio();
				pcEscritorio.setCodigo_(res.getInt(1));
				pcEscritorio.setCodigo(res.getString(2));
				pcEscritorio.setProcesador(res.getString(3));
				pcEscritorio.setDiscoduro(res.getString(4));
				pcEscritorio.setPlacamadre(res.getString(5));
				pcEscritorio.setTarjetavideo(res.getString(6));
				pcEscritorio.setFuentepoder(res.getString(7));
				pcEscritorio.setRefrigeracion(res.getString(8));
				pcEscritorio.setPrecio(res.getDouble(9));
				pcEscritorio.setStock(res.getInt(10));
				pcEscritorio.setCategoria(res.getString(11));

				lista.add(pcEscritorio);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER PC ESCRITORIO " + e.getMessage());
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
