package com.jp.design.patterns.factory;

public class Triangle implements Shape {

	@Override
	public void drawImage(Shape shape) {
		System.out.println("Triangle : " + shape);
	}

}
