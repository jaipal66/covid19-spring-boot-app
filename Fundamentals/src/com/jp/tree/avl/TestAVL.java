package com.jp.tree.avl;

public class TestAVL {

	public static void main(String[] args) {
		
		AVLTree avl=new AVLTree();
		avl.insert(10);
		avl.inOrder();
		avl.insert(11);
		avl.inOrder();
		avl.insert(9);
		avl.inOrder();
		avl.insert(6);
		avl.inOrder();
		avl.insert(8);
		avl.inOrder();
	}
}
