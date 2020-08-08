package com.vastika.Team_A_Account.dao;


import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;

public interface AccountBalanceDao {
	
	int saveBalanceInfo(AccountBalance account);
	
	int updateBalanceInfo(AccountBalance account);
	
	void deleteBalanceInfo(AccountBalance account);
	
	AccountBalance getBalanceInfoById(int id);
	
	List<AccountBalance>getAllAcInfo();
	

}
