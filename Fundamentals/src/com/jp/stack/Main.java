package com.jp.stack;

public class Main {

	public static void main(String[] args) {
             
		StackUsingLinkedList stack=new StackUsingLinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printStackData();
		stack.pop();
		System.out.println();
		stack.printStackData();
		stack.push(5);
		System.out.println();
		stack.printStackData();
	}
	
}
