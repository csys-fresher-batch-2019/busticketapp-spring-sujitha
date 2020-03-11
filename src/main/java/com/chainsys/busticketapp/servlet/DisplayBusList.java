package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.busticketapp.dao.impl.BusListDAOImpl;
import com.chainsys.busticketapp.dao.impl.BusRoutesDAOImpl;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/DisplayBusList")

public class DisplayBusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("FromLocation");
		String to = request.getParameter("ToLocation");
		LocalDate Date = LocalDate.parse(request.getParameter("date"));
		System.out.println("Display:" + from + "-" + to);
		BusRoutesDAOImpl bi = new BusRoutesDAOImpl();
		try {
			int routeNo = bi.findRouteByFromAndToLocations(from, to);
			System.out.println("routeNo: " + routeNo);
			BusListDAOImpl bli = new BusListDAOImpl();
			List<BusesDetails> list1 = new ArrayList<BusesDetails>();
			list1 = bli.findAllByRoute(routeNo);
			request.setAttribute("Bus_list", list1);
			System.out.println(list1);
			HttpSession sess = request.getSession();
			sess.setAttribute("date", Date);
			sess.setAttribute("route_no", routeNo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("BusListDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}
