package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Audifonos;
import Entidad.AudifonosG;
import Interfaces.AudifonoInterfaceDAO;
import Interfaces.AufionosGInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionAudifonosGamerDAO implements AufionosGInterfaceDAO{

	@Override
	public int registrarAudifonosGamer(AudifonosG a) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_audifonosgamer values (null,?,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, a.getCodigo());
			pstn.setString(2, a.getMarca());
			pstn.setString(3, a.getModelo());
			pstn.setString(4, a.getDescripcion());
			pstn.setString(5, a.getTipoconex());
			pstn.setDouble(6, a.getPrecio());
			pstn.setInt(7, a.getStock());
			pstn.setString(8, a.getCategoria());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL REGISTRAR AUDIFONO GAMER " + ex.getMessage());
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
	public int EliminarAudifonosGamer(AudifonosG a) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_audifonosgamer where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, a.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ELIMINAR AUDIFONO GAMER " + ex.getMessage());
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
	public int actualizarAudifonosGamer(AudifonosG a) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarAudifonoGamer(?,?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, a.getMarca());
			pstn.setString(2, a.getModelo());
			pstn.setString(3, a.getDescripcion());
			pstn.setString(4, a.getTipoconex());
			pstn.setDouble(5, a.getPrecio());
			pstn.setInt(6, a.getStock());
			pstn.setString(7, a.getCodigo());


			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR AUDIFONO GAMER " + ex.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_audifonosgamer;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS AUDIFONO GAMER " + e.getMessage());
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
	public ArrayList<AudifonosG> buscarAudifonosGamer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AudifonosG> leerAudifonosGamer() {

		ArrayList<AudifonosG> lista = new ArrayList<AudifonosG>();
		AudifonosG audifonos;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "{call listarAudifonoGamer()};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				audifonos = new AudifonosG();
				audifonos.setCodigo_(res.getInt(1));
				audifonos.setCodigo(res.getString(2));
				audifonos.setMarca(res.getString(3));
				audifonos.setModelo(res.getString(4));
				audifonos.setDescripcion(res.getString(5));
				audifonos.setTipoconex(res.getString(6));
				audifonos.setPrecio(res.getDouble(7));
				audifonos.setStock(res.getInt(8));
				audifonos.setCategoria(res.getString(9));

				lista.add(audifonos);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER AUDIFONOS GAMER " + e.getMessage());
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
