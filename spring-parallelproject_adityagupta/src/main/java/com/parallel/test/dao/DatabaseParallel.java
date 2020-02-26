package com.parallel.test.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.parallel.test.bean.Transactions;
import com.parallel.test.bean.Wallet;
import static com.parallel.test.dao.ConnectionsParallel.jdbcTemplate;


@Repository
public class DatabaseParallel {
	
	@Autowired
	ConnectionsParallel connections;
	
	static int transactionNumber=10001;
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   
	
	public boolean create(Wallet w) throws SQLException {
		
        if(this.numberOfRecords() == 0) {
        	//System.out.println("No Records present in the Table");
        	String querry="insert into walletusers values(?,?,?,?,?,?)";
        	jdbcTemplate.update(querry, new Object[] {
        			101,
        			w.getWalletName(),
        			w.getWalletEmailId(),
        			w.getWalletPhoneNumber(),
        			w.getBalance(),
        			w.getPin()
        	});
    		
    		return true;
        }
        else {
        	
			String querry="insert into walletusers values(NUll,?,?,?,?,?)";
        	jdbcTemplate.update(querry, new Object[] {
        			w.getWalletName(),
        			w.getWalletEmailId(),
        			w.getWalletPhoneNumber(),
        			w.getBalance(),
        			w.getPin()
        	});
			return true;
        }
	}
	
	public Integer numberOfRecords() {
		String qr="select count(*) from walletusers";
		return jdbcTemplate.queryForObject(qr,Integer.class);
	}
	
	public String username(Wallet w) throws SQLException {
		String q ="select walletName from walletusers where walletPhoneNumber=?";
		return jdbcTemplate.queryForObject(q,new Object[] {
				w.getWalletPhoneNumber()
		},String.class);
	}
	public String userEmail(Wallet w) throws SQLException {
		String q ="select walletEmailId from walletusers where walletPhoneNumber=?";
		
		return jdbcTemplate.queryForObject(q,new Object[] {
				w.getWalletPhoneNumber()
		}, String.class);
	}
	
	public boolean verifies(Wallet w) throws SQLException {
		String q="select id from walletusers where walletPhoneNumber=? && pin=?";
		
		if((jdbcTemplate.queryForObject(q,new Object[] {w.getWalletPhoneNumber(),w.getPin()} ,Integer.class))>0){
			return true;
		}
		return false;
		
	}
	public int userId(Wallet w) throws SQLException {
		String querry="select id from walletusers where walletPhoneNumber=?";
		return jdbcTemplate.queryForObject(querry,new Object[] {
				w.getWalletPhoneNumber()
		},Integer.class);
		
	}
	
	public int withdraw(Wallet w,int amt) throws SQLException {
		
		int balance1 = this.Balance(w);
		
		if(balance1-amt>0) {
			
			String q = "update walletusers set balance=? where id=?";
			if(jdbcTemplate.update(q,new Object[] { balance1-amt,w.getWalletId()})>0) {
				if(this.addDebitTransaction(w,amt)) {
					return 1;
				}
			}
			
		}
		return 0;
	}
	
	
	
	public boolean addDebitTransaction(Wallet w,int amt) throws SQLException {
		
		int balance2 = this.Balance(w);
		LocalDateTime now = LocalDateTime.now();
		String q ="insert into transactions values(?,?,?,?,?,?)";
		if(jdbcTemplate.update(q, new Object[] {w.getWalletId(),transactionNumber++,dtf.format(now),"Debit",amt,balance2})>0) {
			return true;
		}
		return false;
	}
		public boolean addCreditTransaction(Wallet w,int amt) throws SQLException {
		
		int balance3 = this.Balance(w);
		LocalDateTime now = LocalDateTime.now();
		String q ="insert into transactions values(?,?,?,?,?,?)";
		if(jdbcTemplate.update(q, new Object[] {w.getWalletId(),transactionNumber++,dtf.format(now),"Credit",amt,balance3})>0) {
			return true;
		}
		return false;
	}
	
	public int Balance(Wallet w) throws SQLException {
		String s ="select balance from walletusers where id=?";
		return jdbcTemplate.queryForObject(s,new Object[] {
				w.getWalletId()
		}, Integer.class);
	}
	public int deposit(Wallet w,int amt) throws SQLException {
		
		int balance1 = this.Balance(w);
		String q = "update walletusers set balance=? where id=?";
		if(jdbcTemplate.update(q,new Object[] { balance1+amt,w.getWalletId()})>0) {
			if(this.addCreditTransaction(w,amt)) {
				return 1;
			}
		}
		return 0;
				
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
	public List<Transactions>  viewTransactions(Wallet w) throws SQLException {
		
		String s = "select * from transactions where id=?";
        return jdbcTemplate.query(s,new Object[] {w.getWalletId()},new UserMapper());
        
	}
	
	public Integer numberOfRecords(Wallet w) {
		String qr="select count(*) from transactions where id=?";
		return jdbcTemplate.queryForObject(qr,new Object[] {w.getWalletId()},Integer.class);
	}
	
	public boolean update(Wallet w) throws SQLException {
		String q = "update walletusers set walletName=?, walletEmailId=?, walletPhoneNumber=?, pin=? where id=?";
		if(jdbcTemplate.update(q,new Object[] { w.getWalletName(),w.getWalletEmailId(),w.getWalletPhoneNumber(),w.getPin(),w.getWalletId()})>0) {
			return true;
		}
		return false;
	}
}
