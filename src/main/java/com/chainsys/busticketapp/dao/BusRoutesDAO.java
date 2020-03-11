package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.domain.BusRoutes;
import com.chainsys.busticketapp.exception.DbException;

public interface BusRoutesDAO {
	public String findToLocationByRouteNumber(int routeNo) throws DbException;

	public void save(int routeNo, String fromLocation, String toLocation) throws DbException;

	public void updateToLocationByRouteNumber(int routeNo, String toLocation) throws DbException;

	public int findRouteByFromAndToLocations(String fromLocation, String toLocation) throws DbException;

	public List<BusRoutes> findAll() throws DbException;

	public List<BusRoutes> findFromLocation() throws DbException;

	public List<BusRoutes> findToLocations() throws DbException;

}
