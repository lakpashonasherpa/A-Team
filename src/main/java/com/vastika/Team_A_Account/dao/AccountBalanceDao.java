package com.vastika.Team_A_Account.dao;

import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;

public interface AccountBalanceDao {
	
	void saveAccountInfo(AccountBalance account);
	
	void updateAccountInfo(AccountBalance account);
	
	void deleteAccountInfo(AccountBalance account);
	
	void getAccountInfoById(int id);
	
	List<AccountBalance>getAllAcInfo=new ArrayList<>();
	

}
