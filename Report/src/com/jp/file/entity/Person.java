package com.jp.file.entity;

import com.jp.file.enums.Gender;

public class Person {

	private int personID;
	private Address address;
	private Gender gender;
	private float averageIncome;
	
	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public float getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(float averageIncome) {
		this.averageIncome = averageIncome;
	}
	
	
}
