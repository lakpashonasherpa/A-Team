package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountInfoDaoImpl implements AccountInfoDao{

	@Override
	public int saveCustomerInfo(AccountInfo accInfo) {
		
		int saved=0;
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_INFO);
			
				){
				
				ps.setString(1,accInfo.getCustomerName());
				ps.setString(2, accInfo.getCustomerAddress());
				ps.setLong(3, accInfo.getCustomerPhoneNumber());
				ps.setString(4, accInfo.getCustomerUniqueIdType());
				ps.setLong(5, accInfo.getCustomerUniqueIdNum());
				ps.setDouble(6, accInfo.getInitialBalance());
			
			saved =ps.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		
		return saved;
	}
	@Override
	public void saveCustomerBalance( double balance,int customerNum) {
		int saved=0;
		AccountInfo accInfo = new AccountInfo();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_BALANCE_BY_ID);
				
				){
			
				double balance1 = 4500;
				long customerId =8;
				ps.setDouble(1, balance1);
				ps.setLong(2, customerId);
				
			saved =ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
		//return saved;
		
	}

	@Override
	public int updateCustomerInfo(AccountInfo accInfo) {
		int updated =0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER);
				){
			
				
				ps.setString(1,accInfo.getCustomerName());
				ps.setString(2, accInfo.getCustomerAddress());
				ps.setLong(3, accInfo.getCustomerPhoneNumber());
				ps.setString(4, accInfo.getCustomerUniqueIdType());
				ps.setLong(5, accInfo.getCustomerUniqueIdNum());
				ps.setDouble(6, accInfo.getInitialBalance());
				ps.setInt(7, accInfo.getCustomerAccountNum());
							
			updated=	ps.executeUpdate();
							
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
			
		return updated;
	}

	@Override
	public void deleteCustomerInfo(int customerId) {
		//Scanner sc = new Scanner(System.in);
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps1 = con.prepareStatement(QueryUtil.DELETE_SQL_CUSTOMER);
				PreparedStatement ps2 = con.prepareStatement(QueryUtil.DELETE_SQL_CUSTOMER_BALANCE);
				){
				ps1.setLong(1,customerId);
				ps2.setLong(1, customerId);
				ps1.executeUpdate();
				ps2.executeUpdate();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public AccountInfo getCustomerById(int customerId) {
		AccountInfo accInfo = new AccountInfo();
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL_CUSTOMER)
				){
				ps.setLong(1, customerId);
				
				 ResultSet rs = ps.executeQuery();
			
				 if(rs.next()) {
				
					 //accInfo.setCustomerAccountNum(rs.getLong("account_id"));
					 accInfo.setCustomerName(rs.getString("customer_name"));
					 accInfo.setCustomerAddress(rs.getString("customer_address"));
					 accInfo.setCustomerPhoneNumber(rs.getLong("customer_mobileNum"));
					 accInfo.setCustomerUniqueIdType(rs.getString("customer_unique_idType"));
					 accInfo.setCustomerUniqueIdNum(rs.getLong("customer_unique_id_number"));	
					 accInfo.setInitialBalance(rs.getDouble("initialBalance"));
					
				 }
				 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		} 
		return accInfo;
	}

	@Override
	public List<AccountInfo> getAllCustomerList() {
		
		List<AccountInfo> accountInfoList = new ArrayList<>();
		
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER);
				){
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				AccountInfo accInfo = new AccountInfo();
				// accInfo.setCustomerAccountNum(rs.getLong("account_id"));
				 accInfo.setCustomerName(rs.getString("customer_name"));
				 accInfo.setCustomerAddress(rs.getString("customer_address"));
				 accInfo.setCustomerPhoneNumber(rs.getLong("customer_mobileNum"));
				 accInfo.setCustomerUniqueIdType(rs.getString("customer_unique_idType"));
				 accInfo.setCustomerUniqueIdNum(rs.getLong("customer_unique_id_number"));
				 accInfo.setInitialBalance(rs.getDouble("initialBalance"));
				 accountInfoList.add(accInfo);
				 
			}
				
			
		} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
		}		
		return accountInfoList;
	}
	


	
	

}
