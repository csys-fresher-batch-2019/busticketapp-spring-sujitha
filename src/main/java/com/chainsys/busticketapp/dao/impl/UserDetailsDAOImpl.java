package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.UserGenderEnum;
import com.chainsys.busticketapp.exception.DbException;
import com.chainsys.busticketapp.exception.ErrorConstant;
import com.chainsys.busticketapp.util.DbConnection;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDAOImpl.class);

	public int save(String userName, long userPhnNum, String userGender, String password) throws DbException {
		String str = "insert into user_details(user_id ,user_name,user_phn_num,user_gender,password)values(user_id_seq.nextval,?,?,?,?)";
		logger.info("Rows : " + str);
		int rows = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(str);) {
			pst.setString(1, userName);
			pst.setLong(2, userPhnNum);
			pst.setString(3, userGender);
			pst.setString(4, password);
			rows = pst.executeUpdate();
			System.out.println(rows);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO ADD DATA", e);
		}
		return rows;
	}

	public void updateUserPhoneNumberByUserId(int userId, long userPhnNum) throws DbException {
		try (Connection connection = DbConnection.getConnection();) {
			String sql = "update user_details set user_phn_num=? where user_id=?";
			logger.info("Update: " + sql);
			try (PreparedStatement pst = connection.prepareStatement(sql);) {
				pst.setLong(1, userPhnNum);
				pst.setInt(2, userId);
				int row = pst.executeUpdate(sql);
				System.out.println(row);
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO UPDATE PHONE NUMBER", e);
		}
	}

	public String findGenderByUserId(int userId) throws DbException {
		String strn = "select user_gender from user_details where user_id=?";
		logger.info("Users: " + strn);
		String gender = null;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(strn);) {
			pst.setInt(1, userId);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					gender = rs.getString("user_gender");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND GENDER", e);
		}
		return gender;
	}

	public int findGenderCountByUserGender(String userGender) throws DbException {
		String sql = "select count (*)user_gender from user_details where user_gender=?";
		logger.info("Count : " + sql);
		int gendercount = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, userGender);
			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					gendercount = rs.getInt("user_gender");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND GENDER", e);
		}
		return gendercount;
	}

	public void saveDetails(UserDetails userdetails) throws DbException {
		String sql = "insert into user_details(user_id ,user_name,user_phn_num,user_gender)values(?,?,?,?)";
		logger.info("Rows : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setInt(1, userdetails.getUserId());
			pst.setString(2, userdetails.getUserName());
			pst.setLong(3, userdetails.getUserPhnNum());
			pst.setString(4, userdetails.getUserGender().toString());
			int rows = pst.executeUpdate();
			logger.info("No Of Rows : " + rows);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO ADD USERS DATA", e);
		}
	}

	public void updateGenderByUserId(int userID, UserGenderEnum userGender) throws DbException {
		String sql = "UPDATE USER_DETAILS SET USER_GENDER=? WHERE USER_ID=?";
		logger.info("Update : " + sql);
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setString(1, userGender.toString());
			pst.setInt(2, userID);
			int rows = pst.executeUpdate();
			logger.info("No Of Rows Updated : " + rows);
		} catch (SQLException e) {
			throw new DbException("UNABLE TO UPDATE GENDER", e);
		}
	}

	public boolean findByPhoneNumberAndPassword(long userPhnNum, String password) throws DbException {
		String sql = "select user_phn_num,password from user_details where user_phn_num=? and password = ?";
		logger.info("Users : " + sql);
		boolean msg = true;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setLong(1, userPhnNum);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					msg = true;
					logger.info("User: " + "Succesfully login");
				} else {
					msg = false;
					logger.info("User: " + "Login details are invalid");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND PHONE NUMBER,PASSWORD", e);
		}
		return msg;
	}

	public int findUserIdByPhoneNumberAndPassword(long userPhnNum, String password) throws DbException {
		String sql = "select user_id from user_details where user_phn_num=?and password=?";
		logger.info("Users : " + sql);
		int id = 0;
		try (Connection connection = DbConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);) {
			pst.setLong(1, userPhnNum);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					id = rs.getInt("user_Id");
				}
			}
		} catch (SQLException e) {
			throw new DbException("UNABLE TO FIND USER ID", e);
		}
		return id;
	}
}
