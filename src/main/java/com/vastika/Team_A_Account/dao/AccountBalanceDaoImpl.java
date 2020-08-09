package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.model.Report;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountBalanceDaoImpl implements AccountBalanceDao {

	@Override
	public void displayAccountInfo(long customerAccountNum) {
		AccountInfo accInfo = new AccountInfo();
		AccountBalance accBal = new AccountBalance();
		customerAccountNum = accInfo.getCustomerAccountNum();
		//double balance= accBal.getInitialBalance();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.Update_SQL_CUSTOMER_BALANCE_BY_ID)
				){
			ps.setLong(1, customerAccountNum);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				accBal.setTranscationId(rs.getLong("account_transaction_id"));
				accBal.setAccountBalance(rs.getDouble("account_balance"));
				accBal.setDeposit(rs.getDouble("deposit_amount"));
				accBal.setWithdrawal(rs.getDouble("withdraw_amount"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		//return balance;
	}

	@Override
	public void depositBalance(long customerAccountNum, double amount) {
		//int updated =0;
		AccountInfo accInfo = new AccountInfo();
		
		double balance= accInfo.getInitialBalance();
		
		balance = balance+amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_DEPOSIT_BY_ID);
				//PreparedStatement ps1 = con.prepareStatement(QueryUtil.GET_SQL_CUSTOMER_DEPOSIT_BY_ID);
				
				){
			
			ps.setDouble(1, amount);
			ps.setDouble(2, balance);
			ps.setLong(3, customerAccountNum);
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void withdrawalBalance(long customerAccountNum, double amount) {
		AccountInfo accInfo = new AccountInfo();
		double balance = accInfo.getInitialBalance();
		balance = balance-amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.Update_SQL_CUSTOMER_WITHDRAWAL_BY_ID)
				){
			
				ps.setLong(1, customerAccountNum);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Report> getAllAccountBalancewithCustomerInfo() {

		List<Report> reports = new ArrayList<>();
		
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER_BALANCE);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Report rep = new Report();
				rep.setCustomerAccountNum(rs.getLong("account_id"));
				rep.setCustomerName(rs.getString("customer_name"));
				rep.setInitialBalance(rs.getDouble("total_balance"));
				rep.setDeposit(rs.getDouble("deposit_amount"));
				rep.setWithdrawal(rs.getDouble("withdraw_amount"));
				
				reports.add(rep);
				
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		} 
		return reports;
	}

}
