package com.chainsys.busticketapp.dto;

import java.time.LocalDate;

public class BusSeatsBooked {
	private int totalseats;
	private LocalDate bookedDate;

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	@Override
	public String toString() {
		return "BusSeatsBooked [totalseats=" + totalseats + ", bookedDate=" + bookedDate + "]";
	}
}
