	
	package com.vastika.Team_A_Account.Controller;
	import java.util.List;
	import java.util.Scanner;
	import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDao;
	import com.vastika.Team_A_Account.dao.AccountInfoBalanceReportDaoImpl;
	import com.vastika.Team_A_Account.model.AccountBalance;
	import com.vastika.Team_A_Account.model.AccountInfo;
	import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;
	import com.vastika.Team_A_Account.service.AccontBalanceService;
	import com.vastika.Team_A_Account.service.AccontBalanceServiceImpl;
	import com.vastika.Team_A_Account.service.AccountInfoService;
	import com.vastika.Team_A_Account.service.AccountInfoServiceImpl;


	public class BankController {
			
			public static void main(String[] args) {
				Scanner input = new Scanner(System.in);
				AccountInfoService accInfoServ = new AccountInfoServiceImpl();
				AccontBalanceServiceImpl accBalServ = new AccontBalanceServiceImpl();
				String decision = "";
				try{
				do {
				System.out.println("Please select 1|2 from below option: \n"
						+ "1. Create|Edit Customer Account | 2. View Customer Records| Update Balance: ");
				int selection = input.nextInt();
				
				switch (selection) {
				
				case 1:
					System.out.println("1.Add New Customer | 2.Update Current Customer | 3.Delete Customer");
					int selection1 = input.nextInt();
					if(selection1==1) {
						System.out.println("1.Current Account | 2. Saving Account");
						int selection12= input.nextInt();
						if(selection12==1) {
							System.out.println("------Add Account------");
								AccountInfo saveCustomer = getCustomerInfo();
								//Account acc = new CurrentAccount();
								accInfoServ.saveCustomerInfo(saveCustomer);
								System.out.println("*********************************************");
								System.out.println("Success!!");
								System.out.println("Data has been saved!!!");
								CurrentAccount ca = new CurrentAccount();
								ca.openAccount();	
								break;
							}else if(selection12==2) {
								System.out.println("------Add Account------");
								AccountInfo saveCustomer = getCustomerInfo();
								accInfoServ.saveCustomerInfo(saveCustomer);
								System.out.println("*********************************************");
								System.out.println("Success!!");
								System.out.println("Data has been saved!!!");
								
								SavingAccount sa = new SavingAccount();
								sa.openAccount();	
								break;
						}
					}else if(selection1==2) {
						System.out.println("------Update Account------");
						//AccountInfo accIn = new AccountInfo();
						AccountInfo updateCustomer = getCustomerUpdateInfo();
						accInfoServ.updateCustomerInfo(updateCustomer);
						System.out.println("*********************************************");
						System.out.println("Success!!");
						System.out.println("Data has been updated!!!");
						break;
					}else if (selection1==3) {
						System.out.println("------Delete Account------");
						
							System.out.println("Enter Id:");
			           	  int deleteId = input.nextInt();	  
			           	accInfoServ.deleteCustomerInfo(deleteId);
			           	System.out.println("*********************************************");
			           	System.out.println("Success!!");
						System.out.println("Data has been deleted!!!");
			           	  break;
						
					}else {
						System.out.println("Thank you");
					}
					
					break;
				case 2:
					
					System.out.println("View Customer Records| Update Balance: ");
					System.out.println("*********************************************");
					System.out.println("1.View current Customer Records | 2.Update Balance");
					int selection2= input.nextInt();
					switch (selection2) {
					case 1:
						System.out.println("1.View by CustomerID| 2.View all records");
						int selection3 = input.nextInt();
						if(selection3==1) {
							//view by customerID
							//AccontBalanceService accBalServ = new AccontBalanceServiceImpl();
							AccountInfoBalanceReportDao accInfBalRepo= new AccountInfoBalanceReportDaoImpl();
							System.out.println("Enter customer ID: ");
							int customerId=input.nextInt();
							
							//accInfBalRepo.displayAll();
							System.out.println("==================================================");
							AccountInfoBalanceReport report= accInfBalRepo.displayById(customerId);
							System.out.println("Customer Id is:"+report.getCustomerAccountNum());
							System.out.println("Customer name is: "+report.getCustomerName());
							System.out.println("Initial balance: "+report.getInitialBalance());
							System.out.println("Deposited ammount: "+report.getDeposit());
							System.out.println("Withdraw ammount: "+report.getWithdrawal());
						}else if(selection3==2) {
							//view all records
							AccountInfoBalanceReportDao accInfBalRepo= new AccountInfoBalanceReportDaoImpl();
							List<AccountInfoBalanceReport> customerReportList =accInfBalRepo.displayAll();
							for (AccountInfoBalanceReport u : customerReportList) {
								System.out.println("Customer Id is:"+u.getCustomerAccountNum());
								System.out.println("Customer name is: "+u.getCustomerName());
								System.out.println("Initial balance: "+u.getInitialBalance());
								System.out.println("Deposited ammount: "+u.getDeposit());
								System.out.println("Withdraw ammount: "+u.getWithdrawal());
								System.out.println("==============");
						}
							}
						break;
					case 2:
						System.out.println("Update Balance");
						System.out.println("1. Deposit Balance |2.Withdrawal Balance ");
						int selection4=input.nextInt();
						if(selection4==1) {
							//deposit balance
							DepositBalance();
							System.out.println("Success!!");
							System.out.println("Amount has been deposited!!!");
						}else if (selection4==2) {
							
							//withdrawal
							withdrawalBalance();
							
							System.out.println("Success!!");
							System.out.println("Amount has been withdrawn!!!");
							
							break;
						}
						
					}
				
				default:
					System.out.println("=====================");
					System.out.println("Thank you!!!");
					}
				System.out.println("");
				System.out.println("Return to the main menu? (Y/N)");
				decision = input.next().toLowerCase();
				}while(decision.equals("y"));
				}catch(Exception e) {
					System.out.println(e);
				}finally {
					input.close();
				}
				
			}
			
		public static AccountInfo getCustomerInfo() {
		
			AccountInfo accInfoCustomerInfo = new AccountInfo();
			
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
			accInfoCustomerInfo.setCustomerUniqueId(uniqueIdnum);
			accInfoCustomerInfo.setInitialBalance(bal);
			
			
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
			accInfoCustomerInfo.setCustomerUniqueId(uniqueIdnum);
			accInfoCustomerInfo.setInitialBalance(bal);
			accBalCustomer.setAccountBalance(bal);
			
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				sc.close();
			}
			return accInfoCustomerInfo;
		}
		public static void withdrawalBalance() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer ID Number: ");
			int customerId=sc.nextInt();
			System.out.println("Enter balnace to be withdraw: ");
			double amount = sc.nextDouble();
			AccontBalanceService accBalServ = new AccontBalanceServiceImpl();
			accBalServ.withdrawalBalance(customerId,amount);
			sc.close();
		}
		public static void DepositBalance() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer ID Number: ");
			int customerId=sc.nextInt();
			System.out.println("Enter balnace to be deposit: ");
			double amount = sc.nextDouble();
			AccontBalanceService accBalServ = new AccontBalanceServiceImpl();
			accBalServ.depositBalance(customerId, amount);
			sc.close();
		}
		
		public static void openAccount(Account ac) {
			ac.openAccount();
		}
		
		
}
