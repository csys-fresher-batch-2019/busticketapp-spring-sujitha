package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.domain.OperatorsDetails;

@WebServlet("/OpDetailsAdd")

public class OpDetailsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		OperatorsDetails o = new OperatorsDetails();
		o.setOperatorName(request.getParameter("name"));
		o.setOperatorEmailId(request.getParameter("email"));
		o.setOperatorPhoneNumber(request.getParameter("number"));
		o.setOperatorPassword(request.getParameter("password"));
		try {
			od.save(o);
			RequestDispatcher dispatcher = request.getRequestDispatcher("aaa.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
