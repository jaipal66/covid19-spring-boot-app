package com.jp.design.patterns.factory;

public class VehicleFactory {

	public static Vehicle createVehicle(VehicleType vehicleType) {
		Vehicle vehicle = null;
		switch (vehicleType) {
		case TWOWHEELER:
			vehicle = new TwoWheeler();
			break;
		case FOURWHEELER:
			vehicle = new FourWheeler();
			break;
		case THREEWHEELER:
			vehicle = new ThreeWheeler();
			break;
		}
		return vehicle;
	}
}
