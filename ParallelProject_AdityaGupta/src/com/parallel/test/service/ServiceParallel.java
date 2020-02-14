package com.parallel.test.service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.parallel.test.bean.Wallet;
import com.parallel.test.dao.DatabaseParallel;

public class ServiceParallel{
		
		ArrayList<Wallet> storingList = new ArrayList<>();
		DatabaseParallel d = new DatabaseParallel();
		public boolean validate(Wallet w) {
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			
			if(! (w.getWalletEmailId().matches(regex))) {
				System.out.println("Please enter the valid email");
				return false;
			}
			if(Long.toString(w.getWalletPhoneNumber()).length()!=10) {
				System.out.println("Please enter the valid phone number");
				return false;
			}
			if(Integer.toString(w.getPin()).length()<4) {
				System.out.println("Please enter the valid pin");
				return false;
			}
			if(w.getWalletName().compareTo("")==0) {
				return false;
			}
			return true;
		}
		public boolean validate(String email) {
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			
			if(! (email.matches(regex))) {
				System.out.println("Please enter the valid email");
				return false;
			}
			return true;
		}
		public boolean validate(Long phn) {
			
			if(Long.toString(phn).length()!=10) {
				System.out.println("Please enter the valid phone number");
				return false;
			}
			return true;
		}
		public boolean validate(int pin) {
			
			if(Integer.toString(pin).length()<=4) {
				System.out.println("Please enter the valid pin");
				return false;
			}
			return true;
		}
		
		
		public boolean create(Wallet w) throws SQLException {
			return d.create(w);
		}
		
		public String username(Wallet w) throws SQLException {
			return d.username(w);
		}
		public String userEmail(Wallet w) throws SQLException {
			return d.userEmail(w);
		}
		public int userId(Wallet w) throws SQLException {
			return d.userId(w);
		}
		
		public boolean verifies(Wallet w) throws SQLException {
			return d.verifies(w);
		}
		
		public int withdraw(Wallet w,int amt) throws SQLException {
			return d.withdraw(w,amt);
		}
		public int fundTransfer(Wallet w,Wallet w2,int amt) throws SQLException {
			return d.fundTransfer(w,w2,amt);
		}
		public int deposit(Wallet w, int amt) throws SQLException {
			return d.deposit(w, amt);
		}
		public ArrayList<String> viewTransactions(Wallet w) throws SQLException {
			return d.viewTransactions(w);
		}
		public boolean update(Wallet w) throws SQLException {
			return d.update(w);
		}
		public int balance(Wallet w) throws SQLException {
			return d.Balance(w);
		}
}
