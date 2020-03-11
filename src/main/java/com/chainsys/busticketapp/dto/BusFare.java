package com.chainsys.busticketapp.dto;

public class BusFare {

	private String busName;
	
	private int fare;

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "BusFare [busName=" + busName + ", fare=" + fare + "]";
	}
}
