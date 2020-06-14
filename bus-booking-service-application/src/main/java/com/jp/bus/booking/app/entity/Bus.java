package com.jp.bus.booking.app.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="bus_tb")
public class Bus {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int busId;
	private String busNumber;
	private String operatorName;
	private String departure;
	private LocalDateTime arrivalTime;
	private LocalDateTime deratureTime;
	private int price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="routeId",referencedColumnName="routeId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Route route;
	
	public Bus() {}

	public Bus(String busNumber, String operatorName, String departure, LocalDateTime arrivalTime,
			LocalDateTime deratureTime, int price, Route route) {
		super();
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.departure = departure;
		this.arrivalTime = arrivalTime;
		this.deratureTime = deratureTime;
		this.price = price;
		this.route = route;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDeratureTime() {
		return deratureTime;
	}

	public void setDeratureTime(LocalDateTime deratureTime) {
		this.deratureTime = deratureTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busNumber=" + busNumber + ", operatorName=" + operatorName + ", departure="
				+ departure + ", arrivalTime=" + arrivalTime + ", deratureTime=" + deratureTime + ", price=" + price
				+ ", route=" + route + "]";
	}
	
	
	
	
}
