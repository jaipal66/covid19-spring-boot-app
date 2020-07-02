package com.jp.bus.booking.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.Passenger;

@Transactional
public interface PassengerRepository extends JpaRepository<Passenger, String> {
	
	Optional<Passenger> findByEmail(String email);
	
}
