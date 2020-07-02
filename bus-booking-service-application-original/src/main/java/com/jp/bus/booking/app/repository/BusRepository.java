package com.jp.bus.booking.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.Bus;

@Transactional
public interface BusRepository extends JpaRepository<Bus, String> {
	
	List<Bus> findByDepartureAndDepartureTimeGreaterThan(String departure, LocalDateTime departureDate);
}
