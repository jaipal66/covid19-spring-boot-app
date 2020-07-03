package com.jp.thread.producer;

import java.util.Queue;
import java.util.Random;

public class NumberGenerator {

	private final int CAPACITY = 2;

	private Queue<Integer> list = null;

	NumberGenerator(Queue<Integer> list) {
		this.list = list;
	}

	public void produceNumber() {
		while (true) {
			synchronized (this) {
				while (list.size() == CAPACITY) {
					try {
						System.out.println("List is Full so "+Thread.currentThread().getName()+" will wait untill consumer consume");
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int number=giveNextNumber();
				System.out.println(Thread.currentThread().getName() + " Produced "+number);
				list.add(number);
				System.out.println("Notify Consumer");
				this.notify();
			}
		}

	}

	public void consumeNumber() {

		while (true) {
			synchronized (this) {
				while (list.size() == 0) {
					try {
						System.out.println("List is Empty so "+Thread.currentThread().getName()+" will wait for producer to produce number");
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " consumed " + list.poll());
				System.out.println("Notify Producer");
				this.notify();
			}
		}
	}

	private int giveNextNumber() {
		return new Random().nextInt(20);
	}
}
