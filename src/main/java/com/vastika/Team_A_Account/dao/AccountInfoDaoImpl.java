package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountInfoDaoImpl implements AccountInfoDao{

	@Override
	public int saveCustomerInfo(AccountInfo accInfo) {
		int saved=0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER);
				){
				ps.setString(1, accInfo.getCustomerName());
				ps.setString(2, accInfo.getCustomerAddress());
				ps.setLong(3,accInfo.getCustomerPhoneNumber());
				ps.setString(4, accInfo.getCustomerUniqueIdType());
				ps.setLong(5, accInfo.getCustomerUniqueIdNum());
				
				saved =ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return saved;
	}

	@Override
	public int updateCustomerInfo(AccountInfo accInfo) {
		int updated =0;
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER);
				){
			
			
			
			updated=	ps.executeUpdate();
				
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
			
		return updated;
	}

	@Override
	public void deleteCustomerInfo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountInfo getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountInfo> getAllCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

}
