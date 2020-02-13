package com.parallel.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

import com.parallel.test.bean.Wallet;



public class DatabaseParallel {
	
	//ArrayList<Wallet> storingList = new ArrayList();
	ConnectionsParallel connections = new ConnectionsParallel();
	static int transactionNumber=10001;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   
	
	public void create(Wallet w) throws SQLException {
		
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from walletusers");
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();

        if(resultSet.next()==false) {
        	//System.out.println("No Records present in the Table");
        	ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("insert into walletusers values(?,?,?,?,?,?)");
        	ConnectionsParallel.ps.setInt(1,101);
        	ConnectionsParallel.ps.setString(2,w.getWalletName());
    		ConnectionsParallel.ps.setString(3,w.getWalletEmailId());
    		ConnectionsParallel.ps.setLong(4,w.getWalletPhoneNumber());
    		ConnectionsParallel.ps.setInt(5,w.getBalance());
    		ConnectionsParallel.ps.setInt(6,w.getPin());
    		if(ConnectionsParallel.ps.executeUpdate()>0) {
    			System.out.println("Employee Added Sucesfully");
    			//Thread.sleep(3000);
    		}
    		else{
    			System.out.println("Employee can't be Added");
    			//Thread.sleep(1500);
    		}
        	//Thread.sleep(3000);
        }
        else {
        	
        	ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("insert into walletusers values(NULL,?,?,?,?,?)");
			ConnectionsParallel.ps.setString(1,w.getWalletName());
			ConnectionsParallel.ps.setString(2,w.getWalletEmailId());
			ConnectionsParallel.ps.setLong(3,w.getWalletPhoneNumber());
			ConnectionsParallel.ps.setInt(4,w.getBalance());
			ConnectionsParallel.ps.setInt(5,w.getPin());
			
			if(ConnectionsParallel.ps.executeUpdate()>0) {
				System.out.println("Accounted Created Sucesfully");
			//Thread.sleep(3000);
			}
			else{
				System.out.println("Account can't be created");
			//Thread.sleep(1500);
			}
        }
	}
	
	
	public String users(long phn) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from walletusers where walletPhoneNumber=?");
		ConnectionsParallel.ps.setLong(1,phn);
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();
		resultSet.next();
		return resultSet.getString("walletName");
	}
	
	public boolean verifies(long phn,int pin) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from walletusers where walletPhoneNumber=? && pin=?");
		ConnectionsParallel.ps.setLong(1,phn);
		ConnectionsParallel.ps.setInt(2,pin);
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();
		
		if(resultSet.next()  ==false) {
        	System.out.println("No Records present in the Table");
        	return false;
        	//Thread.sleep(3000);
        }
        else {
        	return true;
        	//Thread.sleep(3000);
        }
		
	}
	public int userId(long phn) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from walletusers where walletPhoneNumber=?");
		ConnectionsParallel.ps.setLong(1,phn);
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();
		
		if(resultSet.next()==false) {
        	//System.out.println("No Records present in the Table");
        	return 0;
        	
        	//Thread.sleep(3000);
        }
        else {
        	return resultSet.getInt("id");
        	//Thread.sleep(3000);
        }
	}
	
	public int withdraw(int id,int amt) throws SQLException {
		
		int balance1 = this.Balance(id);
		
		if(balance1-amt>0) {
			ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set balance=? where id=?");
			ConnectionsParallel.ps.setInt(1,balance1-amt);
			ConnectionsParallel.ps.setInt(2,id);
			if(ConnectionsParallel.ps.executeUpdate()>0){
				this.addDebitTransaction(id,amt);
				//System.out.println("Payment Done Successfully");
				System.out.println("Balance is " + this.Balance(id));
			}
			else {
				System.out.println("Payment unsucessfull");
			}
			return 1;
		}
		else {
			this.lowBalance();
			return 0;
		}
	}
	
	public void lowBalance() {
		System.out.println("You have insufficient Balance");
	}
	
	public void addDebitTransaction(int id,int amt) throws SQLException {
		
		int balance2 = this.Balance(id);
		
		LocalDateTime now = LocalDateTime.now();
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
		ConnectionsParallel.ps.setInt(1,id);
		ConnectionsParallel.ps.setInt(2,transactionNumber++);
		ConnectionsParallel.ps.setString(3,dtf.format(now));
		ConnectionsParallel.ps.setString(4,"Debit");
		ConnectionsParallel.ps.setInt(5,amt);
		ConnectionsParallel.ps.setInt(6,balance2);
		
		if(ConnectionsParallel.ps.executeUpdate()>0) {
			System.out.println("Transactoin Done Sucesfully");
		//Thread.sleep(3000);
		}
	}
		public void addCreditTransaction(int id,int amt) throws SQLException {
		
		int balance3 = this.Balance(id);
		LocalDateTime now = LocalDateTime.now();
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
		ConnectionsParallel.ps.setInt(1,id);
		ConnectionsParallel.ps.setInt(2,transactionNumber++);
		ConnectionsParallel.ps.setString(3,dtf.format(now));
		ConnectionsParallel.ps.setString(4,"Credit");
		ConnectionsParallel.ps.setInt(5,amt);
		ConnectionsParallel.ps.setInt(6,balance3);
		
		if(ConnectionsParallel.ps.executeUpdate()>0) {
			System.out.println("Transactoin Done Sucesfully");
		//Thread.sleep(3000);
		}
	}
	
	public int Balance(int id) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from walletusers where id=?");
		ConnectionsParallel.ps.setInt(1,id);
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();
		resultSet.next();
		return resultSet.getInt("balance");
	}
	public void deposit(int id,int amt) throws SQLException {
		
		int balance1 = this.Balance(id);
			ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set balance=? where id=?");
			ConnectionsParallel.ps.setInt(1,balance1+amt);
			ConnectionsParallel.ps.setInt(2,id);
			if(ConnectionsParallel.ps.executeUpdate()>0){
				this.addCreditTransaction(id,amt);
				//System.out.println("Payment Done Successfully");
				System.out.println("Balance is " + this.Balance(id));
			}
			else {
				System.out.println("Payment unsucessfull");
			}
	}
	
	
	public void fundTransfer(int id1,int id2,int amt) throws SQLException {
		
		if(this.withdraw(id1, amt) == 1) {
			this.deposit(id2, amt);
			
			System.out.println("Balance is " + this.Balance(id1));
		}
		else {
			this.lowBalance();
		}
	}
	public void viewTransactions(int id) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("select * from transactions where id=?");
		ConnectionsParallel.ps.setInt(1, id);
		ResultSet resultSet = ConnectionsParallel.ps.executeQuery();

        if(resultSet.next()==false) {
        	System.out.println("No Recors present in the Table");
        	//Thread.sleep(3000);
        }
        else {
        	System.out.println("Transactoins for "+id);
        	System.out.println("Tansaction Id       Date           Amount        Type         Balance");
        	do {
        		
        		System.out.println(resultSet.getInt("transId")+"  "+resultSet.getString("date")+ "     "+resultSet.getInt("amount")+ "     "+resultSet.getString("type")+ "     "+resultSet.getInt("balance"));
        	}while(resultSet.next());
        	//Thread.sleep(3000);
        }
	}
	
	public void update1(int id,String name) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set walletName=? where id=?");
		ConnectionsParallel.ps.setInt(2,id);
		ConnectionsParallel.ps.setString(1,name);
		if(ConnectionsParallel.ps.executeUpdate()>0){
			System.out.println("Updated name Successfully");
		}
		else {
			System.out.println("No records were Updated");
		}
	}
	public void update1(int id,Long phn) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set walletPhoneNumber=? where id=?");
		ConnectionsParallel.ps.setInt(2,id);
		ConnectionsParallel.ps.setLong(1,phn);
		if(ConnectionsParallel.ps.executeUpdate()>0){
			System.out.println("Updated Phone Number Successfully");
		}
		else {
			System.out.println("No records were Updated");
		}
	}
	public void update2(int id,String email) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set walletEmailId=? where id=?");
		ConnectionsParallel.ps.setInt(2,id);
		ConnectionsParallel.ps.setString(1,email);
		if(ConnectionsParallel.ps.executeUpdate()>0){
			System.out.println("Updated E-mail Successfully");
		}
		else {
			System.out.println("No records were Updated");
		}
	}
	public void update2(int id,int pin) throws SQLException {
		ConnectionsParallel.ps =ConnectionsParallel.conn.prepareStatement("update walletusers set pin=? where id=?");
		ConnectionsParallel.ps.setInt(2,id);
		ConnectionsParallel.ps.setInt(1,pin);
		if(ConnectionsParallel.ps.executeUpdate()>0){
			System.out.println("Updated your record Successfully");
		}
		else {
			System.out.println("No records were Updated");
		}
	}
	
	
	
	
	
	
	
}
