package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BusDAO;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
@Service
public class BusService {
	@Autowired
	BusDAO busDAO;
	public List<BusesDetails> findBus(int routeNo) throws ServiceException{
		List<BusesDetails> list=null;
		try {
			list=busDAO.findAllByRoute(routeNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		
		return list;
		
	}
}
