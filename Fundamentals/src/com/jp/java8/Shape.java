package com.jp.java8;

public interface Shape {

	void draw();
	static void drawShape() {
		System.out.println("Shape drawShape static method");
	}
	
	default void drawShape1() {
		System.out.println("Shape drawShape1  default method");
	}
	
}
