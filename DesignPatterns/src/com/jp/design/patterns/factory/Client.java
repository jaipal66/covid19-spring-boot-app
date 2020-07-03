package com.jp.design.patterns.factory;

public class Client {

	public static void main(String[] args) {

		Vehicle vehicle = VehicleFactory.createVehicle(VehicleType.FOURWHEELER);
        vehicle.getVehicleDetails(vehicle);
        
        Shape shape=ShapeFactory.createShape(ShapeType.CIRCLE);
        shape.drawImage(shape);
	}
}
