package com.jp.oops.polymorphism;

import java.io.FileNotFoundException;
import java.util.Date;

public class Person {
	
	static{
		System.out.println("static block 2 from person");
	}
	{
		System.out.println("Instance Initilization Block 1 from Person");
	}
	static {
		System.out.println("static block 1 from person");
	}
	
	{
		System.out.println("Instance Initilization Block 2 from Person");
	}
	public Person() {
		System.out.println("Person()");
	}
	
	private int personID;
	private Name name;
	private String email;
	private Date dob;
	
	public Object sleep(int i) throws FileNotFoundException {
		System.out.println("Person Sleep");
		return "";
		
	}
	public int ran(){
		System.out.println("Person ran");
		return 1;
	}
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
	
}
