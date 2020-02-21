package com.parallel.test.service;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LogoutServelet
 */
@WebServlet("/LogoutServelet")
public class LogoutServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("id") == null && request.getParameter("phoneNumber") != null)
		{
			//out.println("Not Logged in...");
			System.out.println("Session not present");
			response.sendRedirect("index.jsp");
			
		}
		else if(request.getSession().getAttribute("id") != null) {
			
			
				request.getSession().invalidate();
				System.out.println("Logged Out");
				
				response.sendRedirect("index.jsp");	 
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
