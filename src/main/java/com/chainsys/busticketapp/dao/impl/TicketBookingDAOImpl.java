package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.TicketBookingDAO;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.domain.TicketBooking;
import com.chainsys.busticketapp.dto.BusSeatsBooked;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.util.DbConnection;

@Repository
public class TicketBookingDAOImpl implements TicketBookingDAO {
	private static final Logger logger = LoggerFactory.getLogger(TicketBookingDAOImpl.class);

	public void save(TicketBooking tic) throws DbException {
		String sql = "insert into ticket_booking(travel_id,no_of_seats_booked,user_id,fair,j_date,booked_date,payment,status) values(?,?,?,?,?,?,?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, tic.getTravelId());
			pst.setInt(2, tic.getNoOfSeatsBooked());
			pst.setInt(3, tic.getUserId());
			pst.setInt(4, tic.getFair());
			pst.setDate(5, Date.valueOf(tic.getjDate()));
			pst.setDate(6, Date.valueOf(tic.getBookedDate()));
			pst.setInt(7, tic.getPayment());
			pst.setString(8, tic.getStatus());
			int row = pst.executeUpdate();
			logger.info("No of Rows: " + row);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO ADD DATA", e);
		}
	}

	public int findBookedSeatsByTravelID(int travelId) throws DbException {
		String n = " select sum(no_of_seats_booked) no_of_seats_booked from ticket_booking where travel_id=? ";
		logger.info("Booked Seats: " + n);
		int bookedseats = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(n);) {
			pst.setInt(1, travelId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					bookedseats = rs.getInt("no_of_seats_booked");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return bookedseats;
	}

	public int findPriceByStatus(String status) throws DbException {
		String sql = "select sum(payment) as payment from ticket_booking where status=?";
		logger.info("Payment : " + sql);
		int price = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, status);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					price = rs.getInt("payment");
				}
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO FIND PRICE", e);
		}
		return price;
	}

	public ArrayList<BusSeatsBooked> findBookedDateAndCountSeatsByStatus(String status) throws DbException {
		String sql = "select booked_date,count(no_of_seats_booked) as total_seats from ticket_booking where status= ? group by booked_date";
		logger.info("Count: " + sql);
		ArrayList<BusSeatsBooked> list = new ArrayList<BusSeatsBooked>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, status);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					int s = rs.getInt("total_seats");
					Date si = rs.getDate("booked_date");
					LocalDate ld = si.toLocalDate();
					BusSeatsBooked bsd = new BusSeatsBooked();
					bsd.setTotalseats(s);
					bsd.setBookedDate(ld);
					list.add(bsd);
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND DATE,SEATS", e);
		}
		return list;
	}

	public int findSeatsCountByTravelIdAndUserId(int travelId, int userId) throws DbException {
		String sql = "select  count(b.seat_no) as ticket_count from booking b  where travel_id=?  and user_id=?";
		logger.info("SeatNo : " + sql);
		int seats = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, travelId);
			pst.setInt(2, userId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					seats = rs.getInt("ticket_count");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return seats;
	}

	public List<Booking> findAllByUserIdAndBookedDate(int userId) throws DbException {
		List<Booking> list = new ArrayList<Booking>();
		String sql = "select * from booking where user_id=? order by booked_date desc";
		logger.info("Booking Details : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Booking bl = new Booking();
					bl.setBookingId(rs.getLong("booking_id"));
					bl.setBusNum(rs.getInt("bus_num"));
					bl.setUserId(rs.getInt("user_id"));
					bl.setUserGender(rs.getString("user_gender"));
					bl.setSeatNo(rs.getInt("seat_no"));
					Date id = rs.getDate("booked_date");
					if (id != null) {
						LocalDate ld = id.toLocalDate();
						bl.setBookedDate(ld);
					}
					bl.setGenderPreference(rs.getString("gender_preferences"));
					Date d = rs.getDate("created_date");
					LocalDate d1 = d.toLocalDate();
					bl.setCreatedDate(d1);
					bl.setStatus(rs.getString("status"));
					bl.setAmount(rs.getInt("amount"));
					list.add(bl);
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND DATA", e);
		}
		return list;
	}

	public void save(int busNum, String busName, int noOfSeats, String seatType, String busModel, String opName)
			throws DbException {
		String sql = "insert into seater(bus_num,seat_type,right_window_seat,right_center_seat,left_window_seat,left_center_seat)values(?,?,?,?,?,?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, busNum);
			pst.setString(2, seatType);
			String RightWindowSeat = null;
			pst.setString(3, RightWindowSeat);
			String RightCenteSeat = null;
			pst.setString(4, RightCenteSeat);
			String LeftWindowSeat = null;
			pst.setString(5, LeftWindowSeat);
			String LeftCenterSeat = null;
			pst.setString(6, LeftCenterSeat);
			int totalSeats = 0;
			pst.setInt(7, totalSeats);
			if (seatType.equals("seater") && totalSeats <= 20) {
				int row = pst.executeUpdate();
				logger.info("No of Rows inserted : " + row);
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO ADD DATA", e);
		}
	}

}
