package com.chainsys.busticketapp.domain;

public class UserDetails {
	private int userId;
	private String userName;
	private long userPhnNum;
	private String userGender;
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserPhnNum() {
		return userPhnNum;
	}

	public void setUserPhnNum(long userPhnNum) {
		this.userPhnNum = userPhnNum;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userPhnNum=" + userPhnNum
				+ ", userGender=" + userGender + ", password=" + password + "]";
	}

}
