package com.jp.sorting.selectionsort;

import java.util.Arrays;

/*
 * Time Complexity : 
 * 
 * Worst case and Best case : O(n2)
 * first consider sorted array have zero element
* divide the given array into two parts sorted and unsorted array
* in unsorted array find the minimum element and swap this minimum element
* with first element of unsorted array.then reduce the size of unsorted array by 1.
* 
* 
*/

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = { 17, 3, 8, 19, 11, 6, 7, 10 };
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void selectionSort(int array[]) {
		for (int i = 0; i < array.length; i++) {
			int minValueIndex = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[minValueIndex])
					minValueIndex = j;
			}
			if (minValueIndex != i)
				swap(array, minValueIndex, i);
		}
	}

	private static void swap(int array[], int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
