package com.hexaware.main;
import com.hexaware.*;
import java.util.Scanner;
import com.hexaware.controller.OrderController;
import com.hexaware.controller.OrderInterface;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public class OrderManagement {
	private static OrderInterface orderController = new OrderController();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("User Authentication");
		System.out.println("Enter Username :");
		String username = scanner.next();
		System.out.println("Enter Password :");
		String password = scanner.next();
		String ch=null;
		if (username.equals("jasmitha") && password.equals("jessie123")) {
			System.out.println("Welcome " + username + "!!");
		System.out.println("Welcome to Order Management System!");
		do {
			System.out.println("Select an option:");
			System.out.println("1. Create User");
			System.out.println("2. Create Product");
			System.out.println("3. Create Order");
			System.out.println("4. Cancel Order");
			System.out.println("5. Get All Products");
			System.out.println("6. Get Orders by User");
			System.out.println("7. Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();

			try {
				switch (choice) {
				case 1:
					orderController.createUser();
					break;
				case 2:
					orderController.createProduct();
					break;
				case 3:
					orderController.createOrder();
					break;
				case 4:
					orderController.cancelOrder();
					break;
				case 5:
					orderController.getAllProducts();
					break;
				case 6:
					orderController.getOrdersByUser();
					break;
				case 7:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 7.");
					break;
				}
			} catch (UserNotFoundException | OrderNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Do you want to continue? (Y/N)");
			ch = scanner.next();
		}while (ch.equalsIgnoreCase("Y"));
		
		System.out.println("Thanks for using our system!!!");
	}
	}
}
		