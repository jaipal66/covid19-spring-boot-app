package com.jp.bus.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.Passenger;
import com.jp.bus.booking.app.exceptions.PassengerNotFoundException;
import com.jp.bus.booking.app.repository.PassengerRepository;
import com.jp.bus.booking.app.service.PassengerService;

@Service
@Transactional(readOnly = true)
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public Passenger getPassengerById(String passengerId) {
		return passengerRepo.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
	}

	@Override
	public List<Passenger> getAllPassengers() {
		return passengerRepo.findAll();
	}

}
