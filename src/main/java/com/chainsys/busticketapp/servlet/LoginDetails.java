package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.service.UserDetailsService;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/LoginDetails")

public class LoginDetails extends HttpServlet {
	@Autowired
	UserDetailsService user;
	private static final Logger log = Logger.getInstance();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetails ud = new UserDetails();
		ud.setUserPhnNum(Long.parseLong(request.getParameter("phonenumber")));
		ud.setPassword(request.getParameter("password"));
		PrintWriter out = response.getWriter();
		try {
			int uid = user.loginDetails(ud.getUserPhnNum(), ud.getPassword());
			out.print(uid);
			if (uid != 0) {

				HttpSession sess = request.getSession();
				sess.setAttribute("userid", uid);
				response.sendRedirect("Routes.jsp");
			} else {
				response.sendRedirect("Login.jsp?errorMessage=Invalid Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
