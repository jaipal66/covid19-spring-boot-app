package com.jp.bus.booking.app.service;

import java.util.List;

import com.jp.bus.booking.app.entity.BusStation;

public interface BusStationService {
	BusStation getBusStationById(String busStationId);
	List<BusStation> getAllBusStations();
}
