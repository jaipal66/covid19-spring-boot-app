package com.jp.bus.booking.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jp.bus.booking.app.entity.Bus;

public interface BusService {

	public Bus addBus(Bus bus);

	public Bus findBusById(int busId);

	public List<Bus> findAllBuses();

	public Bus updateBus(Bus bus);

	public void deleteAllBuses();

	public void deleteBusById(int busId);
	
	Page<Bus> findAll(Pageable pageable);

}
