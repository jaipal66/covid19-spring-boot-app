package com.jp.java8.searching;

import java.util.Arrays;
import java.util.Random;

public class LinearSerch {

	public static void main(String[] args) {
		int array[] = generateRandomArray(20);
		System.out.println("Array is :" + Arrays.toString(array));
		long start = System.currentTimeMillis();
		System.out.println("startedAt " + start);
		int index =linearSearch(array,7);
		long end = System.currentTimeMillis();
		System.out.println("endAt " + end + " : " + (end - start));
		System.out.println("Index is : "+index);
	}

	private static int[] generateRandomArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = new Random().nextInt(size);
		return array;
	}


	private static int linearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}
}
