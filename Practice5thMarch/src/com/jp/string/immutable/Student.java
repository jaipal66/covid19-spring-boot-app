package com.jp.string.immutable;

public final class Student {

	private int studentID;
	private String name;
	private String emailID;
	private Address address;

	public Student(int studentID, String name, String emailID) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.emailID = emailID;
	}

	public Student(String name, String emailID, Address address) {
		super();
		this.name = name;
		this.emailID = emailID;
		this.address = address;
	}

	public Student(int studentID, String name, String emailID, Address address) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.emailID = emailID;
		this.address = address;
	}

	public int getStudentID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	public String getEmailID() {
		return emailID;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address)address.clone();
	}

}
