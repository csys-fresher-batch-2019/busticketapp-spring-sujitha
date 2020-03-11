package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.busticketapp.dao.OperatorsDetailsDAO;
import com.chainsys.busticketapp.domain.Admin;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;

public class OperatorsDetailsDAOImpl implements OperatorsDetailsDAO {
	private static final Logger logger = LoggerFactory.getLogger(OperatorsDetailsDAOImpl.class);

	@Override
	public List<Buses> findAllByOperatorName(String opName) throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select  bl.bus_num,bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bl.bus_num in(select bus_num from buslist where op_name=?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, opName);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Buses> findAllByBusName(String busName) throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num, bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bl.bus_num in(select bus_num from buslist where bus_name=?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, busName);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;

	}

	@Override
	public List<Buses> findAllByBusModel(String busModel) throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num,bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bl.bus_num in(select bus_num from buslist where bus_model=?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, busModel);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Buses> findAllByMinimumRatings() throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num, bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bd.ratings in(select min(ratings) from busdetails)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Buses> findAllByMaximumRatings() throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num,bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bd.ratings in(select max(ratings) from busdetails)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Buses> findAllByMinimumPrice() throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num,bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bd.fair in(select min(fair) from busdetails)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public List<Buses> findAllByMaximumPrice() throws DbException {
		List<Buses> list = new ArrayList<Buses>();
		String sql = "select bl.bus_num,bl.bus_name,br.from_location,br.to_location,bl.no_of_seats, bl.seat_type,bl.bus_model,bd.start_time,bd.end_time,bd.fair,bd.ratings,bd.available_seats from buslist bl,busdetails bd,busroutes br where bl.bus_num=bd.bus_num and br.route_no=bd.route_no and bd.fair in(select max(fair) from busdetails)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					Buses b = new Buses();
					b.setBusNum(rs.getInt("bus_num"));
					b.setBusName(rs.getString("bus_name"));
					b.setFromLocation(rs.getString("from_location"));
					b.setToLocation(rs.getString("to_location"));
					b.setNoOfSeats(rs.getInt("no_of_seats"));
					b.setSeatType(rs.getString("seat_type"));
					b.setBusModel(rs.getString("bus_model"));
					b.setStartTime(rs.getString("start_time"));
					b.setEndTime(rs.getString("end_time"));
					b.setFair(rs.getInt("fair"));
					b.setRatings(rs.getString("ratings"));
					b.setAvailableSeats(rs.getInt("available_seats"));
					list.add(b);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}

	@Override
	public int findOperatorIdByOperatorMailIdAndPassword(String operatorEmailId, String operatorPassword)
			throws DbException {
		String sql = "select op_id from operator where op_email=?and op_password=?";
		Admin a = new Admin();
		int v = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, operatorEmailId);
			pst.setString(2, operatorPassword);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					v = rs.getInt("op_id");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return v;
	}

	@Override
	public void save(OperatorsDetails operator) throws DbException {
		List<OperatorsDetails> list = new ArrayList<OperatorsDetails>();
		String sql = "insert into operator(op_id,op_name,op_email,op_phn,op_password)values(op_id.nextval,?,?,?,?)";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, operator.getOperatorName());
			pst.setString(2, operator.getOperatorEmailId());
			pst.setString(3, operator.getOperatorPhoneNumber());
			pst.setString(4, operator.getOperatorPassword());
			int rows = pst.executeUpdate();
			logger.info("No of Rows inserted : " + rows);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_ADD);
		}
	}

	@Override
	public List<OperatorsDetails> findOperatorName() throws DbException {
		List<OperatorsDetails> list = new ArrayList<OperatorsDetails>();
		String sql = "select op_name from operator";
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					OperatorsDetails o = new OperatorsDetails();
					o.setOperatorName(rs.getString("op_name"));
					list.add(o);
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			throw new DbException(ErrorConstant.INVALID_SELECT);
		}
		return list;
	}
}
