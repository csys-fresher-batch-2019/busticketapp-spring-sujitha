package com.chainsys.busticketapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.busticketapp.dao.OperatorsDetailsDAO;
import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ServiceException;
import com.chainsys.busticketapp.exception.ValidatorException;
import com.chainsys.busticketapp.validator.Validator;

@Service
public class OperatorsService {
	@Autowired
	OperatorsDetailsDAO operatorsdetailsDAO;// =new OperatorsDetailsDAOImpl();
	@Autowired
	Validator validator;

	public List<Buses> findByOperatorName(String opName, int routeNo) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByOperatorName(opName, routeNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public void saveAdminOpDetails(OperatorsDetails operator) throws ServiceException {
		try {
			operatorsdetailsDAO.save(operator);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public List<Buses> findOperator(int routeNo) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findOperatorNames(routeNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
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

	public int OperatorsLogin(String operatorEmailId, String operatorPassword) throws ServiceException {
		int id = 0;
		OperatorsDetails operators = new OperatorsDetails();
		try {
			operators.setOperatorEmailId(operatorEmailId);
			operators.setOperatorPassword(operatorPassword);
			validator.validateOperatorsLoginForm(operators);
			id = operatorsdetailsDAO.findOperatorIdByOperatorMailIdAndPassword(operatorEmailId, operatorPassword);
		} catch (DbException e) {
			throw new ServiceException(e);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return id;
	}

	public void saveOperatorsOpDetails(OperatorsDetails operator) throws ServiceException {
		try {
			operatorsdetailsDAO.save(operator);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
	}

	public List<Buses> findByBusName(String busName, int routeNo) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByBusName(busName, routeNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findOperatorNamebyId(int opId) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findOperatorName(opId);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findMaxRatings(int routeNo, int routeno) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByMaximumRatings(routeNo, routeno);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findMinRatings(int routeNo, int routeno) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByMinimumRatings(routeNo, routeno);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findMaxFare(int routeNo, int routeno) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByMaximumPrice(routeNo, routeno);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findMinFare(int routeNo, int routeno) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByMinimumPrice(routeNo, routeno);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}

	public List<Buses> findModel(String busModel, int routeNo) throws ServiceException {
		List<Buses> list = null;
		try {
			list = operatorsdetailsDAO.findAllByBusModel(busModel, routeNo);
		} catch (DbException e) {
			throw new ServiceException(e);
		}
		return list;
	}
}
