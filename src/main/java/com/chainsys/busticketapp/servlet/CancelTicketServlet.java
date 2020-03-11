package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.busticketapp.dao.BookingDeatilsDAO;
import com.chainsys.busticketapp.dao.impl.BookingDetailDAOImpl;
import com.chainsys.busticketapp.exception.DbException;

@WebServlet("/CancelTicketServlet")

public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookingId = request.getParameter("bookingId");
		System.out.println(bookingId);
		BookingDeatilsDAO bookingDeatilsDAO = new BookingDetailDAOImpl();
		try {
			bookingDeatilsDAO.update(bookingId);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print("Your Ticeket is successfully cancelled");
	}
}
