package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.AdminDao;
import com.hexaware.entity.Admin;
import com.hexaware.exception.AdminNotFoundException;

public class AdminService implements IAdminService {
	Scanner sc=new Scanner(System.in);
	AdminDao ad=new AdminDao();
	
	public void registerAdmin() {
		System.out.println("Enter Admin details");
		System.out.println("Enter AdminId:");
		Long adminID = sc.nextLong();
		System.out.println("Enter FirstName:");
		String firstName = sc.next();
		System.out.println("Enter LastName:");
		String lastName = sc.next();
		System.out.println("Enter Email:");
		String email = sc.next();
		System.out.println("Enter PhoneNumber:");
		String phoneNumber = sc.next();
		System.out.println("Enter UserName:");
		String userName = sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();
		System.out.println("Enter Role:");
		String role = sc.next();
		System.out.println("Enter JoinDate(yyyy-mm-dd):");
		String joinDate = sc.next();
		Admin a = new Admin(adminID,firstName, lastName, email, phoneNumber,userName,password,role,joinDate);
		ad.registerAdmin(a);
		System.out.println("Admin Registered successfully !!!");
	}
	
	public void viewAdmin() {
		ad.viewAdmin();
	}

	@Override
	public void getAdminById(Long adminID) throws AdminNotFoundException  {
		ad.getAdminById(adminID);	
	}

	@Override
	public void getAdminByUsername(String userName)throws AdminNotFoundException {
		 ad.getAdminByUserName(userName);
		
	}

	@Override
	public String updateAdmin(Long adminID)throws AdminNotFoundException {
		
		String password=null;
		String phoneNumber = null;
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
		return ad.updateAdmin(adminID,password,phoneNumber);
		
	}	

	@Override
	public boolean deleteAdmin(Long adminID) throws AdminNotFoundException {
		return ad.deleteAdmin(adminID);
		
	}
}

	