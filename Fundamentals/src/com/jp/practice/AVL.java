package com.jp.practice;

public class AVL {

	
	Node root;
	
	
	static class Node {
		int data;
		Node left;
		Node right;
		int height;

		Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}
}
