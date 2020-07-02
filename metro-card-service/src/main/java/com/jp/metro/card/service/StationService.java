package com.jp.metro.card.service;

import com.jp.metro.card.entity.Station;

public interface StationService {

	Station getAllStations();
	Station getStationByName(String stationName);
	Station getStationByID(String stationID);
	void addStation(Station station);
	void removeStation(String stationID);
	void updateStation(Station station);
	
	
	
}
