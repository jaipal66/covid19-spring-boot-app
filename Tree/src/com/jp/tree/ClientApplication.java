package com.jp.tree;

public class ClientApplication {

	public static void main(String[] args) {
		
		BinaryTree tree=new BinaryTree(10);
		tree.add(10);
		tree.add(11);
		tree.add(9);
		tree.add(7);
		tree.add(1);
		tree.add(15);
		
		tree.inOrder();
		System.out.println();
		tree.inOrderTraversal();
		System.out.println();
		tree.preOrderTraversal();
		
	}
}
