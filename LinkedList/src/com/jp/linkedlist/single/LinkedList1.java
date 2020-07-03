package com.jp.linkedlist.single;

public class LinkedList1 {

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public void addAtLast(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		if (temp == null)
			head = newNode;
		else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = null;
		}
	}

	public void addAtBegining(int data) {
		Node newNode = new Node(data);
		Node temp = head;
		if (temp == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addAtGivenPosition(int data, int index) {

		Node newNode = new Node(data);
		Node temp = head;
		while (temp.data != index) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;

	}

	public void findNthNodeFromLast(int index) {
		Node p = head;
		Node f = head;
		int cnt = 1;
		while (cnt <= index - 1) {
			f = f.next;
			cnt++;
		}
		while (f.next != null) {
			f = f.next;
			p = p.next;
		}
		System.out.println(index + ": element from last is : " + p.data);
	}

	public Node reverseNode() {
		head = reverseNode(head);
		return head;
	}

	private Node reverseNode(Node head) {
		Node current_node = head;
		Node next_node = null;
		Node prev_node = null;
		while (current_node != null) {
			next_node = current_node.next;
			current_node.next = prev_node;
			prev_node = current_node;
			current_node = next_node;
		}
		head=prev_node;
		return head;
	}

	public void delete(int data) {
		Node first = head;
		Node second = head.next;
		if (first.data == data) {
			head = second;
		} else {
			while (second.data != data && second != null) {
				first = first.next;
				second = second.next;
			}
			if (second.next == null && second.data == data) {
				first.next = null;
				second = null;
			} else if (second != null && second.data == data) {
				first.next = second.next;
				second = null;
			}
		}
	}
}
