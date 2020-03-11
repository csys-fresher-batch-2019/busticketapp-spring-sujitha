package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.dto.Buses;

@WebServlet("/AcServ")
public class AcServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		List<Buses> list = null;
		Buses b = new Buses();
		b.setBusModel(request.getParameter("ac"));
		System.out.println(b);
		try {
			list = od.findAllByBusModel(b.getBusModel());
			System.out.println(list);
			request.setAttribute("ac_list", list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Ac.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
