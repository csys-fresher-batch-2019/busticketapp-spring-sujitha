package com.chainsys.busticketapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.busticketapp.dao.BusListDAO;
import com.chainsys.busticketapp.dao.impl.UserDetailsDAOImpl;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.BusesDetails;
import com.chainsys.busticketapp.dto.Messagedto;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.factory.DAOFactory;

@RestController
@RequestMapping("api")
public class BusController {
	
	BusListDAO bdao =DAOFactory.getBusListDAO();
	
	@GetMapping("/allBusListDetails")
	public List<BusesDetails> allBusListDetails(@RequestParam("routeNo")int routeNo) throws DbException{
		List<BusesDetails> b=bdao.findAllByRoute(routeNo);
		return b;
	}
	/*@GetMapping("/Register")
	public Messagedto Register(@RequestParam("userName")String userName,@RequestParam("password")String password,@RequestParam("city")String city,@RequestParam("mobileNo")long mobileNo,@RequestParam("email")String email,@RequestParam("qualification")String qualification,@RequestParam("gender")String gender) throws DbException {
		Messagedto msg = new Messagedto();
		Registration reg1 = new Registration();
		reg1.setUserName(userName);
		reg1.setUserPassword(password);
		reg1.setUserCity(city);
		reg1.setMobileNo(mobileNo);
		reg1.setMailId(email);
		reg1.setQualification(qualification);
		reg1.setGender(gender);
		int v = rdao.addUserDetails(reg1);
		 if(v == 1) {
			 msg.setInfoMessage("Registered Successfully!!");
		 }
		 else
		 {
			 msg.setErrorMessage("Registration Failed");
		 }
		return msg;*/
	
@GetMapping("/Register")
 public Messagedto Register(@RequestParam("userName")String userName,@RequestParam("mobileNo") long mobileNo,
		 @RequestParam("gender")String gender,@RequestParam("password")String password) throws Exception {
			UserDetails u= new UserDetails();
			Messagedto m= new Messagedto();
			u.setUserName(userName);
			u.setUserPhnNum(mobileNo);
			u.setUserGender(gender);
			u.setUserPhnNum(mobileNo);
			 UserDetailsDAOImpl ud = new  UserDetailsDAOImpl ();
	int v=ud.save(u.getUserName(), u.getUserPhnNum(), u.getUserGender(), u.getPassword());
	if(v==1) {
		m.setInfoMessage("Registered Successfully!!");
	}else
	{
		 m.setErrorMessage("Registration Failed");	
	}
	
	
	
	return m;

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
