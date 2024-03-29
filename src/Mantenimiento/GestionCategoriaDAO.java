package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.Categoria;
import Entidad.Consolas;
import Interfaces.CategoriaInterfaceDAO;
import Utils.MySQLConexion8;

public class GestionCategoriaDAO implements CategoriaInterfaceDAO{

	@Override
	public Categoria buscarCodigoCategoria(String code) {
		Categoria categoria=null;

		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;

		try {
			// Paso 1: Establecer la conexion con la base de datos
			con = MySQLConexion8.getConexion();

			// PASO 2: establecer la instruccion SQL listar consolas
			String sql = "select codigo from tb_categoria where categoria = ?;";

			// Paso 3: Enviar la variable SQL al objeto (pstm) ---> obtener los comandos
			pstm = con.prepareStatement(sql);

			// PAso 4: Parametros -------> No hay
			
			pstm.setString(1, code);

			// Paso 5: ejecutar la instruccion
			res = pstm.executeQuery();

			// paso 6

			while (res.next()) {
				categoria = new Categoria();
				categoria.setCodigo(res.getString(1));
			}

		} catch (Exception e) {
			System.out.println("Error >>> En la instruccion SQL BUSCAR CODIGO CATEGORIA " + e.getMessage());
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
		return categoria;

	
	}

}
