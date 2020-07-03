package com.jp.stack;

public class StackUsingLinkedList {

	private Node top;
	private int size;

	public void printStackData() {
		Node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public int push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
		return data;
	}

	public int pop() {
		Node temp = top;
		top = temp.next;
		int x = temp.data;
		return x;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
