package com.vastika.Team_A_Account.dao;

import java.util.List;
import com.vastika.Team_A_Account.model.AccountInfo;

//think from the bank perspective
public interface AccountInfoDao {

	int saveCustomerInfo(AccountInfo accInfo);
	int updateCustomerInfo(AccountInfo accInfo);
	void deleteCustomerInfo(long customerId);
	AccountInfo getCustomerById (long customerId);
	List<AccountInfo> getAllCustomerList();
	
}
