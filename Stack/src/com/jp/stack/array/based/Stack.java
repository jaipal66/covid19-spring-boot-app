package com.jp.stack.array.based;

import java.util.Arrays;

public class Stack<E> {

	private Object[] stackData = null;
	private int top = -1;
	private static final int STACK_SIZE = 10;
	private int size = 0;

	public Stack() {
		stackData = new Object[STACK_SIZE];
	}

	public Stack(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("initialCapacity can't be " + initialCapacity);
		stackData = new Object[initialCapacity];
	}

	public void push(E data) {
		checkCapacity(size + 1);
		stackData[++top] = data;
		size++;
	}

	private void checkCapacity(int newCapacity) {
		int oldCapacity = stackData.length;
		if (oldCapacity - newCapacity < 0) {
			newCapacity = oldCapacity + oldCapacity <<1;
			stackData = Arrays.copyOf(stackData, newCapacity);
		}

	}

	public E pop() {
		E e = (E) stackData[top--];
		size--;
		return e;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return stackData.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.capacity());
	}
}
