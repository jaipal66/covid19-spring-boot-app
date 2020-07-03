package com.jp.tree.bst;

public class ClientApp {

	/**
	 * 
	 *      10
	 *     /  \
	 *    3    11
	 *    \     \
	 *    5      20
	 * @param args
	 */
	public static void main(String[] args) {
		
		
 
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(10);
		bst.addNode(3);
		bst.addNode(5);
		bst.addNode(11);
		bst.addNode(20);
		//bst.levelOrder();
		bst.rightView();
		
		bst.printLeaves();
		System.out.println(bst.isBST());
	}
}
