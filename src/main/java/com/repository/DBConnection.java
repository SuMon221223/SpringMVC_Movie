package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection con=null;
	
	public static Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","admin");
//			System.out.println("con : "+con);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver error : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connection error : "+ e.getMessage());
		}
		
		return con;
		
	}
	
	
	public static void main(String[] args) {
		
		
	}

}
