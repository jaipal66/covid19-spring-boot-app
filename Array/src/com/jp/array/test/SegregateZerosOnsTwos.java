package com.jp.array.test;

import java.util.Arrays;


/**
 * @author Jaipal
 * 
 * segregate 0's 1's and 2's for given input array
 * 
 * input: int array[]= {0,1,0,1,1,0,2,1,0,1,2,0,2,0,2,1};
 * 
 * output : {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2}
 * 
 * 
 *
 */
public class SegregateZerosOnsTwos {

	public static void main(String[] args) {

		int array[]= {0,1,0,1,1,0,2,1,0,1,2,0,2,0,2,1};
		System.out.println(Arrays.toString(array));
		segregateZerosOnsTwos(array);
		System.out.println(Arrays.toString(array));
		
	}

	public static void segregateZerosOnsTwos(int array[]) {
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while (mid < high) {
			switch (array[mid]) {
			case 0:
				swap(array, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(array, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int array[], int first, int second) {
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
