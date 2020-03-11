package com.chainsys.busticketapp.domain;

import java.time.LocalDate;

public class TicketBooking {
	private int travelId;
	private int noOfSeatsBooked;
	private int userId;
	private int fair;
	private LocalDate jDate;
	private LocalDate bookedDate;
	private int payment;
	private String status;

	public int getTravelId() {
		return travelId;
	}

	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}

	public int getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}

	public void setNoOfSeatsBooked(int noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFair() {
		return fair;
	}

	public void setFair(int fair) {
		this.fair = fair;
	}

	public LocalDate getjDate() {
		return jDate;
	}

	public void setjDate(LocalDate jDate) {
		this.jDate = jDate;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TicketBooking [travelId=" + travelId + ", noOfSeatsBooked=" + noOfSeatsBooked + ", userId=" + userId
				+ ", fair=" + fair + ", jDate=" + jDate + ", bookedDate=" + bookedDate + ", payment=" + payment
				+ ", status=" + status + "]";
	}

}
