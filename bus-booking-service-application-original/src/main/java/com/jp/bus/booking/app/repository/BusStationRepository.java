package com.jp.bus.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.BusStation;

@Transactional
public interface BusStationRepository extends JpaRepository<BusStation, String> {
	
}
