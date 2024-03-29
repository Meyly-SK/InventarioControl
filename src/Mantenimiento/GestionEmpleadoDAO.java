package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Empleados;
import Interfaces.EmpleadoInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionEmpleadoDAO implements EmpleadoInterfaceDAO {

	@Override
	public int registrarEmpleados(Empleados e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "insert tb_empleado values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			pstn.setString(12, e.getCargo());
			pstn.setString(13, e.getSede());
			pstn.setString(14, e.getUsuario());
			pstn.setString(15, e.getClave());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL REGISTRAR EMPLEADO " + a.getMessage());
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
	public ArrayList<Empleados> buscarEmpleados(String filter, int num, ArrayList<String> listaFiltro) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		Empleados emp;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		if (!filter.equals(";")) {
			try {
				// Paso 1: Establecer la conexion con la base de datos
				con = MySQLConexion8.getConexion();

				// PASO 2: establecer la instruccion SQL registrar

				String sql = "select e.codigo_, e. codigo, e.nombre, e.apellido, e.dni, e.edad, e.fechaNacimiento, "
						+ "g.descripcion, est.descripcion, e.celular, e.correo, e.direccion, c.descripcion, s.descripcion,"
						+ " e.usuario, e.clave "
						+ "from tb_empleado e "
						+ "inner join tb_genero g on e.genero = g.codigo "
						+ "inner join tb_cargo c on e.cargo = c.codigo "
						+ "inner join tb_sede s on e.sede = s.codigo "
						+ "inner join tb_estadocivil est on e.estadocivil = est.codigo where "
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
					emp = new Empleados();
					emp.setCodigo_(res.getInt(1));
					emp.setCodigo(res.getString(2));
					emp.setNombre(res.getString(3));
					emp.setApellido(res.getString(4));
					emp.setDni(res.getString(5));
					emp.setEdad(res.getInt(6));
					emp.setFechaNac(res.getString(7));
					emp.setGenero(res.getString(8));
					emp.setEstadoCivil(res.getString(9));
					emp.setCelular(res.getString(10));
					emp.setCorreo(res.getString(11));
					emp.setDireccion(res.getString(12));
					emp.setCargo(res.getString(13));
					emp.setSede(res.getString(14));
					emp.setUsuario(res.getString(15));
					emp.setClave(res.getString(16));

					lista.add(emp);

				}
				

			} catch (Exception e) {
				System.out.println("Error >>> En la instruccion SQL BUSCAR EMPLEADOS FILTRO " + e.getMessage());
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
	public ArrayList<Empleados> leerEmpleados(int column, boolean condition) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		Empleados emp;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "";
			if (condition) {
				sql = "{call listarEmpleadosASC(?)};";
			} else {
				sql = "{call listarEmpleadosDESC(?)};";
			}

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setInt(1, column);
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleados();
				emp.setCodigo_(res.getInt(1));
				emp.setCodigo(res.getString(2));
				emp.setNombre(res.getString(3));
				emp.setApellido(res.getString(4));
				emp.setDni(res.getString(5));
				emp.setEdad(res.getInt(6));
				emp.setFechaNac(res.getString(7));
				emp.setGenero(res.getString(8));
				emp.setEstadoCivil(res.getString(9));
				emp.setCelular(res.getString(10));
				emp.setCorreo(res.getString(11));
				emp.setDireccion(res.getString(12));
				emp.setCargo(res.getString(13));
				emp.setSede(res.getString(14));
				emp.setUsuario(res.getString(15));
				emp.setClave(res.getString(16));

				lista.add(emp);

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Leer Empleados " + e.getMessage());
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
	public ArrayList<Empleados> buscarEmpleadoIngreso(String clave) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		Empleados emp;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "{call busquedaEmpleadoIngreso(?)};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setString(1, clave);
			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleados();
				emp.setCodigo_(res.getInt(1));
				emp.setCodigo(res.getString(2));
				emp.setNombre(res.getString(3));
				emp.setApellido(res.getString(4));
				emp.setDni(res.getString(5));
				emp.setEdad(res.getInt(6));
				emp.setFechaNac(res.getString(7));
				emp.setGenero(res.getString(8));
				emp.setEstadoCivil(res.getString(9));
				emp.setCelular(res.getString(10));
				emp.setCorreo(res.getString(11));
				emp.setDireccion(res.getString(12));
				emp.setCargo(res.getString(13));
				emp.setSede(res.getString(14));
				emp.setUsuario(res.getString(15));
				emp.setClave(res.getString(16));

				lista.add(emp);

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Leer Empleados " + e.getMessage());
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
			String sql = "SHOW COLUMNS FROM bd_upmorbsluck.tb_empleado;";

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
			System.out.println("Error >>> En la instruccion SQL Leer Columnas " + e.getMessage());
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
		lista.remove(lista.size() - 1);
		lista.remove(lista.size() - 1);
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
	public String buscarSede(String s) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String sede = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select descripcion from tb_sede where codigo = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, s);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				sede = res.getString(1);

			}
			return sede;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR SEDE " + e.getMessage());
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
		return sede;

	}

	@Override
	public String buscarCargo(String c) {
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		String cargo = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL buscar sede
			String sql = "select descripcion from tb_cargo where codigo = ?";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros
			pstm.setString(1, c);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6 bucle para recorrer el objeto res
			while (res.next()) {

				cargo = res.getString(1);

			}
			return cargo;

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR CARGO " + e.getMessage());
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
		return cargo;

	}

	@Override
	public int EliminarEmpleado(Empleados e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "delete from tb_empleado where codigo = ?";
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
	public int actualizarEmpleados(Empleados e) {
		int res = 0;
		PreparedStatement pstn = null;
		Connection con = null;

		try {
			// 1. Conexion a la bd
			con = MySQLConexion8.getConexion();
			// 2. Establecer la instruccion SQL
			String sql = "{call ActualizarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?)};";
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
			pstn.setString(11, e.getCargo());
			pstn.setString(12, e.getSede());
			pstn.setString(13, e.getCodigo());

			// 5. Ejecutar la instruccion
			res = pstn.executeUpdate();

		} catch (Exception a) {
			System.out.println("Error en la instruccion SQL ACTUALIZAR EMPLEADO " + a.getMessage());
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
	public ArrayList<Empleados> busquedaPorCodigo(String code) {
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		Empleados emp;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL registrar
			String sql = "{call busquedaPorCodigoEmpleado(?)};";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			pstm.setString(1, code);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				emp = new Empleados();
				emp.setCodigo_(res.getInt(1));
				emp.setCodigo(res.getString(2));
				emp.setNombre(res.getString(3));
				emp.setApellido(res.getString(4));
				emp.setDni(res.getString(5));
				emp.setEdad(res.getInt(6));
				emp.setFechaNac(res.getString(7));
				emp.setGenero(res.getString(8));
				emp.setEstadoCivil(res.getString(9));
				emp.setCelular(res.getString(10));
				emp.setCorreo(res.getString(11));
				emp.setDireccion(res.getString(12));
				emp.setCargo(res.getString(13));
				emp.setSede(res.getString(14));
				emp.setUsuario(res.getString(15));
				emp.setClave(res.getString(16));

				lista.add(emp);

			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL Buscar Empleado Por Codigo " + e.getMessage());
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
