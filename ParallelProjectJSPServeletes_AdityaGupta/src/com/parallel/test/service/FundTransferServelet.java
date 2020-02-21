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
 * Servlet implementation class FundTransferServelet
 */
@WebServlet("/FundTransferServelet")
public class FundTransferServelet extends HttpServlet {
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
				Wallet w = new Wallet();
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				int amount=Integer.parseInt(request.getParameter("amount"));
				Long phn = Long.parseLong(request.getParameter("phoneNumber2"));
				Wallet w2 = new Wallet();
				w2.setWalletPhoneNumber(phn);
				if(d.userId(w2)==0) {
					request.setAttribute("name", "No Account Linked to this number");
					request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
				}
				else {
					w2.setWalletId(d.userId(w2));
					if((d.fundTransfer(w,w2,amount)==1)){
						request.setAttribute("name", "Money Successfully transfered of amount "+Integer.toString(amount)+". Your Updated Balance is "+Integer.toString(d.Balance(w)));
						request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					}
					else {
						request.setAttribute("name", "Cannot Transfer the money");
						request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
					}
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
