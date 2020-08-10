//this is account info
package com.vastika.Team_A_Account.model;

public class AccountInfo {
	
	private int customerAccountNum;
	private String customerName;
	private String customerAddress;
	private long customerPhoneNumber;
	private String customer_unique_id;
	private long customerUniqueIdNum;
	private double initialBalance;

	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
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
		return customer_unique_id;
	}
	public void setCustomerUniqueIdType(String customerUniqueIdType) {
		this.customer_unique_id = customerUniqueIdType;
	}
	public long getCustomerUniqueIdNum() {
		return customerUniqueIdNum;
	}
	public void setCustomerUniqueIdNum(long customerUniqueIdNum) {
		this.customerUniqueIdNum = customerUniqueIdNum;
	}
	public int getCustomerAccountNum() {
		return customerAccountNum;
	}
	public void setCustomerAccountNum(int customerAccountNum) {
		this.customerAccountNum = customerAccountNum;
	}


}
