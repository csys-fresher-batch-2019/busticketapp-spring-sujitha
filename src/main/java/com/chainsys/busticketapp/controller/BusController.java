package com.chainsys.busticketapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.BusDAO;
import com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.dto.Messagedto;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.factory.DAOFactory;

@RestController
@RequestMapping("api")
public class BusController {

	BusDAO bdao = DAOFactory.getBusListDAO();

	@GetMapping("/allBusListDetails")
	public List<BusesDetails> allBusListDetails(@RequestParam("routeNo") int routeNo) throws DbException {
		List<BusesDetails> b = bdao.findAllByRoute(routeNo);
		return b;
	}

	@PostMapping("/Register")
	public Messagedto Register(@RequestParam("userName") String userName, @RequestParam("mobileNo") long mobileNo,
			@RequestParam("gender") String gender, @RequestParam("password") String password) throws Exception {
		UserDetails u = new UserDetails();
		Messagedto m = new Messagedto();
		u.setUserName(userName);
		u.setUserPhnNum(mobileNo);
		u.setUserGender(gender);
		u.setPassword(password);
		UserDetailsDAOImpl ud = new UserDetailsDAOImpl();
		int v = ud.save(userName, mobileNo, gender, password);
		if (v == 1) {
			m.setInfoMessage("Registered Successfully!!");
		} else {
			m.setErrorMessage("Registration Failed");
		}
		return m;
	}

}
