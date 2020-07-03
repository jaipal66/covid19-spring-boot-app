package com.jp.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public static void main(String[] args) {

		    Node root = new Node(10); 
	       /* root.left = new Node(11); 
	        root.left.left = new Node(7); 
	        root.right = new Node(9); 
	        root.right.left = new Node(15); 
	        root.right.right = new Node(8);*/ 
	        System.out.println("Before");
	        inOrderTraversal(root);
	        
		    insert(root, 16);
		    System.out.println();
		    System.out.println("After");
	        inOrderTraversal(root);
		//preOrderTraversal(root);
	}


	public static void insert(Node root, int data) {
		Queue<Node> queue = new LinkedList<Node>();
		Node temp = root;
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
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

	}

	public void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}

	public static void preOrderTraversal(Node root) {

		if (root != null) {
			System.out.print(root.data+" ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void inOrderTraversal(Node root) {

		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data+" ");
			inOrderTraversal(root.right);
		}

	}

	public void levelOrderTraversal(Node root) {
		Node temp = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		while (!queue.isEmpty()) {
			temp = queue.peek();
			System.out.print(temp.data+" ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}
}
