package com.parallel.test.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.parallel.test.bean.Wallet;
import com.parallel.test.service.ServiceParallel;

public class MainParallel {
	
		static Scanner sc = new Scanner(System.in);
		static ServiceParallel s = new ServiceParallel(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
				}
				catch(Exception f) {
					System.out.println("PLease Enter a Valid input");
				}
			}
			else if(option == 2) {
			
				try {
					login();
				} catch (InputMismatchException e) {
					//System.out.println(e);
					// TODO Auto-generated catch block
					System.out.println("PLease Enter a Valid input");
					//e.printStackTrace();
				}catch(SQLException es) {
					System.out.println("PLease Enter a Valid input");
				}catch(Exception d) {
					System.out.println("PLease Enter a Valid input");
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
	public static void add() throws SQLException, InterruptedException {
		System.out.println("Enter your Name");
		String tmpname = sc.next();
		System.out.println("Enter the email-Id");
		String tmpEmailId = sc.next();
		System.out.println("Enter Your Phone Number");
		Long tmpphn = sc.nextLong();
		System.out.println("Enter your Pin");
		int pin = sc.nextInt();
		if(s.validate(tmpname,tmpEmailId,tmpphn,pin)){
			Wallet w = new Wallet(tmpname,tmpEmailId,tmpphn,500,pin);
			s.create(w);
		}
		Thread.sleep(5000);
		
	}
	public static void login() throws SQLException, InterruptedException, Exception {
		
		System.out.println("Enter your phone number which is linked to wallet");
		Long phn = sc.nextLong();
		System.out.println("Enter your pin");
		int pin = sc.nextInt();
		if(s.verifies(phn,pin)) {
			afterLogin(phn,pin);
		}
		else {
			System.out.println("Invalid Credentials");
		}
		Thread.sleep(5000);
	}
	public static void afterLogin(Long phn,int pin) throws SQLException, InterruptedException {
		
		String name = s.users(phn);
		int id = s.userId(phn);
		//System.out.println(name);
		//System.out.println(id);
		Thread.sleep(3000);
		while(true) {
			System.out.println("Hello  "+s.users(phn)+"   Welcome to your Dashboard");
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
				if(s.withdraw(id,amt)==1) {
					System.out.println("Payment Done");
				}
				Thread.sleep(3000);
			}
			else if(ch == 2) {
				System.out.println("Please enter the phone number you want to send money");
				Long phn2=sc.nextLong();
				System.out.println("Please enter the amount you want to send");
				int amt2 = sc.nextInt();
				int id2 = s.userId(phn2);
				if(id2 == 0) {
					System.out.println("No account is Linked to this Number");
				}
				else {
					s.fundTransfer(id,id2,amt2);
				}
				Thread.sleep(3000);
			}
			else if(ch == 3) {
				System.out.println("Please enter the amount you want to add");
				int amt2 = sc.nextInt();
				s.deposit(id,amt2);
				Thread.sleep(3000);
			}
			else if(ch == 4) {
				s.viewTransactions(id);
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
						s.update1(id, tmpname);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 2) {
					System.out.println("Enter the Email-Id");
					String email = sc.next();	
					if(s.validate(email)) {
						s.update2(id,email);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 3) {
					System.out.println("Enter the Phone Number");
					Long phnu = sc.nextLong();
					if(s.validate(phnu)) {
						s.update1(id,phnu);
					}
					else {
						throw new SQLException();
					}
					
				}
				else if(k1 == 4) {
					System.out.println("Enter the Pin");
					int pins = sc.nextInt();
					if(s.validate(pin)) {
						s.update2(id,pins);
					}
					else{
						throw new SQLException();
					}					
				}
				else {
					System.out.println("PLease Enter valid option");
				}
				Thread.sleep(5000);
			}
			
			else if(ch ==6) {
				System.out.println("Your Balance is "+s.balance(id));
				Thread.sleep(3000);
			}
			else if(ch == 7) {
				System.out.println("Thank You"+ name);
				break;
			}
			else {
				System.out.println("Please Choose A Valid Option");
			}
		}
		
	}

}
