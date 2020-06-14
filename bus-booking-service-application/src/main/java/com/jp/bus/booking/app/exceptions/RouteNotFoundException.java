package com.jp.bus.booking.app.exceptions;

public class RouteNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -4185306016942664972L;

	public RouteNotFoundException() {
		super();
	}
	public RouteNotFoundException(String busId) {
		super("Bus", "BusId", busId);
	}

}
