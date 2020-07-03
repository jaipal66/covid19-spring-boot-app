package com.jp.sorting;

import java.util.Arrays;

public class TestSorting {

	public static void main(String[] args) {

		int[] array = { 24, 12, 2, 3, 1, 45, 78 };
		printArray(array);
		bubble_sort(array);
		printArray(array);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void bubble_sort(int array[]) {
		int flag = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i-1; j++) {
				if (array[j + 1] < array[j]) {
					flag = 1;
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
				if (flag == 0)
					return;
			}
		}
	}

	public static void selection_Sort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;

			// int minIndex = minValueIndex(array, i, array.length);

		}
	}

	private static int minValueIndex(int array[], int k, int length) {
		int index = k;
		int minValue = array[k];
		for (int i = k + 1; i < length - 1; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
				index = i;
			}
		}
		return index;
	}

	public static void insertionSort(int[] array) {
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
