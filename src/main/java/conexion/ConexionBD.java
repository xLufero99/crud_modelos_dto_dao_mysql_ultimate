package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud_dao_dto_ultimate";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	// =>Load & Register the Driver Classes
	public ConexionBD() {
		try {
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Something went wrong");
		}
	}

	// =>Establish the Connection with Database server
	public Connection getConnecion() throws SQLException {
		return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	}
	
	
	
}
