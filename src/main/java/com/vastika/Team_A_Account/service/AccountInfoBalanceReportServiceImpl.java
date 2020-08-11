package com.vastika.Team_A_Account.service;

import java.util.List;

import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDao;
import com.vastika.Team_A_Account.dao.AcountInfoBalanceReportDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;

public class AccountInfoBalanceReportServiceImpl implements AccountInfoBalanceReportService {
 AccountInfoBalanceReportDao report=new AcountInfoBalanceReportDaoImpl();
	@Override
	public AccountInfoBalanceReport displayById(int customerID) {
		
		return report.displayById(customerID);
	}

	@Override
	public List<AccountInfoBalanceReport> displayAll() {
		
		return report.displayAll();
	}

}
