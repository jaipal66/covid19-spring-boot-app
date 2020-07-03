package com.jp.linked.list;

public class TestLinkedList {

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addAtBegining(1);
		list.addAtBegining(2);
		list.addAtBegining(3);
		list.addAtBegining(4);
		list.printList();
		System.out.println();
		list.addAtPosition(3, 5);
		list.printList();
		System.out.println();
		list.addAtLast(8);
		list.printList();
		list.delete(5);
		System.out.println();
		list.printList();
		list.count();
		//list.printNthLast(2);
	}

}

class LinkedList<E> {

	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private Node<E> head;

	public void printNthLast(int n) {
		System.out.println("positin "+n);
		System.out.println(head.data);
		Node<E> p=head;
		Node<E> f=head;
		int counter=1;
		while(counter<=n-1) {
			f=f.next;
			counter=counter+1;
		}
		while(f.next==null) {
			p=p.next;
			f=f.next;	
		}
		System.out.println("At "+n+" : "+p.data);
	}
	public void printList() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public boolean atBegining(E data) {
		Node<E> newNode = new Node<E>(data);
		if (head == null) {
			newNode.next = null;
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		return true;
	}

	static class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}

	}
}