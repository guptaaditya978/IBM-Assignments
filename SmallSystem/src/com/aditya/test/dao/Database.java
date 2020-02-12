package com.aditya.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.aditya.test.bean.Employees;

public class Database {
	ArrayList<Employees> storingList = new ArrayList();
	Connections connections = new Connections();
	public void addEmployees(Employees e) {
//		storingList.add(e);
		try {
			Connections.ps =Connections.conn.prepareStatement("insert into employees values(?,?,?,?,?)");
			Connections.ps.setInt(1,e.getEmpid());
			Connections.ps.setString(2,e.getName());
			Connections.ps.setInt(3,e.getSalary());
			Connections.ps.setString(4,e.getInsuranceScheme());
			Connections.ps.setString(5,e.getDesignation());
			if(Connections.ps.executeUpdate()>0) {
				System.out.println("Employee Added Sucesfully");
				Thread.sleep(3000);
			}
			else{
				System.out.println("Employee can't be Added");
			}			
		}catch(Exception s) {
			System.out.println(s);
			System.out.println("From AddEmployees");
		}
	}
	
	
	public ArrayList<Employees> display(){
		storingList.clear();
		try {
			Connections.ps =Connections.conn.prepareStatement("select * from employees");
			ResultSet resultSet = Connections.ps.executeQuery();

            if(resultSet.next()==false) {
            	System.out.println("No Recors present in the Table");
            }
            else {
            	do {
            		storingList.add(new Employees(resultSet.getString("name") ,resultSet.getString("designation") ,resultSet.getInt("empid") ,resultSet.getInt("salary") ,resultSet.getString("insuranceScheme")));
            	}while(resultSet.next());
            }
		}catch(Exception e){
			System.out.println("From display");
		}
			
		return storingList;
	}
	
	public void deleteEmployee(int id){
		try {
			Connections.ps =Connections.conn.prepareStatement("delete from employees where empid=?");
			Connections.ps.setInt(1,id);
			if(Connections.ps.executeUpdate()>0){
				System.out.println("Deleted Successfully");
			}
			else {
				System.out.println("No records were Deleted");
			}
		}catch(Exception e) {
			System.out.println("In Delete");
		}
	}
	public Employees display(int id){
//		storingList.clear();
		try {
			Connections.ps =Connections.conn.prepareStatement("select * from employees where empid=?");
			Connections.ps.setInt(1,id);
			ResultSet resultSet = Connections.ps.executeQuery();

            if(resultSet.next()==false) {
            	System.out.println("No Recors present in the Table");
            	return null;
            }
            else {
            	return (new Employees(resultSet.getString("name") ,resultSet.getString("designation") ,resultSet.getInt("empid") ,resultSet.getInt("salary") ,resultSet.getString("insuranceScheme")));
            }
		}catch(Exception e){
			System.out.println("From display");
		}
		return null;
	}
	public void connClose() {
		try {
			Connections.conn.close();
		}catch(Exception e) {
			System.out.println("Connectoin close problem");
		}
		
	}
}
