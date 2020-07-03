package com.jp.practice;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(5);
		bst.insert(7);
		bst.insert(6);
		bst.insert(4);
		bst.insert(8);
		bst.inOrderTraversal();
		System.out.println();
		/*
		bst.postOrderTraversal();
		System.out.println();
		bst.preOrderTraversal();
		System.out.println();
		bst.breadthFirstSearch();*/
		System.out.println(bst.findLevel(14));
		bst.deleteGreaterThan(7);
		bst.inOrderTraversal();
		
	}
}
