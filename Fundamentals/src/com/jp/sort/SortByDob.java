package com.jp.sort;

import java.util.Comparator;

public class SortByDob implements Comparator<Student> {

	@Override
	public int compare(Student first, Student second) {
		return first.dob.compareTo(second.dob);
	}

}
