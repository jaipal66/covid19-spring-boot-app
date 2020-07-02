package com.jp.bus.booking.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.model.BusModel;
import com.jp.bus.booking.app.service.BusService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BusController {

	@Autowired
	private BusService busService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BusController.class);

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value = "View All Register Buses ", response = BusModel.class)
		
	@RequestMapping(value = "/buses", method = RequestMethod.GET)
	public List<Bus> getAllBuses() {
		LOGGER.info("");
		return busService.getAllBuses();
	}
	@ApiOperation(value = "View a bus based on busId ", response = BusModel.class)
	@RequestMapping(value = "/buses/{busId}", method = RequestMethod.GET)
	public Bus getBusById(@PathVariable("busId") String busId) {
		return busService.getBusById(busId);
	}
}
