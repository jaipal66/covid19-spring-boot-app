package com.jp.bus.booking.app.exceptions;

public class BusNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -4185306016942664972L;

	public BusNotFoundException() {
		super();
	}
	public BusNotFoundException(String busId) {
		super("Bus", "BusId", busId);
	}

}
