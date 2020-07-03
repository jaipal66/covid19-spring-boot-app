package com.jp.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	BinaryTree(int data) {
		root = new Node(data);

	}

	static class Node {
		private int data;
		private Node left;
		private Node right;

		Node(int data) {
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}

	private Node root;

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node root, int data) {
		Queue<Node> queue = new LinkedList<>();
		Node temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp.left == null) {
				temp.left = new Node(data);
				break;
			} else {
				queue.add(temp.left);
			}
			if (temp.right == null) {
				temp.right = new Node(data);
				break;
			} else {
				queue.add(temp.right);
			}
		}
		return root;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	/*
	 * 1.push current node to stack and go to left child till left child is null
	 * 2.when stack is empty break the outer loop 3.pop node from stack 4.print node
	 * data 5.go to right child of current node
	 * 
	 * 
	 * 
	 */
	private void inOrderTraversal(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack();
		while (true) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			if (stack.isEmpty())
				break;
			temp = stack.pop();
			System.out.print(temp.data + " ");
			temp = temp.right;
		}
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node root) {
		Stack<Node> stack = new Stack();
		Node temp = root;
		while (true) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				if (stack.isEmpty())
					break;
				else {
					if (stack.peek() == null) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
						while (temp == stack.peek().right) {
							System.out.print(stack.peek().data + " ");
							temp = stack.pop();
						}
					}
					if (!stack.isEmpty()) {
						temp = stack.peek().right;
					} else
						temp = null;
				}
			}
		}

	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack();
		while (true) {
			while (temp != null) {
				System.out.print(temp.data + " ");
				stack.push(temp);
				temp = temp.left;
			}
			if (stack.isEmpty())
				break;

			temp = stack.pop();
			temp = temp.right;
		}

	}

	public void delete(int data) {
		delete(root, data);
	}

	private Node delete(Node root, int data) {
		if (root == null)
			return root;
		else if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.data = minimum(root.right);
			root.right = delete(root.right, root.data);

		}
		return root;
	}

	private int minimum(Node right) {
		Node temp = right;
		int data = temp.data;
		while (temp != null) {
			data = temp.left.data;
			temp = temp.left;
		}
		return data;
	}

	public static boolean isBST(Node root, int min, int max) {

		if (root == null)
			return false;
		return (root.data < min && root.data > max && isBST(root.left, min, root.data)
				&& isBST(root.right, root.data, max));
	}

	public static boolean isBST(Node root) {
		if (root == null)
			return true;
		int prev = 0;
		if (isBST(root.left) == false)
			return false;
		if (root.data <= prev)
			return false;
		prev = root.data;
		return isBST(root.right);
	}
}
