//this is account balance
package com.vastika.Team_A_Account.model;

public class AccountBalance {
	
	private long transcationId;
	private double deposit; 
	private double withdrawal;
	private double accountBalance;
	private long customer_id;
	
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
	
	
	public void  accountInfoId(AccountInfo ac) {
		
		//long accountId= ac.
		
		//return accountId;
		
	}
	/*
	public long getAccount_info_id() {
		return account_info_id;
	}
	public void setAccount_info_id(long account_info_id) {
		this.account_info_id = account_info_id;
	}
	*/
	
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
}
