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
		try (
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER);
				PreparedStatement ps1=con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_BALANCE_BY_ID);

		) {
			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerAddress());
			ps.setLong(3, customer.getCustomerPhoneNumber());
			ps.setString(4, customer.getCustomerUniqueIdType());
			ps.setDouble(5, customer.getCustomerUniqueId());
			ps.setDouble(6, customer.getInitialBalance());

				ps.executeUpdate();
			saved = ps1.executeUpdate();
			ps.close();


		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateCustomerInfo(AccountInfo customer) {
		int update = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_CUSTOMER);) {

			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getCustomerAddress());
			ps.setLong(3, customer.getCustomerPhoneNumber());
			ps.setString(4, customer.getCustomerUniqueIdType());
			ps.setLong(5, customer.getCustomerUniqueId());
			ps.setDouble(6, customer.getInitialBalance());
			ps.setInt(7,customer.getCustomerAccountNum());

			update = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return update;

	}

	@Override
	public void deteteCustomerInfo(int customerId) {
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL_CUSTOMER);
				PreparedStatement ps1= con.prepareStatement(QueryUtil.DELETE_SQL_CUSTOMER_BALANCE)
				
				) {

			ps.setInt(1, customerId);
			
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public AccountInfo getCustomerInfoByID(int id) {
		AccountInfo customer = new AccountInfo();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL_CUSTOMER);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//customer.setId(rs.getInt("account_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setCustomerPhoneNumber(rs.getLong("customer_mobileNum"));
				customer.setCustomerUniqueIdType(rs.getString("customer_unique_idType"));
				customer.setCustomerUniqueId(rs.getInt("customer_unique_id_number"));
				customer.setInitialBalance(rs.getDouble("inititalBalance"));
				
			
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<AccountInfo> getAllCustomerInfo() {
		AccountInfo customer = new AccountInfo();
		List<AccountInfo> getAllCustomer = new ArrayList<AccountInfo>();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_CUSTOMER);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomerAccountNum(rs.getInt("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerAddress(rs.getString("customer_address"));
				customer.setCustomerPhoneNumber(rs.getLong("customer_mobileNum"));
				customer.setCustomerUniqueIdType(rs.getString("customer_unique_idType"));
				customer.setCustomerUniqueId(rs.getInt("customer_unique_id_number"));
				customer.setInitialBalance(rs.getDouble("inititalBalance"));
				
				
				getAllCustomer.add(customer);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return getAllCustomer;
	}

	@Override
	public void saveCustomerBalance(double amount, int customerId) {
		int saved=0;
		AccountInfo accInfo = new AccountInfo();
		try(
				Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_CUSTOMER_BALANCE_BY_ID);
				
				){
			
				//double balance1 = 4500;
				//int customerId =8;
				ps.setDouble(1, amount);
				ps.setLong(2, customerId);
				
			saved =ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
