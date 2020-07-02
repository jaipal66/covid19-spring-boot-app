package com.jp.java8.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		int array[]=generateRandomArray(10);
		System.out.println("Before sorting : "+Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After sorting : "+Arrays.toString(array));
	}

	private static int[] generateRandomArray(int size) {
		int [] array= new int[size];
		for(int i=0;i<size;i++)
			array[i]=new Random().nextInt(size);
		return array;
	}
	public static  void bubbleSort(int intArray[]) {
		int length = intArray.length-1;
		for (int i = 0; i < length; i++) {
			boolean isWapped = false;
			for (int j = 0; j < length - i; j++) {
				if (intArray[j] > intArray[j + 1]) {
					swap(intArray, j, j + 1);
					isWapped = true;
				}
			}
			if (!isWapped)
				break;
		}
	}

	private static void swap(int[] intArray, int first, int second) {
		int temp = intArray[first];
		intArray[first] = intArray[second];
		intArray[second] = temp;
	}
}
