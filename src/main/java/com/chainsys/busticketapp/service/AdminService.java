package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.AdminDAO;
import com.chainsys.busticketapp.dao.OperatorsDetailsDAO;
import com.chainsys.busticketapp.domain.Admin;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.validator.Validator;

@Service
public class AdminService {
	@Autowired
	Validator validator;
	@Autowired
	AdminDAO adminDAO;// =new AdminDAOImpl();
	@Autowired
	OperatorsDetailsDAO operatorsdetailsDAO;

	public int adminLogin(String adminMailId, String adminPassword) throws ServiceException {
		Admin admin = new Admin();
		int id;
		try {
			admin.setAdminMailId(adminMailId);
			admin.setAdminPassword(adminPassword);
			validator.validateAdminLoginForm(admin);
			id = adminDAO.findByAdminMailIdAndPassword(adminMailId, adminPassword);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return id;
	}

	public void saveAdminOpDetails(OperatorsDetails operator) throws ServiceException {
		try {
			operatorsdetailsDAO.save(operator);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public List<Buses> findByOperatorName(String opName) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByOperatorName(opName);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<OperatorsDetails> findOperator() throws ServiceException {
		List<OperatorsDetails> list = null;
		try {
			list = operatorsdetailsDAO.findOperatorName();
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
	//public List<OperatorsDetails> findByAdminEmailIdAndPassword() {
	//return null;
	
