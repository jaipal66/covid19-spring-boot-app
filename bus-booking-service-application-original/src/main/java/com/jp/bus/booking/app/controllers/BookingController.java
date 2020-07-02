package com.jp.bus.booking.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.entity.BusBooking;
import com.jp.bus.booking.app.exceptions.BookingNotFoundException;
import com.jp.bus.booking.app.model.BusBookingModel;
import com.jp.bus.booking.app.model.BusBookingSummaryModel;
import com.jp.bus.booking.app.model.converter.BusBookingModelConverter;
import com.jp.bus.booking.app.service.BookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BookingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;

	@Autowired
	private BusBookingModelConverter toBookingModelConverter;
	@ApiOperation(value = "View Booking deatils based on bookingId ", response = BusBooking.class)
	@RequestMapping(value = "/bookings/{bookingId}", method = RequestMethod.GET)
	public  BusBookingModel getBookingById(@PathVariable String bookingId) {

		LOGGER.info("Finding booking by id ... " + bookingId);
		return toBookingModelConverter.convert(bookingService.getBooking(bookingId));
	}
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value = "View All Bookings ", response = BusBooking.class)
	
	@RequestMapping(value = "/bookings", method = RequestMethod.GET)
	public  List<BusBookingSummaryModel> getBookings(
			@RequestParam(required = false, name = "uid") String passengerId,
			@RequestParam(required = false, name = "multi-buses", defaultValue = "false") boolean multiBuses) {

		LOGGER.info("Finding booking by passengerId ... " + passengerId);

		List<BusBooking> bookings = null;
		if (!StringUtils.isEmpty(passengerId)) {

			if (multiBuses) {
				bookings = bookingService.getAllMultiBusBookingsByPassenger(passengerId);
			} else {
				bookings = bookingService.getAllBookingsByPassenger(passengerId);
			}
		} else {
			throw new BookingNotFoundException(null);
		}

		List<BusBookingSummaryModel> bookingModels = new ArrayList<>(bookings.size());
		bookings.stream().forEach(booking -> {
			bookingModels.add(new BusBookingSummaryModel(booking.getId(), booking.getPassenger().getLastName(),
					((Bus) booking.getBuses().toArray()[0]).getDeparture()));
		});
		return bookingModels;
	}
}
