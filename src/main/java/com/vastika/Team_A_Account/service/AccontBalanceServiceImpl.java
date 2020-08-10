package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.dao.AccountBalanceDao;
import com.vastika.Team_A_Account.dao.AccountBalanceDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public class AccontBalanceServiceImpl implements AccontBalanceService {

	AccountBalanceDao accBald = new AccountBalanceDaoImpl();
	@Override
	public void displayAccountInfo(int customerAccountNum, double amount) {
		
		accBald.displayAccountInfo( customerAccountNum, amount);
	}

	@Override
	public void depositBalance(int customerAccountNum, double amount) {
		accBald.depositBalance(customerAccountNum, amount);
		
	}

	@Override
	public void withdrawalBalance( int customerAccountNum,double amount) {
		accBald.withdrawalBalance(customerAccountNum,amount);
		
	}

	@Override
	public List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo() {
		return accBald.getAllAccountBalancewithCustomerInfo();
		
	}

}
