package com.jp.datastructure.array;

public class ContigeousSubArray {

	public static void main(String[] args) {
		int array[] = { 1, 2, -7, 4, 2, -1, 6, 8 };
		int max = findContigeousSubArray(array);
		System.out.println(max);
	}

	private static int findContigeousSubArray(int array[]) {

		int max = 0;
		int maxAt = 0;
		int startIndex = 0;
		int endIndex = 0;
		int s=0;
		for (int i = 0; i < array.length; i++) {
			maxAt = maxAt + array[i];
			if (maxAt < 0) {
				maxAt = 0;
				s =  i+1;
			} else if (max < maxAt) {
				max = maxAt;
				startIndex=s;
				endIndex = i;
			}
		}
		System.out.println("Start index is "+startIndex+" and end index is "+endIndex);
		System.out.println("Max sum is "+max);
		return max;
	}
}
