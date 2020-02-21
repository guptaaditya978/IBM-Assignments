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

/**
 * Servlet implementation class CheckBalanceServelet
 */
@WebServlet("/CheckBalanceServelet")
public class CheckBalanceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
				Wallet w = new Wallet();
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				
				request.setAttribute("name", Integer.toString(d.Balance(w)));
				request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					
				
				
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
