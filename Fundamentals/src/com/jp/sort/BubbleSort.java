package com.jp.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int array[] = { 1, 4, 5, 2, 9, 6, 10, 16, 20, 14 };
		printArray(array);
		Buuble.bubble_sort(array);
		System.out.println(".......After Bubble sort.......");
		printArray(array);

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

class Buuble {

	public static void bubble_sort(int array[]) {

		boolean swaped = false;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j + 1] < array[j]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swaped = true;
				}
			}
			if(!swaped)
				return;

		}
	}
}