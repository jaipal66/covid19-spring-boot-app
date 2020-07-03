
package com.jp.sorting.bubblesort;

import java.util.Arrays;

/*
 * Time Complexity : 
 * Best case O(n): when array is already sorted.
 * Average and Worst case : O(n2)
 * 
 * Adjacent two elements are compared if elements are at correct position then 
 * keep as it else swap the data.
 * 
 * When number of elements is N then total N-1 passes required
 * and in Each pass N-1 comparison needed
 * 
 * Note : As number of passes increasing then number of comparison decreasing in each pass
 *        so we can swapping condition change like N-pass-1
 *        
 *        swapping will only happened if elements are in unsorted order.
 *        i.e when there is no swap then we can say that array is sorted.
 *        for this we can have a flag while swapping;
 * 
 *   in each pass we bubble out max value to the end
 * 
 * */
public class BubbleSort {

	public static void main(String[] args) {

		int[] array = { 17, 3, 8, 19, 11, 6, 7, 10 };
		System.out.println(Arrays.toString(array));
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void bubbleSort(int array[]) {
		int length = array.length-1;
		for (int i = 0; i < length ; i++) {
			boolean flag = false;
			for (int j = 0; j < length  - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
					flag = true;
				}
			}
			if (!flag)
				break;
		}
	}

	private static void swap(int[] array, int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
