package com.dziadekprzemek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection getConnection() {
	
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka?useSSL=true","root","admin");
			
		} 
		
		catch (SQLException e) {
		
			e.printStackTrace();
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
		
		
	}



	
}