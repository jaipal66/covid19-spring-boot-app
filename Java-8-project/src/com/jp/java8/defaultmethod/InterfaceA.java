package com.jp.java8.defaultmethod;

public interface InterfaceA {

	 default void method1() {
		System.out.println("InterfaceA method1");
	}
	
	void method2();
}
