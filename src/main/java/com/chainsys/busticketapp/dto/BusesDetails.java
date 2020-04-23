package com.chainsys.busticketapp.dto;

public class BusesDetails {
	private int busNum;
	private String busName;
	private int noOfSeats;
	private String seatType;
	private String busModel;
	private int travelId;
	private int routeNo;
	private String startTime;
	private String endTime;
	private int fair;
	private int ratings;
	private int availableSeats;

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getBusModel() {
		return busModel;
	}

	public void setBusModel(String busModel) {
		this.busModel = busModel;
	}

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

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "BusesDetails [busNum=" + busNum + ", busName=" + busName + ", noOfSeats=" + noOfSeats + ", seatType="
				+ seatType + ", busModel=" + busModel + ", travelId=" + travelId + ", routeNo=" + routeNo
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", fair=" + fair + ", ratings=" + ratings
				+ ", availableSeats=" + availableSeats + "]";
	}
}
