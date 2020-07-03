package com.jp.linked.list;

import java.util.Stack;

public class CheckPalindrome {

	public static void main(String[] args) {

	}

	class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public static boolean checkPalindrome(Node head) {

		Node curr = head;
		Node runner = head;
		Stack<Integer> stack = new Stack<>();

		while (runner != null && runner.next != null) {
			stack.push(curr.data);
			curr = curr.next;
			runner = runner.next.next;
		}

		/*this will execute only for odd number of node
		 * 
		 * 1->2->1
		 * 
		 * */
		if (runner != null)
			curr = curr.next;
		while (curr != null) {
			if (stack.pop() != curr.data)
				return false;
			curr = curr.next;
		}

		return true;
	}
}
