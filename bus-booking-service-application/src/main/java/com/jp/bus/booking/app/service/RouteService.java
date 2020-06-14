package com.jp.bus.booking.app.service;

import java.util.List;

import com.jp.bus.booking.app.entity.Route;

public interface RouteService {

	public Route addRoute(Route route);

	public Route findRouteById(int routeId);

	public List<Route> findAllRoutes();

	public Route updateRoute(Route route);

	public void deleteAllRoutes();

	public void deleteRouteById(int routeId);

}
