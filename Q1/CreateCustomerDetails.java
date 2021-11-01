package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCustomerDetails {

	public static void main(String[] args) {
		
		Connection connection=null;
		Statement statement=null;
		
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","c##bms", "abc");
			statement = connection.createStatement();
			statement.executeQuery("CREATE table Customer_details("
					+ "cid int,firstname varchar2(20),lastname varchar2(20),"
					+ "street varchar2(20),city varchar2(20),state varchar2(20),zipcode int,product_name varchar2(20),"
					+ "created_on date,created_by varchar2(20),update_on date,updated_by varchar2(20))");
			System.out.println("table Customer_details created");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
