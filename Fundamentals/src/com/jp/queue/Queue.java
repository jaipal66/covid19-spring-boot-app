package com.jp.queue;

public class Queue {

	int size, front, rear, capacity = 0;
	int[] array;

	Queue(int capacity) {
		this.capacity = capacity;
		this.array = new int[capacity];
		this.size = 0;
		this.front = this.size=0;
		this.rear = capacity-1;
	}

	public void enQueue(int data) {
		if (isFull())
			return;
		this.rear = (rear + 1) % capacity;
		this.array[rear] = data;
		size++;
	}

	public int rear() {
		return this.array[rear];
	}

	public int front() {
		return this.array[front];
	}

	public int deQueue() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		int value = this.array[front];
		this.front = (front + 1) % capacity;
		size--;
		return value;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}
	public void printQueueData() {
		for(int i=0;i<this.size;i++) {
			System.out.print(this.array[i]+" ");
		}
	}
}
