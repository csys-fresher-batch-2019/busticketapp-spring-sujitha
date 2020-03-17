package com.chainsys.busticketapp.dto;

public class Buses {
	private int busNum;
	private int routeNo;
private String busName; 
private String fromLocation;
private String toLocation;
	private int noOfSeats;
	private String seatType;
    private String busModel;
    private String opName;
	private  String startTime;
	private  String endTime;
	private  int fair ;
	private String ratings;
	private  int availableSeats;
	
	public int getBusNum() {
		return busNum;
	}
	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}
	
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public int getRouteNo() {
		return routeNo;
	}
	public void setRouteNo(int routeNo) {
		this.routeNo = routeNo;
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
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
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
	
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
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
		return "Buses [busNum=" + busNum + ", routeNo=" + routeNo + ", busName=" + busName + ", fromLocation="
				+ fromLocation + ", toLocation=" + toLocation + ", noOfSeats=" + noOfSeats + ", seatType=" + seatType
				+ ", busModel=" + busModel + ", opName=" + opName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", fair=" + fair + ", ratings=" + ratings + ", availableSeats=" + availableSeats + "]";
	}
	
	
	
	
	
}
