package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BusDAO;
import com.chainsys.busticketapp.domain.Bus;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;
@Repository
public class BusDAOImpl implements BusDAO {
	private static final Logger logger = LoggerFactory.getLogger(BusDAOImpl.class);

	public void save(int busNum, String busName, int noOfSeats, String seatType, String busModel, String opName)
			throws DbException {
		String sql = "insert into buslist(bus_num,bus_name,no_of_seats,seat_type,bus_model,op_name)values(?,?,?,?,?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, busNum);
			pst.setString(2, busName);
			pst.setInt(3, noOfSeats);
			pst.setString(4, seatType);
			pst.setString(5, busModel);
			pst.setString(6, opName);
			if (noOfSeats <= 10) {
				int row = pst.executeUpdate();
				logger.info("No of Rows inserted : " + row);
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO ADD DATA", e);
		}
	}

	public void updateBusNameByBusNumber(String busName, int busNum) throws DbException {
		String s = "update buslist set bus_name =? where bus_num=?";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(s);) {
			pst.setString(1, busName);
			pst.setInt(2, busNum);
			int rows = pst.executeUpdate();
			logger.info("No of Rows inserted : " + rows);
		} catch (Exception e) {
			throw new DbException("UNABLE TO UPDATE  BUS NAME", e);
		}
	}

	public String findBusNamebyBusNumber(int busNum) throws DbException {
		String name = "select bus_name from buslist where bus_num=?";
		logger.info("BusName : " + name);
		String busname = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(name);) {
			pst.setInt(1, busNum);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					busname = rs.getString("bus_name");
				}
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO FIND BUS NAME", e);
		}
		return busname;
	}

	public int findSeatsByBusNumber(int busNum) throws DbException {
		String seats = "select no_of_seats from buslist where bus_num=?";
		logger.info("No Of Seats: " + seats);
		int seat = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(seats);) {
			pst.setInt(1, busNum);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					seat = rs.getInt("no_of_seats");
				}
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return seat;
	}

	public List<Bus> findAll() throws DbException {
		List<Bus> list = new ArrayList<Bus>();
		String sql = "select*from buslist";
		logger.info("BusList : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Bus bl = new Bus();
					bl.setBusNum(rs.getInt("bus_num"));
					bl.setBusName(rs.getString("bus_name"));
					bl.setNoOfSeats(rs.getInt("no_of_seats"));
					bl.setSeatType(rs.getString("seat_type"));
					list.add(bl);
				}
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO FIND BUS", e);
		}
		return list;
	}

	public List<BusesDetails> findAllByRoute(int routeNo) throws DbException {
		List<BusesDetails> list1 = new ArrayList<BusesDetails>();
		String sql = "select b.bus_num,bl.bus_name,bl.no_of_seats,bl.seat_type,bl.bus_model,b.start_time,b.end_time,b.fair,b.ratings,b.available_seats from buslist bl,busdetails b where bl.bus_num=b.bus_num and b.route_no=?";
		logger.info("Buslist : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, routeNo);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusesDetails b = new BusesDetails();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getInt("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list1.add(b);
				}
			}
		} catch (Exception e) {
			throw new DbException("UNABLE TO SELECT DATA", e);
		}
		return list1;
	}

	public int findSeatsByBusNumber(int busNum, LocalDate bookedDate) throws DbException {
		String s = "select (no_of_seats - ( select nvl(sum(seat_no),0) from booking bg where bg.bus_num = bl.bus_num and booked_date= ? )) as no_of_seats from buslist bl where bus_num =?";
		logger.info("No Of Seats : " + s);
		int noOfSeat = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(s);) {
			Date d = Date.valueOf(bookedDate);
			pst.setDate(1, d);
			pst.setInt(2, busNum);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				noOfSeat = rs.getInt("no_of_seats");
			}
			logger.info("No Of Seats : " + noOfSeat);
		} catch (Exception e) {
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return noOfSeat;
	}
}
