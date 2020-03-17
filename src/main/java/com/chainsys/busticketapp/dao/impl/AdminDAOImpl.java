package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chainsys.busticketapp.dao.AdminDAO;
import com.chainsys.busticketapp.domain.Admin;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;

public class AdminDAOImpl implements AdminDAO {
	private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);

	public int findByAdminMailIdAndPassword(String adminMailId, String adminPassword) throws DbException {
		String sql = "select admin_id from admin where admin_mail=?and admin_password=?";
		Admin a = new Admin();
		int id = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, adminMailId);
			pst.setString(2, adminPassword);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt("admin_id");
				}
			}
		} catch (SQLException e) {
			throw new DbException("Unable to Login",e);
		}
		return id;
	}
}