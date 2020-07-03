package com.jp.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int array[] = { 1, 4, 5, 2, 9, 6, 10, 16, 20, 14 };
		printArray(array);
		Selection.selection_sort(array);
		System.out.println(".......After Selection sort.......");
		printArray(array);

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
class Selection{
	
	public static void selection_sort(int array[]) {
		
		
		
	}
}