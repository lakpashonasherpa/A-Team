package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfoBalanceReport;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountInfoBalanceReportDaoImpl implements AccountInfoBalanceReportDao{

	@Override
	public AccountInfoBalanceReport displayById(int customerId) {
		AccountInfoBalanceReport infoReport=new AccountInfoBalanceReport();
		try(
				Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(QueryUtil.LIST_CUSTOMER_RECORD_SQL_BY_ID);
				
				){
			//ps.setLong(1,customerId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				infoReport.setCustomerAccountNum(rs.getLong("customer_id"));
				infoReport.setCustomerName(rs.getString("customer_name"));
				infoReport.setInitialBalance(rs.getDouble("initial_balance"));
				infoReport.setDeposit(rs.getDouble("deposit_amount"));
				infoReport.setWithdrawal(rs.getDouble("withdraw_amount"));
				infoReport.setInitialBalance(rs.getDouble("account_balance"));
				
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		
		
		return infoReport;
	}

	@Override
	public List<AccountInfoBalanceReport> displayAll() {
		List<AccountInfoBalanceReport> report =new ArrayList<>();
		
		try(
				Connection con= DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(QueryUtil.LIST_CUSTOMER_RECORD_SQL_BY_ID);
				){
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				AccountInfoBalanceReport infoReport=new AccountInfoBalanceReport();
				infoReport.setCustomerAccountNum(rs.getLong("customer_id"));
				infoReport.setCustomerName(rs.getString("customer_name"));
				infoReport.setInitialBalance(rs.getDouble("initial_balance"));
				infoReport.setDeposit(rs.getDouble("deposit_amount"));
				infoReport.setWithdrawal(rs.getDouble("withdraw_amount"));
				infoReport.setInitialBalance(rs.getDouble("account_balance"));
				
				
				report.add(infoReport);
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		return report;
	}

	@Override
	public double calculateTotalBalance(double initial, double deposite, double withdraw) {
		// TODO Auto-generated method stub
		return 0;
	}

}
