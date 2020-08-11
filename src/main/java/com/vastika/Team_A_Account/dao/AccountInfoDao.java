package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;

public interface AccountInfoDao {

	int saveCustomerInfo(AccountInfo customer);
	void saveCustomerBalance( double amount, int customerId);
	int updateCustomerInfo(AccountInfo customer);

	void deteteCustomerInfo(int id);

	AccountInfo getCustomerInfoByID(int id);
	
	List<AccountInfo>getAllCustomerInfo();

}
