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
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.service.OperatorsService;

@WebServlet("/DisplayOperatorservlet")
public class DisplayOperatorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private OperatorsService operators;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		HttpSession sess = request.getSession();
		int id = (Integer) sess.getAttribute("Operator_id");
		try {
			List<Buses> list = new ArrayList<Buses>();
			// list = od.findOperatorName(id);
			list = operators.findOperatorNamebyId(id);
			System.out.println(list);
			request.setAttribute("op_list", list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayOperators.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
