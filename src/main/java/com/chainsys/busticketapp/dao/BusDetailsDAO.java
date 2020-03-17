package com.chainsys.busticketapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.chainsys.busticketapp.domain.BusDetails;
import com.chainsys.busticketapp.dto.BusFare;
import com.chainsys.busticketapp.exception.DbException;

public interface BusDetailsDAO<Details> {
	public void updateprice(int fair, int travelId) throws DbException;

	public int findAvailbleSeatsByTravelId(int travelId) throws DbException;

	public void save(BusDetails bus) throws DbException;

	public int findPriceByTravelId(int travelId) throws DbException;

	public ArrayList<BusFare> findBusNameAndPriceByBusNumber(String busName) throws DbException;

	public String findBusNameByToLocation(String toLocation) throws DbException;

	public List<BusDetails> findTimingAndPriceByBusNumber(BusDetails bus) throws DbException;
}
