package com.jp.tree.bst;

public class TestBST {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(8);
		bst.insert(2);
		bst.insert(7);
		bst.insert(9);
		bst.insert(6);
		System.out.println("InOrder : ");
		bst.inOrder();
		System.out.println();
		System.out.println(bst.findLevel(16));
	}
}
