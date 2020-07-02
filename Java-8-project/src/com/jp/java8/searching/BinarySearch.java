package com.jp.java8.searching;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {
		int array[] = generateRandomArray(10);
		System.out.println("Array is : " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Array is : " + Arrays.toString(array));
		int index = binarySearchWithLoop(array, 7);
		System.out.println("Index : " + index);
	}

	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = new Random().nextInt(size);
		return array;
	}

	private static int binarySearch(int[] intArray, int target) {
		return binarySearch(intArray, 0, intArray.length - 1, target);
	}

	private static int binarySearch(int[] intArray, int start, int end, int target) {
		if (start < end) {
			int mid = (start + end) / 2;
			if (intArray[mid] == target) {
				return mid;
			} else if (target < intArray[mid]) {
				binarySearch(intArray, start, mid - 1, target);
			} else {
				binarySearch(intArray, mid + 1, end, target);
			}
		}
		return -1;
	}

	private static int binarySearchWithLoop(int[] array, int target) {

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == array[mid]) {
				return mid;
			} else if (target < array[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
