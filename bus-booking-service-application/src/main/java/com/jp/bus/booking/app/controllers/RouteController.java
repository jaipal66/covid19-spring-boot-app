package com.jp.bus.booking.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.bus.booking.app.entity.Route;
import com.jp.bus.booking.app.service.RouteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("API to manage all route endpoints")
public class RouteController {
	
	@Autowired
	private RouteService routeService;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value = "View All Register Routes ", response = Route.class)
		

	@RequestMapping(value = "/routes", method = RequestMethod.GET)
	public List<Route> getAllBuses() {
		return routeService.findAllRoutes();
	}

	@ApiOperation(value = "View route based on routeId ", response = Route.class)
	@RequestMapping(value = "/routes{routeId}", method = RequestMethod.GET)
	public Route getRouteById(@PathVariable Integer routeId) {
		return routeService.findRouteById(routeId);
	}

	@ApiOperation(value = "Update route ", response = Route.class)
	@RequestMapping(value = "/routes", method = RequestMethod.PUT)
	public Route updateRoute(@RequestBody Route route) {
		return routeService.updateRoute(route);
	}

	@ApiOperation(value = "Add route ", response = Route.class)
	@RequestMapping(value = "/routes", method = RequestMethod.POST)
	public Route addRoute(@RequestBody Route route) {
		return routeService.addRoute(route);
	}

	@ApiOperation(value = "Delete all routes ", response = Route.class)
	@RequestMapping(value = "/routes", method = RequestMethod.DELETE)
	public void deleteAllBuses() {
		routeService.deleteAllRoutes();
	}

	@ApiOperation(value = "Delete route based on routeId", response = Route.class)
	@RequestMapping(value = "/routes/{routeId}", method = RequestMethod.DELETE)
	public void deleteBusById(@PathVariable Integer routeId) {
		routeService.deleteRouteById(routeId);
	}

}
