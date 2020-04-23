package com.chainsys.busticketapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.BookingDetailDAO;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.validator.Validator;

@Service
public class BookingService {
	@Autowired
	Validator validator;
	@Autowired
	BookingDetailDAO bookingdetailDAO;

	public int getPrice(int busNum) throws ServiceException {
		int price;
		try {
			price = bookingdetailDAO.findPriceByBusNumber(busNum);
			System.out.println(price);

		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return price;
	}

	public int addBooking(Booking b) throws ServiceException {
		int rows = 0;
		try {
			/*
			 * //b.setUserId(1); //b.setBusNum(1); String gender=null; int seatNo=0; String
			 * genderPreferences=null; String status=null; int amount=0; //LocalDate
			 * bookedDate=null; b.setUserGender(gender); b.setSeatNo(seatNo);
			 * //b.setBookedDate(bookedDate); b.setGenderPreference(genderPreferences);
			 * b.setStatus(status); b.setAmount(amount);
			 */
			validator.validateTicketBookingForm(b);
			rows = bookingdetailDAO.save(b);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return rows;
	}

	public void updateCancelTicket(String bookingId) throws ServiceException {
		try {
			bookingdetailDAO.update(bookingId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

}
