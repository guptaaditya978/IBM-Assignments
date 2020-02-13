package com.parallel.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionsParallel {
		
	public static Connection conn;
	public static PreparedStatement ps;
	public ConnectionsParallel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm trainning","root","");
			if(conn==null) {
				System.out.println("Connection not established");
			}
		}catch(Exception e) {
			System.out.println(e);
			System.out.println("Connection not established && Wrong in Connections.java");
		}
	}
}
