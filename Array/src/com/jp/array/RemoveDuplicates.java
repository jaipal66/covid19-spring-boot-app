package com.jp.array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int array[] = { 1, 3, 4, 5, 5, 6, 4, 8 };
		removeDuplicates(array);
	}

	public static Integer[] removeDuplicates(int array[]) {
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

	@Test
	public void testArrayWithDuplicates() {
		int array[] = { 1, 3, 4, 5, 5, 6, 4, 8 };
		Integer[] actuals = RemoveDuplicates.removeDuplicates(array);
		Integer[] expecteds = { 1, 3, 4, 5, 8 ,9};
		assertArrayEquals(expecteds, actuals);
	}
}
