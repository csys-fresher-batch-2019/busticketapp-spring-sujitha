package com.chainsys.busticketapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.domain.TicketBooking;
import com.chainsys.busticketapp.dto.BusSeatsBooked;
import com.chainsys.busticketapp.exception.DbException;

public interface TicketBookingDAO {
	public void save(TicketBooking tic) throws DbException;

	public int findBookedSeatsByTravelID(int travelId) throws DbException;

	public int findPriceByStatus(String status) throws DbException;

	public ArrayList<BusSeatsBooked> findBookedDateAndCountSeatsByStatus(String status) throws DbException;

	public int findSeatsCountByTravelIdAndUserId(int travelId, int userId) throws DbException;

	public List<Booking> findAllByUserIdAndBookedDate(int userId) throws Exception;
}
