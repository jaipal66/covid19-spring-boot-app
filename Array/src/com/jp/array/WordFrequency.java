package com.jp.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("Apple", "Apple", "Mango");

		Map<String, List<String>> result = words.parallelStream().sorted().collect(Collectors.groupingBy(word -> word));
		System.out.println(result);
	}
}
