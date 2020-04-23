package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.service.SeatService;
import com.chainsys.busticketapp.util.DbConnection;

public class SeatDAOImpl {
	private static final Logger logger = LoggerFactory.getLogger(SeatDAOImpl.class);

	public int findSeatsByBusNumber(int BusNum) throws DbException {
		String s = "select seat_no from booking where bus_num=?";
		logger.info("Seats : " + s);
		int b = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		int c = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(s);) {
			pst.setInt(1, BusNum);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					b = rs.getInt("seat_no");
					c++;
					l.add(b);
					logger.info("List : " + b);
				}
				logger.info("Count : " + c);
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND SEAT NO", e);
		}
		return c;
	}

	public int findTotalSeatsByBusNumber(int BusNum) throws DbException {
		String s = "select no_of_seats from buslist where bus_num=?";
		logger.info("No Of Seats : " + s);
		int seats = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(s);) {
			pst.setInt(1, BusNum);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					seats = rs.getInt("no_of_seats");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return seats;
	}

	public ArrayList<Integer> findUnFilledSeatsByBusNumberAndBookedDate(LocalDate bookedDate, int busNum)
			throws DbException {
		String sql = "select min_seat_no -1+level missing_number from (select min(1) min_seat_no,max(10) max_seat_no from booking)connect by  level <=max_seat_no-min_seat_no+1 minus select seat_no  as available_seats from booking where bus_num=? and booked_date=?";
		logger.info("Seats : " + sql);
		ArrayList<Integer> unSeats = new ArrayList<Integer>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, busNum);
			pst.setDate(2, Date.valueOf(bookedDate));
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					unSeats.add(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND UNFILLED SEATS", e);
		}
		return unSeats;
	}

	public HashMap<String, String> findSeatsByBookedDateAndBusNumberAndSeatNumber(int busNum, int seatNo,
			LocalDate bookedDate) throws DbException {
		String sql = "select user_gender,gender_preferences from booking where booked_date=? and bus_num=? and seat_no=? ";
		SeatService s = new SeatService();
		HashMap<String, String> hm = new HashMap<String, String>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			int previousSeatNo = s.getUnFiledSeats(busNum, seatNo, bookedDate);
			pst.setDate(1, Date.valueOf(bookedDate));
			pst.setInt(2, busNum);
			pst.setInt(3, previousSeatNo);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					hm.put(rs.getString("user_gender"), rs.getString("gender_preferences"));
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND GENDER,GENDER PREFEERNCES", e);
		}
		return (hm);

	}
}
