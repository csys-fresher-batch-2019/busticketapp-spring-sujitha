package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.BusRoutesDAO;
import com.chainsys.busticketapp.domain.BusRoutes;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;
@Repository
public class BusRoutesDAOImpl implements BusRoutesDAO {
	private static final Logger logger = LoggerFactory.getLogger(BusRoutesDAOImpl.class);

	public String findToLocationByRouteNumber(int routeNo) throws DbException {
		String s = "select to_location from busroutes where route_no=?";
		logger.info("ToLocation : " + s);
		String location = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(s);) {
			pst.setInt(1, routeNo);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					location = rs.getString("to_location");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND TO LOCATION", e);
		}
		return location;
	}

	public void save(int routeNo, String fromLocation, String toLocation) throws DbException {
		String st = "insert into busroutes(route_no,from_location,to_location)values(?,?,?)";
		logger.info("Rows : " + st);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(st);) {
			pst.setInt(1, routeNo);
			pst.setString(2, fromLocation);
			pst.setString(3, toLocation);
			int row = pst.executeUpdate();
			logger.info("No of Rows: " + st);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO ADD ROUTES", e);
		}
	}

	public void updateToLocationByRouteNumber(int routeNo, String toLocation) throws DbException {
		String n = "update busroutes set to_location=? where route_no=?";
		logger.info("Update : " + n);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(n);) {
			pst.setString(1, toLocation);
			pst.setInt(2, routeNo);
			int row = pst.executeUpdate();
			logger.info("No Of Rows : " + row);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO UPDATE TO LOCATION", e);
		}
	}

	public int findRouteByFromAndToLocations(String fromLocation, String toLocation) throws DbException {
		String sql = "select route_no from busroutes where from_location =? and to_location=?";
		logger.info("Routes: " + sql);
		int route = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, fromLocation);
			pst.setString(2, toLocation);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					route = rs.getInt("route_no");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO ROUTE NO", e);
		}
		return route;
	}

	public List<BusRoutes> findAll() throws DbException {
		String sql = "select * from busroutes";
		logger.info("Routes: " + sql);
		List<BusRoutes> busroutes = new ArrayList<BusRoutes>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusRoutes br = new BusRoutes();
					int routeNo1 = rs.getInt("route_no");
					String fromLocation1 = rs.getString("from_location");
					String toLocation1 = rs.getString("to_location");
					br.setRouteNo(routeNo1);
					br.setFromLocation(fromLocation1);
					br.setToLocation(toLocation1);
					busroutes.add(br);
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND ROUTES", e);
		}
		return busroutes;
	}

	public List<BusRoutes> findFromLocation() throws DbException {
		String sql = "select distinct from_location from busroutes ";
		logger.info("From Location: " + sql);
		List<BusRoutes> busroutes = new ArrayList<BusRoutes>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusRoutes br = new BusRoutes();
					String fromLocation1 = rs.getString("from_location");
					br.setFromLocation(fromLocation1);
					busroutes.add(br);
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FROM LOCATION", e);
		}
		return busroutes;
	}

	public List<BusRoutes> findToLocations() throws DbException {
		String sql = "select distinct to_location from busroutes ";
		logger.info("To Location: " + sql);
		List<BusRoutes> busroutes = new ArrayList<BusRoutes>();
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					BusRoutes br = new BusRoutes();
					String toLocation1 = rs.getString("to_location");
					br.setToLocation(toLocation1);
					busroutes.add(br);
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND TO LOCATION", e);
		}
		return busroutes;
	}

}
