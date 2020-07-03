package com.jp.sorting.quick;

import java.util.Arrays;

public class IterativeQuickSort {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int intArray[], int low, int high) {
		int array[] = new int[high - low + 1];
		int top = -1;
		array[++top] = low;
		array[++top] = high;

		while (top >= 0) {
			high = array[top--];
			low = array[top--];
			int pivotIndex = partitions(intArray, low, high);

			if (pivotIndex - 1 > low) {
				array[++top] = low;
				array[++top] = pivotIndex - 1;
			}
			if (pivotIndex + 1 < high) {
				array[++top] = pivotIndex + 1;
				array[++top] = high;
			}
		}
	}

	public static int partitions(int intArray[], int low, int high) {
		int pivot = intArray[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (intArray[j] < pivot) {
				i++;
				swap(intArray, j, i);
			}
		}
		swap(intArray, i + 1, high);
		return i + 1;
	}

	public static void swap(int intArray[], int first, int second) {
		int temp = intArray[first];
		intArray[first] = intArray[second];
		intArray[second] = temp;
	}
}
