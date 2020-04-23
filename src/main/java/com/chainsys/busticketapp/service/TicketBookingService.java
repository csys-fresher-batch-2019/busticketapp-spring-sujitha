package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.TicketBookingDAO;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;

@Service
public class TicketBookingService {
	@Autowired
	TicketBookingDAO ticketbookingDAO;

	public List<Booking> findBookedUserDetails(int userId) throws ServiceException {
		List<Booking> list = null;
		try {
			list = ticketbookingDAO.findAllByUserIdAndBookedDate(userId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
