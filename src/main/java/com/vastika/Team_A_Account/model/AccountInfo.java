package com.vastika.Team_A_Account.model;

public class AccountInfo {
	private int customerAccountNum;
	private String customerName;
	private String customerAddress;
	private long customerPhoneNumber;
	private String customerUniqueIdType;
	private long customerUniqueId;
	private double initialBalance;
	
	
	public int getCustomerAccountNum() {
		return customerAccountNum;
	}
	public void setCustomerAccountNum(int customerAccountNum) {
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
	public long getCustomerUniqueId() {
		return customerUniqueId;
	}
	public void setCustomerUniqueId(long customerUniqueId) {
		this.customerUniqueId = customerUniqueId;
	}
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	

}
