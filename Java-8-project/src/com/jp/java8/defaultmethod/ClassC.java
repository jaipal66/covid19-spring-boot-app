package com.jp.java8.defaultmethod;

public class ClassC implements InterfaceA,InterfaceB{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		InterfaceA.super.method1();
	}

}
