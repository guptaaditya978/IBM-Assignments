package com.aditya.test.bean;

public class Employees {
	String name , insuranceScheme,designation;
	int empid, salary;
	
	public Employees(String name, String designation, int empid, int salary,String insurance) {
		this.name = name;
		this.designation = designation;
		this.empid = empid;
		this.salary = salary;
		this.insuranceScheme = insurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [name=" + name + ", insuranceScheme=" + insuranceScheme + ", designation=" + designation
				+ ", empid=" + empid + ", salary=" + salary + "]";
	}
	
	

	
}
