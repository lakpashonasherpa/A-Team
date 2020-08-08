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
	public double displayAccountInfo(long customerAccountNum) {
		
		AccountInfo accInfo = new AccountInfo();
		
		double balance= accInfo.getInitialBalance();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.Update_SQL_CUSTOMER_BALANCE_BY_ID)
				){
			ps.setLong(1, customerAccountNum);
			balance = ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		return balance;
	}

	@Override
	public double depositBalance(long customerAccountNum, double amount) {
		AccountInfo accInfo = new AccountInfo();
		
		double balance= accInfo.getInitialBalance();
		
		balance = balance+amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.Update_SQL_CUSTOMER_DEPOSIT_BY_ID)
				){
			
			ps.setLong(1, customerAccountNum);
			balance = ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public double withdrawalBalance(long customerAccountNum, double amount) {
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
		return balance;
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
			//select account_info.account_id, account_info.customer_name, account_balance.account_balance, 
			//account_balance.deposit_amount, account_balance.withdraw_amount
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
			//totalList.addAll(accbalList);
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		} 
		return null;
	}

}
