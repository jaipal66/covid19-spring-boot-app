package com.jp.bus.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.exceptions.BusNotFoundException;
import com.jp.bus.booking.app.repository.BusRepository;
import com.jp.bus.booking.app.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) {
		return busRepository.save(bus);
	}

	@Override
	public List<com.jp.bus.booking.app.entity.Bus> findAllBuses() {
		return busRepository.findAll();
	}

	@Override
	public Bus updateBus(Bus bus) {
		return busRepository.save(bus);
	}

	@Override
	public void deleteAllBuses() {
		busRepository.deleteAll();

	}

	@Override
	public void deleteBusById(int busId) {
		busRepository.deleteById(busId);

	}

	@Override
	public Bus findBusById(int busId) {
		return busRepository.findById(busId).orElseThrow(() -> new BusNotFoundException(String.valueOf(busId)));
	}
	@Override
	public Page<Bus> findAll(Pageable pageable){
		return busRepository.findAll(pageable);
	}

}
