package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountBalanceDaoImpl implements AccountBalanceDao {

	@Override
	public void displayAccountInfo(long customerAccountNum) {
		
		AccountBalance accBal = new AccountBalance();
		
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
		AccountInfo accInfo = new AccountInfo();
		
		double balance= accInfo.getInitialBalance();
		
		balance = balance+amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_DEPOSIT_BY_ID);
				PreparedStatement ps1 = con.prepareStatement(QueryUtil.GET_SQL_CUSTOMER_DEPOSIT_BY_ID);
				
				){
			
			ps.setLong(1, customerAccountNum);
			ps.setDouble(2, amount);
			ps.setDouble(3, balance);
			ps.executeUpdate();
			ps1.setLong(1, customerAccountNum);
			 ps1.executeQuery();
			
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
	//	return balance;
	}

	@Override
	public List<AccountBalance> getAllAccountBalance() {

		List<AccountInfo> accInfoList = new ArrayList<>();
		List<AccountBalance> accbalList = new ArrayList<>();
		List<String> totalList =new ArrayList<>();
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER_BALANCE);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountInfo accInfo = new AccountInfo();
				accInfo.setCustomerAccountNum(rs.getLong("account_id"));
				accInfo.setCustomerName(rs.getString("customer_name"));
				accInfoList.add(accInfo);
				
				AccountBalance accBal = new AccountBalance();
				accBal.setAccountBalance(rs.getDouble("total_balance"));
				accBal.setDeposit(rs.getDouble("deposit_amount"));
				accBal.setWithdrawal(rs.getDouble("withdrawal_amount"));
				accbalList.add(accBal);
				
			}
		//	totalList.addAll(accbalList);
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		} 
		return null;
	}

}
