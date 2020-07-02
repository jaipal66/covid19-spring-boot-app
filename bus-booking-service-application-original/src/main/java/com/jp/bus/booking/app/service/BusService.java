package com.jp.bus.booking.app.service;

import java.util.List;

import com.jp.bus.booking.app.entity.Bus;

public interface BusService {
	
	Bus getBusById(String busId);

	List<Bus> getAllBuses();
}
