package com.jp.bus.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.BusStation;
import com.jp.bus.booking.app.exceptions.BusNotFoundException;
import com.jp.bus.booking.app.repository.BusStationRepository;
import com.jp.bus.booking.app.service.BusStationService;

@Service
@Transactional(readOnly = true)
public class BusStationServiceImpl implements BusStationService {

	@Autowired
	private BusStationRepository busStationRepository;

	@Override
	public BusStation getBusStationById(String busStationId) {
		return busStationRepository.findById(busStationId).orElseThrow(() -> new BusNotFoundException(busStationId));
	}

	@Override
	public List<BusStation> getAllBusStations() {
		return busStationRepository.findAll();
	}

}
