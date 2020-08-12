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
	public void displayAccountInfo(int customerAccountNum) {
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_CUSTOMER_RECORD_SQL_BY_ID);
				){
			ps.setInt(1, customerAccountNum);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				AccountBalance acBal=new AccountBalance();
				AccountInfo acInfo=new AccountInfo();
				
				acInfo.setCustomerAccountNum(rs.getInt("customer_id"));
				acInfo.setCustomerName(rs.getString("cunstomer_name"));
				acBal.setDeposit(rs.getDouble("deposit_amount"));
				acBal.setWithdrawal(rs.getDouble("withdraw_amount"));
				acBal.setTotalBalance(rs.getDouble("account_balance"));
				
				
				
				
				
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		//return balance;
	
		
	}

	@Override
	public void depositBalance(int customerAccountNum, double amount) {
		
				
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER_DEPOSIT_BY_ID);
				){
			
			ps.setDouble(1, amount);
			ps.setLong(2, customerAccountNum);
			
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
				ps.setInt(2, customerAccountNum);
				
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
				rep.setCustomerAccountNum(rs.getLong("customer_id"));
				rep.setCustomerName(rs.getString("customer_name"));
				rep.setInitialBalance(rs.getDouble("account_balance"));
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
	public AccountBalance totalBalance(int customerAccountNum) {
		AccountBalance acBal= new AccountBalance();
		try(
				Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(QueryUtil.GET_TOTAL_BALANCE_BY_ID);
				
				){
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				acBal.setTotalBalance(rs.getDouble("acount_balance"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return acBal;
		
		
	}

	
}
