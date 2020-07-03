package com.jp.string;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

	public static void main(String[] args) {

		Validator.isValid("aaq11");

		/*
		 * int number = 5;
		 * 
		 * List<Integer> list = new ArrayList<>(); list.add(1); for (int i = 2; i <=
		 * Math.sqrt(number); i++) { if (number % i == 0) { list.add(i); } if (i !=
		 * Math.sqrt(i)) list.add(number / i); } int result = 0; int count = 0; for (int
		 * n : list) { result += n; if (result > number) break; count++;
		 * 
		 * }
		 * 
		 * System.out.println(count);
		 */
	}

	public static void giveName(String[] a) {

		String[] array = { "hacker", "google" };

		TreeSet<Character> s = new TreeSet<>();
		for (char i = 97; i <= 122; i++) {
			s.add(i);
		}
		System.out.println(s);

		Set<Character> set = new TreeSet<>();
		for (String string : array) {
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				set.add(ch);
			}
		}

		System.out.println(set);
		System.out.println(s.removeAll(set));
		System.out.println(s.first());
		System.out.println(set);
	}

	public static void isAlphaNumeric(String string) {
		String regex = "[A-Za-z0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		System.out.println(matcher.matches());

	}

	public static void permutation(String string) {

		permutation(string, 0, string.length() - 1);
	}

	public static void rotateByPosition(int[] array, int position) {

		int mod = position % array.length;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[(i + mod) % array.length] + " ");
		}
	}

	private static void permutation(String string, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			System.out.println(string);
		} else {
			for (int i = 1; i <= end; i++) {
				string = swap(string, start, i);
				permutation(string, start + 1, end);
				string = swap(string, start, i);
			}
		}
	}

	private static String swap(String string, int start, int end) {
		char ch[] = string.toCharArray();
		char temp = ch[start];
		ch[start] = ch[end];
		ch[end] = temp;
		return new String(ch);
	}

}

class Validator {

	static boolean isValid(String string) {
		boolean isNumeric = true;
		boolean isAlphNumeric = false;
		boolean isString = false;

		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (!Character.isDigit(c)) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {
			System.out.println("Valid Format");
			return isNumeric;
		}
		if (!isNumeric) {
			/*Pattern pattern1 = Pattern.compile("[A-Za-z]*");
			Matcher matcher1 = pattern1.matcher(string);
			isString = matcher1.matches();*/
			isString=string.matches("[A-Za-z]*");
			if (isString) {
				System.out.println("it's String");
				return isString;
			} else if (!isString) {
				Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
				Matcher matcher = pattern.matcher(string);
				isAlphNumeric = matcher.matches();
				if (isAlphNumeric) {
					System.out.println("it's an AlphaNumeric");
					return isAlphNumeric;
				} else {
					throw new AlphaNumericException();
				}
			}
		}
		return isNumeric;

	}

	static boolean isNumeric(String name) {
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	/*
	 * static boolean isValid(String name) { for (int i = 0; i < name.length(); i++)
	 * { char c = name.charAt(i); if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <=
	 * 'z') && !(c >= '0' && c <= '9')) { return false; } } return true; }
	 */
}

class AlphaNumericException extends RuntimeException {
	AlphaNumericException(String message) {
		super(message);
	}

	AlphaNumericException() {
	}
}

class StringException extends RuntimeException {
	StringException(String message) {
		super(message);
	}

	StringException() {
	}
}