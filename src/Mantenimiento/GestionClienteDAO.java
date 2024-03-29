package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Clientes;
import Entidad.Empleados;
import Interfaces.ClienteInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionClienteDAO implements ClienteInterfaceDAO{

	@Override
	public int registrarClientes(Clientes e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_cliente values (null,?,?,?,?,?,?,?,?,?,?,?)";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, e.getCodigo());
			pstn.setString(2, e.getNombre());
			pstn.setString(3, e.getApellido());
			pstn.setString(4, e.getDni());
			pstn.setInt(5, e.getEdad());
			pstn.setString(6, e.getFechaNac());
			pstn.setString(7, e.getGenero());
			pstn.setString(8, e.getEstadoCivil());
			pstn.setString(9, e.getCelular());
			pstn.setString(10, e.getCorreo());
			pstn.setString(11, e.getDireccion());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL REGISTRAR CLIENTE " + a.getMessage());
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
	public ArrayList<Clientes> buscarClientes(String filter, int num, ArrayList<String> listaFiltro) {

		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		Clientes cliente;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		if (!filter.equals(";")) {
			try {
				// Paso 1: Establecer la conexion con la base de datos
				con = MySQLConexion8.getConexion();

				// PASO 2: establecer la instruccion SQL registrar

				String sql = "select cli.codigo_, cli.codigo, cli.nombre, cli.apellido, cli.dni, cli.edad, cli.fechaNacimiento, "
						+ "g.descripcion, est.descripcion, cli.celular, cli.correo, cli.direccion "
						+ "from tb_cliente cli "
						+ "inner join tb_genero g on cli.genero = g.codigo "
						+ "inner join tb_estadocivil est on cli.estadocivil = est.codigo where "
						+ filter;
				System.out.println(sql);

				// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
				pstm = con.prepareStatement(sql);

				int index = 0;
				
				// Generar Filtro
				for (String s : listaFiltro) {
					// Paso 4: Parametros
					pstm.setString(index + 1, s);
					index++;
				}
				

				// Paso 5: ejecutar la instruccion
				res = pstm.executeQuery();

				// paso 6
				
				while (res.next()) {
					cliente = new Clientes();
					cliente.setCodigo_(res.getInt(1));
					cliente.setCodigo(res.getString(2));
					cliente.setNombre(res.getString(3));
					cliente.setApellido(res.getString(4));
					cliente.setDni(res.getString(5));
					cliente.setEdad(res.getInt(6));
					cliente.setFechaNac(res.getString(7));
					cliente.setGenero(res.getString(8));
					cliente.setEstadoCivil(res.getString(9));
					cliente.setCelular(res.getString(10));
					cliente.setCorreo(res.getString(11));
					cliente.setDireccion(res.getString(12));

					lista.add(cliente);
				}
				

			} catch (Exception e) {
				System.out.println("Error >>> En la instruccion SQL BUSCAR CLIENTES FILTRO " + e.getMessage());
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
		}
		
		return lista;
	
	}

	@Override
	public ArrayList<Clientes> leerClientes(int column, boolean condition) {

		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		Clientes cliente;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "";
			if (condition) {
				sql = "{call listarClientesASC()};";
			} else {
				sql = "{call listarClientesDESC()};";
			}

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				cliente = new Clientes();
				cliente.setCodigo_(res.getInt(1));
				cliente.setCodigo(res.getString(2));
				cliente.setNombre(res.getString(3));
				cliente.setApellido(res.getString(4));
				cliente.setDni(res.getString(5));
				cliente.setEdad(res.getInt(6));
				cliente.setFechaNac(res.getString(7));
				cliente.setGenero(res.getString(8));
				cliente.setEstadoCivil(res.getString(9));
				cliente.setCelular(res.getString(10));
				cliente.setCorreo(res.getString(11));
				cliente.setDireccion(res.getString(12));

				lista.add(cliente);

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL LEER CLIENTES " + e.getMessage());
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
	public ArrayList<Object> leerColumnas() {
		ArrayList<Object> lista = new ArrayList<Object>();

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_cliente;";

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
			System.out.println("Error >>> En la instruccion SQL LEER COLUMNAS CLIENTES " + e.getMessage());
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
		lista.set(lista.indexOf("estadocivil"), "Est. Civil");
		lista.remove(lista.indexOf("codigo_"));
		return lista;
	}

	@Override
	public String buscarEstCivil(String s) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String estCivil = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select descripcion from tb_estadocivil where codigo = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, s);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				estCivil = res.getString(1);

			}
			return estCivil;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR ESTADO CIVIL " + e.getMessage());
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
		return estCivil;

	}
	
	@Override
	public String buscarGenero(String s) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String genero = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select descripcion from tb_genero where codigo = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, s);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				genero = res.getString(1);

			}
			return genero;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR GENERO " + e.getMessage());
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
		return genero;

	}
	

	@Override
	public int EliminarClientes(Clientes e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_cliente where codigo = ?";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, e.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ELIMINAR EMPLEADO " + a.getMessage());
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
	public int actualizarClientes(Clientes e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarCliente(?,?,?,?,?,?,?,?,?,?,?)};";
			// 3. Preparar la instruccion --> obteniendo comandos SQL
			pstn = con.prepareStatement(sql);

			// 4. Parametros
			pstn.setString(1, e.getNombre());
			pstn.setString(2, e.getApellido());
			pstn.setString(3, e.getDni());
			pstn.setInt(4, e.getEdad());
			pstn.setString(5, e.getFechaNac());
			pstn.setString(6, e.getGenero());
			pstn.setString(7, e.getEstadoCivil());
			pstn.setString(8, e.getCelular());
			pstn.setString(9, e.getCorreo());
			pstn.setString(10, e.getDireccion());
			pstn.setString(11, e.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR CLIENTE" + a.getMessage());
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
	public ArrayList<Clientes> busquedaPorCodigo(String code) {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		Clientes cliente;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();
			
			// PASO 2: establecer la instruccion SQL registrar
			String sql = "{call busquedaPorCodigoCliente(?)};";
			
			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);
			
			// PAso 4: Parametros -------> No hay
			pstm.setString(1, code);
			
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			// paso 6
			while (res.next()) {
				cliente = new Clientes();
				cliente.setCodigo_(res.getInt(1));
				cliente.setCodigo(res.getString(2));
				cliente.setNombre(res.getString(3));
				cliente.setApellido(res.getString(4));
				cliente.setDni(res.getString(5));
				cliente.setEdad(res.getInt(6));
				cliente.setFechaNac(res.getString(7));
				cliente.setGenero(res.getString(8));
				cliente.setEstadoCivil(res.getString(9));
				cliente.setCelular(res.getString(10));
				cliente.setCorreo(res.getString(11));
				cliente.setDireccion(res.getString(12));

				lista.add(cliente);
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR CLIENTE POR CODIGO " + e.getMessage());
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
