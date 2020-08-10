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
import com.vastika.Team_A_Account.service.AccontBalanceService;
import com.vastika.Team_A_Account.service.AccontBalanceServiceImpl;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class test {

	public static void main(String[] args) {
		AccontBalanceService accBalServ = new AccontBalanceServiceImpl();
		double balance=1000;
		double depositamount=4000;
		double withdrawamount=300;
		int customerId=8;
		
		accBalServ.displayAccountInfo(customerId,balance);
		System.out.println("success");
		
		
		}
		

	}
	


