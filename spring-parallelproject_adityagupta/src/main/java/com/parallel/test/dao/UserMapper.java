package com.parallel.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;


import com.parallel.test.bean.Transactions;

public class UserMapper implements RowMapper<Transactions> {

	
 
	
	public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println(t);
		Transactions t = new Transactions();
		t.setTno(rs.getInt("transid"));
		t.setDot(rs.getString("date"));
		t.setType(rs.getString("type"));
		t.setAmount(rs.getInt("amount"));
		t.setBalance(rs.getInt("balance"));
		
		return t;
	}

}
