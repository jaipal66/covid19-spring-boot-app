package com.jp.string.interview.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Client {

	public static void main(String[] args) {

		System.out.println(isUniqueCharacter("cat"));
		System.out.println(reverse("cat"));
		System.out.println(reverseByLoop("cat"));
		System.out.println(": " + "t".substring(1));
		System.out.println(isAnagram("cat", "acc"));
		System.out.println("compress: " + compress("aaabbbcddd"));
		System.out.println("Duplicate Words and count : " + duplicateWords("super man spider man bat man"));
		System.out.println(printDuplicateChar("java is platform independent"));
		System.out.println(removeWhiteSpace("  jai pal "));

		System.out.println(sortInAscending("jaipal kumar"));

		System.out.println(" : " + findFirstNonRepeatingChar("java"));
	}

	/*
	 * 1.How to determine a String has all unique character e.g i/p o/p cat true dog
	 * true pen true book false java false
	 * 
	 * 
	 */
	public static boolean isUniqueCharacter(String string) {
		Map<Character, Integer> map = new HashMap<>();
		for (Character ch : string.toCharArray()) {
			if (map.containsKey(ch)) {
				return false;
			} else
				map.put(ch, 1);
		}
		return true;
	}

	/*
	 * 2. How to reverse a String with loop and recurssion
	 * 
	 *
	 *
	 */
	public static String reverse(String string) {
		if (string.isEmpty())
			return string;
		return reverse(string.substring(1)) + string.charAt(0);
	}

	public static String reverseByLoop(String string) {
		StringBuilder sb = new StringBuilder();
		for (int i = string.length() - 1; i >= 0; i--) {
			sb.append(string.charAt(i));
		}
		return sb.toString();
	}

	/*
	 * 3. Write a program to check two Strings are anagram or not e.g i/p cat and
	 * tac true jar and raj true dog and got false
	 *
	 *
	 */
	public static boolean isAnagram(String one, String second) {
		if (one == null && second == null)
			return true;
		else if (one.isEmpty() && second.isEmpty())
			return true;
		else if (one.length() != second.length())
			return false;
		else if (one.length() == second.length()) {
			for (char ch : one.toCharArray()) {
				if (second.indexOf(ch) == -1) {
					return false;
				}
			}
		}

		return true;
	}

	/*
	 * 4. Write a program to compress a String e.g aabbcddee a2b2c1d2e2
	 *
	 */
	public static String compress(String string) {
		String result = "";
		int count = 1;
		for (int i = 0; i < string.length() - 1; i++) {
			if (string.charAt(i) == string.charAt(i + 1))
				count++;
			else {
				result = result + string.charAt(i) + count;
				count = 1;
			}
		}
		result = result + string.charAt(string.length() - 1) + count;
		return result.length() < string.length() ? result : string;
	}
	/*
	 * 5. Write a program to find the duplicate words and their number of occurrence
	 * 
	 * e.g i/p : spider man bat man super man o/p man-3
	 *
	 *
	 */

	public static String duplicateWords(String string) {
		Map<String, Integer> wordMap = new HashMap<>();
		String[] words = string.split(" ");
		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}

		Map.Entry<String, Integer> maxEntry = null;
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			if (maxEntry != null && entry.getValue() > maxEntry.getValue()) {
				maxEntry = entry;
			} else if (maxEntry == null)
				maxEntry = entry;
		}
		return maxEntry.getKey() + " : " + maxEntry.getValue();
	}

	/*
	 * 6. Write a program to print duplicate character in all the String
	 * 
	 * e.g java is platform independent a n e d
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static Set<Character> printDuplicateChar(String string) {
		// Map<Character, Integer> charMap = new HashMap<>();
		Set<Character> set = new HashSet<>();
		Set<Character> set1 = new HashSet<>();
		for (Character ch : string.toCharArray()) {
			if (set.contains(ch)) {
				set1.add(ch);
			} else {
				set.add(ch);
			}
		}
		return set1;
	}
	/*
	 * 7. Write a program to remove all the white space
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static String removeWhiteSpace(String string) {
		String result = "";
		for (int i = 0; i < string.length() - 1; i++) {
			if (string.charAt(i) != ' ')
				result += string.charAt(i);
		}
		return result;
	}

	/*
	 * 8. Sort String
	 *
	 *
	 *
	 *
	 */

	public static String sortInAscending(String string) {

		Comparator<Character> sortByAsc = new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}

		};
		// Set<Character> set = new TreeSet<Character>(sortByAsc);
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < string.length() - 1; i++) {
			list.add(string.charAt(i));
		}
		Collections.sort(list, sortByAsc);
		String result = "";
		for (Character character : list) {
			result += character;
		}
		return result;
	}

	/*
	 * .9. Find first non-repeating char in string e.g java --> j
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static char findFirstNonRepeatingChar(String string) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < string.length() - 1; i++) {
			if (map.containsKey(string.charAt(i))) {
				map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
			} else {
				map.put(string.charAt(i), 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return ' ';
	}
}
