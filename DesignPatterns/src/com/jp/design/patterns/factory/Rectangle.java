package com.jp.design.patterns.factory;

public class Rectangle implements Shape {

	@Override
	public void drawImage(Shape shape) {
		
		System.out.println("Rectangle : "+shape);
	}

	
}
