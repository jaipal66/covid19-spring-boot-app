package com.jp.datastructure.array;

import java.util.Arrays;

public class FindPairsWithGivenSum {

	public static void main(String[] args) {
		int array[] = { 1, 4, 7, 3, 6, 5, 12, 23, 22 };
		int sum = 7;
		findPairsWithGivenSum(array, sum);
	}

	private static void findPairsWithGivenSum(int array[], int sum) {

		Arrays.sort(array);
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] + array[high] > sum) {
				high--;
			} else if (array[low] + array[high] < sum) {
				low++;
			} else if (array[low] + array[high] == sum) {
				System.out.println("Pair (" + array[low] + "," + array[high] + ")");
				low++;
				high--;
			}
		}
	}
}
