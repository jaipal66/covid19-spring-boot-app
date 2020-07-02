package com.jp.bus.booking.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bus_station_tb")
public class BusStation {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String busStationId;
	private String name;

	public BusStation() {
	}

	public BusStation(String stationName) {
		this.name = stationName;
	}

	public String getBusStationId() {
		return busStationId;
	}

	public void setBusStationId(String busStationId) {
		this.busStationId = busStationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
