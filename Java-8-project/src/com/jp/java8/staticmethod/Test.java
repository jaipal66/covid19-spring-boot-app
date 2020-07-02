package com.jp.java8.staticmethod;

public class Test {

	public static void main(String[] args) {
		
		InterfaceA a = new ClassA();
		InterfaceA.method1(); // it will call InterfaceA method implementation
		ClassA.method1(); // it will call ClassA method implementation
		InterfaceB.method1(); // it will call InterfaceB method implementation
		
		InterfaceA a1 = new ClassA();
		a1.method2();
		InterfaceB b1 = new ClassA();
		b1.method2();
		
	}
}
