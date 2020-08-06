package com.vastika.Team_A_Account.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static final String DRIVER="com.mysql.cj.jdbc.Driver";

	public static final String URL="jdbc:mysql://localhost:3307/team_a_db_p1";
	
	public static final String USERNAME="root";
	
	public static final String PASSWORD="root";
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		
	}
}
