package com.parallel.test.service;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parallel.test.bean.Wallet;
import com.parallel.test.dao.Database;

/**
 * Servlet implementation class SignupServelet
 */
@WebServlet("/SignupServelet")
public class SignupServelet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	static Database d = new Database();
	static ValidateService vs = new ValidateService();
	
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
		//PrintWriter out = response.getWriter();
		
		String tmpName = request.getParameter("name");
		String tmpEmailId = request.getParameter("emailId");
		Long tmpPhn = Long.parseLong(request.getParameter("phoneNumber"));
		int pin = Integer.parseInt(request.getParameter("pin"));
		Wallet w = new Wallet(tmpName,tmpEmailId,tmpPhn,500,pin);
		try {
			if(vs.validate(w)) {
				if(d.add(w)) {
					request.setAttribute("name", "Account Added Sucessfully");
					request.getRequestDispatcher("Signup.jsp").forward(request, response);
				}
				else {
					request.setAttribute("name", "Sign Up Failed");
					request.getRequestDispatcher("Signup.jsp").forward(request, response);
				}
				
			}
			else {
				request.setAttribute("name", "Please Check Your Input");
				request.getRequestDispatcher("Signup.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
//			e.printStackTrace();
		}
		
		
	}

}
