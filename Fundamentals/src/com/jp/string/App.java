package com.jp.string;

public class App {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abba"));
		//abd("adbgcfbea");
		printZigZag(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
	}

	public static void printZigZag(int array[][]) {
		int rows = array.length;
		int columns = array[0].length;
        
		for (int k = 0; k < rows; k++) {
			int i = k;
			int j = 0;
			while (i >= 0) {
				System.out.print(array[i--][j++]+" ");
			}
			System.out.println();
		}

		for (int k = 0; k < columns; k++) {
			int i = rows - 1;
			int j = k;
			while (j <columns) {
				System.out.print(array[i--][j++]+" ");
			}
			System.out.println();
		}
	}

	/*
	 * O(n2) take 2 D array of rows and column as length of string make all the
	 * diagonal as 1 bcz same char is palindrome of itself make all cell as 0 of
	 * below diagonal we don't want in reverse order for each cell above diagonal
	 * if(s[i]==s[j]){ array[i][j]==2+array[i+1][j-1] }else{
	 * array[i][j]=max(array[i+1][j],array[i][j-1])
	 * 
	 * 
	 */

	public static String abd(String string) {
		if (string == null || string.length() == 0)
			return "";
		int length = string.length() - 1;
		int array[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j)
					array[i][j] = 1;
				if (string.charAt(i) == string.charAt(j)) {
					array[i][j] = 2 + array[i + 1][j - 1];
				} else {
					array[i][j] = Math.max(array[i + 1][j], array[i][j - 1]);
				}
			}
		}
		print2D(array);
		return null;
	}

	public static void print2D(int array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - ((len - 1) / 2);
				end = i + (len / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	public static int expandFromMiddle(String s, int left, int right) {
		if (s == null || left > right) {
			return 0;
		}
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
