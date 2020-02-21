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
 * Servlet implementation class ViewTransactionsServelet
 */
@WebServlet("/ViewTransactionsServelet")
public class ViewTransactionsServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
			try {
				System.out.println("Inside View Transaction");
				Wallet w = new Wallet();
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				//ArrayList<Transactions>
				
				System.out.println(d.viewTransactions(w));
					request.setAttribute("lists", d.viewTransactions(w));
					request.getRequestDispatcher("ViewTransactions.jsp").include(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Inside catch");
				System.out.println(e);
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
