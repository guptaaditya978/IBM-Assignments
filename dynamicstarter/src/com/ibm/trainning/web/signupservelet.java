package com.ibm.trainning.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class signupservelet
 */
@WebServlet("/signupservelet")
public class signupservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		if(uname.equalsIgnoreCase("")||uname.equalsIgnoreCase("")||uname.equalsIgnoreCase("")) {
			System.out.println("Please Enter the valid details");
		}
		else {
			
			try {
				out.print("In servelet");
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice","root","");
				PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?)");
				ps.setString(1, uname);
				ps.setString(2, name);
				ps.setString(3, pass);
				if(ps.executeUpdate()>0) {
					out.println("Account created Successfully");
					Thread.sleep(2000);
					response.sendRedirect("http://localhost:8090/dynamicstarter/");
				}
				else {
					out.println("Could Not create Account");
					Thread.sleep(2000);
					response.sendRedirect("http://localhost:8090/dynamicstarter/");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				//e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				//e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e);
			}
			
			
			
		}
		
	}

}
