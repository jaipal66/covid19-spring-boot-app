package com.jp.stack.linkedlist.based;

public class Stack<E> {

	private Node<E> head;

	public void push(E data) {
		Node<E> temp = head;
		Node<E> node = new Node<>(data);
		if (temp == null)
			head = node;
		else {
			node.next = temp;
			head = node;
		}
		size++;
	}
	
	public E pop() {
		E e;
		Node<E> temp=head;
		if(temp==null)
			return null;
		else {
			e=temp.data;
			Node<E> p=temp.next;
			head=p;
			temp.next=null;
			temp=null;
		}
		size--;
		return e;
	}

	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private static class Node<E> {
		private E data;
		private Node<E> next;

		Node(E data) {
			this.data = data;
		}
	}
	
	public void printStack() {
		Node<E> temp=head;
		while(temp!=null) {
			System.out.print(temp.data+((temp.next!=null)?"->":""));
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.pop();
		System.out.println(stack.size);
		System.out.println(stack.isEmpty());
		stack.printStack();
	}
}
