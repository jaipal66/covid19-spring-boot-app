package com.jp.bus.booking.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.Passenger;
import com.jp.bus.booking.app.service.PassengerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	private static final Logger LOGGER = LoggerFactory.getLogger(PassengerController.class);

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value = "View All Passangers ", response = Passenger.class)
	@RequestMapping(value = "/passengers", method = RequestMethod.GET)
	public @ResponseBody List<Passenger> getAllPassengers() {
		LOGGER.info("");
		return passengerService.getAllPassengers();
	}
	@ApiOperation(value = "View passanger based on passengerId ", response = Passenger.class)
	@RequestMapping(value = "/passengers/{passengerId}", method = RequestMethod.GET)
	public Passenger getPassengerById(@PathVariable("passengerId") String passengerId) {
		return passengerService.getPassengerById(passengerId);
	}
}
