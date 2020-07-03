package com.jp.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int array[] = { 1, 4, 5, 2, 9, 6, 10, 16, 20, 14 };
		printArray(array);
		Insertion.insertion_sort(array);
		System.out.println(".......After Insertion sort.......");
		printArray(array);

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

class Insertion {

	public static void insertion_sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int temp = array[i];
			while (j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
}