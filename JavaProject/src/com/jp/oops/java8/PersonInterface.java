package com.jp.oops.java8;

public interface PersonInterface {

	default void personMethod() {
		System.out.println("PersonInterface personMethod");
	}
	default void commanPersonMethod() {
		System.out.println("PersonInterface commanPersonMethod");
	}
	default void personMethod2() {
		System.out.println("PersonInterface personMethod2");
	}
	
	static int personStaticMethod() {
		System.out.println("PersonInterface personStaticMethod");
		return 1;
	}
}
