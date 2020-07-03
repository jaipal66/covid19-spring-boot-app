package com.jp.oops;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private int studentID;
	private List<Test> tests=new ArrayList<Test>();

	public void takeTest(Test test) {
		tests.add(test);
	}

	public double averageScore() {
		double average = 0;
		for (Test test : this.tests) {
			average += test.getScore();
		}
		return average/this.tests.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

}
