package com.chainsys.busticketapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.busticketapp.domain.UserDetails;
import com.chainsys.busticketapp.dto.Users;
import com.chainsys.busticketapp.exception.DbException;

public interface UserDetailsDAO {
	public int save(String userName, long userPhnNum, String userGender, String password) throws DbException;

	public void updateUserPhoneNumberByUserId(int userId, long userPhnNum) throws DbException;

	public String findGenderByUserId(int userId) throws DbException;

	public int findGenderCountByUserGender(String userGender) throws DbException;

	public void saveDetails(UserDetails userdetails) throws DbException;

	public boolean findByPhoneNumberAndPassword(long userPhnNum, String password) throws DbException;

	public int findUserIdByPhoneNumberAndPassword(long userPhnNum, String password) throws DbException;

	public List<Users> findUserDetails(String Status, LocalDate bookedDate, int busNum) throws DbException;

}
