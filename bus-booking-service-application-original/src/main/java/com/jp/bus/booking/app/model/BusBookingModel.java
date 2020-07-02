package com.jp.bus.booking.app.model;

import java.util.List;

public class BusBookingModel {

	private String id;
	private PassengerModel passenger;
	private List<BusModel> buses;

	public BusBookingModel(String id, PassengerModel passenger, List<BusModel> buses) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.buses = buses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PassengerModel getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerModel passenger) {
		this.passenger = passenger;
	}

	public List<BusModel> getBuses() {
		return buses;
	}

	public void setBuses(List<BusModel> buses) {
		this.buses = buses;
	}

}
