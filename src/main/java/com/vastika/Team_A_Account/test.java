package com.vastika.Team_A_Account;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vastika.Team_A_Account.dao.AccountBalanceDao;
import com.vastika.Team_A_Account.dao.AccountBalanceDaoImpl;
import com.vastika.Team_A_Account.dao.AccountInfoDao;
import com.vastika.Team_A_Account.dao.AccountInfoDaoImpl;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class test {

	public static void main(String[] args) {
		AccountBalanceDao accBalDao = new AccountBalanceDaoImpl();
		AccountInfoDao accInfod = new AccountInfoDaoImpl();
		BankController bk = new BankController();
		AccountInfo accInfo = new AccountInfo();
		//long customerId=8;
		//double balance=3000;
				
		//accInfod.saveCustomerBalance(balance,customerId);	
		bk.getCustomerInfo();
		//System.out.println(accInfo.getCustomerAccountNum());
		System.out.println("your balance is: "+accInfo.getInitialBalance());
		
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_CUSTOMERID_BALANCE);){
			ResultSet rs = ps.executeQuery();
			
			 if(rs.next()) {
			
				 //accInfo.setCustomerAccountNum(rs.getLong("account_id"));
				 accInfo.setCustomerAccountNum(rs.getInt("customer_id"));
				 accInfo.setInitialBalance(rs.getDouble("initialBalance"));
				
			 }
			 System.out.println("Success!!!\n"
						+ "Balance has been inserted!!!");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		}
		

	}
	


