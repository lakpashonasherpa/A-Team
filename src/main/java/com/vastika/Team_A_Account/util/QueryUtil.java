package com.vastika.Team_A_Account.util;

public class QueryUtil {
	public static final String CREATETABLE_account_info="CREATE TABLE account_info (customer_id int NOT NULL auto_increment, customer_name varchar(50), customer_address varchar(255), customer_mobileNum bigint, customer_unique_idType varchar(25), customer_unique_id_number int,initial_balance double, PRIMARY KEY (customer_id))";
	public static final String CREATETABLE_account_balance= "CREATE TABLE account_balance (account_transaction_id int NOT NULL auto_increment, account_balance double, deposit_amount double, withdraw_amount double, customer_id int NOT NULL, PRIMARY KEY (account_transaction_id),  KEY customer_id (customer_id), CONSTRAINT account_balance FOREIGN KEY (customer_id) REFERENCES account_info (customer_id))";

	//DML for customer info table
	public static final String INSERT_SQL_CUSTOMER= "insert into account_info(customer_id,customer_name,customer_address, customer_mobileNum,customer_unique_id,customer_unique_id_number) values(?,?,?,?,?,?)";	
	public static final String UPDATE_SQL_CUSTOMER= "update account_info set account_id=?,customer_name=?,customer_address=?, customer_mobileNum=?,customer_unique_id=?,customer_unique_id_number=? ";
	public static final String LIST_SQL_CUSTOMER= "select * from account_info";
	public static final String  DELETE_SQL_CUSTOMER= "delete from account_info where account_id=?";
	public static final String GET_BY_ID_SQL_CUSTOMER= "select * from account_info where id=?";
	
	
	//DML for account balance info table
	
	public static final String INSERT_SQL_INITIAL_DEPOSITE="insert into account_balance (account_balance,account_info_id) values(?,?)";
	public static final String INSERT_SQL_BALANCE="insert into account_balance(account_transaction_id, account_balance, deposit_amount, withdraw_amount) values(?,?,?,?)";
	public static final String UPDATE_SQL_BALANCE="update account_balance set account_transaction_id=?,account_balance=?,deposit_amount=?,withdraw_amount=? where account_info_id=?";
	public static final String LIST_SQL_BALANCE="select * from account_balance";
	public static final String GET_BY_ID_SQL_BALANCE="select * from account_balance where customer_id=?";
	public static final String DELETE_SQL_BALANCE="delete from account_balance where account_transaction_id=?";
	public static final String INSERT_DEPOSIT_SQL_BY_JOIN="insert into account_balance(account_transaction_id,account_balance) values(?,?) select account_id from account_info join";
	public static final String DEPOSIT="insert into table account_balance(deposit_amount)value(?)";
	public static final String INSERT_SQL_CUSTOMER_BALANCE_INNER_JOIN= "Insert into account_balance (account_balance,customer_id) values(?,?) select account_balance.account_balance, account_balance.customer_id From account_info inner join account_balance on account_info.customer_id = account_balance.customer_id";
	public static final String UPDATE_SQL_CUSTOMER_DEPOSIT_BY_ID ="update account_balance set deposit_amount=? , account_balance =? where customer_id=?";
	public static final String INSERT_SQL_CUSTOMER_BALANCE_BY_ID = "insert into account_balance(account_balance, customer_id) select initial_balance,customer_id from account_info where customer_id = (select max(customer_id) from account_info);";
	public static final String Update_SQL_CUSTOMER_WITHDRAWAL_BY_ID="update account_balance set withdraw_amount =?, account_balance =? where customer_id=?";
	public static final String LIST_SQL_CUSTOMER_BALANCE="select account_info.customer_id, account_info.customer_name, account_balance.account_balance, account_balance.deposit_amount, account_balance.withdraw_amount from account_info inner join account_balance on account_info.customer_id = account_balance.customer_id where account_info.customer_id=?";

	//displayReport query list
	public static final String LIST_CUSTOMER_RECORD_SQL_BY_ID="SELECT account_info.customer_id, account_info.customer_name,account_info.initial_balance, account_balance.deposit_amount FROM account_info inner join account_balance WHERE account_info.customer_id = account_balance.customer_id;";
	



}
