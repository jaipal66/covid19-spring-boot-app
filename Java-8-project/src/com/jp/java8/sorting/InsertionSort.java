package com.jp.java8.sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		int array[]=generateRandomArray(500);
		long start=System.currentTimeMillis();
		System.out.println("startedAt "+start/1000);
		System.out.println("Before sorting : "+Arrays.toString(array));
		
		insertionSort(array);
		
		System.out.println("After sorting : "+Arrays.toString(array));
		long end=System.currentTimeMillis();
		System.out.println("endAt "+(end-start));
	}

	private static int[] generateRandomArray(int size) {
		int [] array= new int[size];
		for(int i=0;i<size;i++)
			array[i]=new Random().nextInt(size);
		return array;
	}

	public static void insertionSort(int[] intArray) {
		for (int i = 1; i < intArray.length; i++) {
			int temp = intArray[i];
			int j = i - 1;
			while (j >= 0 && intArray[j] > temp) {
				intArray[j + 1] = intArray[j];
				j--;
			}
			intArray[j + 1] = temp;
		}
	}
}
