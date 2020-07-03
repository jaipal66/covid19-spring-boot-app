package com.jp.java8.foreach;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ListToMap {

	public static void main(String[] args) {

		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "mkyong.com", 1));

		System.out.println("Normal for each");
		for (Hosting host : list)
			System.out.println(host);
		
		System.out.println(".........Lamda Expression..........");
		list.forEach(hosting -> System.out.println(hosting));
		
		System.out.println("..........Method Reference..........");
		list.forEach(System.out::println);
		
		System.out.println("........Using stream............");
		list.stream().forEach(System.out::println);

		System.out.println("........List to Map Id as key and name as value............");
		Map<Integer, String> hostingMap = list.stream()
				.collect(Collectors.toMap(Hosting::getId, Hosting::getName));

		hostingMap.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("........List to Map name as key and website as value............");
		Map<String, Long> hostingMap2 = list.stream()
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		hostingMap2.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println(".........to preserve the order..........");
		// Collectors.toMap by default it use HashMap
		Map<String, Long> hostingMap3 = list.stream()
				.collect(Collectors
				.toMap(Hosting::getName, Hosting::getWebsites, 
						(old, value) -> old, LinkedHashMap::new));
		hostingMap3.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("......... with concurrent map..........");
		Map<String, Long> hostingMap4 = list.stream()
				.collect(Collectors
				.toConcurrentMap(Hosting::getName,
				Hosting::getWebsites, (old, value) -> old, ConcurrentHashMap::new));
		hostingMap4.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("........to handle duplicate value............");
		Map<String, Long> hostingMap5 = list.stream()
				.collect(Collectors
						.toMap(Hosting::getName, Hosting::getWebsites,
								(oldvalue, newValue) -> oldvalue));
																														// 																												// consider
		hostingMap5.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

		System.out.println("........sort and collect............");
		Map<String, Long> hostingMap6 = list.stream()
				.sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
				.collect(Collectors
				.toMap(Hosting::getName, Hosting::getWebsites, 
				(oldvalue, newValue) -> oldvalue));
		hostingMap6.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});

	}

}

class Hosting {

	private int Id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWebsites() {
		return websites;
	}

	public void setWebsites(long websites) {
		this.websites = websites;
	}

	@Override
	public String toString() {
		return "Hosting [Id=" + Id + ", name=" + name + ", websites=" + websites + "]";
	}

}
