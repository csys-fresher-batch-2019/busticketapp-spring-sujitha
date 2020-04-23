package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.chainsys.busticketapp.dto.Users;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.service.OperatorsService;
import com.chainsys.busticketapp.service.UserDetailsService;

@WebServlet("/OperatorsViewDetails")
public class OperatorsViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDetailsService users;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetailsDAO user = new UserDetailsDAOImpl();
		List<Users> list = null;
		// HttpSession sess = request.getSession();
		// int busnumber = (Integer) sess.getAttribute("busNo");
		int busnumber = Integer.parseInt(request.getParameter("busNo"));
		System.out.println("Bus number:" + busnumber);
		LocalDate todayDate = LocalDate.now();
		System.out.println(todayDate);
		try {
			// list = user.findUserDetails("BOOKED", todayDate, busnumber);
			list = users.findUserDetailsByOperators("BOOKED", todayDate, busnumber);
			request.setAttribute("View_list", list);
			System.out.println("view:" + list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOperators.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}