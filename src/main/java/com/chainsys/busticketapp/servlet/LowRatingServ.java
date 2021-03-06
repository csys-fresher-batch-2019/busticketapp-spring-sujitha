package com.chainsys.busticketapp.servlet;

import java.io.IOException;
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

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.service.OperatorsService;

@WebServlet("/LowRatingServ")

public class LowRatingServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OperatorsService operators;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		HttpSession sess = request.getSession();
		int route = (Integer) sess.getAttribute("route_no");
		Buses b = new Buses();
		try {
			List<Buses> list = new ArrayList<Buses>();
			// list = od.findAllByMinimumRatings(route,route);
			list = operators.findMinRatings(route, route);
			System.out.println(list);
			request.setAttribute("low", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("LowRating.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
