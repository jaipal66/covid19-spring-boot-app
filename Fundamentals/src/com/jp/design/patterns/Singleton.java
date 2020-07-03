package com.jp.design.patterns;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

	private static volatile Singleton instance = null;

	private Singleton() {
		if (instance != null) {
			throw new RuntimeException("Object Already exit");
		}

	}

	public static Singleton getInstance() {

		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public Object readResolve() {
		return instance;
	}
}
