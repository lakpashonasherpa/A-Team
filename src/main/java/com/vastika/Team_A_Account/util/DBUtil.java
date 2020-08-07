package com.vastika.Team_A_Account.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";

	//public static final String URL="mysql:jdbc://localhost:3306/bank_info";
	public static final String URL1 = "jdbc:mysql://localhost:3306/bank_info";
	
	public static final String USERNAME="root";
	
	public static final String PASSWORD="root";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL1, USERNAME, PASSWORD);
		
	}
}
