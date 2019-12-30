package jdbc1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;
public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		//step1 - load the driver
		
		Driver d = new OracleDriver();
		try {
		DriverManager.registerDriver(d);
		
		String userName = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@192.168.1.57:1522:xe";
		
		Connection conn = DriverManager.getConnection(url,userName,password);
		System.out.println("connect to oracle database open");
		Statement stmt = conn.createStatement();
		String query = (" select first_name from employees");
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next())
		{
			System.out.println("Name = "+rs.getString("first_name"));
		}
		//PreparedStatement pstmt = conn.prepareStatement("");
		//CallableStatement cstmt = conn.prepareCall("");
		conn.close();
		System.out.println("connection closed");
		
		}catch(SQLException e) {
		System.err.println("error in registering the driver");
		e.printStackTrace();
		}
	}

}
