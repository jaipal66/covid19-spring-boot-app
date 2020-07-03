package com.jp.linkedlist.single;

public class ClientApp {

	public static void main(String[] args) {
		
		LinkedList1 list=new LinkedList1();
		list.addAtLast(1);
		list.addAtLast(2);
		list.addAtLast(3);
		list.addAtLast(4);
		list.addAtLast(5);
		list.addAtGivenPosition(7,2);
		list.addAtBegining(6);
		list.printList();
		
		list.delete(2);
		System.out.println();
		list.printList();
		System.out.println();
		list.findNthNodeFromLast(2);
		list.reverseNode();
		list.printList();
		
		
	}
}
