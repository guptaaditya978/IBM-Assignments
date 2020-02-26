package com.parallel.test.bean;

import org.springframework.stereotype.Component;

@Component
public class Transactions{
	
	int tno;
	String dot;
	String type;
	int amount;
	int balance;
	
	public Transactions() {
		
	}
	
	public Transactions(int tno, String dot, String type, int amount, int balance) {
		this.tno = tno;
		this.dot = dot;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getDot() {
		return dot;
	}
	public void setDot(String dot) {
		this.dot = dot;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	@Override
	public String toString() {
		return "Transactions [tno=" + tno + ", dot=" + dot + ", type=" + type + ", amount=" + amount + ", balance="
				+ balance + "]";
	}
	
}
