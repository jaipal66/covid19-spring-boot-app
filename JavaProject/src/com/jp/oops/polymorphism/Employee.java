package com.jp.oops.polymorphism;

import java.io.FileNotFoundException;

public class Employee extends Person {
	
	static{
		System.out.println("static block 2 from Employee");
	}
	{
		System.out.println("Instance Initilization Block 1 from Employee");
	}
	static {
		System.out.println("static block 1 from Employee");
	}
	
	{
		System.out.println("Instance Initilization Block 2 from Employee");
	}
	public Employee() {
		
		System.out.println("Employee()");
	}
	
	public Employee(String name) {
		this();
		System.out.println("Employee name");
	}
	
	
	public String sleep(String n) throws IllegalArgumentException{
		try {
			super.sleep(1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee Sleep");
		return "";
	}
	
	public int ran()  {
		System.out.println("Employee ran");
		return 1;
	}

	public void walk() {
		this.walk(1);
	}
	
	private int walk(int number) {
		return 1;
	}
}
