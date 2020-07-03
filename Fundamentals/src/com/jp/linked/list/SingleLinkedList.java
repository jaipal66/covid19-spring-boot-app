package com.jp.linked.list;

public class SingleLinkedList {

	private Node head;

	public int addAtBegining(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		return value;
	}

	public int addAtLast(int value) {
		Node temp = head;
		Node newNode = new Node(value);
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = null;
		return value;
	}

	public int addAtPosition(int index, int data) {
		Node temp = head;
		Node newNode = new Node(data);
		Node store;
		int count = 1;
		while (count != index) {
			count++;
			temp = temp.next;
		}
		store=temp.next;
		newNode.next = store;
		temp.next = newNode;
		return data;
	}

	public void delete(int key) {
		Node temp = head;
		Node prev = null;
		if (temp != null && temp.data == key)
			head = temp.next;
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public int count() {
		Node temp = head;
		int count = 1;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		System.out.println("count : "+count);
		return count;
	}

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

}
