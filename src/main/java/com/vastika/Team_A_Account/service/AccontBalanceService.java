package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public interface AccontBalanceService {
	void displayAccountInfo(long customerAccountNum);
	void depositBalance(long customerAccountNum, double amount);
	void withdrawalBalance(long customerAccountNum, double amount);
	List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo();
	
}
