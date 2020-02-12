package com.aditya.test.ui;

import java.util.*;

import com.aditya.test.service.Service;
import com.aditya.test.bean.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Service s = new Service();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		while(true) {
			System.out.println("Choose The Option");
			System.out.println("1. Add the Employee");
			System.out.println("2. Display The Employees");
			System.out.println("3. Delete The Employee");
			System.out.println("4. Display Info about a particular Employee");
			System.out.println("5. Exit");
			int option = sc.nextInt();
			if(option == 1) {
				try {
				add();
				}catch(Exception e) {
					System.out.println("Sorry you hav input the wrong id");
				}
			}
			else if(option == 2) {
				for(Employees ef:s.display()) {
					System.out.println(ef);
				}
				if(s.display().size()==0) {
					System.out.println("No Records present");
				}
			}
			else if(option == 3) {
				System.out.println("Enter the id of the Employee you want to delete");
				int k = sc.nextInt();
				s.delete(k);
			}
			else if(option ==4 ) {
				System.out.println("Enter the employee id you want to have the information");
				int r = sc.nextInt();
				if(s.display(r)!=null) {
					System.out.println(s.display(r));
				}
			}
			else if(option == 5) {
				System.out.println("Thank you");
				s.connclose();
				break;
			}
			else {
				System.out.println("PLease choose a valid optoin");
			}
		}
	}
	public static void add() {
		System.out.println("Enter the employee Id");
		int id = sc.nextInt();
		System.out.println("Enter the employee Name");
		String tmpname = sc.next();
		System.out.println("Enter the employee Salary");
		int salary = sc.nextInt();
		Employees e = new Employees(tmpname,s.getDesignation(salary),id,salary,s.getInsuranceScheme(salary));
		s.add(e);
	}

}
