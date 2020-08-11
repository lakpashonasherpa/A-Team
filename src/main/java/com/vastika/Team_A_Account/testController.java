package com.vastika.Team_A_Account;

import java.util.List;
import java.util.Scanner;

import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDao;
import com.vastika.Team_A_Account.dao.AcountInfoBalanceReportDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;
import com.vastika.Team_A_Account.service.AccountInfoBalanceReportService;
import com.vastika.Team_A_Account.service.AccountInfoBalanceReportServiceImpl;

public class testController {
	public static void main(String[] args) {
		AccountInfoBalanceReportService reportDao= new AccountInfoBalanceReportServiceImpl();
		
		
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the customer id:");
		int customerId=input.nextInt();
		AccountInfoBalanceReport report= reportDao.displayById(customerId);
		System.out.println("Customer Id is:"+report.getCustomerAccountNum());
		System.out.println("Customer name is: "+report.getCustomerName());
		System.out.println("Initial balance: "+report.getInitialBalance());
		System.out.println("Deposited ammount: "+report.getDeposit());
		System.out.println("Withdraw ammount: "+report.getWithdrawal());

		System.out.println("==========================================");
		
		
		List<AccountInfoBalanceReport> customerReportList =reportDao.displayAll();
		for (AccountInfoBalanceReport u : customerReportList) {
			System.out.println("Customer Id is:"+u.getCustomerAccountNum());
			System.out.println("Customer name is: "+u.getCustomerName());
			System.out.println("Initial balance: "+u.getInitialBalance());
			System.out.println("Deposited ammount: "+u.getDeposit());
			System.out.println("Withdraw ammount: "+u.getWithdrawal());
			System.out.println("==============");
		}
	}
	
}
