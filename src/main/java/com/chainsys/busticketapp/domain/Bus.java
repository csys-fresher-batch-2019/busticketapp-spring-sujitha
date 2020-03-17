package com.chainsys.busticketapp.domain;

public class Bus {
	private int busNum;
	private String busName;
	private int noOfSeats;
	private String seatType;
	private String busModel;
	private String operatorName;

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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	@Override
	public String toString() {
		return "Bus [busNum=" + busNum + ", busName=" + busName + ", noOfSeats=" + noOfSeats + ", seatType=" + seatType
				+ ", busModel=" + busModel + ", operatorName=" + operatorName + "]";
	}

}