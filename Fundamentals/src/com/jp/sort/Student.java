package com.jp.sort;

public class Student {

	int rollNumber;
	String name;
	String dob;

	public Student(int rollNumber, String name, String dob) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.dob = dob;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", dob=" + dob + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this != obj)
			return false;
		Student student = (Student)obj;
		if (this.rollNumber != student.rollNumber)
			return false;
		if (this.name != student.name)
			return false;
		if (this.dob != student.dob)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + this.rollNumber;
		hash = 31 * hash + this.name == null ? 0 : name.hashCode();
		hash = 31 * hash + this.dob == null ? 0 : dob.hashCode();
		return hash;
	}
}