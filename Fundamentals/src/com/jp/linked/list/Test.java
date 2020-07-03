package com.jp.linked.list;

public class Test {

	public static void main(String[] args) {
		LinkedList1<Integer> list = new LinkedList1();
		list.addAtLast(1);
		list.addAtLast(2);
		list.addAtLast(3);
		list.addAtLast(4);
		list.addAtLast(5);
		list.addAtBegin(8);
		list.printList();
		System.out.println();
		list.addAtPosotion(6, 3);
		list.printList();
		System.out.println();
		list.printMiddle();
		System.out.println();

		System.out.println(list.printNthLast(3));

		list.reverse();

		list.printList();

	}

}

class LinkedList1<E> {
	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<E> head;

	public void addAtBegin(E data) {
		Node<E> temp = head;
		Node<E> newNode = new Node(data);
		if (temp == null) {
			head = newNode;

		} else {
			newNode.next = head;
			head = newNode;

		}

	}

	public void addAtPosotion(E data, int index) {

		Node<E> temp = head;
		Node<E> newNode = new Node<E>(data);
		if (temp == null) {
			head = newNode;
		}
		int count = 1;
		while (count != index) {
			count++;
			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	public E addAtLast(E data) {
		Node<E> newNode = new Node<E>(data);
		Node<E> temp = head;
		if (temp == null) {
			head = newNode;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = null;
		}
		return data;
	}

	public void printList() {
		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public E printMiddle() {
		return printMiddle(head);
	}

	public E printNthLast(int n) {
		return printNthLast(head, n);
	}

	public void addTwoLinkedList(Node<E> first, Node<E> second) {

		Node<E> result;
		Node<E> pre;
		Node<E> temp;
		int carry = 0;
		int sum = 0;

		/*while (first != null || second != null) {

			//sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			temp = new Node(sum);

			if (result == null)
				result = temp;
			else
				pre.next = temp;
			pre = temp;

			if (first != null)
				first = first.next;
			if (second != null)
				second = second.next;
		}*/
	}

	public Node<E> reverse() {
		return reverse(head);
	}

	private Node<E> reverse(Node<E> head) {
		Node<E> current = head;
		Node<E> pre = null;
		Node<E> next = null;
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		this.head = pre;
		return head;

	}

	private E printNthLast(Node<E> head, int n) {
		int length = 0;
		Node<E> temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		temp = head;
		for (int i = 1; i <= length - n; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private E printMiddle(Node<E> head) {
		Node<E> middle = head;
		Node<E> temp = head;
		int count = 0;
		while (temp != null) {
			if (count % 2 != 0)
				middle = middle.next;
			count++;
			temp = temp.next;
		}
		return middle.data;
	}

}