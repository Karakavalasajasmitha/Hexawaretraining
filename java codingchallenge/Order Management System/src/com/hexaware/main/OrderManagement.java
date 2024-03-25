package com.hexaware.main;
import java.util.Scanner;

import com.hexaware.controller.*;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public class OrderManagement {
	public static void main(String[] args) {
	IOrderManagementRepository omr = new OrderProcessorController();
	Scanner sc = new Scanner(System.in);
	String ch=null;
	boolean exit = false;
	while(!exit){
		 System.out.println("Order Management System Menu:");
         System.out.println("1. Create User");
         System.out.println("2. View User");
         System.out.println("3. Create Product");
         System.out.println("4. Cancel Order");
         System.out.println("5. Get All Products");
         System.out.println("6. Get Order by User");
         System.out.println("7. Exit");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			omr.createUser();
			break;
		case 2:
			omr.viewUser();
			break;
		case 3:
			try {
				omr.createProduct();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				omr.cancelOrder();
			} catch (UserNotFoundException | OrderNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			omr.getAllProducts();
			break;
		case 6:
			omr.getOrderByUser();
			break;
		case 7:
			exit=true;
			System.out.println("Exiting Order Management System...");
			break;
		default:
            System.out.println("Invalid choice. Please enter a valid option.");
            break;
    }
		System.out.println("Do you want to continue? (Y/N)");
		ch = sc.next();
}while(ch.equalsIgnoreCase("Y"));
System.out.println("Thanks for using our system!!!");
}
	}

