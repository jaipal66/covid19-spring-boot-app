package com.jp.oops;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentResult {

	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();
		Student jaipal = new Student();
		jaipal.setStudentID(101);
		Test first = new Test();
		first.setTestID(1);
		first.setTestDate(new Date());
		first.setScore(99);
		first.setName("java");
		Test second = new Test();
		second.setTestID(2);
		second.setTestDate(new Date());
		second.setScore(89);
		second.setName("Spring");
		jaipal.takeTest(first);
		jaipal.takeTest(second);
		students.add(jaipal);
		printStudentDetails(students);
	}

	public static void printStudentDetails(List<Student> students) {
		for (Student student : students) {
			System.out.println(
					"StudentID : " + student.getStudentID() + " Averagre Score is : " + student.averageScore());
		}

	}
}
