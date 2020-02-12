package com.aditya.test.dao;

import java.util.ArrayList;
import com.aditya.test.bean.Employees;

public class Database {
	ArrayList<Employees> storingList = new ArrayList();
	
	public void addEmployees(Employees e) {
		storingList.add(e);
	}
	
	public ArrayList<Employees> display(){
		return storingList;
	}
	
	public void deleteEmployee(int id){
		int i=0;
		for(Employees e : storingList) {
			if(e.getEmpid()==id) {
				break;
			}
			i++;
		}
		if(i>=storingList.size()) {
			System.out.println("No matches with this id found.");
			return;
		}
		storingList.remove(i);
		System.out.println("Deleted Successfully");
	}
}
