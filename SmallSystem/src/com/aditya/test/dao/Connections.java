package com.aditya.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connections {
		public static Connection conn;
		public static PreparedStatement ps;
		public Connections() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibm trainning","root","");
				if(!conn.isClosed() || conn!=null) {
					System.out.println("Connection not established");
				}
			}catch(Exception e) {
				System.out.println("Connection not established && Wrong in Connections.java");
			}
		}
	
}

