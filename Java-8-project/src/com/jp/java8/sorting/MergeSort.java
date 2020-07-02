package com.jp.java8.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int array[] = generateRandomArray(100);
		System.out.println("Before sorting : " + Arrays.toString(array));
		long start = System.currentTimeMillis();
		System.out.println("startedAt " + start);
		mergeSort(array);
		long end = System.currentTimeMillis();
		System.out.println("endAt " + end + " : " + (end - start));
		System.out.println("After sorting : " + Arrays.toString(array));
	}

	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = new Random().nextInt(size);
		return array;
	}

	public static void mergeSort(int array[]) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int array[], int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, mid, end);
		}
	}

	private static void merge(int array[], int start, int mid, int end) {
		int copy[] = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				copy[k] = array[i++];
			} else
				copy[k] = array[j++];
			k++;
		}
		while (j <= end) {
			copy[k] = array[j];
			k++;
			j++;
		}
		while (i <= mid) {
			copy[k] = array[i];
			k++;
			i++;
		}
		for(int c = start; c <= end; c += 1) {
			array[c] = copy[c - start];
		}
	}
}
