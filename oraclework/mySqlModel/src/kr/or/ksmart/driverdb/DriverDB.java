package kr.or.ksmart.driverdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DriverDB {
	public Connection driverDbcon() throws ClassNotFoundException, SQLException{
		System.out.println("01_driverDbcon DriverDB.java");
		System.out.println("01_����̹��ε��� DB���� ó�� driverDbcon DriverDB.java");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		String jdbcDriver = "jdbc:mysql://localhost:3306/dev37db?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "dev37id";
		String dbPass = "dev37pw";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(conn + "<-- conn driverDbcon DriverDB.java");
		return conn;
	}
}
