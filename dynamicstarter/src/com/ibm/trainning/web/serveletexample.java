package com.ibm.trainning.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class serveletexample
 */
@WebServlet("/serveletexample")
public class serveletexample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice","root","");
			PreparedStatement ps = conn.prepareStatement("select * from users where username=? && password=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()  == false) {
				out.println("Invalid Credentials");
	        	//Thread.sleep(3000);
				Thread.sleep(2000);
				response.sendRedirect("http://localhost:8090/dynamicstarter/login.html");
	        }
	        else {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("username", resultSet.getString("username"));
	        	session.setAttribute("name", resultSet.getString("name"));
	        	//Thread.sleep(3000);
	        	//out.println("Logged In Sucessfully");
	        	//Thread.sleep(3000);
				
				String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
				out.println(docType +
				         "<html>\n" +
				            "<body >\n" +
				            	"<marquee>" + "Welcome"+ session.getAttribute("username") +"</marquee><br>"+
//				            	"<form action=\"logoutservelet\" method= \"post\"" +
//				            		"<input type=\"submit\" value=\"logout\">\n"+
//				            		
//				            	"</form>\n"
								"<a href=\"logoutservelet\"><input type=\"button\" value=\"LogOut\" method=\"post\"></a>\n"+	
				            "</body>" +
				         "</html>"
				      );
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
