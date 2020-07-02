package com.jp.bus.booking.app.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.entity.BusBooking;
import com.jp.bus.booking.app.entity.Passenger;
import com.jp.bus.booking.app.exceptions.BookingNotFoundException;
import com.jp.bus.booking.app.exceptions.BookingNotFoundForPassengerException;
import com.jp.bus.booking.app.repository.BusBookingRepository;
import com.jp.bus.booking.app.repository.BusRepository;
import com.jp.bus.booking.app.repository.PassengerRepository;
import com.jp.bus.booking.app.service.BookingService;

@Service
@Transactional(readOnly = true)
public class BookingServiceImpl implements BookingService {
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BusBookingRepository bookingRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private BusRepository busRepository;

	@Override
	public BusBooking getBooking(String bookingId) {
		return bookingRepository.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}

	@Override
	public List<BusBooking> getAllBookingsByPassenger(String passengerId) {
		List<BusBooking> bookings = bookingRepository.findByPassengerId(passengerId);
		if (CollectionUtils.isEmpty(bookings))
			throw new BookingNotFoundForPassengerException(passengerId);
		return bookings;
	}

	@Override
	@Transactional
	public void createSampleBookings() {
		List<Passenger> allPassengers = passengerRepository.findAll();
		final Random flightSelector = new Random(1);

		int[] passCounter = new int[1];

		allPassengers.stream().forEach(passenger -> {

			createRandomBooking(passenger, flightSelector);

			if (passCounter[0] % 3 == 0) {
				createRandomBooking(passenger, flightSelector);
			}

			passCounter[0]++;
		});
	}

	private void createRandomBooking(Passenger passenger, Random flightSelector) {
		String busId = "FL-" + (flightSelector.nextInt(19) + 1);
		logger.debug(">>>>>>>>>>>>>>> BUS-ID = " + busId);
		Bus bus = busRepository.findById(busId).orElse(null);
		logger.debug(">>>>>>>>>>>>>>>>>> Bus = " + bus);

		List<Bus> nextFlights = busRepository.findByDepartureAndDepartureTimeGreaterThan(bus.getArrival(),
				bus.getArrivalTime());
		Bus nextBus = CollectionUtils.isEmpty(nextFlights) ? null : nextFlights.get(0);
		logger.debug(" CCCCCCCCCCCC >>>>>>>>>>>>>>>>>> nextBus = " + nextBus);

		BusBooking booking = new BusBooking();
		booking.setPassenger(passenger);

		Set<Bus> flights = new HashSet<>(2);
		flights.add(bus);
		if (CollectionUtils.isEmpty(bus.getBookings())) {
			bus.setBookings(new HashSet<>(2));
		}
		bus.getBookings().add(booking);
		if (nextBus != null) {
			flights.add(nextBus);
			if (CollectionUtils.isEmpty(nextBus.getBookings())) {
				nextBus.setBookings(new HashSet<>(2));
			}
			nextBus.getBookings().add(booking);
		}
		booking.setFlights(flights);
		bookingRepository.save(booking);
		busRepository.save(bus);

		busRepository.save(bus);
		if (nextBus != null) {
			busRepository.save(nextBus);
		}
	}

	@Override
	public List<BusBooking> getAllMultiBusBookingsByPassenger(String passengerId) {
		List<BusBooking> bookings = bookingRepository.findByPassengerId(passengerId);
		return bookings.stream().filter(booking -> booking.getBuses().size() > 1).collect(Collectors.toList());

	}

	@Override
	public List<BusBooking> getAllMultiBusBookings() {
		return bookingRepository.findAll();
	}

}
