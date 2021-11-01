package com.greycampus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateNewEmployee {
	public int save(Employee employee) {
		Connection connection=null;
		PreparedStatement preparestatement=null;
		int count=0;
		String sql="insert into Customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##bms","abc");
		    preparestatement=connection.prepareStatement(sql);
		    
		    preparestatement.setInt(1, employee.getCid());
		    preparestatement.setString(2, employee.getFirstname()); 
		    preparestatement.setString(3, employee.getLastname());
		    preparestatement.setString(4, employee.getStreet());
		    preparestatement.setString(5, employee.getCity());
		    preparestatement.setString(6, employee.getState());
		    preparestatement.setInt(7, employee.getZipcode());
		    preparestatement.setString(8, employee.getProduct_name());
		    preparestatement.setDate(9, (Date) employee.getCreated_on());
		    preparestatement.setString(10, employee.getCreated_by());
		    preparestatement.setDate(11, (Date) employee.getUpdated_on());
		    preparestatement.setString(12, employee.getUpdated_by());
		    count=preparestatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				preparestatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
