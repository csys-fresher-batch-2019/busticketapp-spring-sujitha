package com.chainsys.busticketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.busticketapp.dao.UserDetailsDAO;
import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.Users;
import com.chainsys.busticketapp.exception.DbException;
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

 public List<Users> findUserDetails(String Status,LocalDate bookedDate,int busNum) throws DbException{
		List<Users> list = new ArrayList<Users>();
String sql="select u.user_name,u.user_phn_num,u.user_gender,b.seat_no from user_details u,booking b where u.user_id=b.user_id and status=? and b.booked_date=?and bus_num=?";
try (Connection connection = DbConnection.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);) {
	 pst.setString(1,Status);
	 pst.setDate(2, Date.valueOf(bookedDate));
	 pst.setInt(3, busNum);
	 try (ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				Users u = new Users();
				u.setUserName(rs.getString("user_name"));
				u.setUserPhnNum(rs.getLong("user_phn_num"));
                u.setUserGender(rs.getString("user_gender"));
                u.setSeatNo(rs.getInt("seat_no"));
               list.add(u);
               System.out.println("usersimpl:"+list);
			}
		}
	} catch (SQLException e) {
		throw new DbException("UNABLE TO FIND DATA", e);
	}
	return list;
}
}