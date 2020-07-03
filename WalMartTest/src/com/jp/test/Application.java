package com.jp.test;

public class Application {

	public static void main(String[] args) {

		// 1 2 3 4 5 6 ->4

		// 5
		// 3 10
		// 12 4 2 1
		// 23

		// 22
		// 21
	}

	class BT {

		Node root;
		static Node node = null;

		static class Node {
			int data;
			Node left;
			Node right;

			Node(int data) {
				this.data = data;
			}
		}

		public int height(Node root) {
			if (root == null)
				return 0;
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}

		public int zigZagheight(Node root) {
			if(root==null) return 0;
			if(root.left!=null) {
				if()
				zigZagheight(root.left.right);
				
			}else if(root.right!=null) {
				if()
				zigZagheight(root.right.left);
			}
		}
	}

	class LinkedList {

		Node head;

		class Node {
			int data;
			Node next;

			Node(int data) {
				this.data = data;
			}
		}

		public int detectCycle(Node head) {
			Node fast = head;
			Node slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow)
					break;
			}
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			int result = slow.data;
			return result;

		}
	}

	public static int peek(int[] numbers, int start, int end) {

		int midddleIndex = start + (end - start) / 2;

		if (numbers[midddleIndex - 1] < numbers[midddleIndex] && numbers[midddleIndex + 1] > numbers[midddleIndex]) {
			return midddleIndex;

		} else if (numbers[midddleIndex] < numbers[midddleIndex - 1] || midddleIndex > 0) {
			return peek(numbers, start, midddleIndex - 1);
		} else {
			return peek(numbers, midddleIndex + 1, end);
		}
	}
}
