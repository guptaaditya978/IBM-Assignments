package com.parallel.test.service;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import static com.parallel.test.service.SignupServelet.d;

import com.parallel.test.bean.Wallet;

/**
 * Servlet implementation class LoginServelet
 */
@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BAdhiya");
		System.out.println(request.getSession());
		if(request.getSession().getAttribute("id") == null && request.getParameter("phoneNumber") != null)
		{
			//out.println("Not Logged in...");
			System.out.print("as");
			Long phn = Long.parseLong(request.getParameter("phoneNumber"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			Wallet w = new Wallet();
			w.setPin(pin);
			w.setWalletPhoneNumber(phn);
				
			
			try {
				if(d.verifies(w)) {
					w.setWalletId((d.userId(w)));
					w.setWalletName(d.userName(w));
					request.getSession().setAttribute("id", w.getWalletId());
					request.setAttribute("name", w.getWalletName());
					request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
				}
				else {
					//request.setAttribute("g", "Invalid Credentials");
//					request.setAttribute("name", "");
//					request.getRequestDispatcher("Login.jsp").include(request, response);
					response.sendRedirect("Login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}
		}
		else if(request.getSession().getAttribute("id") != null) {
			try {
				System.out.print("as2");
				Wallet w = new Wallet();
				w.setWalletId((Integer)(request.getSession().getAttribute("id")));
				w.setWalletPhoneNumber(d.userPhoneNumber(w));
				w.setWalletName(d.userName(w));
				w.setWalletEmailId(d.userEmail(w));
				request.setAttribute("name", w.getWalletName());
				request.getRequestDispatcher("AfterLogin.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
			
	}

}
