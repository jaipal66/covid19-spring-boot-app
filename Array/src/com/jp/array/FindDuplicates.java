package com.jp.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindDuplicates {

	public static void main(String[] args) {

		int[] array = { 1, 3, 2, 5, 8,5, 4 };
		findDuplicates(array);
		
		
		
	}

	private static void findDuplicates(int array[]) {
		Set<Integer> unqiueElements = new HashSet<>();
		boolean duplicateExit = false;
		for (int i = 0; i < array.length; i++) {
			if (unqiueElements.contains(array[i])) {
				duplicateExit = true;
				System.out.println("Duplicates is : " + array[i]);
			} else {
				unqiueElements.add(array[i]);
			}
		}
		if (!duplicateExit)
			System.out.println("Duplicate does not Exit");
	}
}

