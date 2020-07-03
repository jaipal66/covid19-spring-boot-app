package com.jp.practice;

public class Employee implements Comparable<Employee> {

	private int empID;
	private String name;

	public Employee(int empID, String name) {
		// TODO Auto-generated constructor stub
		this.empID = empID;
		this.name = name;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "[ empID=" + empID + ",name=" + name + "]";
	}
}
