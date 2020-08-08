package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountInfo;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountInfoDaoImpl implements AccountInfoDao {

	@Override
	public int saveCustomerInfo(AccountInfo customer) {
		int saved = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER);) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setLong(3, customer.getMobileNo());
			ps.setInt(4, customer.getUniqueId());

			saved = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateCustomerInfo(AccountInfo customer) {
		int update = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER);) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setLong(3, customer.getMobileNo());
			ps.setInt(4, customer.getUniqueId());
			ps.setInt(5, customer.getId());

			update = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return update;

	}

	@Override
	public void deteteCustomerInfo(int id) {
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL_CUSTOMER);) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public AccountInfo getCustomerInfoByID(int id) {
		AccountInfo customer=new AccountInfo();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL_CUSTOMER);
				) {
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				customer.setId(rs.getInt("account_id"));
				customer.setName(rs.getString("customer_name"));
				customer.setAddress(rs.getString("customer_address"));
				customer.setMobileNo(rs.getLong("customer_mobileNum"));
				customer.setUniqueId(rs.getInt("customer_unique_no"));
			}
			

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<AccountInfo> getAllCustomerInfo() {
		AccountInfo customer=new AccountInfo();
		List<AccountInfo> getAllCustomer=new ArrayList<AccountInfo>();
		try(
			Connection con =DBUtil.getConnection();
				PreparedStatement ps =con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER);
				){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				customer.setId(rs.getInt("account_id"));
				customer.setName(rs.getString("customer_name"));
				customer.setAddress(rs.getString("customer_address"));
				customer.setMobileNo(rs.getLong("customer_mobileNum"));
				customer.setUniqueId(rs.getInt("customer_unique_id"));
				getAllCustomer.add(customer);
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return getAllCustomer;
	}

}
