package FugetronTest.FugetronTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class JDBCTest {
	
	@Test
	public void testConnection(){
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			if (conn!= null) {
				System.out.print("Connection Successful!");
			} else {
			    System.out.print("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.print("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}

	}

}
