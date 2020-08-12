package com.vastika.Team_A_Account.dao;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public interface AccountInfoBalanceReportDao {

	
	 AccountInfoBalanceReport displayById(int customerID);
	 
	 List<AccountInfoBalanceReport>displayAll();
	
}
