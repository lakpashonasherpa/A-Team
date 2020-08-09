package com.vastika.Team_A_Account.model;

public class AccountInfoBalanceReport {
	
	private long customerAccountNum;
	private String customerName;
	//private String customerAddress;
	private double initialBalance;

	private double deposit; 
	private double withdrawal;

	public double getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
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

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	
	
}