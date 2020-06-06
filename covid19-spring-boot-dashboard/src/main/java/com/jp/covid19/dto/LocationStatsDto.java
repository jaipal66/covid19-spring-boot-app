package com.jp.covid19.dto;

public class LocationStatsDto {
	
	private String country;
	private String state;
	private int latestTotalCases;
	private int chnagesFromYesterday;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(int latestTotalCases) {
		this.latestTotalCases = latestTotalCases;
	}
	public int getChnagesFromYesterday() {
		return chnagesFromYesterday;
	}
	public void setChnagesFromYesterday(int chnagesFromYesterday) {
		this.chnagesFromYesterday = chnagesFromYesterday;
	}
	@Override
	public String toString() {
		return "LocationStatsDto {country=" + country + ", state=" + state + ", latestTotalCases=" + latestTotalCases
				+ ", chnagesFromYesterday=" + chnagesFromYesterday + "}";
	}
	
	
	

}
