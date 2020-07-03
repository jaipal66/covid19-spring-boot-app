package com.jp.sort;

import java.util.Comparator;

public class SortByRollNumber implements Comparator<Student> {

	@Override
	public int compare(Student first, Student second) {
		return first.rollNumber - second.rollNumber;
	}

}
