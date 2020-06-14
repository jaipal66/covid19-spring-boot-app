package com.jp.bus.booking.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.bus.booking.app.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	Page<Bus> findAll(Pageable pageable);

}
