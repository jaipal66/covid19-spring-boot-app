package com.jp.bus.booking.app.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="bus_tb")
public class Bus {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String busNumber;
	private String operatorName;
	private String departure;
	private String arrival;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	@ManyToOne
	private Route route;
	
	@ManyToMany(mappedBy = "buses", fetch = FetchType.LAZY)
	private Set<BusBooking> bookings;

	public Bus() {
	}

	public Bus(String busNumber, String operatorName, String departure, String arrival, LocalDateTime departureTime,
			LocalDateTime arrivalTime, Set<BusBooking> bookings) {
		super();
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.bookings = bookings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Set<BusBooking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<BusBooking> bookings) {
		this.bookings = bookings;
	}

	
	@Override
	public String toString() {
		return "Bus [id=" + id + ", busNumber=" + busNumber + ", operatorName=" + operatorName + ", departure="
				+ departure + ", arrival=" + arrival + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", bookings=" + bookings + "]";
	}

	
}
