package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.busticketapp.dao.impl.BookingDetailDAOImpl;
import com.chainsys.busticketapp.dao.impl.BusDAOImpl;
import com.chainsys.busticketapp.domain.Booking;

@WebServlet("/BusBooking")
public class BusBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Booking b = new Booking();
		int rows = 0;
		BusDAOImpl bl = new BusDAOImpl();
		int UserId = Integer.parseInt(request.getParameter("userid"));
		b.setUserId(UserId);
		int BusNumber = Integer.parseInt(request.getParameter("busnumber"));
		b.setBusNum(BusNumber);
		int SeatNo = Integer.parseInt(request.getParameter("numberofseats"));
		b.setSeatNo(SeatNo);
		String Gender = (request.getParameter("gender"));
		b.setUserGender(Gender);
		String Preferences = request.getParameter("preferences");
		b.setGenderPreference(Preferences);
		LocalDate BookingDate = LocalDate.parse(request.getParameter("date"));
		b.setBookedDate(BookingDate);
		System.out.println(BookingDate);

		// int Amount = Integer.parseInt(request.getParameter("amount"));
		// b.setAmount(Amount);
		PrintWriter out = response.getWriter();
		BookingDetailDAOImpl bg = new BookingDetailDAOImpl();
		int tot = 0;
		try {
			int a = bg.findPriceByBusNumber(b.getBusNum());
			out.print(a);
			tot = b.getSeatNo() * a;
			b.setAmount(tot);
			HttpSession s = request.getSession();
			s.setAttribute("tot_amnt", tot);
			rows = bg.save(b);
			System.out.println(rows);
			response.sendRedirect("ticketsummary.jsp");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}