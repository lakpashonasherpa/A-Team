package com.vastika.Team_A_Account.model;

public class AccountInfoBalanceReport {
	
	private long CustomerAccountNum;
	private String CustomerName;
	//private String customerAddress;
	private double InitialBalance;
	private double Deposit; 
	private double Withdrawal;

	public double getWithdrawal() {
		return Withdrawal;
	}

	public void setWithdrawal(double withdrawal) {
		this.Withdrawal = withdrawal;
	}

	public long getCustomerAccountNum() {
		return CustomerAccountNum;
	}

	public void setCustomerAccountNum(long customerAccountNum) {
		this.CustomerAccountNum = customerAccountNum;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		this.CustomerName = customerName;
	}

	public double getInitialBalance() {
		return InitialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.InitialBalance = initialBalance;
	}

	public double getDeposit() {
		return Deposit;
	}

	public void setDeposit(double deposit) {
		this.Deposit = deposit;
	}
	
	
}