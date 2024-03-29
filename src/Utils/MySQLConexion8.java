package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Vista.frmPrincipal;

public class MySQLConexion8 {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_upmorbsluck?serverTimezone=UTC";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			frmPrincipal.errorConexion="Error >> Driver no Instalado!!\n  "+e.getMessage();
		} catch (SQLException e) {
			frmPrincipal.errorConexion="Error >> de conexión con la BD\n  "+e.getMessage();
		} catch (Exception e) {
			frmPrincipal.errorConexion="Error >> General\n  "+e.getMessage();
		} 
		return con;
	}

}
