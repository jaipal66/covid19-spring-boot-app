package com.jp.design.patterns.factory;

public class ShapeFactory {
	static Shape shape = null;

	private ShapeFactory() {
	}

	public static Shape createShape(ShapeType shapeType) {

		switch (shapeType) {
		case CIRCLE:
			shape = new Circle();
			break;
		case RECTANGLE:
			shape = new Rectangle();
			break;
		case TRIANGLE:
			shape = new Triangle();
			break;
		default:
			break;
		}
		return shape;
	}
}
