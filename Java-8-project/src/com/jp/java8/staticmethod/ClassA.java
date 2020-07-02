package com.jp.java8.staticmethod;

public class ClassA implements InterfaceA,InterfaceB {
	public static void method1() {
	   System.out.println("ClassA method1");	
	}

	@Override
	public void method2() {
		System.out.println("ClassA comman instance method2");
		
	}
	public void method2(String a) {
		
	}

}
