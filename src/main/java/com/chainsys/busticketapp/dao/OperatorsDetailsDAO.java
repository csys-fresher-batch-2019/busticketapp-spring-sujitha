package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.exception.DbException;

public interface OperatorsDetailsDAO {

	public List<Buses> findAllByOperatorName(String opName, int routeNo) throws DbException;

	public List<Buses> findAllByBusName(String busName, int routeNo) throws DbException;

	public List<Buses> findAllByBusModel(String busModel, int routeNo) throws DbException;

	public List<Buses> findAllByMinimumRatings(int routeNo, int routeno) throws DbException;

	public List<Buses> findAllByMaximumRatings(int routeNo, int routeno) throws DbException;

	public List<Buses> findAllByMinimumPrice(int routeNo, int routeno) throws DbException;

	public List<Buses> findAllByMaximumPrice(int routeNo, int routeno) throws DbException;

	public int findOperatorIdByOperatorMailIdAndPassword(String operatorEmailId, String operatorPassword)
			throws DbException;

	public void save(OperatorsDetails operator) throws DbException;

	public List<OperatorsDetails> findOperatorName() throws DbException;

	public List<Buses> findAllByOperatorName(String opName) throws DbException;

	public List<Buses> findOperatorNames(int routeNo) throws DbException;

	public List<Buses> findOperatorName(int opId) throws DbException;
}
