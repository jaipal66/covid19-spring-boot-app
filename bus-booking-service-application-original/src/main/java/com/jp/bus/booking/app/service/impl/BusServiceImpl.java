package com.jp.bus.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.exceptions.BusNotFoundException;
import com.jp.bus.booking.app.repository.BusRepository;
import com.jp.bus.booking.app.service.BusService;

@Service
@Transactional(readOnly = true)
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus getBusById(String busId) {
		return busRepository.findById(busId).orElseThrow(() -> new BusNotFoundException(busId));
	}

	@Override
	public List<Bus> getAllBuses() {
		return busRepository.findAll();
	}

}
