package com.jp.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	Node root;

	public int findLevel(int sum) {
		return findLevel(root, sum);
	}

	private int findLevel(Node root, int sum) {
		Queue<Node> q = new LinkedList<>();
		Node temp = null;
		int level = 0;
		int currentSum = 0;
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			if (temp == null) {
				if (currentSum == sum) {
					
					return level;
				}
				currentSum = 0;
				if (!q.isEmpty()) {
					q.add(null);
				}
				level++;
			} else {
				currentSum += temp.data;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		return -1;
	}

	public void insert(int data) {
		root = createNode(root, data);
	}

	public void delete(int key) {
		root = delete(root, key);
	}

	private Node delete(Node root, int data) {

		if (root == null)
			return root;
		if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null) {
				return root.right;

			} else if (root.right == null) {
				return root.left;
			}
			root.data = minimumValue(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	public void deleteGreaterThan(int key) {
		root = deleteGreaterThan(root, key);
	}

	private Node deleteGreaterThan(Node root, int key) {
		if (root == null)
			return root;
		else if (root.data == key) {
			return root.left;
		} else if (root.data > key) {
			return deleteGreaterThan(root.left, key);
		} else {
			root.right = deleteGreaterThan(root.right, key);
			return root;
		}
	}

	private int minimumValue(Node root) {
		int min = root.data;
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}

	private Node createNode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		} else {

			if (root.data > data) {
				root.left = createNode(root.left, data);
			} else if (root.data < data) {
				root.right = createNode(root.right, data);
			}
		}
		return root;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
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

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

}
