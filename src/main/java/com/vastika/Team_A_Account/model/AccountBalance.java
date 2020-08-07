//this is account balance
package com.vastika.Team_A_Account.model;

public class AccountBalance {
	
	private long transcationId;
	private double deposit; 
	private double withdrawal;
	private double accountBalance;
	public long getTranscationId() {
		return transcationId;
	}
	public void setTranscationId(long transcationId) {
		this.transcationId = transcationId;
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
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	} 
	
	public long  accountInfoId() {
		AccountInfo ac = new AccountInfo();
		long accountId= ac.getCustomerAccountNum();
		
		return accountId;
		
	}
	
}
