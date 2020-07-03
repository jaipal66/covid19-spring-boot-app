package com.jp.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {

		int[] array = { 13, 4, 34, 7, 8, 12, 11, 23 };
		System.out.println(mergeSort(array));

		Set<Book> sets = new TreeSet(new BookPriceComparator());
		List<Book> li=new ArrayList();
		Collections.sort(li,new BookPriceComparator());
		addBook(sets, new Book(1, "Java", 120));
		addBook(sets, new Book(2, "Java Advance", 140));
		addBook(sets, new Book(1, "Java", 120));

		System.out.println(sets);

		List<String> list = new ArrayList();
		list.add("Java");
		list.add("is");
		list.add("cool");

		String message = String.join("*", list);
		System.out.println(message);

	}

	static class BookPriceComparator implements Comparator<Book> {
		@Override
		public int compare(Book first, Book second) {

			return (int) (second.getPrice() - first.getPrice());
		}
	}

	public static void addBook(Set<Book> sets, Book book) {
		if (sets.contains(book)) {
			System.out.println("Duplicate entry : " + book);
		} else {
			sets.add(book);
		}
	}

	public static List mergeSort(int[] array) {

		if (array.length < 2)
			return new ArrayList();
		int array1[] = new int[array.length / 2];
		int array2[] = new int[array.length / 2];
		System.arraycopy(array, 0, array1, 0, array.length / 2);
		System.arraycopy(array, array.length / 2, array2, 0, array.length / 2);
		mergeSort(array1);
		mergeSort(array2);
		return merge(array1, array2);
	}

	private static List merge(int[] array1, int[] array2) {
		List list = new ArrayList(array1.length + array2.length);
		int first = 0;
		int second = 0;
		while (first < array1.length && second < array2.length) {
			if (array1[first] <= array2[second]) {
				list.add(array1[first]);
				first++;

			} else {
				list.add(array2[second]);
				second++;
			}
		}
		while (first < array1.length) {
			list.add(array1[first]);
			first++;
		}
		while (second < array2.length) {
			list.add(array2[second]);
			second++;
		}
		return list;
	}

	static int decimal(int number) {
		int decimal = 0;
		int base = 1;
		int temp = number;
		while (temp > 0) {
			int mod = temp % 10;
			temp = temp / 10;
			decimal += mod * base;
			base = base * 2;
		}
		return decimal;

	}

	static int binary(int number) {
		int binary = 0;
		int base = 1;
		int temp = number;
		while (temp > 0) {
			int mod = temp % 2;
			temp = temp / 2;
			binary += mod * base;
			base = base * 10;
		}
		return binary;
	}

	public static void secondLargest(int[] array) {

		int largest = array[0];
		int secondLargest = array[0];
		for (int i = 1; i < array.length; i++) {
			if (largest <= array[i]) {
				secondLargest = largest;
				largest = array[i];
			}
		}
		System.out.println("secondLargest : " + secondLargest);
	}

	public static void LargestAndSmallest(int[] array) {
		int largest = array[0];
		int smallest = array[0];
		for (int i = 1; i < array.length; i++) {
			if (largest <= array[i]) {
				largest = array[i];
			} else if (smallest > array[i]) {
				smallest = array[i];
			}
		}
		System.out.println("Largest : " + largest + " and smallest : " + smallest);
	}
}

class Book implements Comparable<Book> {

	Book(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	private int id;
	private String name;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object instanceof Book) {
			Book book = (Book) object;
			if ((this.id != book.id) || (this.name != book.name))
				return false;
		}
		return true;
	}

	public int hashCode() {
		int hash = 0;
		hash = hash + 31 * hash + this.id;
		hash = hash + 31 * hash + this.name.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return "[ bookId: " + this.id + " , name: " + this.name + " , price: " + this.price + "]";
	}

	@Override
	public int compareTo(Book first) {

		return (int) (first.getPrice() - this.getPrice());
	}
}
