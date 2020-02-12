package com.aditya.test.service;

import com.aditya.test.bean.*;
import java.util.ArrayList;
import com.aditya.test.dao.*;

public class Service {
	
	ArrayList<Employees> storingList = new ArrayList<>();
	Database d = new Database();
	public String getInsuranceScheme(int salary) {
		if( (salary > 5000) && (salary < 20000) ) {
			return "Scheme C";
		}
		else if( (salary >= 20000) && (salary < 40000) ) {
			return "Scheme B";
		}
		else if(salary > 40000) {
			return "Scheme A";
		}
		else {
			return "No Scheme";
		}
	}
	public String getDesignation(int salary) {
		if( (salary > 5000) && (salary < 20000) ) {
			return "System Associate";
		}
		else if( (salary >= 20000) && (salary < 40000) ) {
			return "Programmer";
		}
		else if(salary > 40000) {
			return "Manager";
		}
		else {
			return "Clerk";
		}
	}
	
	public void add(Employees e) {
		d.addEmployees(e);
	}
	public ArrayList<Employees> display(){
		return d.display();
	}
	public Employees display(int id) {
		return d.display(id);
	}
	public void delete(int id) {
		d.deleteEmployee(id);
	}
	public void connclose() {
		d.connClose();
	}
	
	
	
}
