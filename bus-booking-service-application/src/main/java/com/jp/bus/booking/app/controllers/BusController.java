package com.jp.bus.booking.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.Bus;
import com.jp.bus.booking.app.model.BusModel;
import com.jp.bus.booking.app.service.BusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("API to manage all bus endpoints")
public class BusController {

	@Autowired
	private BusService busService;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	@ApiOperation(value = "Available Buses based on source city,destination city, travel date and return date ", response = BusModel.class)
	@RequestMapping(value = "/buses", method = RequestMethod.GET)
	public Page<Bus> getAllBusesBasedOnSourceDestinationAndTravelDate(
			        @RequestParam(name="sourceCity",required=true) String sourceCity,
			        @RequestParam(name="destinationCity",required=true) String destinationCity,
					@RequestParam(name="",required=false) String travelDate,
					@RequestParam(name="",defaultValue="",required=false) String returnDate,
					@RequestParam(name="pageSize",defaultValue="5",required=false)int pageSize,
					@RequestParam(name="pageNumber",defaultValue="0",required=false)int pageNumber,
					@RequestParam(name="operatorName",defaultValue="price",required=false) String operatorName) {
		return busService.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(operatorName)));
	}
	
	@ApiOperation(value = "View register buse based on busId ", response = BusModel.class)
	@RequestMapping(value = "/buses{busId}", method = RequestMethod.GET)
	public Bus getBusById(@PathVariable Integer busId) {
		return busService.findBusById(busId);
	}
	@ApiOperation(value = "update Buse information ", response = BusModel.class)
	@RequestMapping(value = "/buses", method = RequestMethod.PUT)
	public Bus updateBus(@RequestBody Bus bus) {
		return busService.updateBus(bus);
	}

	@ApiOperation(value = "Add Bus to system ", response = BusModel.class)
	@RequestMapping(value = "/buses", method = RequestMethod.POST)
	public Bus addBus(@RequestBody Bus bus) {
		return busService.addBus(bus);
	}
	@ApiOperation(value = "Delete all register buses from system ", response = BusModel.class)
	@RequestMapping(value = "/buses", method = RequestMethod.DELETE)
	public void deleteAllBuses() {
		busService.deleteAllBuses();
	}
	@ApiOperation(value = "Delete bus based on busId ", response = BusModel.class)
	@RequestMapping(value = "/buses/{busId}", method = RequestMethod.DELETE)
	public void deleteBusById(@PathVariable Integer busId) {
		busService.deleteBusById(busId);
	}
}
