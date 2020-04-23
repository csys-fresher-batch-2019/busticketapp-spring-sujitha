package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.TicketBookingDAO;
import com.chainsys.busticketapp.dao.impl.TicketBookingDAOImpl;
import com.chainsys.busticketapp.domain.Booking;
import com.chainsys.busticketapp.service.TicketBookingService;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/DisplayBookedUserDetails")

public class DisplayBookedUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();
	@Autowired
	private TicketBookingService ticketbooking;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketBookingDAOImpl tbi = new TicketBookingDAOImpl();
		List<Booking> list = new ArrayList<Booking>();
		Booking b = new Booking();
		HttpSession sess = request.getSession();
		Integer userId = (Integer) sess.getAttribute("userid");
		Integer amount = (Integer) sess.getAttribute("amount");
		PrintWriter out = response.getWriter();
		out.println(userId);
		try {
			// list = tbi.findAllByUserIdAndBookedDate(userId);
			list = ticketbooking.findBookedUserDetails(userId);
			out.println("TicketS:" + list);
			request.setAttribute("users_display", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("BookingUsersDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
