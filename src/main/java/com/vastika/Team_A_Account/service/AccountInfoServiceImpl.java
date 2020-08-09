package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.dao.AccountInfoDao;
import com.vastika.Team_A_Account.dao.AccountInfoDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfo;

public class AccountInfoServiceImpl implements  AccountInfoService{
	AccountInfoDao accInfoD = new AccountInfoDaoImpl();
	@Override
	public int saveCustomerInfo(AccountInfo accInfo) {
	
		return 0;
	}

	@Override
	public int updateCustomerInfo(AccountInfo accInfo) {
	
		return 0;
	}

	@Override
	public void deleteCustomerInfo(long customerId) {
	
		
	}

	@Override
	public AccountInfo getCustomerById(long customerId) {
		
		return null;
	}

	@Override
	public List<AccountInfo> getAllCustomerList() {
		
		return null;
	}

}
