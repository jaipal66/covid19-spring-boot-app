package com.jp.datastructure.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Java program to find duplicate in array
 * 
 * input:{1,5,4,1,3,2,4,7}
 * output:{1,4}
 * 
 * 
 * */
public class DuplicateElements {

	public static void main(String[] args) {

		int array[] = { 1, 2, 4, 6, 7, 1, 4, 5 };
		findDuplicates(array);

	}

	private static boolean findDuplicates(int array[]) {
		Set<Integer> uniqueNumbers = new HashSet<>();
		boolean dulicateFound = false;
		for (int i = 0; i < array.length; i++) {
			if (uniqueNumbers.contains(array[i])) {
				dulicateFound = true;
				System.out.println("Duplicate Element : " + array[i]);
			} else {
				uniqueNumbers.add(array[i]);
			}
		}
		return dulicateFound;
	}
}
