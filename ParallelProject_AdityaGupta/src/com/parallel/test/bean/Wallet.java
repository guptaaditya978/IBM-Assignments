package com.parallel.test.bean;

public class Wallet {
	int walletid;
	String walletName;
	String walletEmailId;
	Long walletPhoneNumber;
	int balance;
	int pin;
	public Wallet(String walletName, String walletEmailId, Long walletPhoneNumber, int balance,int pin) {
		this.walletName = walletName;
		this.walletEmailId = walletEmailId;
		this.walletPhoneNumber = walletPhoneNumber;
		this.balance = balance;
		this.pin = pin;
	}
	
	public Wallet() {
		this.walletid = 0;
		this.walletName = "";
		this.walletEmailId = "";
		this.walletPhoneNumber = Long.valueOf(0);
		this.balance = 0;
		this.pin = 0;
	}

	public int getWalletid() {
		return walletid;
	}

	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public String getWalletEmailId() {
		return walletEmailId;
	}
	public void setWalletEmailId(String walletEmailId) {
		this.walletEmailId = walletEmailId;
	}
	public Long getWalletPhoneNumber() {
		return walletPhoneNumber;
	}
	public void setWalletPhoneNumber(Long walletPhoneNumber) {
		this.walletPhoneNumber = walletPhoneNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	} 
	
	
}
