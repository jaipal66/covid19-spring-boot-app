package com.jp.bus.booking.app.exceptions;

public class PassengerNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -7428665705397767944L;

	public PassengerNotFoundException(String passengerId) {
		super("Passenger", "passengerId", passengerId);
	}

}
