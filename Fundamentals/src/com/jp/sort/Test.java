package com.jp.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<String> strings = new ArrayList();
		strings.add("10");
		strings.add("14");
		strings.add("16");

		Comparator<String> STR = new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				return second.compareTo(first);
			}
		};

		String result="";
        Collections.sort(strings,STR);
        for (String string : strings) {
        	result+=string;
		}
        System.out.println(result);
	}

	private static void mergeSort(int[] input, int start, int end) {

		// break problem into smaller structurally identical problems
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(input, start, mid);
			mergeSort(input, mid + 1, end);
		}

		// merge solved pieces to get solution to original problem
		int i = 0, first = start, last = mid + 1;
		int[] tmp = new int[end - start + 1];

		while (first <= mid && last <= end) {
			tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
		}
		while (first <= mid) {
			tmp[i++] = input[first++];
		}
		while (last <= end) {
			tmp[i++] = input[last++];
		}
		i = 0;
		while (start <= end) {
			input[start++] = tmp[i++];
		}
	}
}
