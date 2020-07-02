package com.jp.bus.booking.app.service;

import java.util.List;

import com.jp.bus.booking.app.entity.BusBooking;

public interface BookingService {
	
	BusBooking getBooking(String bookingId);
	
	List<BusBooking> getAllBookingsByPassenger(String passengerId);

	List<BusBooking> getAllMultiBusBookingsByPassenger(String passengerId);

	List<BusBooking> getAllMultiBusBookings();
	public void createSampleBookings();
}
