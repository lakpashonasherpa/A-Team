package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;

public interface AccountInfoService {
	int saveCustomerInfo(AccountInfo accInfo);
	int updateCustomerInfo(AccountInfo accInfo);
	void deleteCustomerInfo(int customerId);
	AccountInfo getCustomerById (int customerId);
	List<AccountInfo> getAllCustomerList();
	
}
