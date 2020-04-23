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

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.busticketapp.dao.impl.OperatorsDetailsDAOImpl;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.service.AdminService;
import com.chainsys.busticketapp.service.OperatorsService;
import com.chainsys.busticketapp.service.UserDetailsService;

@WebServlet("/AdminBusDisplay")
public class AdminBusDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminService admin;

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
			// list = os.findByOperatorName(name);
			list = admin.findByOperatorName(name);
			request.setAttribute("Op_list", list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminBusDisplay.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
