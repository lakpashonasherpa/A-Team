package com.vastika.Team_A_Account.dao;

import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;

public interface AccountInfoDao {

	int saveCustomerInfo(AccountInfo account);

	int updateCustomerInfo(AccountInfo account);

	void deteteCustomerInfo(int id);

	AccountInfo getCustomerInfoByID(int id);
	
	List<AccountInfo>getAllCustomerInfo=new ArrayList<>();

}
