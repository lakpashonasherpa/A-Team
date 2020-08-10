package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;

//think from the bank perspective
public interface AccountInfoDao {

	int saveCustomerInfo(AccountInfo accInfo);
	void saveCustomerBalance( double amount, int customerId);
	int updateCustomerInfo(AccountInfo accInfo);
	void deleteCustomerInfo(int customerId);
	AccountInfo getCustomerById (int customerId);
	List<AccountInfo> getAllCustomerList();
	
}
