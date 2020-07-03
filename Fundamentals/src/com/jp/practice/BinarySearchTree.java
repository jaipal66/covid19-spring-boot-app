package com.jp.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	Node root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		} else if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		}
		return root;
	}

	public void deleteGreaterThan(int data) {
		root = deleteGreaterThan(root, data);
	}

	private Node deleteGreaterThan(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			return root.left;
		} else if (key < root.data) {
			return deleteGreaterThan(root.left, key);
		} else {
			root.right = deleteGreaterThan(root.right, key);
			return root;
		}
	}

	public void breadthFirstSearch() {
		breadthFirstSearch(this.root);
	}

	public int findLevel(int sum) {
		return findLevel(this.root, sum);
	}

	private int findLevel(Node root, int sum) {
		int level = 0;
		int currentSum = 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				System.out.println("Level : " + level + " sum : " + currentSum);
				if (currentSum == sum) {
					return level;
				} else {
					currentSum = 0;
					if (!queue.isEmpty())
						queue.add(null);
					level++;
				}
			} else {
				currentSum += temp.data;
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}

		return level;
	}

	private void breadthFirstSearch(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node temp = null;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}

	}

	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}

	private void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}

	private void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	static class Node {
		int data;
		Node left;;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}
