package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.service.OperatorsService;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/Operators")

public class Operators extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();
	@Autowired
	private OperatorsService operators;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl o = new OperatorsDetailsDAOImpl();
		OperatorsDetails od = new OperatorsDetails();
		od.setOperatorEmailId(request.getParameter("email"));
		od.setOperatorPassword(request.getParameter("password"));
		int id = 0;
		try {
			// id = o.findOperatorIdByOperatorMailIdAndPassword(od.getOperatorEmailId(),
			// od.getOperatorPassword());
			id = operators.OperatorsLogin(od.getOperatorEmailId(), od.getOperatorPassword());
			System.out.println(id);
		} catch (Exception e) {
			log.error(e);
		}
		if (id != 0) {
			HttpSession sess = request.getSession();
			sess.setAttribute("Operator_id", id);
			System.out.println(id);
			response.sendRedirect("DisplayOperatorservlet");
		} else {
			response.sendRedirect("Operators.jsp?errorMessage=Invalid Username or Password");
		}
	}
}