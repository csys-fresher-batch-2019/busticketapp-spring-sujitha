package com.chainsys.busticketapp.dao;

import java.time.LocalDate;
import java.util.HashMap;

import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.exception.DbException;

public interface BookingDeatilsDAO {

	public int findbyBookedDateAndBusNumber(LocalDate bookedDate, int BusNum) throws DbException;

	public Booking findbyBookedDateAndBusNumberAndSeatNo(LocalDate bookedDate, int BusNum, int seatNo) throws DbException;

	public HashMap<Integer, String> findByBusNumber(int busNum) throws DbException;

	public int addUserBookingDetails(Booking booking) throws DbException;

	public int save(Booking booking, int seatNo) throws DbException;

	public int bookUnfilledSeats(Booking booking) throws DbException;

	public void update(String bookingId) throws DbException;
}
