package com.vastika.Team_A_Account.model;

public class AccountBalance {
	private int transactionId;
	private double accountBalance;
	private double depositAmount;
	private double withdrawAmount;
	private int accountInfoId;

	public int getTransactionId() {
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

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public int getAccountInfoId() {
		return accountInfoId;
	}

	public void setAccountInfoId(int accountInfoId) {
		this.accountInfoId = accountInfoId;
	}
}
