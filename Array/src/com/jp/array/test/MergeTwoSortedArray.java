package com.jp.array.test;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int firstArray[] = { 1, 3, 5, 7, 9 };
		int secondArray[] = { 2, 4, 6, 8, 10 };
		int result[] = mergeTwoSortedArray(firstArray, secondArray);
		System.out.println(Arrays.toString(result));
	}

	private static int[] mergeTwoSortedArray(int firstArray[], int secondArray[]) {

		int i = 0;
		int j = 0;
		int k = 0;
		int result[] = new int[firstArray.length + secondArray.length];
		while (i < firstArray.length && j < secondArray.length) {
			if (firstArray[i] < secondArray[j]) {
				result[k] = firstArray[i];
				k++;
				i++;
			} else {
				result[k] = secondArray[j];
				k++;
				j++;
			}
		}
		while (i < firstArray.length) {
			result[k++] = firstArray[i++];
		}
		while (j < secondArray.length) {
			result[k++] = secondArray[j++];
		}
		return result;
	}
}
