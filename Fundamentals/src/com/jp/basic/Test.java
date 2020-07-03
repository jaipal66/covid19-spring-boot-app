package com.jp.basic;

public class Test {

	public static void main(String[] args) {

		for(int value:fibByDp(25)) {
			System.out.println(value);
		}
	}

	public static int fibonaciByLoop(int n) {

		int firstNumber = 0;
		int secondNumber = 1;
		for (int i = 2; i <= n; i++) {
			int sum = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = sum;
		}

		return firstNumber;
	}

	public static int fibByRecursion(int n) {
		if (n <= 1) {
			return n;
		}
		return fibByRecursion(n - 1) + fibByRecursion(n - 2);
	}

	public static int[] fibByDp(int n) {
		int[] array = new int[n + 1];
		array[0] = 0;
		if (n > 1) {
			array[1] = 1;
			for (int i = 2; i <= n; i++) {
				array[i] = array[i - 1] + array[i - 2];
			}
		}
		return array;
	}
}
