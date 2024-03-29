package Mantenimiento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entidad.Audifonos;
import Entidad.AudifonosG;
import Entidad.Boleta;
import Entidad.CamaraWeb;
import Entidad.Celular;
import Entidad.Consolas;
import Entidad.Juegos;
import Entidad.Laptop;
import Entidad.LaptopG;
import Entidad.Mandos;
import Entidad.Microfono;
import Entidad.Mouse;
import Entidad.MouseG;
import Entidad.PCEscritorio;
import Entidad.PCGamer;
import Entidad.Parlantes;
import Entidad.SillaG;
import Entidad.Tablet;
import Entidad.TecladoG;
import Entidad.Teclados;
import Entidad.Televisor;
import Interfaces.BoletaInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionBoletaDAO implements BoletaInterfaceDAO {

	@Override
	public int registrarBoleta(Boleta bol, ArrayList<String[]> lista, String tipo) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm1 = null; // Registrar Boleta
		PreparedStatement pstm2 = null; // Actualizar Stock
		try {
			// Paso 1: Conexion a la BD
			con = MySQLConexion8.getConexion();

			// Paso 2: Desactivar la confirmacion automatica
			con.setAutoCommit(false);

			// Instruccion 1: registrar datos boleta
			String sql1;
			if (tipo.equals("venta")) {
				sql1 = "INSERT INTO tb_boleta_venta VALUES(NULL,?,?,?,?,?,?);";
			} else {
				sql1 = "INSERT INTO tb_boleta_compra VALUES(NULL,?,?,?,?,?,?);";
			}
			pstm1 = con.prepareStatement(sql1);

			// Parametros
			pstm1.setString(1, bol.getCodBoleta());
			pstm1.setInt(2, Integer.parseInt(bol.getCod_Empleado()));
			pstm1.setInt(3, Integer.parseInt(bol.getCod_Cli_Prov()));
			pstm1.setString(4, bol.getFechaVenta() + "");
			pstm1.setString(5, bol.getDescripcion());
			pstm1.setDouble(6, bol.getImporte());

			// Ejecutar
			estado = pstm1.executeUpdate();
			// Instruccion 2: actualizar stock
			for (String[] x : lista) {
				String codeInit = String.valueOf(x[0].charAt(0)) + String.valueOf(x[0].charAt(1));
				String sql2 = actualizarProductos(codeInit);
				if (!(sql2 == null)) {
					pstm2 = con.prepareStatement(sql2);

					// Parametros
					pstm2.setInt(1, Integer.parseInt(x[1]));
					pstm2.setString(2, x[0]);

					// Ejecutar
					estado = pstm2.executeUpdate();

				} else {
					System.out.println("Error en el Case ActualizarProductos");
				}
			}

			// Confirmar la transaccion
			con.commit();

		} catch (Exception e) {
			System.out.println("Error al realizar la transaccion " + e);
			estado = 0;
			try {
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error al restaurar ROLLBACK " + e2);
			} finally {
				try {
					if (con != null) {
						con.close();
					}

					if (pstm1 != null) {
						pstm1.close();
					}

					if (pstm2 != null) {
						pstm2.close();
					}
				} catch (SQLException e3) {
					System.out.println("Error al cerrar la BD " + e3);
				}
			}
		}
		return estado;
	}

	@Override
	public ArrayList<Boleta> buscarBoleta(String fecha, String tipo) {

		ArrayList<Boleta> lista = new ArrayList<Boleta>();
		Boleta bol;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "";

			if (tipo.equals("venta")) {
				sql = "{call busquedaPorFechaBoletaVenta(?)};";
			} else {
				sql = "{call busquedaPorFechaBoletaCompra(?)};";
			}

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setString(1, fecha);
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				bol = new Boleta();
				bol.setNum(res.getInt(1));
				bol.setCodBoleta(res.getString(2));
				bol.setCod_Empleado(res.getString(3));
				bol.setCod_Cli_Prov(res.getString(4));
				bol.setFechaVenta(res.getString(5));
				bol.setDescripcion(res.getString(6));
				bol.setImporte(res.getDouble(7));

				lista.add(bol);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR BOLETA POR FECHA" + e.getMessage());
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
	public ArrayList<Boleta> leerBoleta(String tipo) {

		ArrayList<Boleta> lista = new ArrayList<Boleta>();
		Boleta bol;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "";

			if (tipo.equals("venta")) {
				sql = "{call listarBoletaVentas()};";
			} else {
				sql = "{call listarBoletaCompras()};";
			}

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				bol = new Boleta();
				bol.setNum(res.getInt(1));
				bol.setCodBoleta(res.getString(2));
				bol.setCod_Empleado(res.getString(3));
				bol.setCod_Cli_Prov(res.getString(4));
				bol.setFechaVenta(res.getString(5));
				bol.setDescripcion(res.getString(6));
				bol.setImporte(res.getDouble(7));

				lista.add(bol);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER BOLETA " + e.getMessage());
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
	public ArrayList<Object> leerColumnas(String tipo) {
		ArrayList<Object> lista = new ArrayList<Object>();

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "";

			if (tipo.equals("venta")) {
				sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_boleta_venta;";
			} else {
				sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_boleta_compra;";
			}

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS BOLETA " + e.getMessage());
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

	private String actualizarProductos(String name) {

		switch (name) {
		case "CN":
			return "UPDATE tb_consola SET stock = ? WHERE codigo = ?;";

		case "JG":
			return "UPDATE tb_juego SET stock = ? WHERE codigo = ?;";

		case "MD":
			return "UPDATE tb_mando SET stock = ? WHERE codigo = ?;";

		case "AG":
			return "UPDATE tb_audifonosgamer SET stock = ? WHERE codigo = ?;";

		case "SG":
			return "UPDATE tb_sillagamer SET stock = ? WHERE codigo = ?;";

		case "PG":
			return "UPDATE tb_pcgamer SET stock = ? WHERE codigo = ?;";

		case "LG":
			return "UPDATE tb_laptopgamer SET stock = ? WHERE codigo = ?;";

		case "MG":
			return "UPDATE tb_mousegamer SET stock = ? WHERE codigo = ?;";

		case "TG":
			return "UPDATE tb_tecladogamer SET stock = ? WHERE codigo = ?;";

		case "CL":
			return "UPDATE tb_celular SET stock = ? WHERE codigo = ?;";

		case "TL":
			return "UPDATE tb_televisor SET stock = ? WHERE codigo = ?;";

		case "PL":
			return "UPDATE tb_parlante SET stock = ? WHERE codigo = ?;";

		case "AM":
			return "UPDATE tb_audifonosmusica SET stock = ? WHERE codigo = ?;";

		case "PE":
			return "UPDATE tb_pcescritorio SET stock = ? WHERE codigo = ?;";

		case "LP":
			return "UPDATE tb_laptop SET stock = ? WHERE codigo = ?;";

		case "TB":
			return "UPDATE tb_tablet SET stock = ? WHERE codigo = ?;";

		case "MS":
			return "UPDATE tb_mouse SET stock = ? WHERE codigo = ?;";

		case "MC":
			return "UPDATE tb_microfono SET stock = ? WHERE codigo = ?;";

		case "CW":
			return "UPDATE tb_camaraweb SET stock = ? WHERE codigo = ?;";

		case "TO":
			return "UPDATE tb_teclado SET stock = ? WHERE codigo = ?;";

		default:
			return null;
		}
	}

}
