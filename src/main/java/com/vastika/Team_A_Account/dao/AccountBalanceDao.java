package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public abstract interface AccountBalanceDao {
	//customeraccount_number = account_num
	void displayAccountInfo(int customerAccountNum, double amount);
	void depositBalance(int customerAccountNum, double amount);
	void withdrawalBalance( int customerAccountNum,double amount);
	List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo();
	
	
}
