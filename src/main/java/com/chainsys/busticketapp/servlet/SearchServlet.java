package com.chainsys.busticketapp.servlet;

import java.io.IOException;
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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OperatorsService operators;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		List<Buses> list = null;
		Buses b = new Buses();
		b.setBusModel(request.getParameter("model"));
		System.out.println(b);
		HttpSession sess = request.getSession();
		int route = (Integer) sess.getAttribute("route_no");
		try {
			// list = od.findAllByBusModel(b.getBusModel(),route);
			list = operators.findModel(b.getBusModel(), route);
			System.out.println(list);
			request.setAttribute("list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchModel.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
