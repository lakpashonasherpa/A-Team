//this is account info
package com.vastika.Team_A_Account.model;

public class AccountInfo {
	
	private long customerAccountNum;
	private String customerName;
	private String customerAddress;
	private long customerPhoneNumber;
	private String customerUniqueIdType;
	private long customerUniqueIdNum;
	private double initialBalance;

	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	public long getCustomerAccountNum() {
		return customerAccountNum;
	}
	public void setCustomerAccountNum(long customerAccountNum) {
		this.customerAccountNum = customerAccountNum;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerUniqueIdType() {
		return customerUniqueIdType;
	}
	public void setCustomerUniqueIdType(String customerUniqueIdType) {
		this.customerUniqueIdType = customerUniqueIdType;
	}
	public long getCustomerUniqueIdNum() {
		return customerUniqueIdNum;
	}
	public void setCustomerUniqueIdNum(long customerUniqueIdNum) {
		this.customerUniqueIdNum = customerUniqueIdNum;
	}


}
