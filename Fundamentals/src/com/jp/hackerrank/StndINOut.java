package com.jp.hackerrank;

import java.util.Scanner;

public class StndINOut {

	public static void main(String[] args) {
		String result = sortString("ab", "bc", "ca");
		System.out.println(result);

	}

	public static int maximumSubArray(int[] array) {

		int result = 0;
		int temp = 0;
		int startIndex = 0;
		int endIndex = 0;
		int s = 0;
		for (int i = 0; i < array.length; i++) {
			temp = temp + array[i];
			if (result < temp) {
				result = temp;
				startIndex = s;
				endIndex = i;
			}
			if (temp < 0) {
				temp = 0;
				s = i + 1;
			}
		}
		return result;
	}

	public static void rotateInplace(int[][] array) {

		int length = array.length;
		for (int i = 0; i < length / 2; i++) {
			for (int j = 0; j < length; j++) {
				int temp = array[i][j];
				array[i][j] = array[j][length - 1 - i];
				array[j][length - 1 - i] = array[length - 1 - i][length - 1 - j];
				array[length - 1 - i][length - 1 - j] = array[length - 1 - i][j];
				array[length - 1 - i][j] = temp;
			}
		}
	}

	public static String sortString(String firstString, String secondString, String thirdString) {
		StringBuilder sb = new StringBuilder();

		int first = firstString.compareTo(secondString);
		int second = firstString.compareTo(thirdString);
		int third = secondString.compareTo(thirdString);

		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
		System.out.println("12".compareTo("10") > 0);

		if (firstString.compareTo(secondString) > 0 && firstString.compareTo(thirdString) > 0) {
			sb.append(thirdString);
			sb.append(secondString);
			sb.append(firstString);
		} else if (firstString.compareTo(secondString) > 0 && firstString.compareTo(thirdString) < 0) {
			sb.append(secondString);
			sb.append(firstString);
			sb.append(thirdString);

		} else if (firstString.compareTo(secondString) < 0 && firstString.compareTo(thirdString) < 0) {
			sb.append(thirdString);
			sb.append(secondString);
			sb.append(firstString);
		} else {
			sb.append(firstString);
			sb.append(secondString);
			sb.append(thirdString);
		}

		return sb.toString();

	}
}
