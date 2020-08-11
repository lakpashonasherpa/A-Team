package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public interface AccountInfoBalanceReportService {
 
	AccountInfoBalanceReport displayById(int customerID);
	 
	 List<AccountInfoBalanceReport>displayAll();
}
