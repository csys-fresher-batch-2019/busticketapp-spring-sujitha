package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DbException;

public interface AdminDAO {
	public int findByAdminMailIdAndPassword(String adminMailId, String adminPassword) throws DbException;
}
