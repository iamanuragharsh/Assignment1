package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetriveData {

	public ArrayList<Employee> getAllData() {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Employee> empList = null;

		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##bms", "abc");
			statement = connection.createStatement();
			resultset = statement.executeQuery("select * from emp1");
			empList = new ArrayList<Employee>();
			while (resultset.next()) {
				Employee employee = new Employee();
				employee.setCid(resultset.getInt("cid"));
				employee.setFirstname(resultset.getString("firstname"));
				employee.setLastname(resultset.getString("lastname"));
				employee.setStreet(resultset.getString("street"));
				employee.setCity(resultset.getString("city"));
				employee.setState(resultset.getString("state"));
				employee.setZipcode(resultset.getInt("zipcode"));
				employee.setProduct_name(resultset.getString("product_name"));
				employee.setCreated_on(resultset.getDate("created_on"));
				employee.setCreated_by(resultset.getString("created_by"));
				employee.setUpdated_on(resultset.getDate("updated_on"));
				employee.setUpdated_by(resultset.getString("updated_by"));
				empList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
		return empList;
	}

}
