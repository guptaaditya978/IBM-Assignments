package com.parallel.test.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.parallel.test.bean.Transactions;
import com.parallel.test.bean.Wallet;
import com.parallel.test.service.ServiceParallel;

@Component
public class Menu{
	
	static Scanner sc = new Scanner(System.in);
	
	@Autowired
	ServiceParallel s ;
	
	@Autowired
	
	  Wallet w;
	
	@Autowired
	Wallet w2;
	
	public void menuDriven() {
		
		while(true) {
			System.out.println("Hello!! Welcome to the Batwa Payment portal");
			System.out.println("Choose an Option");
			System.out.println("1. Create Account");
			System.out.println("2. Log In");
			System.out.println("3. Exit");
			int option =sc.nextInt();
			if(option == 1) {
				try {
					add();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("This mobile number is already registered");
					//e.printStackTrace();
				}catch (InputMismatchException e) {
					//System.out.println(e);
					// TODO Auto-generated catch block
					System.out.println(e);
					System.out.println("PLease Enter a Valid input");
					//e.printStackTrace();
					sc.nextLine();
				}
				catch(Exception f) {
					System.out.println(f);
					System.out.println("PLease Enter a Valid input");
				}
			}
			else if(option == 2) {
			
				try {
					login();
				} catch (InputMismatchException e) {
					//System.out.println(e);
					// TODO Auto-generated catch block
					System.out.println("Can't put a string in number");
					sc.nextLine();
					//e.printStackTrace();
				}catch(SQLException es) {
					System.out.println(es);
					System.out.println("PLease Enter a Valid input");
				}
				catch(InterruptedException f) {
					System.out.println("Sorry Bruh");
				}
				
				
			}
			else if(option == 3) {
				System.out.println("Exiting from the System");
				break;
			}
			else {
				System.out.println("Please Choose a Valid Option");
			}
		}
		
	}
	
	public void add() throws SQLException, InterruptedException, InputMismatchException {
		System.out.println("Enter your Name");
		String tmpname = sc.next();
		System.out.println("Enter the email-Id");
		String tmpEmailId = sc.next();
		System.out.println("Enter Your Phone Number");
		Long tmpphn = sc.nextLong();
		System.out.println("Enter your Pin");
		int pin = sc.nextInt();
		//Wallet w = new Wallet(tmpname,tmpEmailId,tmpphn,500,pin);
		w.setWalletName(tmpname);
		w.setWalletEmailId(tmpEmailId);
		w.setWalletPhoneNumber(tmpphn);
		w.setBalance(500);
		w.setPin(pin);
		if(s.validate(w)){
			//Wallet w = new Wallet(tmpname,tmpEmailId,tmpphn,500,pin);
			if(s.create(w)) {
				System.out.println("Employee Added Sucesfully");
			}
			else {
				System.out.println("Employee can't be Added");
			}
		}
		Thread.sleep(5000);
		
	} 
public  void login() throws SQLException, InterruptedException,InputMismatchException {
		
		System.out.println("Enter your phone number which is linked to wallet");
		Long phn = sc.nextLong();
		System.out.println("Enter your pin");
		int pin = sc.nextInt();
		//sc.nextLine();
		w.setPin(pin);
		w.setWalletPhoneNumber(phn);
		if(s.verifies(w)) {
			afterLogin(w);
		}
		else {
			System.out.println("Invalid Credentials");
		}
		Thread.sleep(5000);
	}
	public void afterLogin(Wallet w) throws SQLException, InterruptedException, InputMismatchException {
		
		w.setWalletName(s.username(w));
		w.setWalletId(s.userId(w));
		w.setBalance(s.balance(w));
		w.setWalletEmailId(s.userEmail(w));
		//System.out.println(name);
		//System.out.println(id);
		Thread.sleep(3000);
		while(true) {
			System.out.println("Hello  "+w.getWalletName()+"   Welcome to your Dashboard");
			System.out.println("Choose an Option");
			System.out.println("1. Payment");
			System.out.println("2. Fund Transfer");
			System.out.println("3. Recharge my Wallet");
			System.out.println("4. View all my transactions");
			System.out.println("5. Update my Profile");
			System.out.println("6. Check My Balance");
			System.out.println("7. LogOut");
			
			int ch = sc.nextInt();
			
			
			if(ch == 1) {
				System.out.println("Please enter the amount you want to withdraw for the payment");
				int amt = sc.nextInt();
				if(s.withdraw(w,amt)==1) {
					System.out.println("Payment Done");
					System.out.println("Your Updated Balance is "+s.balance(w));
				}
				else {
					System.out.println("Low Balance");
				}
				Thread.sleep(3000);
			}
			else if(ch == 2) {
//				Wallet w2 = new Wallet();
				System.out.println("Please enter the phone number you want to send money");
				Long phn2=sc.nextLong();
				w2.setWalletPhoneNumber(phn2);
				System.out.println("Please enter the amount you want to send");
				int amt2 = sc.nextInt();
				if(s.userId(w2) == 0) {
					System.out.println("No account is Linked to this Number");
				}
				else {
					w2.setWalletId(s.userId(w2));
					if(s.fundTransfer(w,w2,amt2)==1) {
						System.out.println("Money is Sucessfully Transfered");
						System.out.println("Your Updated Balance is "+s.balance(w));
					}
					else {
						System.out.println("Payment Unsucessful");
					}
				}
				Thread.sleep(3000);
			}
			else if(ch == 3) {
				System.out.println("Please enter the amount you want to add");
				int amt2 = sc.nextInt();
				if(s.deposit(w,amt2)==1) {
					System.out.println("Money Added to the wallet successfully");
					System.out.println("Your Updated Balance is "+s.balance(w));
				}
				else {
					System.out.println("Money cannot be added");
				}
				Thread.sleep(3000);
			}
			else if(ch == 4) {
				
				System.out.println("Tansaction Id       Date           Amount        Type         Balance");
				if(s.numberOfRecords(w)>=0) {
					for(Transactions a:s.viewTransactions(w)) {
						System.out.println(a);
					}
				}
				else {
					System.out.println("No Transactions Yet");
				}
				
				
				Thread.sleep(7000);
			}
			else if(ch == 5) {
				
				System.out.println("WHAT DO YOU WANT TO UPDATE?");
				System.out.println("1. Name");
				System.out.println("2. Email-Id");
				System.out.println("3. Phone Number");
				System.out.println("4. Pin");
				int k1 = sc.nextInt();
				if(k1 == 1){
					System.out.println("Enter the Name");
					String tmpname = sc.next();
					if(tmpname.compareTo("")!=0) {
						w.setWalletName(tmpname);
						s.update(w);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 2) {
					System.out.println("Enter the Email-Id");
					String email = sc.next();	
					if(s.validate(email)) {
						w.setWalletEmailId(email);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 3) {
					System.out.println("Enter the Phone Number");
					Long phnu = sc.nextLong();
					if(s.validate(phnu)) {
						w.setWalletPhoneNumber(phnu);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 4) {
					System.out.println("Enter the Pin");
					int pins = sc.nextInt();
					if(s.validate(pins)) {
						w.setPin(pins);
					}
					else{
						throw new SQLException();
					}					
				}
				else {
					System.out.println("PLease Enter valid option");
				}
				if(s.update(w)) {
					System.out.println("Updated Sucessully");
				}
				else {
					System.out.println("Not updated Sucessfully");
				}
				Thread.sleep(5000);
			}
			
			else if(ch ==6) {
				System.out.println("Your Balance is "+s.balance(w));
				Thread.sleep(3000);
			}
			else if(ch == 7) {
				System.out.println("Thank You "+ w.getWalletName());
				break;
			}
			else {
				System.out.println("Please Choose A Valid Option");
			}
		}
		
	}
}
