package com.vastika.Team_A_Account.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) {
		try(Connection con = DBUtil.getConnection();
				PreparedStatement ps1 = con.prepareStatement(QueryUtil.CREATETABLE_account_info);
				PreparedStatement ps2 = con.prepareStatement(QueryUtil.CREATETABLE_account_balance);
				){
				
			ps1.executeUpdate();
			ps2.executeUpdate();
			
			System.out.println("Account Info Table and Account Balance Table has been created!!!");
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		} 
		
	}

}
