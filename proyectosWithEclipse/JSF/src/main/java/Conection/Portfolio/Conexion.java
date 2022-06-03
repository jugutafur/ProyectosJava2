package Conection.Portfolio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection getConexion() {
		String conexionUrl = "jdbc:sqlserver://localhost:1433;"
				+"databaseName=portfolio;"
				+"user=sa;"
				+"password=1234;"
				+"loginTimeout=30;";		
		try {
			Connection con = DriverManager.getConnection(conexionUrl);
			return con;
		} catch (SQLException ex) {
			System.out.println(ex.toString());
			return null;
		}
		
	}
}
