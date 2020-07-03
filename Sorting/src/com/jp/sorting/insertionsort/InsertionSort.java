package com.jp.sorting.insertionsort;

import java.util.Arrays;

/*
 * Time Complexity : 
 * 
 * Best case O(n) : when array is already sorted.
 * Worst Case O(n2) : When array is given in descending order and we have to sort it in ascending order
 * 
 * The given array is divided into two parts sorted and unsorted array then 
 * take first value from unsorted array find the correct position in 
 * sorted array then placed it in sorted array
 *  e.g 
 *                      0  | 1  2  3  4  5  6   7     N=8
 *                     ------------------------------
 *                     | 17| 3| 8| 19|11| 6| 7| 10 |
 *                     ------------------------------
 *     <--sorted array --> |<-- Unsorted Array -->
 *                          
 *                     j>=0  i=1 to N-1 and j=i-1, temp=array[i]
 * */
public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 17, 3, 8, 19, 11, 6, 7, 10 };
		System.out.println(Arrays.toString(array));
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void insertionSort(int array[]) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
}
