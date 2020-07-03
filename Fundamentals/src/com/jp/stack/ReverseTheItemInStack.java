package com.jp.stack;

import java.util.Stack;

public class ReverseTheItemInStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(1);
		stack.push(14);
		stack.push(5);
		stack.push(30);
		System.out.println(stack);
		Stack<Integer> tem = reverse(stack);
		System.out.println(tem);
	}

	public static Stack<Integer> reverse(Stack<Integer> stack) {
		if (stack.isEmpty())
			return stack;

		int temp = stack.pop();
		reverse(stack);
		insertAtBottom(stack, temp);
		return stack;
	}

	private static void insertAtBottom(Stack<Integer> stack, int temp) {
		if (stack.isEmpty()) {
			stack.push(temp);
			return;
		}
		int tp = stack.pop();
		insertAtBottom(stack, temp);
		stack.push(tp);
	}

}
