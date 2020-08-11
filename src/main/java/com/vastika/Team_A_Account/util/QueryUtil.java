package com.vastika.Team_A_Account.util;

public class QueryUtil {
	//creating database DDL
	public static final String CREATETABLE_account_info="CREATE TABLE account_info (customer_id int NOT NULL auto_increment, customer_name varchar(50), customer_address varchar(255), customer_mobileNum bigint, customer_unique_idType varchar(25), customer_unique_id_number int,initial_balance double, PRIMARY KEY (customer_id))";
	public static final String CREATETABLE_account_balance= "CREATE TABLE account_balance (account_transaction_id int NOT NULL auto_increment, account_balance double, deposit_amount double, withdraw_amount double, customer_id int NOT NULL, PRIMARY KEY (account_transaction_id),  KEY customer_id (customer_id), CONSTRAINT account_balance FOREIGN KEY (customer_id) REFERENCES account_info (customer_id))";

	//DML
	public static final String INSERT_SQL_CUSTOMER_INFO= "insert into account_info(customer_name,customer_address, customer_mobileNum,customer_unique_idType,customer_unique_id_number,initial_balance) values(?,?,?,?,?,?)";
	public static final String UPDATE_SQL_CUSTOMER= "update account_info set customer_name=?,customer_address=?, customer_mobileNum=?,customer_unique_idType=?,customer_unique_id_number=?,initial_balance=? where customer_id=? ";
	public static final String LIST_SQL_CUSTOMER= "select * from account_info";
	public static final String  DELETE_SQL_CUSTOMER= "delete from account_info where customer_id=?";
	//this is for deleting customer balance with customer account id
	public static final String  DELETE_SQL_CUSTOMER_BALANCE= "delete from account_balance where customer_id=?";
	public static final String GET_BY_ID_SQL_CUSTOMER= "select account_info.customer_id, account_info.customer_name, account_balance.account_balance, account_balance.deposit_amount, account_balance.withdraw_amount from account_info inner join account_balance on account_info.customer_id = account_balance.customer_id where account_info.customer_id=?";
	public static final String INSERT_SQL_CUSTOMER_BALANCE_BY_ID = "insert into account_balance(account_balance, customer_id) select initial_balance,customer_id from account_info where customer_id = (select max(customer_id) from account_info);";
	public static final String GET_SQL_CUSTOMER_DEPOSIT_BY_ID="select deposit_amount from account_balance where  customer_id=?";
	public static final String Update_SQL_CUSTOMER_WITHDRAWAL_BY_ID="update account_balance set withdraw_amount =? where customer_id=?";
	public static final String LIST_SQL_CUSTOMER_BALANCE="select account_info.customer_id, account_info.customer_name, account_balance.account_balance, account_balance.deposit_amount, account_balance.withdraw_amount from account_info inner join account_balance on account_info.customer_id = account_balance.customer_id";
	public static final String UPDATE_SQL_CUSTOMER_DEPOSIT_BY_ID ="update account_balance set deposit_amount=? where customer_id=?";
	public static final String UPDATE_SQL_CUSTOMER_BALANCE= "update account_balance set account_balance = ? where customer_id=?";

// insert query by using inner join
	public static final String INSERT_SQL_CUSTOMER_BALANCE_INNER_JOIN= "Insert into account_balance (account_balance,customer_id) values(?,?) select account_balance.account_balance, account_balance.customer_id From account_info inner join account_balance on account_info.customer_id = account_balance.customer_id";
	
//insert into account_balance select account_id from account_info
	
	public static final String GET_CUSTOMERID_BALANCE="select customer_id,initial_balance from account_info where customer_id=?  ";
	public static final String INSERT_DEPOSITBAL_TO_ACCBAL="insert into account_balance (account_balance) value(?) select (account_balance + deposit_amount) as account_balance from account_balance where customer_id=?";
	public static final String GET_CUST_BAL_FOR_DEPOSIT="select customer_balance from account_balance where customer_id=?";
}
