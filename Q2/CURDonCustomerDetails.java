package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CURDonCustomerDetails {
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparestatement = null;
		ResultSet rs = null;
		Statement statement = null;
//		Scanner scanner = new Scanner(System.in);

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##bms", "abc");
			statement = connection.createStatement();
//			statement.execute("CREATE table Customer_details(\r\n" + "cid int,\r\n" + "firstname varchar2(20),\r\n"
//					+ "lastname varchar2(20),\r\n" + "street varchar2(20),\r\n" + "city varchar2(20),\r\n"
//					+ "state varchar2(20),\r\n" + "zipcode int,\r\n" + "product_name varchar2(20),\r\n"
//					+ "created_on date,\r\n" + "created_by varchar2(20),\r\n" + "update_on date,\r\n"
//					+ "updated_by varchar2(20));");
			System.out.println("table employ created");
			preparestatement = connection.prepareStatement("insert into Customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)");

			preparestatement.setInt(1, 1);
			preparestatement.setString(2, "anurag");
			preparestatement.setString(3, "harsh");
			preparestatement.setString(4, "street1");
			preparestatement.setString(5, "ranchi");
			preparestatement.setString(6, "jharkhand");
			preparestatement.setInt(7, 835217);
			preparestatement.setString(8, "bms");
			preparestatement.setDate(9, getCurrentDate());
			preparestatement.setString(10, "anurag");
			preparestatement.setDate(11, getCurrentDate());
			preparestatement.setString(12, "anurag");
			int count = preparestatement.executeUpdate();
			System.out.println(count);

			rs = preparestatement.executeQuery("select * from employ");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getString(8));
				System.out.println(rs.getDate(9));
				System.out.println(rs.getString(10));
				System.out.println(rs.getDate(10));
				System.out.println(rs.getString(12));
			}
//			preparestatement=connection.prepareStatement("UPDATE Customer_details set firstname=? where cid=?");
//			preparestatement.setInt(1, 1);
//			preparestatement.setString(2, "anurag");
//			preparestatement.executeUpdate();
//			statement.executeQuery("delete from Customer_details where cid=1");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparestatement.close();
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
