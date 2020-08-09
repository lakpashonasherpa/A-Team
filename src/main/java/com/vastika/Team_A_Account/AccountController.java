package com.vastika.Team_A_Account;

import java.util.Scanner;

import com.vastika.Team_A_Account.dao.AccountInfoDao;
import com.vastika.Team_A_Account.dao.AccountInfoDaoImpl;
import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;

//open an account
//get customer user information name, address, mobile, unique_id
//store in database

//deposite
//withdraw
//totalbalance

public class AccountController {
	public static void main(String[] args) {
		AccountInfoDao customerDao = new AccountInfoDaoImpl();

		Scanner reader = new Scanner(System.in);

		AccountInfo customerInfo = getCustomerInfo("type", reader);

		int saved = customerDao.saveCustomerInfo(customerInfo);
		if (saved >= 1) {
			System.out.println("data enter is successful");
		} else {
			System.out.println("error in db.");
		}

	}

	public static AccountInfo getCustomerInfo(String type, Scanner reader) {
		AccountInfo customerInfo = new AccountInfo();
		System.out.println("Ente the customer info to open the bank account");

		System.out.println("Enter the name: ");
		String name = reader.nextLine();
		System.out.println("Enter the address: ");
		String address = reader.nextLine();
		System.out.println("Enter the mobile Number: ");
		Long mobileNo = reader.nextLong();
		System.out.println("Enter your ID type:");
		String idType = reader.next();
		System.out.println("Enter the" + idType + " number:");
		Integer ssn = reader.nextInt();
		System.out.println("Enter the Customer ID: ");
		Integer id = reader.nextInt();
		
		
		System.out.println("Enter the Initial Balance: ");
		double deposite=reader.nextDouble();
		customerInfo.setId(id);
		customerInfo.setName(name);
		customerInfo.setAddress(address);
		customerInfo.setMobileNo(mobileNo);
		customerInfo.setUniqueId(ssn);
		customerInfo.setCustomerUniqueIdType(idType);
		customerInfo.setInitialBalance(deposite);

		return customerInfo;

	}

	public static AccountBalance getDepositeInfo(String type, Scanner reader) {
		AccountBalance balance = new AccountBalance();
		System.out.println("Enter the ammount you wanna deposite: ");
		double deposite = reader.nextDouble();

		balance.setDepositAmount(deposite);

		return balance;

	}
	public static AccountBalance getWithdrawInfo(String type, Scanner reader) {
		AccountBalance balance = new AccountBalance();
		System.out.println("Enter the ammount you wanna withdraw: ");
		double withdraw = reader.nextDouble();

		balance.setDepositAmount(withdraw);

		return balance;

	}

}
