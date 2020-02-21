package com.parallel.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.parallel.test.bean.Transactions;
import com.parallel.test.bean.Wallet;
import static com.parallel.test.dao.ConnectionsParallel.conn;
import static com.parallel.test.dao.ConnectionsParallel.ps;

public class Database {
	
	ConnectionsParallel connections = new ConnectionsParallel();
	static int transactionNumber=10001;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	public boolean add(Wallet w) throws SQLException {
		
		ps = conn.prepareStatement("select * from walletusers");
		ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()==false) {
        	//System.out.println("No Records present in the Table");
        	ps = conn.prepareStatement("insert into walletusers values(?,?,?,?,?,?)");
        	ps.setInt(1,101);
        	ps.setString(2,w.getWalletName());
    		ps.setString(3,w.getWalletEmailId());
    		ps.setLong(4,w.getWalletPhoneNumber());
    		ps.setInt(5,w.getBalance());
    		ps.setInt(6,w.getPin());
    		if(ps.executeUpdate()>0) {
    			
    			w.setWalletId(101);
    			//Thread.sleep(3000);
    			return true;
    		}
    		else{
    			return false;
    			//Thread.sleep(1500);
    		}
        	//Thread.sleep(3000);
        }
        else {
        	
        	ps = conn.prepareStatement("insert into walletusers values(NULL,?,?,?,?,?)");
			ps.setString(1,w.getWalletName());
			ps.setString(2,w.getWalletEmailId());
			ps.setLong(3,w.getWalletPhoneNumber());
			ps.setInt(4,w.getBalance());
			ps.setInt(5,w.getPin());
			
			
			if(ps.executeUpdate()>0) {
				return true;
				//Thread.sleep(3000);
			}
			else{
				return false;
				//Thread.sleep(1500);
			}
        }
	}
	
	public int userId(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where walletPhoneNumber=?");
		ps.setLong(1,w.getWalletPhoneNumber());
		ResultSet resultSet = ps.executeQuery();
		
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
	
	public String userName(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where walletPhoneNumber=?");
		ps.setLong(1,w.getWalletPhoneNumber());
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		return resultSet.getString("walletName");
	}
	public String userEmail(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where walletPhoneNumber=?");
		ps.setLong(1,w.getWalletPhoneNumber());
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		return resultSet.getString("walletEmailId");
	}
	
	public Long userPhoneNumber(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where id=?");
		ps.setLong(1,w.getWalletId());
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		return resultSet.getLong("walletPhoneNumber");
	}
	
	public boolean verifies(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where walletPhoneNumber=? && pin=?");
		ps.setLong(1,w.getWalletPhoneNumber());
		ps.setInt(2,w.getPin());
		ResultSet resultSet = ps.executeQuery();
		
		if(resultSet.next()  ==false) {
        	return false;
        	//Thread.sleep(3000);
        }
        else {
        	return true;
        	//Thread.sleep(3000);
        }
		
	}
	
	
	public int withdraw(Wallet w,int amt) throws SQLException {
			
			int balance1 = this.Balance(w);
			
			if(balance1-amt>0) {
				ps = conn.prepareStatement("update walletusers set balance=? where id=?");
				ps.setInt(1,balance1-amt);
				ps.setInt(2,w.getWalletId());
				if(ps.executeUpdate()>0){
					if(this.addDebitTransaction(w,amt)){
						
					}
					//System.out.println("Transactoin Done Sucesfully");
					//System.out.println("Payment Done Successfully");
				}
				return 1;
			}
			else {
				return 0;
			}
		}
		
	public boolean addDebitTransaction(Wallet w,int amt) throws SQLException {
		
		int balance2 = this.Balance(w);
		
		LocalDateTime now = LocalDateTime.now();
		ps = conn.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
		ps.setInt(1,w.getWalletId());
		ps.setInt(2,transactionNumber++);
		ps.setString(3,dtf.format(now));
		ps.setString(4,"Debit");
		ps.setInt(5,amt);
		ps.setInt(6,balance2);
		
		if(ps.executeUpdate()>0) {
			return true;
		//Thread.sleep(3000);
		}
		return false;
	}
		
	public boolean addCreditTransaction(Wallet w,int amt) throws SQLException {
		
		int balance3 = this.Balance(w);
		LocalDateTime now = LocalDateTime.now();
		ps = conn.prepareStatement("insert into transactions values(?,?,?,?,?,?)");
		ps.setInt(1,w.getWalletId());
		ps.setInt(2,transactionNumber++);
		ps.setString(3,dtf.format(now));
		ps.setString(4,"Credit");
		ps.setInt(5,amt);
		ps.setInt(6,balance3);
		
		if(ps.executeUpdate()>0) {
			return true;
		//Thread.sleep(3000);
		}
		return false;
	}
	
	public int Balance(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where id=?");
		ps.setInt(1,w.getWalletId());
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		return resultSet.getInt("balance");
	}
	
	
	public int deposit(Wallet w,int amt) throws SQLException {
			
			int balance1 = this.Balance(w);
				ps = conn.prepareStatement("update walletusers set balance=? where id=?");
				ps.setInt(1,balance1+amt);
				ps.setInt(2,w.getWalletId());
				if(ps.executeUpdate()>0){
					if(this.addCreditTransaction(w,amt)) {
						return 1;
						//System.out.println("Balance is " + this.Balance(w));
					}
					//System.out.println("Payment Done Successfully");
					return 0;
				}
				else {
					return 0;
				}
		}
	
	public Wallet fetch(Wallet w) throws SQLException {
		ps = conn.prepareStatement("select * from walletusers where id=?");
		ps.setLong(1,w.getWalletId());
		ResultSet resultSet = ps.executeQuery();
		resultSet.next();
		w.setBalance(resultSet.getInt("balance"));
		w.setWalletEmailId(resultSet.getString("walletEmailId"));
		w.setPin(resultSet.getInt("pin"));
		w.setWalletName(resultSet.getString("walletName"));
		w.setWalletPhoneNumber(resultSet.getLong("walletPhoneNumber"));
		
		return w;
	}
	
	public boolean update(Wallet w) throws SQLException {
		ps = conn.prepareStatement("update walletusers set walletName=?, walletEmailId=?, walletPhoneNumber=?, pin=? where id=?");
		ps.setInt(5,w.getWalletId());
		ps.setString(1,w.getWalletName());
		ps.setString(2,w.getWalletEmailId());
		ps.setLong(3,w.getWalletPhoneNumber());
		ps.setInt(4,w.getPin());
		if(ps.executeUpdate()>0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public int fundTransfer(Wallet w,Wallet w2,int amt) throws SQLException {
		
		if(this.withdraw(w, amt) == 1) {
			if(this.deposit(w2, amt) ==1) {
				return 1;
			}
			//System.out.println("Balance is " + this.Balance(id1));
		}
		return 0;
	}
	
	
	public ArrayList<Transactions>  viewTransactions(Wallet w) throws SQLException {
		
		Transactions t ;
		ArrayList<Transactions> s = new ArrayList<>();
		 
		ps = conn.prepareStatement("select * from transactions where id=?");
		ps.setInt(1, w.getWalletId());
		ResultSet resultSet = ps.executeQuery();
	
	    if(resultSet.next()==false) {
	    	return s;
	    	//Thread.sleep(3000);
	    }
	    else {
	    	
	    	
	    	do {
	    		t=new Transactions(resultSet.getInt("transId"), resultSet.getString("date"), resultSet.getString("type"), resultSet.getInt("amount"), resultSet.getInt("balance"));
	    		s.add(t);
	    	}while(resultSet.next());
	    	//Thread.sleep(3000);
	    	
	    	return s;
	    }
	}
	
}
