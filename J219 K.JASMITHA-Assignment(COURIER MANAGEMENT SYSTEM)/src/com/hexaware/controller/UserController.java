package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.UserDao;
import com.hexaware.entity.User;

public class UserController implements UserInterface {
		Scanner sc = new Scanner(System.in);
		UserDao ud= new UserDao();
		@Override
			public void addUser() {
				System.out.println("Enter user details:");
				System.out.println("User ID:");
				long userID = sc.nextLong();
				System.out.println("User Name:");
				String userName = sc.next();
				System.out.println("Email:");
				String email = sc.next();
				System.out.println("Password:");
				String password = sc.next();
				System.out.println("Contact Number:");
				String contactNumber = sc.next();
				System.out.println("Address:");
				String address = sc.next();
				User u = new User(userID,userName, email, password, contactNumber, address);
				ud.addUser(u);
				System.out.println("User added successfully!!");
			}

			@Override
			public void viewUser() {
				ud.viewUser();
			}

			@Override
			public void updateUser(long userID,String address) {
				ud.updateUser(userID,address);
				System.out.println("User address updated successfully!!");
			}
		}