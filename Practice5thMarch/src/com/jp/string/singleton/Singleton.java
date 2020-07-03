package com.jp.string.singleton;

import java.io.Serializable;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Singleton implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1782222231170328478L;

	private static Singleton singleton;

	private static Lock lock = new ReentrantLock();
	private static Semaphore semaphore = new Semaphore(1);

	private Singleton() {
		if (singleton != null)
			throw new RuntimeException("can't be created twice for singleton class");

	}

	public static Singleton getInstance() {
		try {
			semaphore.acquire();
			lock.lock();
			if (singleton == null) {
				singleton = new Singleton();
			}
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
			semaphore.release();
		}
		return singleton;
	}

	public Object readResolve() {
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singleton;
	}
}
