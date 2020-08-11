package com.vastika.Team_A_Account;

import java.util.List;
import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDao;
import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;


public class test {

	public static void main(String[] args) {
		//AccontBalanceService accBalServ = new AccontBalanceServiceImpl();
		AccountInfoBalanceReportDao accInfBalRepo= new AccountInfoBalanceReportDaoImpl();
		List<AccountInfoBalanceReport> customerReportList =accInfBalRepo.displayAll();
		for (AccountInfoBalanceReport u : customerReportList) {
			System.out.println("Customer Id is:"+u.getCustomerAccountNum());
			System.out.println("Customer name is: "+u.getCustomerName());
			System.out.println("Initial balance: "+u.getInitialBalance());
			System.out.println("Deposited ammount: "+u.getDeposit());
			System.out.println("Withdraw ammount: "+u.getWithdrawal());
			System.out.println("==============");

		System.out.println("success!!!!");
	
		}
		

	}
	

}
