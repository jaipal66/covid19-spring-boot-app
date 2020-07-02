package com.jp.java8.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int array[] = generateRandomArray(500);
		System.out.println("Before sorting : " + Arrays.toString(array));
		long start=System.currentTimeMillis();
		System.out.println("startedAt "+start);
		quickSort(array);
		long end=System.currentTimeMillis();
		System.out.println("endAt "+end +" : "+(end-start));
		System.out.println("After sorting : " + Arrays.toString(array));
	}

	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = new Random().nextInt(size);
		return array;
	}

	public static void quickSort(int intArray[]) {
		quickSort(intArray, 0, intArray.length - 1);
	}

	private static void quickSort(int intArray[], int start, int end) {
		if (start < end) {
			int index = partitions(intArray, start, end);
			quickSort(intArray, start, index - 1);
			quickSort(intArray, index + 1, end);
		}
	}

	private static int partitions(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or equal to the pivot
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		// swap arr[i+1] and arr[high] 
		swap(arr, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] intArray, int first, int second) {
		int temp = intArray[first];
		intArray[first] = intArray[second];
		intArray[second] = temp;
	}
}
