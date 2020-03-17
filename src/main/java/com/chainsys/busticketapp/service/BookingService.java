package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BookingDetailDAO;
import com.chainsys.busticketapp.exception.ServiceException;

@Service
public class BookingService {
	@Autowired
	BookingDetailDAO bookingdetaildao; 
	public int getPriceByBusNum() throws ServiceException {
		return 0;

	}
	
}
