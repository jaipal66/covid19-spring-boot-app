package com.jp.stack;

public class A_Stack {

	public static void main(String[] args) {

		Stack stack=new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(40);
		stack.push(30);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
	}
}

class Stack {

	private int top = -1;
	private int[] array;
	private int capacity;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	Stack() {
		this.capacity = DEFAULT_CAPACITY;
		this.array = new int[capacity];
	}

	Stack(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
	}

	public int size() {
		return size;
	}
	public boolean isFull() {
		return this.size == capacity;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int push(int data) {
		if (isFull())
			throw new IllegalArgumentException("Stack is Full");
		array[++top] = data;
		size++;
		return data;
	}

	public int pop() {
		if (isEmpty())
			throw new IllegalArgumentException("Stack is Empty");
		int data = array[top--];
		size--;
		return data;
	}

	public int peek() {
		return array[top];
	}
	
	@Override
	public String toString() {
		String result="[";
		for(int i=0;i<size;i++)
			result+=array[i]+",";
		result+="]";
		return result;
	}
}