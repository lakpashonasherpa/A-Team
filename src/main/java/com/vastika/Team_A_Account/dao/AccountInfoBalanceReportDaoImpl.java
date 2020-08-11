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
	public AccountInfoBalanceReport displayById(int customerID) {
		AccountInfoBalanceReport infoReport=new AccountInfoBalanceReport();
		try(
				Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(QueryUtil.GET_BY_ID_SQL_CUSTOMER);
				
				){
				ps.setLong(1,customerID);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					infoReport.setCustomerAccountNum(rs.getInt("customer_id"));
					infoReport.setCustomerName(rs.getString("customer_name"));
					infoReport.setDeposit(rs.getDouble("deposit_amount"));
					infoReport.setInitialBalance(rs.getDouble("account_balance"));
					infoReport.setWithdrawal(rs.getDouble("withdraw_amount"));
			
				}
		}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
			
		return infoReport;
	}

	@Override
	public List<AccountInfoBalanceReport> displayAll() {
List<AccountInfoBalanceReport> report =new ArrayList<>();
		
		try(
				Connection con= DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER_BALANCE);
				){
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				AccountInfoBalanceReport infoReport=new AccountInfoBalanceReport();
				infoReport.setCustomerAccountNum(rs.getLong("customer_id"));
				infoReport.setCustomerName(rs.getString("customer_name"));
				infoReport.setDeposit(rs.getDouble("deposit_amount"));
				infoReport.setInitialBalance(rs.getDouble("account_balance"));
				infoReport.setWithdrawal(rs.getDouble("withdraw_amount"));
				
				report.add(infoReport);
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return report;
	}
	
}
