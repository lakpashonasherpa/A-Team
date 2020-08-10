package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public interface AccontBalanceService {
	void displayAccountInfo(int customerAccountNum, double amount);
	void depositBalance(int customerAccountNum, double amount);
	void withdrawalBalance( int customerAccountNum,double amount);
	List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo();
	
}
