package com.jp.tree.avl;

public class AVLTree {

	Node root;

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node t2 = y.left;

		y.left = x;
		x.right = t2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		return y;
	}

	public Node rightRotate(Node y) {

		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;

	}

	public void insert(int key) {
		this.root = insert(this.root, key);
	}

	private Node insert(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		} else if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
		} else {
			return root;
		}
		root.height = 1 + max(height(root.left), height(root.right));
		int balanceFactor = balanceFactor(root);

		if (balanceFactor > 1 && data < root.left.data) {
			System.out.println("balanceFactor > 1 && data < root.left.data");
			return rightRotate(root);

		} else if (balanceFactor < -1 && data > root.right.data) {
			System.out.println("balanceFactor < -1 && data > root.right.data");
			return leftRotate(root);

		} else if (balanceFactor > 1 && data > root.left.data) {
			System.out.println("balanceFactor > 1 && data > root.left.data");
			root.left = leftRotate(root.left);
			return rightRotate(root);

		} else if (balanceFactor < -1 && data < root.right.data) {
			System.out.println("balanceFactor < -1 && data < root.right.data");
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	private int balanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}

	static class Node {
		Node left;
		Node right;
		int data;
		int height;

		Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

}
