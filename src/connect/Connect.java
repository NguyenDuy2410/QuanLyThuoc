package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public   static Connection CreateConnection() {
		Connection conn = null;
		String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyThuoc";
		String user= "sa";
		String password = "sapassword";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("EERROR:Ket noi DB that bai (Connect)"+e.getMessage() );
		}
		return conn;
	}
	
}
