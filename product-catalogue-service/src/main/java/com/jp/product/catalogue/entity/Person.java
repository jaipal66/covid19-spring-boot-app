package com.jp.product.catalogue.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
	
	private String personID;
	private String name;
	private String email;
	private long phone;
	private Date dob;
	
	
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	
	

}
