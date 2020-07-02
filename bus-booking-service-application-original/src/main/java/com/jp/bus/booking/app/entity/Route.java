package com.jp.bus.booking.app.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="route_tb")
public class Route {

	@Id
	private String routeId;
	private String sourceStation;
	private String destinationStop;
	
	@OneToMany
	private Set<Bus> buses;
	
	public Route() {}
	public Route(String sourceStation, String destinationStop) {
		super();
		this.sourceStation = sourceStation;
		this.destinationStop = destinationStop;
	}
	
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}
	public String getDestinationStop() {
		return destinationStop;
	}
	public void setDestinationStop(String destinationStop) {
		this.destinationStop = destinationStop;
	}
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", sourceStation=" + sourceStation + ", destinationStop=" + destinationStop
				+ "]";
	}
	
	
	
}
