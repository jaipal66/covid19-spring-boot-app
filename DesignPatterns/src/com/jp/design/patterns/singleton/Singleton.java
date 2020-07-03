package com.jp.design.patterns.singleton;

public class Singleton {

	private static Singleton singleton;

	private Singleton() {
		if(singleton!=null)
			throw new RuntimeException("Not Allowed");
	}

	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
