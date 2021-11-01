package com.greycampus;

import java.util.ArrayList;

public class DisplayData {

	public static void main(String[] args) {
		
		RetriveData retrivdata=new RetriveData();
		ArrayList<Employee>employeeData=retrivdata.getAllData();
		employeeData.forEach(employee->{
			System.out.println(employee.getCid());
			System.out.println(employee.getFirstname());
			System.out.println(employee.getLastname());
			System.out.println(employee.getStreet());
			System.out.println(employee.getCity());
			System.out.println(employee.getState());
			System.out.println(employee.getZipcode());
			System.out.println(employee.getProduct_name());
			System.out.println(employee.getCreated_on());
			System.out.println(employee.getCreated_by());
			System.out.println(employee.getUpdated_on());
			System.out.println(employee.getUpdated_by());
		});

	}

}
