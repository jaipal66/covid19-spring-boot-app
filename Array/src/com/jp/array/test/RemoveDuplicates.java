package com.jp.array.test;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Integer array[] = { 1, 3, 4, 5, 5, 6, 4, 8 };
		removeDuplicates(array);
	}

	public static Integer[] removeDuplicates(Integer array[]) {
		if (array==null || array.length <= 0)
			return array;
		Set<Integer> unquieElements = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			unquieElements.add(array[i]);
		}
		System.out.println(unquieElements);
		return unquieElements.toArray(new Integer[unquieElements.size()]);
	}

	private static int removeDuplicatesWithoutExtraSpace(int arr[]) {
		if (arr.length == 0 || arr.length == 1)
			return arr.length;
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] != arr[i + 1])
				arr[j++] = arr[i];
		arr[j++] = arr[arr.length - 1];
		return j;
	}
}
