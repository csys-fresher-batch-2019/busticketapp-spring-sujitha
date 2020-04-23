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

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.service.AdminService;

@WebServlet("/AdminOpDetailsDisplay")
public class AdminOpDetailsDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminService admin;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatorsDetailsDAOImpl od = new OperatorsDetailsDAOImpl();
		try {
			List<OperatorsDetails> list = new ArrayList<OperatorsDetails>();
			// list = od.findOperatorName();
			list = admin.findOperator();
			request.setAttribute("op_list", list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminOpDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
