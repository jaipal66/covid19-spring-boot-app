package com.jp.system.design.logistics;

public class Address {

	private int addressId;
	private String streat;
	private String state;
	private int zipCode;
	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the streat
	 */
	public String getStreat() {
		return streat;
	}
	/**
	 * @param streat the streat to set
	 */
	public void setStreat(String streat) {
		this.streat = streat;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}	
}
