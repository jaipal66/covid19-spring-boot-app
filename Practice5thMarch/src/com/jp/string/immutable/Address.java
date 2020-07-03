package com.jp.string.immutable;

public class Address implements Cloneable {

	private String addressID;
	private String streat;
	private String city;
	private int zipCode;
	
	
	
	public Address(String addressID, String streat, String city, int zipCode) {
		this.addressID = addressID;
		this.streat = streat;
		this.city = city;
		this.zipCode = zipCode;
	}
	public String getAddressID() {
		return addressID;
	}
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	public String getStreat() {
		return streat;
	}
	public void setStreat(String streat) {
		this.streat = streat;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
