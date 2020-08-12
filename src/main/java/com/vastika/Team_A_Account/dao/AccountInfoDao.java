package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;

public interface AccountInfoDao {

	int saveCustomerInfo(AccountInfo accInfo);
	void saveCustomerBalance( double amount, int customerId);
	int updateCustomerInfo(AccountInfo accInfo);

	void deteteCustomerInfo(int customerId);

	AccountInfo getCustomerInfoByID(int customerId);
	
	List<AccountInfo>getAllCustomerInfo();

}
