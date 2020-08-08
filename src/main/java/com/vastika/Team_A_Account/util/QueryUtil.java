package com.vastika.Team_A_Account.util;

public class QueryUtil {
	
	public static final String INSERT_SQL_CUSTOMER = "insert into account_info(account_id, customer_name,customer_address,customer_mobileNum, customer_unique_id, customer_unique_id_number)values(?,?,?,?,?,?)";

	public static final String DELETE_SQL_CUSTOMER = "delete from account_info where account_id =?";
	
	public static final String UPDATE_SQL_CUSTOMER = "update account_info set customer_name= ?, customer_address=?, customer_mobileNum =?, customer_unique_id =?, customer_unique_id_number=? where id=?";

	public static final String GET_BY_ID_SQL = "select * from account_info where id = ?";

}
