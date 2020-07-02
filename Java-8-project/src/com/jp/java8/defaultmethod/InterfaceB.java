package com.jp.java8.defaultmethod;

public interface InterfaceB {
	default void method1() {
		System.out.println("InterfaceB method1");
	}
	void method2();
}
