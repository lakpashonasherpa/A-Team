package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.Report;

public abstract interface AccountBalanceDao {
	//customeraccount_number = account_num
	void displayAccountInfo(long customerAccountNum);
	void depositBalance(long customerAccountNum, double amount);
	void withdrawalBalance(long customerAccountNum, double amount);
	List<Report> getAllAccountBalancewithCustomerInfo();
	
	
}
