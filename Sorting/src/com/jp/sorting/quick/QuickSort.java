package com.jp.sorting.quick;

import java.util.Arrays;

/**
 * @author kumajaip
 * 
 *         Steps: 1.partition the given array based on pivot element pivot can
 *         be first, last , middle or any random index; 2.based on partition
 *         index divide the array into two parts element less than partition put
 *         left side and greater value put on right side of pivot
 * 
 *         Time Complexity : 1.Worst case : O(n^2) when we peek smallest or
 *         largest element as pivot 2.Average case : O(nLogn) 3.Best case :
 *         O(nLogn) when we peek middle element as pivot
 * 
 *         why quickSort is preferred over mergeSort for sorting an array?
 * 
 *         quickSort in general forms is an in place sorting(it doesn't require
 *         extra space for sorting) but mergeSort need extra space O(n) to merge
 *         the result.
 * 
 *         Why MergeSort is preferred over QuickSort for Linked Lists?
 * 
 *         MergeSort can be performed on linkedList without using any extra
 *         space. bcz in LinkedList insertion takes constant time constant
 *         memory.
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int array[]) {
		quickSort(array, 0, array.length - 1);
	}

	static void quickSort(int intArray[], int low, int high) {
		if (low < high) {
			int partitionIndex = partitions(intArray, low, high);
			quickSort(intArray, low, partitionIndex - 1);
			quickSort(intArray, partitionIndex + 1, high);
		}
	}

	public static int partitions(int intArray[], int low, int high) {
		int pivot = intArray[low];
		int start = low;
		int end = high;
		while (start < end) {
			while (intArray[start] <= pivot && start < end)
				start++;
			swap(intArray, start, end);
			while (intArray[end] > pivot && start < end)
				end--;
			swap(intArray, start, end);
		}
		swap(intArray, low, end);
		return end;
	}

	static void swap(int intArray[], int first, int second) {
		int temp = intArray[first];
		intArray[first] = intArray[second];
		intArray[second] = temp;
	}
}
