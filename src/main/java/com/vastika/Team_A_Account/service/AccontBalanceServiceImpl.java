package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.dao.AccountBalanceDao;
import com.vastika.Team_A_Account.dao.AccountBalanceDaoImpl;
import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public class AccontBalanceServiceImpl implements AccontBalanceService {
	AccountBalanceDao accBald = new AccountBalanceDaoImpl();

	@Override
	public void displayAccountInfo(int customerAccountNum) {

		accBald.displayAccountInfo(customerAccountNum);
	}

	@Override
	public void depositBalance(int customerAccountNum, double amount) {
		// AccounBalance accountBalance =
		// dao.getAccountBalnceByCustomeId(customerAccountNum);
		// double totalBalance = accountbalnce.getAccountBalnce()+amount;
		// accountBalnce.setAccounbalnce(totalbalnece)

//		AccountBalance accountBalance = accBald.totalBalance(customerAccountNum);
//		double totalBalance = accountBalance.getAccountBalance() + amount;
//		amount=accountBalance.setAccountBalance(totalBalance);
		accBald.depositBalance(customerAccountNum, amount);

	}

	@Override
	public void withdrawalBalance(int customerAccountNum, double amount) {
		accBald.withdrawalBalance(customerAccountNum, amount);

	}

	@Override
	public List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo() {
		return accBald.getAllAccountBalancewithCustomerInfo();

	}
}
