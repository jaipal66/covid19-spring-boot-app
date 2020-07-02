package com.jp.java8.sorting;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

	public static void main(String[] args) {
		int array[] = generateRandomArray(10);
		System.out.println("Before sorting : " + Arrays.toString(array));
		long start = System.currentTimeMillis();
		System.out.println("startedAt " + start);
		heapSort(array, array.length);
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

	public static void heapSort(int intArray[], int length) {

		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(intArray, length, i);
		}
		System.out.println("After building Max Heap : "+Arrays.toString(intArray));
		for (int i = length - 1; i >= 0; i--) {
			swap(intArray, i, 0);
			heapify(intArray,i, 0);
		}
	}

	private static void heapify(int intArray[], int length, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		while (left < length && intArray[left] > intArray[largest])
			largest = left;
		while (right < length && intArray[right] > intArray[largest])
			largest = right;
		if (largest != index) {
			swap(intArray, largest, index);
			heapify(intArray, length, largest);
		}

	}

	private static void swap(int[] intArray, int first, int second) {
		int temp = intArray[first];
		intArray[first] = intArray[second];
		intArray[second] = temp;
	}

}
