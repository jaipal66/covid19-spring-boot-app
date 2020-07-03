package com.jp.stack;

import java.util.Stack;

public class SortElementInStack {

	public static void main(String[] args) {

		Stack<Integer> stack=new Stack<>();
		stack.push(10);
		stack.push(1);
		stack.push(14);
		stack.push(5);
		stack.push(30);
		System.out.println(stack);
		Stack<Integer> tem=sortStack(stack);
		System.out.println(tem);
		
	}

	public static Stack<Integer> sortStack(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty())
			return stack;
		Stack<Integer> newStack = new Stack<>();
		newStack.push(stack.pop());
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!newStack.isEmpty() && temp > newStack.peek()) {
				stack.push(newStack.pop());
			}
			newStack.push(temp);
		}
		return newStack;
	}
}
