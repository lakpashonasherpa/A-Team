package com.vastika.Team_A_Account.dao;


import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public interface AccountBalanceDao {
	
	void displayAccountInfo(int customerAccountNum);
	void depositBalance(int customerAccountNum, double amount);
	void withdrawalBalance( int customerAccountNum,double amount);
	List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo();
	//int depositeBalance(AccountBalance depositAmount);
	
	AccountBalance totalBalance(int customerAccountNum);
	

}
