package com.jp.bus.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jp.bus.booking.app.entity.BusBooking;

@Transactional
public interface BusBookingRepository extends JpaRepository<BusBooking, String> {

	List<BusBooking> findByPassengerId(String passengerId);
}
