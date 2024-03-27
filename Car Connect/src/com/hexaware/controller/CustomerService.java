package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.CustomerDao;
import com.hexaware.entity.Customer;
import com.hexaware.exception.CustomerNotFoundException;

public class CustomerService implements ICustomerService{
	Scanner sc=new Scanner(System.in);
	CustomerDao cd=new CustomerDao();
	@Override
	public void registerCustomer() {
		    System.out.println("Enter Customer details:");
			System.out.println("Enter CustomerID:");
			Long customerID = sc.nextLong();
			System.out.println("Enter FirstName:");
			String firstName = sc.next();
			System.out.println("Enter LastName:");
			String lastName = sc.next();
			System.out.println("Enter Email:");
			String email = sc.next();
			System.out.println("Enter PhoneNumber:");
			String phoneNumber = sc.next();
			System.out.println("Enter Address:");
			String address = sc.next();
			System.out.println("Enter UserName:");
			String userName = sc.next();
			System.out.println("Enter Password:");
			String password = sc.next();
			System.out.println("Enter RegistrationDate(yyyy-mm-dd):");
			String registrationDate = sc.next();
			Customer c = new Customer(customerID,firstName, lastName, email, phoneNumber, address,userName,password,registrationDate);
			cd.registerCustomer(c);
		}
		
		public void viewCustomer() {
			cd.viewCustomer();
		}
		

	@Override
	public void getCustomerById(Long customerID)throws CustomerNotFoundException {
		cd.getCustomerById(customerID);
	}

	@Override
	public void getCustomerByUsername(String userName)throws CustomerNotFoundException {
		cd.getCustomerByUserName(userName);
		
	}

	@Override
	public String updateCustomer(Long customerID)throws CustomerNotFoundException {
		String password=null;
		String phoneNumber = null;
		String address=null;
		String ch;
		
		System.out.print("Want to update password (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter new password : ");
			password = sc.next();
		}
		
		System.out.print("want to update PhoneNumber (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter the new PhoneNumber : ");
			phoneNumber = sc.next();
		}
		System.out.print("want to update Address (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter the new Address : ");
			address = sc.next();
		}
		return cd.updateCustomer(customerID,password,phoneNumber,address);
		
	}	
	@Override
	public boolean deleteCustomer(Long customerID)throws CustomerNotFoundException {
		return cd.deleteCustomer(customerID);
		
	}
}
