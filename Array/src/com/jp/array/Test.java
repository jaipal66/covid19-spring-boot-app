package com.jp.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

	final public static void main(String[] args) {
		
		int array[]= {2,3,4,5};
		System.out.println(findMinDiff(array,4,5));
		
		
		String [] str= {"sdc","sbc","abc","adc","nbm","nmb"};
		
		Map<Object,List<String>> map=Arrays.asList(str).stream()
				.collect(Collectors.groupingBy(s->s.charAt(0)));
         System.out.println(map);
	}

	static int findMinDiff(int arr[], int n, int m) {
		// if there are no chocolates or
		// number of students is 0
		if (m == 0 || n == 0)
			return 0;

		// Sort the given packets
		Arrays.sort(arr);

		// Number of students cannot be
		// more than number of packets
		if (n < m)
			return -1;

		// Largest number of chocolates
		int min_diff = Integer.MAX_VALUE;

		// Find the subarray of size m
		// such that difference between
		// last (maximum in case of
		// sorted) and first (minimum in
		// case of sorted) elements of
		// subarray is minimum.

		for (int i = 0; i + m - 1 < n; i++) {
			int diff = arr[i + m - 1] - arr[i];
			if (diff < min_diff)
				min_diff = diff;
		}
		return min_diff;
	}

	private static void rotateByKth(int array[], int position) {
		int mod = position % array.length;
		for (int i = 0; i < array.length - position; i++) {
			swap(array, i, (i + mod) % array.length);
		}

	}

	private static void swap(int array[], int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
