package com.jp.practice;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

public class ArrayTest {

	public static void main(String[] args) {

		Map<Number, String> map = new TreeMap<Number, String>();
		map.put(new Integer(1), "jaipal");
		System.out.println(map);
		
	}

	public static void intersectionOFArray(int array1[], int array2[]) {
		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				i++;
			} else if (array2[j] < array1[i]) {
				j++;
			} else {
				System.out.print(array1[i++] + ",");
				j++;
			}
		}
	}

	public static int findTotalWays(int array[][], int row, int column) {
		int totalWays = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == 0)
					array[i][j] = 1;
				if (j == 0)
					array[i][j] = 1;
			}
		}
		printArray(array);
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array[0].length; j++) {
				array[i][j] = array[i - 1][j] + array[i][j - 1];
				if (i == row && j == column) {
					totalWays = array[i][j];
					break;
				}
			}
		}

		return totalWays;
	}

	public static void printArray(int array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int getStationsCount(double[] arrivals, double[] departs) {

		Arrays.sort(arrivals);
		Arrays.sort(departs);
		int plateformCount = 0;
		int length = arrivals.length;
		int plateformNeededAtATime = 0;
		int i = 0, j = 0;

		while (i < length && j < length) {
			if (arrivals[i] <= departs[j]) {
				plateformNeededAtATime++;
				i++;
				if (plateformCount < plateformNeededAtATime) {
					plateformCount = plateformNeededAtATime;
				}
			} else {
				plateformNeededAtATime--;
				j++;
			}
		}
		return plateformCount;

	}

	public static void removeDuplicates(int array[]) {

	}

	public static void printMissingNumber(int[] array, int length) {
		int missingCount = length - array.length;
		BitSet bitSet = new BitSet(length);
		for (int number : array) {
			bitSet.set(number - 1);
		}
		System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(array),
				length);
		int lastMissingIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);

			System.out.println(++lastMissingIndex);
		}

	}
}
