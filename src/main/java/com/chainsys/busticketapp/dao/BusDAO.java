package com.chainsys.busticketapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.busticketapp.domain.Bus;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.exception.DbException;

public interface BusDAO {
	public void save(int busNum, String busName, int noOfSeats, String seatType, String busModel, String opName)
			throws DbException;

	public void updateBusNameByBusNumber(String busName, int busNum) throws DbException;

	public String findBusNamebyBusNumber(int busNum) throws DbException;

	public int findSeatsByBusNumber(int busNum) throws DbException;

	public List<Bus> findAll() throws DbException;

	public List<BusesDetails> findAllByRoute(int routeNo) throws DbException;

	public int findSeatsByBusNumber(int busNum, LocalDate bookedDate) throws DbException;
}
