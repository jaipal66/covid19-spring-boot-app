package com.jp.stack.problems;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
         int array[]= {5,3,2,10,7,15,13};
		findNextGreaterElement(array);
	}

	private static void findNextGreaterElement(int array[]) {
		Stack<Integer> stack = new Stack<>();
		stack.push(array[0]);
		for (int i = 1; i < array.length; i++) {
			if (array[i] < stack.peek()) {
				stack.push(array[i]);
			} else {
				while (!stack.isEmpty()) {
					System.out.println(stack.pop() + "->" + array[i]);
				}
				stack.push(array[i]);
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + "-> -1");
		}
	}
}
