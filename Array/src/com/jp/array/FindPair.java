package com.jp.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Jaipal
 * 
 * for given input array find the pair of element whose sum is same as given key
 * 
 * input: int array[] = { 2, 3, 1, 8, 5, 9, 4, 10, 7 } and for key : 13
 * output :
 *        (5,8) (4,9) and (10,3)
 *
 */
public class FindPair {

	public static void main(String[] args) {
		int array[] = { 2, 3, 1, 8, 5, 9, 4, 10, 7 };
		findPairsUsingSet(array, 13);
	}

	private static void findPairsUsingSet(int array[], int key) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			int second = key - array[i];
			if (set.contains(second)) {
				System.out.println("pair is : (" + array[i] + "," + second + ")");
			} else
				set.add(array[i]);
		}
	}

	private static void findPairs(int array[], int sum) {
		int low = 0;
		int high = array.length - 1;
		Arrays.sort(array);
		while (low < high) {
			if (array[low] + array[high] == sum) {
				System.out.println("pair is : (" + array[low] + "," + array[high] + ")");
				low++;
				high--;
			} else if (array[low] + array[high] > sum) {
				high--;
			} else if (array[low] + array[high] < sum) {
				low++;
			}
		}
	}
}
