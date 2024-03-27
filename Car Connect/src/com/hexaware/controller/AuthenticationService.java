package com.hexaware.controller;
import java.util.Scanner;

public class AuthenticationService implements IAuthenticationService {

	public void startAuthentication() {
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Authentication system !!!");
		while(true) {
		System.out.println("Enter your Username :");
		String username = sc.next();
		System.out.println("Enter your Password :");
		String password = sc.next();
		
		if (username.equals("jasmitha") && password.equals("jessie123")) {
			System.out.println("Authentication successful..Welcome " + username + "!!");
			break;
		}
		else {
			System.out.println("Authentication failed... Please try again..");
		}
		}
	}
	}
