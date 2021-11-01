package com.greycampus;

import java.util.Date;
import java.util.Scanner;

public class GetUserData {

	public static void main(String[] args, Date date) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("enter cid:");
		int cid=scanner.nextInt();
		System.out.println("enter firstname:");
		String firstname=scanner.next();
		System.out.println("Enter last name:");
		String lastname=scanner.next();
		System.out.println("enter street:");
		String street=scanner.next();
		System.out.println("enter city:");
		String city=scanner.next();
		System.out.println("enter state:");
		String state=scanner.next();
		System.out.println("enter zipcode");
		int zipcode=scanner.nextInt();
		System.out.println("enter product_name:");
		String product_name=scanner.next();
		System.out.println("enter created_on");
		Date created_on= date;
		System.out.println("enter created_by:");
		String created_by=scanner.next();
		System.out.println("enter updated_on:");
		Date updated_on=date;
		System.out.println("enter updated_by:");
		String updated_by=scanner.next();
		
		Employee employee = new Employee();
		employee.setCid(cid);
		employee.setFirstname(firstname);

		employee.setLastname(lastname);
		employee.setStreet(street);
		employee.setCity(city);
		employee.setState(state);
		employee.setZipcode(zipcode);
		employee.setProduct_name(product_name);
		employee.setCreated_on(created_on);
		employee.setCreated_by(created_by);
		employee.setUpdated_on(updated_on);
		employee.setUpdated_by(updated_by);
		
		CreateNewEmployee createNewEmployee=new CreateNewEmployee();
		int count=createNewEmployee.save(employee);
		System.out.println("data is stored"+count);
		scanner.close();

	}

}
