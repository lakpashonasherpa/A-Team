package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;

public interface AccountBalanceDao {
	//customeraccount_number = account_num
	double displayAccountInfo(long customerAccountNum);
	double depositBalance(long customerAccountNum, double amount);
	double withdrawalBalance(long customerAccountNum, double amount);
	List<AccountBalance> getAllAccountBalance();
	
}
