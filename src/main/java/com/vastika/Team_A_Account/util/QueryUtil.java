package com.vastika.Team_A_Account.util;

public class QueryUtil {
	//creating database DDL
	public static final String CREATETABLE_account_info="CREATE TABLE account_info (account_id int NOT NULL, customer_name varchar(50), customer_address varchar(255), customer_mobileNum bigint, customer_unique_id varchar(25), customer_unique_id_number int, PRIMARY KEY (account_id), UNIQUE KEY customer_unique_id_number (customer_unique_id_number))";
	public static final String CREATETABLE_account_balance= "CREATE TABLE account_balance (account_transaction_id int NOT NULL, account_balance double, deposit_amount double, withdraw_amount double , account_info_id int NOT NULL, PRIMARY KEY (account_transaction_id),  KEY account_info_id (account_info_id), CONSTRAINT account_balance FOREIGN KEY (account_info_id) REFERENCES account_info (account_id))";

	//DML
	public static final String INSERT_SQL_CUSTOMER= "insert into account_info(account_id,customer_name,customer_address, customer_mobileNum,customer_unique_id,customer_unique_id_number) values(?,?,?,?,?,?)";
	public static final String UPDATE_SQL_CUSTOMER= "update account_info set account_id=?,customer_name=?,customer_address=?, customer_mobileNum=?,customer_unique_id=?,customer_unique_id_number=? ";
	public static final String LIST_SQL_CUSTOMER= "select * from account_info";
	public static final String  DELETE_SQL_CUSTOMER= "delete from account_info where account_id=?";
	public static final String GET_BY_ID_SQL_CUSTOMER= "select * from account_info where id=?";
}
