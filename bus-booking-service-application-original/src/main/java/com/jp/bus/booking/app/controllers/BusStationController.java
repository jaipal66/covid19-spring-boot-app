package com.jp.bus.booking.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.BusStation;
import com.jp.bus.booking.app.service.BusStationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BusStationController {
	
	@Autowired
	private BusStationService busStationService;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BusStationController.class);
	
    @ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved All Bus Stations"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value = "View All Bus Stations ", response = BusStation.class)
	@RequestMapping(value = "/busStations", method = RequestMethod.GET)
	public  List<BusStation> getAllBusStations() {
		LOGGER.info("");
		return busStationService.getAllBusStations();
	}
	@ApiOperation(value = "View Bus station based on busStationId ", response = BusStation.class)
	@RequestMapping(value = "/busStations/{busStationId}", method = RequestMethod.GET)
	public  BusStation getBusStationById(@PathVariable("busStationId") String iataCode) {
		return busStationService.getBusStationById(iataCode);
	}
}
