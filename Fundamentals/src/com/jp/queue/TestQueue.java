package com.jp.queue;

public class TestQueue {

	public static void main(String[] args) {
		
		Queue q=new Queue(10);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		q.printQueueData();
		q.deQueue();
		System.out.println();
		q.printQueueData();
	}
}
