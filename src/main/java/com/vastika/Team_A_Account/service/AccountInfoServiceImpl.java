package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.dao.AccountInfoDao;
import com.vastika.Team_A_Account.dao.AccountInfoDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfo;

public class AccountInfoServiceImpl implements  AccountInfoService{
	AccountInfoDao accInfoD = new AccountInfoDaoImpl();
	@Override
	public int saveCustomerInfo(AccountInfo accInfo) {
	
		return accInfoD.saveCustomerInfo(accInfo);
	}

	@Override
	public int updateCustomerInfo(AccountInfo accInfo) {
	
		return accInfoD.updateCustomerInfo(accInfo);
	}

	@Override
	public void deleteCustomerInfo(int customerId) {
	
		accInfoD.deleteCustomerInfo(customerId);
	}

	@Override
	public AccountInfo getCustomerById(int customerId) {
		
		return accInfoD.getCustomerById(customerId);
	}

	@Override
	public List<AccountInfo> getAllCustomerList() {
		
		return accInfoD.getAllCustomerList();
	}

}
