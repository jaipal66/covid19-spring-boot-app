package com.jp.array;

public class MaxElementInEachRow {

	public static void main(String[] args) {
		int matrix[][]= {{1,4,8,2},{9,45,22,43},{12,22,45,98},{11,88,55,34}};
		findMaxElementFromEachRow(matrix);
	}

	public static void findMaxElementFromEachRow(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			int maxElement = matrix[i][0];
			for (int j = 0; j < matrix[i].length; j++) {
				if (maxElement < matrix[i][j]) {
					maxElement = matrix[i][j];
				}
			}
			System.out.println("Max Element at row " + i + " is " + maxElement);
		}
	}
}
