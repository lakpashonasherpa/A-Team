package com.vastika.Team_A_Account;
import java.util.Scanner;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.service.AccontBalanceServiceImpl;
import com.vastika.Team_A_Account.service.AccountInfoService;
import com.vastika.Team_A_Account.service.AccountInfoServiceImpl;

public class BankController {
		
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			AccountInfoService accInfoServ = new AccountInfoServiceImpl();
			AccontBalanceServiceImpl accBalServ = new AccontBalanceServiceImpl();
			try{
			
			System.out.println("Please select 1|2 from below option: \n"
					+ "1. Create|Edit Customer Account | 2. View|Update Customer And Their Balances ");
			int selection = input.nextInt();
			
			switch (selection) {
			
			case 1:
				System.out.println("1.Add New Customer |2.Update Current Customer");
				int selection1 = input.nextInt();
				if(selection1==1) {
					
				AccountInfo saveCustomer = getCustomerInfo();
				accInfoServ.saveCustomerInfo(saveCustomer);
				
				
				System.out.println("Success!!");
				System.out.println("Data has been saved!!!");
				
				}else if(selection1==2) {
					AccountInfo accIn = new AccountInfo();
					AccountInfo updateCustomer = getCustomerUpdateInfo();
					accInfoServ.updateCustomerInfo(updateCustomer);
					System.out.println("Success!!");
					System.out.println("Data has been updated!!!");
					
				}else {
					System.out.println("Invalid Input!!!\n"
							+ "Please try again!!!");
				}
				
				break;
			case 2:
				
				System.out.println("1.Update Present Customer Info | ");
				
				break;
			
			case 3:
				break;
			
			default:
				System.out.println("Invalid Input!!!\n"
						+ "Please try again!!!");
				}
			
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				input.close();
			}
			
		}
		
	public static AccountInfo getCustomerInfo() {
	
		AccountInfo accInfoCustomerInfo = new AccountInfo();
		AccountBalance accBal = new AccountBalance();
		
		Scanner sc = new Scanner(System.in);
		try{
		System.out.println("Enter customer name: ");
		String name = sc.next();
		System.out.println("Enter customer address: ");
		String address = sc.next();
		System.out.println("Enter customer phone number: ");
		long phone= sc.nextLong();
		System.out.println("Enter customer id type: ");
		String idType = sc.next();
		System.out.println("Enter document id number: ");
		long uniqueIdnum = sc.nextLong();
		System.out.println("Enter initial balance: ");
		double bal = sc.nextDouble();
		
		accInfoCustomerInfo.setCustomerName(name);
		accInfoCustomerInfo.setCustomerAddress(address);
		accInfoCustomerInfo.setCustomerPhoneNumber(phone);
		accInfoCustomerInfo.setCustomerUniqueIdType(idType);
		accInfoCustomerInfo.setCustomerUniqueIdNum(uniqueIdnum);
		//accInfoCustomerInfo.setInitialBalance(300);
		
		
		}catch (Exception e) {
			System.out.println(e);
		}
		return accInfoCustomerInfo;
	}
	public static AccountInfo getCustomerUpdateInfo() {
		
		AccountInfo accInfoCustomerInfo = new AccountInfo();
		AccountBalance accBalCustomer = new AccountBalance();
		
		Scanner sc = new Scanner(System.in);
		
		try{
			System.out.println("Enter customer account number: ");
			int customerAccountNum = sc.nextInt();
		
		accInfoCustomerInfo.setCustomerAccountNum(customerAccountNum);
		 
		
		System.out.println("Enter customer name: ");
		String name = sc.next();
		System.out.println("Enter customer address: ");
		String address = sc.next();
		System.out.println("Enter customer phone number: ");
		long phone= sc.nextLong();
		System.out.println("Enter customer id type: ");
		String idType = sc.next();
		System.out.println("Enter document id number: ");
		long uniqueIdnum = sc.nextLong();
		System.out.println("Enter initial balance: ");
		double bal = sc.nextDouble();
		
		accInfoCustomerInfo.setCustomerName(name);
		accInfoCustomerInfo.setCustomerAddress(address);
		accInfoCustomerInfo.setCustomerPhoneNumber(phone);
		accInfoCustomerInfo.setCustomerUniqueIdType(idType);
		accInfoCustomerInfo.setCustomerUniqueIdNum(uniqueIdnum);
		accInfoCustomerInfo.setInitialBalance(bal);
		accBalCustomer.setAccountBalance(bal);
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			sc.close();
		}
		return accInfoCustomerInfo;
	}
	
	
	}
