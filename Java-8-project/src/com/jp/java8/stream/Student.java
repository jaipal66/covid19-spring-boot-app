package com.jp.java8.stream;

public class Student {

	private String name;
	private int age;
	private int id;
	private Gender gender;

	Student(String name, int age, int id, Gender gender) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", id=" + id + ", gender=" + gender + "]";
	}
	
	

}
