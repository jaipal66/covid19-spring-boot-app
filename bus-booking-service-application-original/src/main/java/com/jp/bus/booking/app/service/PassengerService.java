package com.jp.bus.booking.app.service;

import java.util.List;

import com.jp.bus.booking.app.entity.Passenger;

public interface PassengerService {
	
	Passenger getPassengerById(String passengerId);

	List<Passenger> getAllPassengers();
}
