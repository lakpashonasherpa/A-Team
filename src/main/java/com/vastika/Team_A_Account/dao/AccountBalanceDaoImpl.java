package com.vastika.Team_A_Account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.Team_A_Account.model.AccountBalance;
import com.vastika.Team_A_Account.util.DBUtil;
import com.vastika.Team_A_Account.util.QueryUtil;

public class AccountBalanceDaoImpl implements AccountBalanceDao {

	@Override
	public int saveBalanceInfo(AccountBalance account) {
		int saved = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL_BALANCE);

		) {
			ps.setDouble(1, account.getAccountBalance());
			ps.setDouble(2, account.getDepositAmount());
			ps.setDouble(3, account.getWithdrawAmount());

			saved = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateBalanceInfo(AccountBalance account) {
		int update = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL_BALANCE);

		) {
			ps.setDouble(1, account.getAccountBalance());
			ps.setDouble(2, account.getDepositAmount());
			ps.setDouble(3, account.getWithdrawAmount());

			ps.setInt(4, account.getAccountInfoId());

			update = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return update;
	}

	@Override
	public void deleteBalanceInfo(AccountBalance account) {
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL_BALANCE);) {
			ps.setInt(1, account.getTransactionId());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountBalance getBalanceInfoById(int transactionId) {
		AccountBalance account = new AccountBalance();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_TID_SQL_BALANCE);

		) {
			ps.setInt(1, transactionId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				account.setTransactionId(rs.getInt("account_transaction_id"));
				account.setAccountBalance(rs.getDouble("account_balance"));
				account.setDepositAmount(rs.getDouble("deposit_amount"));
				account.setWithdrawAmount(rs.getDouble("withdraw_amount"));
				account.setAccountInfoId(rs.getInt("account_info_id"));

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<AccountBalance> getAllAcInfo() {
		List<AccountBalance> balanceList= new ArrayList<>();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL_BALANCE);

		) {
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			AccountBalance account =new AccountBalance();
				account.setTransactionId(rs.getInt("account_transaction_id"));
				account.setAccountBalance(rs.getDouble("account_balance"));
				account.setDepositAmount(rs.getDouble("deposit_amount"));
				account.setWithdrawAmount(rs.getDouble("withdraw_amount"));
				account.setAccountInfoId(rs.getInt("account_info_id"));
				balanceList.add(account);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return balanceList;
	}

}
