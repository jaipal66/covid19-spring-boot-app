package com.jp.tree.bt;

public class TestBT {

	public static void main(String[] args) {

		BinaryTreeArrayImp bt = new BinaryTreeArrayImp();
		bt.createRoot("A");
		bt.leftChild("B",0);
		bt.leftChild("C",1);
		bt.printTree();
	}

}
