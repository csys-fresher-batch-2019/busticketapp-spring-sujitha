package com.chainsys.busticketapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.Users;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.validator.Validator;

@Service
public class UserDetailsService {

	@Autowired
	Validator validator;
	@Autowired
	UserDetailsDAO userdetailsDAO;

	public void registrationDetails(String userName, long userPhnNum, String userGender, String password)
			throws ServiceException {
		UserDetails u = new UserDetails();
		try {
			u.setUserName(userName);
			u.setUserPhnNum(userPhnNum);
			u.setUserGender(userGender);
			u.setPassword(password);
			validator.validateUserRegisterForm(u);
			userdetailsDAO.save(userName, userPhnNum, userGender, password);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int loginDetails(long userPhnNum, String password) throws ServiceException {
		int login;
		try {
			validator.validateUserLoginForm(userPhnNum, password);
			login = userdetailsDAO.findUserIdByPhoneNumberAndPassword(userPhnNum, password);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return login;
	}

	public List<Users> findUserDetailsByOperators(String Status, LocalDate bookedDate, int busNum)
			throws ServiceException {
		List<Users> list = null;
		try {
			list = userdetailsDAO.findUserDetails(Status, bookedDate, busNum);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
