package com.jerry.hibernatedemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static void main(String[] args) {
		
		//define connection jdbc url
		String jdbcURL = "jdbc:mysql://localhost:3306/";
		String username = "root";
		String password = "S@uras01";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcURL,username,password);
			
			if(con != null)
				System.out.println("Connection Successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
