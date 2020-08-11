package com.vastika.Team_A_Account;

import java.util.Scanner;

import com.vastika.Team_A_Account.dao.AccountBalanceDao;
import com.vastika.Team_A_Account.dao.AccountBalanceDaoImpl;
import com.vastika.Team_A_Account.model.AccountBalance;

public class TransactionController {

	public static void main(String[] args) {
		AccountBalanceDao balanceDao=new AccountBalanceDaoImpl();
		
		//AccountBalance customerBalance=new AccountBalance();
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your choice deposite | withdraw | checktotal");
		String choice=input.next();
		switch (choice) {
		case "deposite":
			
			AccountBalance depositAmount=getDeposite(choice, input);
			
			int saved=balanceDao.depositeBalance(depositAmount);
			
			if(saved>=1) {
				System.out.println("you have deposited your ammount sucessfully!!!");
				} else {
					System.out.println("error in db.");
				}
			
			
			break;
		case "withdraw":
			
			
			
			break;
		case "checktotal":
			
			break;



		default:
			System.out.println("you have enter the wrong choice");
			break;
		}
		
		
	}
	
	public static AccountBalance getDeposite(String choice , Scanner input) {
		AccountBalance account=new AccountBalance();
		 
		if(choice.equalsIgnoreCase("deposite")) {
			System.out.println("Enter the Deposite ammount: ");
			 double deposite=input.nextDouble();
			account.setDepositAmount(deposite);
			
			
		}
		
		
		
		return account;
		
		
		
	}
}
