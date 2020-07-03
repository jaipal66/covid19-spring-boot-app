package com.jp.sort;

public class HeapSort {

	public static void main(String[] args) {

		int array[] = { 1, 4, 5, 2, 9, 6, 10, 16, 20, 14 };
		printArray(array);
		Heap.heap_sort(array);
		System.out.println();
		printArray(array);
		
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}

class Heap {

	public static void heap_sort(int array[]) {

		int length = array.length-1;

		for (int i = length / 2 ; i >= 0; i--) {
			heapify(array, length, i);
		}
		
		for (int i = length; i >= 0; i--) {

			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			heapify(array, i, 0);
		}
	}

	private static void heapify(int[] array, int length, int index) {
		int max = index;

		/*
		 * In binary tree if root is at index i then left child will be at 2*i+1 and
		 * right child will be at 2*i+2
		 */
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		/*
		 * if left child is greater then root
		 */
		if (left < length && array[max] < array[left]) {
			max = left;

		}
		/*
		 * if right child is greater then root
		 */
		if (right < length && array[max] < array[right]) {
			max = right;
		}

		if (max != index) {
			int temp = array[index];
			array[index] = array[max];
			array[max] = temp;

			heapify(array, length, max);
		}

	}
}
