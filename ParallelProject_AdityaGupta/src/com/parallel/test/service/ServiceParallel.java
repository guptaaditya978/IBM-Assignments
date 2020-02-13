package com.parallel.test.service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.parallel.test.bean.Wallet;
import com.parallel.test.dao.DatabaseParallel;

public class ServiceParallel{
		
		ArrayList<Wallet> storingList = new ArrayList<>();
		DatabaseParallel d = new DatabaseParallel();
		public boolean validate(String tmpname,String tmpEmailId,Long tmpphn,int pin) {
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			
			if(! (tmpEmailId.matches(regex))) {
				System.out.println("Please enter the valid email");
				return false;
			}
			if(Long.toString(tmpphn).length()!=10) {
				System.out.println("Please enter the valid phone number");
				return false;
			}
			if(Integer.toString(pin).length()<=4) {
				System.out.println("Please enter the valid pin");
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
		
		
		public void create(Wallet w) throws SQLException {
			d.create(w);
		}
		
		public String users(long phn) throws SQLException {
			return d.users(phn);
		}
		public int userId(long phn) throws SQLException {
			return d.userId(phn);
		}
		
		public boolean verifies(long phn, int pin) throws SQLException {
			return d.verifies(phn,pin);
		}
		
		public int withdraw(int id,int amt) throws SQLException {
			return d.withdraw(id,amt);
		}
		public void fundTransfer(int id1,int id2,int amt) throws SQLException {
			d.fundTransfer(id1,id2,amt);
		}
		public void deposit(int id, int amt) throws SQLException {
			d.deposit(id, amt);
		}
		public void viewTransactions(int id) throws SQLException {
			d.viewTransactions(id);
		}
		public void update1(int id,String name) throws SQLException {
			d.update1(id,name);
		}
		public void update2(int id,String email) throws SQLException {
			d.update2(id,email);
		}
		public void update1(int id,Long phn) throws SQLException {
			d.update1(id,phn);
		}
		public void update2(int id,int pin) throws SQLException {
			d.update2(id,pin);
		}
		public int balance(int id) throws SQLException {
			return d.Balance(id);
		}
		
}
