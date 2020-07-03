package com.jp.array.test;

import java.util.Arrays;


/**
 * @author Jaipal
 * 
 * segregate 0's and 1's for given array
 * 
 * input : int array[] = { 1, 1, 0, 0, 1, 0, 0, 1, 0, 1 };
 * output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}
 *
 */
public class SegregateZerosAndOnes {

	public static void main(String[] args) {
		int array[] = { 1, 1, 0, 0, 1, 0, 0, 1, 0, 1 };
		System.out.println(Arrays.toString(array));
		segregateZerosAndOnesByCountingWithExtraSpace(array);
		System.out.println(Arrays.toString(array));
	}

	private static void segregateZerosAndOnes(int array[]) {

		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			if (array[start] == 1 && array[end] == 0) {
				swap(array, start, end);
				start++;
				end--;
			} else if (array[start] == 1 && array[end] == 1) {
				end--;
			} else if (array[start] == 0 && array[end] == 0) {
				start++;
			}
		}
	}

	private static void swap(int array[], int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

	private static void segregateZerosAndOnesByCountingWithExtraSpace(int array[]) {
		int cnt = 0;
		int temp[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				cnt++;
			}
		}
		for (int i = cnt; i < array.length; i++) {
			temp[i] = 1;
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = temp[i];
		}

	}

	private static void segregateZerosAndOnesByCounting(int array[]) {
		int cnt = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				cnt++;
			}
		}
		for (int i = 0; i <= cnt; i++) {
			array[i] = 0;
		}
		for (int i = cnt; i < array.length; i++) {
			array[i] = 1;
		}

	}

}
