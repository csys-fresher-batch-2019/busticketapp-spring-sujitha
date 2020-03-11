package com.chainsys.busticketapp.dao;

import java.util.List;

import com.chainsys.busticketapp.domain.OperatorsDetails;
import com.chainsys.busticketapp.dto.Buses;
import com.chainsys.busticketapp.exception.DbException;

public interface OperatorsDetailsDAO {

	public List<Buses> findAllByOperatorName(String opName) throws DbException;

	public List<Buses> findAllByBusName(String busName) throws DbException;

	public List<Buses> findAllByBusModel(String busModel) throws DbException;

	public List<Buses> findAllByMinimumRatings() throws DbException;

	public List<Buses> findAllByMaximumRatings() throws DbException;

	public List<Buses> findAllByMinimumPrice() throws DbException;

	public List<Buses> findAllByMaximumPrice() throws DbException;

	public int findOperatorIdByOperatorMailIdAndPassword(String operatorEmailId, String operatorPassword) throws DbException;

	public void save(OperatorsDetails operator) throws DbException;

	public List<OperatorsDetails> findOperatorName() throws  DbException;

}
