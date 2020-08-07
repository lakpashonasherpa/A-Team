package com.vastika.Team_A_Account.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB_Bank_Info {
	private static final String CREATE_DB="create database bank_info";
	
	public static void main(String[] args) {
	try(
			Connection con = DBUtil.getConnection();
			Statement st = con.createStatement();
			){
			
			st.executeUpdate(CREATE_DB);
			System.out.println("Database has been created!!!");
			
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	} 

	}

}
