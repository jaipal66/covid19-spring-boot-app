package com.jp.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String");
		String string = scanner.nextLine();

		Set<String> words = findAllPermutation(string);
		System.out.println(words);
		scanner.close();

	}

	public static Set<String> findAllPermutation(String string) {
		Set<String> set = new HashSet<>();
		if (string == null)
			return null;
		if (string.length() == 0) {
			set.add("");
			return set;
		}
		char firstChar = string.charAt(0);
		String remianingChars = string.substring(1);
		Set<String> words = findAllPermutation(remianingChars);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				set.add(makeString(word, firstChar, i));
			}
		}
		return set;

	}

	private static String makeString(String word, char ch, int index) {
		String first = word.substring(0, index);
		String last = word.substring(index);
		return first + ch + last;
	}
}
