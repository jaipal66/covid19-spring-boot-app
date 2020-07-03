package com.jp.tree.bt;

public class BinaryTree<E> {

	private Node<E> root;

	public Node<E> addNode(E data) {

		return root;
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node<E> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	private static class Node<E> {
		Node<E> left;
		E data;
		Node<E> right;

		Node(E data) {
			this.left = left;
			this.data = data;
			this.right = right;
		}
	}
}
