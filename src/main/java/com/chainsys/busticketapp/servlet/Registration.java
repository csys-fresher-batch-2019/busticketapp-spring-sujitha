package com.chainsys.busticketapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.service.UserDetailsService;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/Registration")

public class Registration extends HttpServlet {
	private static final Logger log = Logger.getInstance();
@Autowired
private UserDetailsService us;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetails ud = new UserDetails();
		ud.setUserName(request.getParameter("name"));
		ud.setUserGender(request.getParameter("gender"));
		ud.setUserPhnNum(Long.parseLong(request.getParameter("mobileno")));
		ud.setPassword(request.getParameter("password"));
		UserDetailsDAOImpl udi = new UserDetailsDAOImpl();
		
		try {
			//udi.save(ud.getUserName(), ud.getUserPhnNum(), ud.getUserGender(), ud.getPassword());
			us.registrationDetails(ud.getUserName(), ud.getUserPhnNum(), ud.getUserGender(), ud.getPassword());
			response.sendRedirect("Login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
			dispatcher.forward(request, response);	
		}
	}
}
