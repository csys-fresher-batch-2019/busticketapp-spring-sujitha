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

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.dto.Buses;

@WebServlet("/OpBusDisplay")

public class OpBusDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		List<Buses> list = null;
		String name = request.getParameter("OperatorName");
		System.out.println(name);
		HttpSession sess = request.getSession();
		int route=(Integer)sess.getAttribute("route_no");
		try {
			list = od.findAllByOperatorName(name,route);
			request.setAttribute("Op_list", list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("OpBusDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}