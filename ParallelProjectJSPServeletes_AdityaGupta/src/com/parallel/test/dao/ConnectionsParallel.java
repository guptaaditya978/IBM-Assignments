package com.parallel.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionsParallel {
		
	public static Connection conn;
	public static PreparedStatement ps;
	public ConnectionsParallel() {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice?serverTimezone=IST","root","");
				if(conn==null) {
					System.out.println("Connection not established");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver not loaded : " + e.getMessage());
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQl Ex : " + e.getMessage());
				e.printStackTrace();
			}
			
	}
}
