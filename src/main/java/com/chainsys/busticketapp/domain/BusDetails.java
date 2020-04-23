package com.chainsys.busticketapp.domain;

import java.time.LocalDate;

public class BusDetails {
	private int travelId;
	private int routeNo;
	private int busNum;
	private LocalDate travelDate;
	private String startTime;
	private String endTime;
	private int fair;
	private int availableSeats;
	private int ratings;

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public int getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
	}

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getFair() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair = fair;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "BusDetails [travelId=" + travelId + ", routeNo=" + routeNo + ", busNum=" + busNum + ", travelDate="
				+ travelDate + ", startTime=" + startTime + ", endTime=" + endTime + ", fair=" + fair
				+ ", availableSeats=" + availableSeats + ", ratings=" + ratings + "]";
	}

}
