package com.jp.thread.even;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {
	static int number = 1;
	Lock lock = new ReentrantLock();

	public void printOddNumber(int limit) {

		while (number < limit) {
			try {
				while (number % 2 != 0) {
					lock.lock();
				}
				number++;
				System.out.println(Thread.currentThread().getName() + " printing : " + number);
			} finally {
				lock.unlock();
			}
		}
	}

	public void printEvenNumber(int limit) {
		while (number < limit) {
			try {
				while (number % 2 == 0) {
					lock.lock();
				}
				number++;
				System.out.println(Thread.currentThread().getName() + " printing : " + number);
			} finally {
				lock.unlock();
			}
		}
	}
}
