package com.jp.serialization;

public class Person {

	private int pID;
	private String qualification;

	
	public Person() {
		System.out.println("DC Person");
	}
	public Person(int pID, String qual) {
		this.pID = pID;
		this.qualification = qual;
	}
}
