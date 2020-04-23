package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.BookingDetailDAO;
import com.chainsys.busticketapp.dao.impl.BookingDetailDAOImpl;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.service.BookingService;

@WebServlet("/CancelTicketServlet")

public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private BookingService booking;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookingId = request.getParameter("bookingId");
		System.out.println(bookingId);
		BookingDetailDAO bookingDeatilsDAO = new BookingDetailDAOImpl();
		try {
			// bookingDeatilsDAO.update(bookingId);
			booking.updateCancelTicket(bookingId);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print("Your Ticeket is successfully cancelled");
	}
}
