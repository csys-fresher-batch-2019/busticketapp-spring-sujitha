package com.chainsys.busticketapp.dao;

import com.chainsys.busticketapp.exception.DbException;

public interface AdminDAO {
	//select admin_id from admin where admin_mail='admin@gmail.com'and admin_password='admin1234';
 public int findByAdminMailIdAndPassword(String adminMailId, String adminPassword) throws DbException;
}
