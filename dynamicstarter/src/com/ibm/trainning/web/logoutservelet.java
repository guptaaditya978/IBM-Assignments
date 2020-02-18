package com.ibm.trainning.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutservelet
 */
@WebServlet("/logoutservelet")
public class logoutservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		System.out.print(session);
		if(session!=null) {
			session.invalidate();
			out.print("You have been Logged Out");
			
				//Thread.sleep(2000);
				response.sendRedirect("http://localhost:8090/dynamicstarter/index.html");
		}
		else {
			out.print("Please Log In First");
			System.out.print("Please Log In First");
				
				response.sendRedirect("http://localhost:8085/dynamicstarter/index.html");
		}
	}

}
