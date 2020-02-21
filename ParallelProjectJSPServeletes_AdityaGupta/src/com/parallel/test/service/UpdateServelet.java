package com.parallel.test.service;

import static com.parallel.test.service.SignupServelet.d;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parallel.test.bean.Wallet;
import static com.parallel.test.service.SignupServelet.vs;

@WebServlet("/UpdateServelet")
public class UpdateServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
			try {
				
				String tmpName = request.getParameter("name");
				String tmpEmailId = request.getParameter("emailId");
				Long tmpPhn = Long.parseLong(request.getParameter("phoneNumber"));
				int pin = Integer.parseInt(request.getParameter("pin"));
				Wallet w = new Wallet(tmpName,tmpEmailId,tmpPhn,500,pin);
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				if(vs.validate(w)) {
					if(d.update(w)) {
						request.setAttribute("name", "Updated Successfully");
						request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					}
					else {
						request.setAttribute("name", "Cannot update after getting right");
						request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					}
					
				}
				else {
					request.setAttribute("name", "Check input for validate");
					request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
