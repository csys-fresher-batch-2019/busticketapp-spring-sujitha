package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.service.AdminService;
import com.chainsys.busticketapp.service.OperatorsService;

@WebServlet("/DisplayBusOperatorsServlet")
public class DisplayBusOperatorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OperatorsService operators;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		OperatorsService os = new OperatorsService();
		List<Buses> list = null;
		String name = request.getParameter("OperatorName");
		System.out.println(name);
		// HttpSession sess = request.getSession();
		// int route=(Integer)sess.getAttribute("route_no");
		try {
			list = operators.findByOperatorName(name);
			request.setAttribute("Op_list", list);
			System.out.println("servlet:" + list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayBusOperators.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
