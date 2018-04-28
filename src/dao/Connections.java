package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/faculdade";
			String user1 = "root";
			String pass1 = "root";
			
			Connection c = DriverManager.getConnection(url, user1, pass1);
			return c;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;	
	}
		
}
