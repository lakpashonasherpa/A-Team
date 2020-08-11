package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountBalanceDaoImpl implements AccountBalanceDao {

	@Override
	public void displayAccountInfo(int customerAccountNum, double amount) {
		AccountInfo accInfo = new AccountInfo();
		AccountBalance accBal = new AccountBalance();
		//customerAccountNum = accInfo.getCustomerAccountNum();
		//double balance= accBal.getAccountBalance();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_BALANCE_BY_ID);
				){
			ps.setDouble(1, amount);
			//ps.setInt(2, x);
			
			
			ps.executeUpdate();
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		//return balance;
	
		
	}

	@Override
	public void depositBalance(int customerAccountNum, double amount) {
		double balance =0;
		AccountInfo accInfo = new AccountInfo();
		
		//double balance= accInfo.getInitialBalance();
		
		balance = balance+amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER_DEPOSIT_BY_ID);
				//PreparedStatement ps1 = con.prepareStatement(QueryUtil.GET_SQL_CUSTOMER_DEPOSIT_BY_ID);
				
				){
			
			ps.setDouble(1, amount);
			ps.setDouble(2, balance);
			ps.setLong(3, customerAccountNum);
			
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void withdrawalBalance(int customerAccountNum, double amount) {
AccountInfo accInfo = new AccountInfo();
		
		double balance = accInfo.getInitialBalance();
		balance = balance-amount;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.Update_SQL_CUSTOMER_WITHDRAWAL_BY_ID)
				){
				ps.setDouble(1, amount);
				ps.setDouble(2, balance);
				ps.setInt(3, customerAccountNum);
				
				ps.executeUpdate();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<AccountInfoBalanceReport> getAllAccountBalancewithCustomerInfo() {
		
		List<AccountInfoBalanceReport> accountInfoBalanceReports = new ArrayList<>();
		
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER_BALANCE);
				){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AccountInfoBalanceReport rep = new AccountInfoBalanceReport();
				rep.setCustomerAccountNum(rs.getLong("account_id"));
				rep.setCustomerName(rs.getString("customer_name"));
				rep.setInitialBalance(rs.getDouble("total_balance"));
				rep.setDeposit(rs.getDouble("deposit_amount"));
				rep.setWithdrawal(rs.getDouble("withdraw_amount"));
				
				accountInfoBalanceReports.add(rep);
				
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		} 
		return accountInfoBalanceReports;
	
		
	}

	@Override
	public int depositeBalance(AccountBalance depositAmount) {
		
		return 0;
	}

}
