package com.chainsys.busticketapp.domain;

public class OperatorsDetails {
	private int operatorId;
	private String operatorName;
	private String operatorEmailId;
	private String operatorPhoneNumber;
	private String operatorPassword;

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorEmailId() {
		return operatorEmailId;
	}

	public void setOperatorEmailId(String operatorEmailId) {
		this.operatorEmailId = operatorEmailId;
	}

	public String getOperatorPhoneNumber() {
		return operatorPhoneNumber;
	}

	public void setOperatorPhoneNumber(String operatorPhoneNumber) {
		this.operatorPhoneNumber = operatorPhoneNumber;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

	@Override
	public String toString() {
		return "Operators [operatorId=" + operatorId + ", operatorName=" + operatorName + ", operatorEmailId="
				+ operatorEmailId + ", operatorPhoneNumber=" + operatorPhoneNumber + ", operatorPassword="
				+ operatorPassword + "]";
	}

}
