package com.jp.java8.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterCollect {

	public static void main(String[] args) {

		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		System.out.println("Noraml for each");
		for (String temp : lines) {
			if (!temp.equals("node"))
				System.out.println(temp);
		}

		System.out.println("with stream,filter and collect as list");
		List<String> list = lines.stream()
				.filter(line -> !"node".equals(line))
				.collect(Collectors.toList());
		list.forEach(System.out::println);

		System.out.println("with stream ,filter and findAny");
		String string = lines.stream().filter(line -> "ass".equals(line)).findAny().orElse(null);
		System.out.println(string);

		System.out.println("with stream , map and collect");
		List<String> list2 = lines.stream().map(String::toUpperCase).collect(Collectors.toList());
		list2.forEach(System.out::println);
		

	}
}
