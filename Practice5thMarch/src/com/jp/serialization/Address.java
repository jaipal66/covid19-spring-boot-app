package com.jp.serialization;

import java.io.Serializable;

public class Address implements Serializable{

	private transient int addID;
	private static String streat;
	private String city;
	private int zipCode;
	
	public Address(int addID, String streat, String city, int zipCode) {
		super();
		this.addID = addID;
		this.streat = streat;
		this.city = city;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addID=" + addID + ", streat=" + streat + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
	
	
}

