package com.jp.leetcode.recurrsion;

public class ReverseLinkedList {

	static class Node {
		int data;
		Node next;
	}

	public static void main(String[] args) {

		Node head = new Node();
		reverseLinkedList(head);
	}

	private static Node reverseLinkedList(Node head) {
		Node current_node = head;
		Node previous_node = null;
		Node next_node = null;
		while (current_node != null) {
			next_node = current_node.next;
			current_node.next = previous_node;
			previous_node = current_node;
			current_node = next_node;
		}
		head = previous_node;
		return head;
	}
}
