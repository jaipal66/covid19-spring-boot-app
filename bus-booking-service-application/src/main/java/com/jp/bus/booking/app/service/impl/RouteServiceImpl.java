package com.jp.bus.booking.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.bus.booking.app.entity.Route;
import com.jp.bus.booking.app.exceptions.RouteNotFoundException;
import com.jp.bus.booking.app.repository.RouteRepository;
import com.jp.bus.booking.app.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Override
	public Route findRouteById(int routeId) {
		return routeRepository.findById(routeId).orElseThrow(() -> new RouteNotFoundException(String.valueOf(routeId)));
	}

	@Override
	public Route addRoute(Route route) {
		return routeRepository.save(route);
	}

	@Override
	public List<Route> findAllRoutes() {
		return routeRepository.findAll();
	}

	@Override
	public Route updateRoute(Route route) {
		return routeRepository.save(route);
	}

	@Override
	public void deleteAllRoutes() {
		routeRepository.deleteAll();
	}

	@Override
	public void deleteRouteById(int routeId) {
		routeRepository.deleteById(routeId);
		
	}

}
