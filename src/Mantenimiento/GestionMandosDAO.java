package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Consolas;
import Entidad.Mandos;
import Interfaces.MandoInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionMandosDAO implements MandoInterfaceDAO{

	@Override
	public int registrarMandos(Mandos m) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_mando values (null,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, m.getCodigo());
			pstn.setString(2, m.getNombre());
			pstn.setString(3, m.getMarca());
			pstn.setString(4, m.getTipoconex());
			pstn.setDouble(5, m.getPrecio());
			pstn.setInt(6, m.getStock());
			pstn.setString(7, m.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL REGISTRAR MANDO " + a.getMessage());
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
	public int EliminarMandos(Mandos m) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_mando where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, m.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ELIMINAR MANDO " + a.getMessage());
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
	public int actualizarMandos(Mandos m) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarMando(?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, m.getNombre());
			pstn.setString(2, m.getMarca());
			pstn.setString(3, m.getTipoconex());
			pstn.setDouble(4, m.getPrecio());
			pstn.setInt(5, m.getStock());
			pstn.setString(6, m.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR MANDO " + a.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_mando;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS MANDOS " + e.getMessage());
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
		lista.set(lista.indexOf("tipoconex"), "tipoconexion");
		return lista;
	}

	@Override
	public ArrayList<Mandos> buscarMandos(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mandos> leerMandos() {

		ArrayList<Mandos> lista = new ArrayList<Mandos>();
		Mandos mandos;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarMandos()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				mandos = new Mandos();
				mandos.setCodigo_(res.getInt(1));
				mandos.setCodigo(res.getString(2));
				mandos.setNombre(res.getString(3));
				mandos.setMarca(res.getString(4));
				mandos.setTipoconex(res.getString(5));
				mandos.setPrecio(res.getDouble(6));
				mandos.setStock(res.getInt(7));
				mandos.setCategoria(res.getString(8));

				lista.add(mandos);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER MANDOS " + e.getMessage());
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
