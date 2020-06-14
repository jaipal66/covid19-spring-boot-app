package com.jp.bus.booking.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="route_tb")
public class Route {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int routeId;
	private String routeName;
	private String sourceCity;
	private String destinationCity;
	
	public Route() {}
	public Route(String routeName, String sourceCity, String destinationCity) {
		super();
		this.routeName = routeName;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeName=" + routeName + ", sourceCity=" + sourceCity
				+ ", destinationCity=" + destinationCity + "]";
	}
	
	
	
	
}
