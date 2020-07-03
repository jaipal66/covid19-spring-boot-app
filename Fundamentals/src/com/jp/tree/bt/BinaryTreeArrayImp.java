package com.jp.tree.bt;

public class BinaryTreeArrayImp {

	String nodes[] = new String[10];

	public void createRoot(String data) {
		nodes[0] = data;
	}

	public void leftChild(String data, int root) {

		int index = (root * 2) + 1;
		if (nodes[root] == null)
			System.out.println("root is not available");
		else
			nodes[index] = data;
	}

	public void rightChild(String data, int root) {
		int index = (root * 2) + 2;
		if (nodes[root] == null)
			System.out.println("root is not available");
		else
			nodes[index] = data;
	}
	
	public void printTree() {
		for(int i=0;i<nodes.length;i++) {
			if(nodes[i]!=null)
				System.out.print(nodes[i]+" ");
		}
	}

}
