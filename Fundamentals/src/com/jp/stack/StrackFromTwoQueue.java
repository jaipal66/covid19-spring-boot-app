package com.jp.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StrackFromTwoQueue {

	public static void main(String[] args) {
	  push(10);
	  push(20);
	  push(30);
	  System.out.println(pop());
	  
		
		
	}

	private static Queue<Integer> primary = new LinkedList<>();
	private static Queue<Integer> secondary = new LinkedList<>();

	public static void push(int number) {
		secondary.add(number);
		while (!primary.isEmpty())
			secondary.add(primary.remove());

		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;
	}

	public static int pop() {
		if (primary.isEmpty())
			throw new NullPointerException();
		return primary.remove();
	}

}
