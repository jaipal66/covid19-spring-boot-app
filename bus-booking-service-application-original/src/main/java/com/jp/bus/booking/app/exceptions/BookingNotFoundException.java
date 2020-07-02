package com.jp.bus.booking.app.exceptions;

public class BookingNotFoundException extends ResourceNotFoundException {
	
	private static final long serialVersionUID = -3880429246973279969L;

	public BookingNotFoundException(String bookingId) {
		super("Booking", "bookingId", bookingId);
	}

}
