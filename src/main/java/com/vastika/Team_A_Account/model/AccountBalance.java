package com.vastika.Team_A_Account.model;

public class AccountBalance {
	private long transactionId;
	private double accountBalance;
	private double deposit;
	private double withdrawal;
	private double customerId;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
	}
	public double getCustomerId() {
		return customerId;
	}
	public void setCustomerId(double customerId) {
		this.customerId = customerId;
	}

}
