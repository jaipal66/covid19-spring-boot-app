package com.jp.tree.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root,int min,int max) {
		if(root==null)
			return true;
	 if((root.data>min && root.data<max) && 
		isBST(root.left,min,root.data) && 
		isBST(root.right,root.data,max))
		return true;
	 return false;
		
	}

	public void printLeaves() {
		printLeaves(root);
	}

	void printLeaves(Node root) {
		if (root == null)
			return;
		printLeaves(root.left);
		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");
		printLeaves(root.right);
	}

	public int findHeight() {
		return findHeight(root);
	}

	private int findHeight(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}

	public boolean isMirrorImage(BinarySearchTree rootOne, BinarySearchTree rootSecond) {
		return isMirrorImage(rootOne.root, rootOne.root);
	}

	/*
	 * 
	 * To check if one tree is mirror image of another tree
	 */
	public boolean isMirrorImage(Node rootOne, Node rootSecond) {
		if (rootOne == null && rootSecond == null)
			return true;
		if (rootOne == null || rootSecond == null)
			return false;
		if (rootOne.data == rootSecond.data) {
			if (isMirrorImage(rootOne.left, rootSecond.right) && isMirrorImage(rootOne.right, rootSecond.left))
				return true;
		}
		return false;
	}

	public void levelOrderLineByLine() {
		levelOrderLineByLine(root);
	}

	private void levelOrderLineByLine(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp == null) {
				if (!queue.isEmpty())
					queue.add(null);
				System.out.println();
			} else {
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
		}
	}

	public void leftView() {
		leftView(root);
	}

	private void leftView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node temp = queue.peek();
			if (temp != null) {
				System.out.print(temp.data + " ");
				while (queue.peek() != null) {
					if (temp.left != null) {
						queue.add(temp.left);
					}
					if (temp.right != null) {
						queue.add(temp.right);
					}
					queue.remove();
					temp = queue.peek();
				}
				queue.add(null);
			}
			queue.remove();
		}
	}

	public void rightView() {
		rightView(root);
	}

	private void rightView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				Node temp = queue.poll();
				// i==1 will print leftView
				if (i == size)
					System.out.print(temp.data + " ");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}

		}
	}

	public void inOrderByLoop() {
		inOrderByLoop(root);
	}

	private void inOrderByLoop(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
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

	public void preOrderByLoop() {
		preOrderByLoop(root);
	}

	private void preOrderByLoop(Node root) {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
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

	private int minimumValue(Node right) {
		int minimumValue = right.data;
		while (right.left != null) {
			minimumValue = root.left.data;
			right = right.left;
		}
		return minimumValue;
	}

	public void inOrder() {
		inOrder(root);
	}

	public void postOrder() {
		postOrder(root);
	}

	public void preOrder() {
		preOrder(root);
	}

	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	private Node root;

	public void addNode(int data) {
		this.root = addNode(root, data);
	}

	private Node addNode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (data < root.data) {
				root.left = addNode(root.left, data);
			} else if (data > root.data) {
				root.right = addNode(root.right, data);
			}
		}
		return root;
	}

	private static class Node {
		private Node left;
		private int data;
		private Node right;

		public Node(int data) {
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}
}
