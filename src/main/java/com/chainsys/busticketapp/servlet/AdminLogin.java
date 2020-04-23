package com.chainsys.busticketapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.impl.AdminDAOImpl;
import com.chainsys.busticketapp.domain.Admin;
import com.chainsys.busticketapp.service.AdminService;
import com.chainsys.busticketapp.service.UserDetailsService;
import com.chainsys.busticketapp.util.Logger;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getInstance();
	@Autowired
	private AdminService admin;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Admin a = new Admin();
		a.setAdminMailId(request.getParameter("email"));
		a.setAdminPassword(request.getParameter("password"));
		AdminDAOImpl ai = new AdminDAOImpl();
		try {
			// int id = ai.findByAdminMailIdAndPassword(a.getAdminMailId(),
			// a.getAdminPassword());
			int id = admin.adminLogin(a.getAdminMailId(), a.getAdminPassword());
			if (id != 0) {
				response.sendRedirect("AdminOperatorsDetails.jsp");
			} else {
				response.sendRedirect("Admin.jsp?errorMessage=Invalid Username or Password");
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
}
