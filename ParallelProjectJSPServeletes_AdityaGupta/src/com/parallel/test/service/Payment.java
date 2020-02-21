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
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
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
//		doGet(request, response);
		
		if(request.getSession().getAttribute("id") == null && request.getParameter("phoneNumber") != null)
		{
			//out.println("Not Logged in...");
			System.out.println("Session not present");
			response.sendRedirect("index.jsp");
			
		}
		else if(request.getSession().getAttribute("id") != null) {
			try {
				int amount=Integer.parseInt(request.getParameter("amount"));
				Wallet w = new Wallet();
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				w.setWalletPhoneNumber(d.userPhoneNumber(w));
				w.setWalletName(d.userName(w));
				w.setWalletEmailId(d.userEmail(w));
				w.setBalance(d.Balance(w));
				if(d.withdraw(w, amount)==1) {
					request.setAttribute("name", "Payment Successfully done of "+Integer.toString(amount)+".  Your Updated Balance is "+Integer.toString(d.Balance(w)));
					request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					
				}
				else {
					request.setAttribute("name", "Not Insufficient Balance in the wallet");
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
