package com.jp.array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		int array[] = { 2, 7, 8, 3, 5, 1 };

		int sum = 10;

		// 1,2,3,5,7,8

		// 8
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			int secondValue = sum - array[i];
			if (set.contains(secondValue)) {
				System.out.println("pair is " + secondValue + "," + array[i]);
			} else
				set.add(array[i]);

		}

	}
}
