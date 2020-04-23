package com.chainsys.busticketapp.dto;

import java.time.LocalDate;

public class Users {
	private String userName;
	private long userPhnNum;
	private String userGender;
	private int busNum;
	private int seatNo;
	private LocalDate bookedDate;
	private String genderPreference;
	private int amount;
	private long bookingId;
	private String status;

	public int getBusNum() {
		return busNum;
	}

	public void setBusNum(int busNum) {
		this.busNum = busNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserPhnNum() {
		return userPhnNum;
	}

	public void setUserPhnNum(long userPhnNum) {
		this.userPhnNum = userPhnNum;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public LocalDate getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getGenderPreference() {
		return genderPreference;
	}

	public void setGenderPreference(String genderPreference) {
		this.genderPreference = genderPreference;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", userPhnNum=" + userPhnNum + ", userGender=" + userGender + ", busNum="
				+ busNum + ", seatNo=" + seatNo + ", bookedDate=" + bookedDate + ", genderPreference="
				+ genderPreference + ", amount=" + amount + ", bookingId=" + bookingId + ", status=" + status + "]";
	}

}
