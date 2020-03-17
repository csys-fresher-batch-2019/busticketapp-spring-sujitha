package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.busticketapp.dao.BusDetailsDAO;
import com.chainsys.busticketapp.domain.BusDetails;
import com.chainsys.busticketapp.dto.BusFare;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;

public class BusDetailsDAOImpl implements BusDetailsDAO {
	private static final Logger logger = LoggerFactory.getLogger(BusDetailsDAOImpl.class);

	public void updateprice(int fair, int travelId) throws DbException {
		String strr = "update busdetails set fair =?where travel_id=?";
		logger.info("BusDetails : " + strr);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(strr);) {
			pst.setInt(1, fair);
			pst.setInt(2, travelId);
			int rows = pst.executeUpdate();
			logger.info("No Of Rows : " + rows);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO UPDATE FARE", e);
		}
	}

	public int findAvailbleSeatsByTravelId(int travelId) throws DbException {
		String sql = "select (bl.no_of_seats-bd.available_seats)availableSeats from  buslist bl,busdetails bd where bl.bus_num=bd.bus_num and bd.travel_id=?";
		logger.info("Seats : " + sql);
		int availableseats = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, travelId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					availableseats = rs.getInt("availableseats");
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO FIND SEATS", e);
		}
		return availableseats;
	}

	public void save(BusDetails bus) throws DbException {
		String sql = "insert into busdetails(travel_id,route_no,bus_num,travel_date,start_time,end_time,fair,available_seats)values(?,?,?,?,?,?,?,?)";
		logger.info("No Of Rows : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, bus.getTravelId());
			pst.setInt(2, bus.getRouteNo());
			pst.setInt(3, bus.getBusNum());
			pst.setDate(4, Date.valueOf(bus.getTravelDate()));
			pst.setString(5, bus.getStartTime().toString());
			pst.setString(6, bus.getEndTime().toString());
			pst.setInt(7, bus.getFair());
			pst.setInt(8, bus.getAvailableSeats());
			int rows = pst.executeUpdate();
			logger.info("No Of Rows : " + rows);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO ADD DATA", e);
		}
	}

	public int findPriceByTravelId(int travelId) throws DbException {
		String sql = "select fair as f  from busdetails where travel_id=?";
		logger.info("Price : " + sql);
		int price = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, travelId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					price = rs.getInt("f");
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO FIND FARE", e);
		}
		return price;
	}

	public ArrayList<BusFare> findBusNameAndPriceByBusNumber(String busName) throws DbException {
		ArrayList<BusFare> busfares = new ArrayList<BusFare>();
		String sql = "select buslist.bus_name, busdetails.fair from buslist inner join busdetails on buslist.bus_num = busdetails.bus_num";
		logger.info("BusDetails : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusFare bd = new BusFare();
					String name = rs.getString("bus_name");
					int fare = rs.getInt("fair");
					bd.setBusName(name);
					bd.setFare(fare);
					busfares.add(bd);
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO FIND BUS NAME AND FARE", e);
		}
		return busfares;
	}

	public String findBusNameByToLocation(String toLocation) throws DbException {
		String sql = "select bus_name,no_of_seats from buslist where bus_num=(select bus_num from busdetails where route_no = (select route_no from busroutes where to_location= ? ))";
		logger.info("List: " + sql);
		String e1 = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, toLocation);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					e1 = rs.getString("bus_name");
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO FIND BUS NAME,SEATS", e);
		}
		return e1;
	}

	public List<BusDetails> findTimingAndPriceByBusNumber(BusDetails bus) throws DbException {
		ArrayList<BusDetails> busdetails = new ArrayList<BusDetails>();
		String sql = "select start_time,end_time,fair from busdetails where bus_num=?";
		logger.info("Time and Price : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, bus.getBusNum());
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusDetails bl = new BusDetails();
					bl.setStartTime(rs.getString("start_time"));
					bl.setEndTime(rs.getString("end_time"));
					bl.setFair(rs.getInt("fair"));
					busdetails.add(bl);
				}
			}
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			throw new DbException("UNABLE TO FIND TIMINGS", e);
		}
		return busdetails;
	}
}
