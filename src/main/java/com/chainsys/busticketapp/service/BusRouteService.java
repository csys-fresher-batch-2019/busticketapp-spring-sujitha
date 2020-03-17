package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BusRoutesDAO;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
@Service
public class BusRouteService {
	@Autowired
    BusRoutesDAO busroutesDAO;
	public int findRoutes( String fromLocation, String toLocation) throws ServiceException {
		int route=0;
		try {
			route=busroutesDAO.findRouteByFromAndToLocations(fromLocation, toLocation);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return route;
		}
}
