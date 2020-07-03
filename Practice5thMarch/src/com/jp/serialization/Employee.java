package com.jp.serialization;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

	private int empID;
	private static String name;
	private String email;
	private double salary;
	
	private Address address;
	
	public Employee(int pID,String qual,int empID, String name, String email, double salary,Address address) {
		super(pID,qual);
		this.empID = empID;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.address=address;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", email=" + email + ", salary=" + salary + ", address=" + address + "]";
	}

	
	
	
}
