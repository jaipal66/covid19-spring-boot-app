package com.jp.java8;

public class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle draw method");
		
	}

	static void drawShape() {
		System.out.println("Circle drawShape static method");
	}
}
