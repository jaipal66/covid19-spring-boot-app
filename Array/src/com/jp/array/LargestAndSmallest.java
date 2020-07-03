package com.jp.array;

public class LargestAndSmallest {

	public static void main(String[] args) {
		int[] intArray = { 2, 4, 8, 9, 78, 1 };
		findLargestAndSmallest(intArray);
	}

	public static void findLargestAndSmallest(int intArray[]) {

		int smallest = intArray[0];
		int largest = intArray[0];
		for (int i = 1; i < intArray.length; i++) {
			if (largest < intArray[i])
				largest = intArray[i];
			else if (smallest > intArray[i])
				smallest = intArray[i];
		}
		System.out.println("Smallest : " + smallest + " Largest : " + largest);
	}
}
