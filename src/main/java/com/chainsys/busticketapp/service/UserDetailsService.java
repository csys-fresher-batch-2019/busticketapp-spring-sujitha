package com.chainsys.busticketapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.domain.UserDetails;
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
		int v;

		try {
			
			validator.validateUserLoginForm(userPhnNum, password);
			v = userdetailsDAO.findUserIdByPhoneNumberAndPassword(userPhnNum, password);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return v;
	}
}
