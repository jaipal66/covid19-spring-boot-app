package com.jp.design.patterns.factory;

public class Circle implements Shape{

	@Override
	public void drawImage(Shape shape) {
		System.out.println("Circle : "+shape);
		
	}
	

}
