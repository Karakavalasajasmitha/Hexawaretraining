package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.controller.CourierInterface;
import com.hexaware.controller.EmployeeController;
import com.hexaware.controller.EmployeeInterface;
import com.hexaware.controller.LocationController;
import com.hexaware.controller.CourierController;
import com.hexaware.controller.UserController;
import com.hexaware.controller.UserInterface;
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;
import com.hexaware.controller.LocationInterface;
import com.hexaware.controller.PaymentController;
import com.hexaware.controller.PaymentInterface;
public class CourierMain {

	public static void main(String[] args) {
		CourierInterface courierController = new CourierController();
		UserInterface userController = new UserController();
		LocationInterface locationController = new LocationController();
		PaymentInterface paymentController = new PaymentController();
		EmployeeInterface employeeController = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch = null;
		System.out.println("User Authentication");
		System.out.println("Enter Username :");
		String username = sc.next();
		System.out.println("Enter Password :");
		String password = sc.next();

		if (username.equals("jasmitha") && password.equals("jessie123")) {
			System.out.println("Welcome " + username + "!!");
			do {
				System.out.println("Select category :");
				System.out.println("1. Courier");
				System.out.println("2. User");
				System.out.println("3. Location");
				System.out.println("4. Payment");
				System.out.println("5. Courier Staff");
				int category = sc.nextInt();
				switch (category) {
				case 1:
					System.out.println("Courier options:");
					System.out.println("1. Place an order");
					System.out.println("2. View couriers");
					System.out.println("3. Get order status");
					System.out.println("4. Cancel order");
					System.out.println("5. Update courier status");
					System.out.println("6. Retrieve delivery history of courier");
					System.out.println("7. Check if courier is delivered or not");
					System.out.println("8. Categorize Courier By Weight");
					System.out.println("9. Display all the orders for a specific customer");
					System.out.println("10. Display a report of the couriers");
					int courierChoice = sc.nextInt();
					switch (courierChoice) {
					case 1:
						courierController.placeOrder();
						break;
					case 2:
						courierController.viewCourier();
						break;
					case 3:
						System.out.println("Enter tracking number:");
						String trackingNumber = sc.next();
						try {
							System.out.println("Order status: " + courierController.getOrderStatus(trackingNumber));
						} catch (TrackingNumberNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						System.out.println("Enter tracking number:");
						String cancelTrackingNumber = sc.next();
						try {
							if (courierController.cancelOrder(cancelTrackingNumber)) {
								System.out.println("Order cancelled successfully.");
							} else {
								System.out.println("Failed to cancel order.");
							}
						} catch (TrackingNumberNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("Enter tracking number of courier status to update:");
						String t = sc.next();
						System.out.println("Enter the new status:");
						String newStatus = sc.next();
						courierController.updateCourierStatus(t, newStatus);
						break;
					case 6:
						System.out.println("Enter tracking number of courier to retrieve delivery history:");
						String trackingNumber1 = sc.next();
						courierController.retrieveDeliveryHistory(trackingNumber1);
						break;
					case 7:
						System.out.println("Enter tracking number to check delivery status:");
						String trackingNo = sc.next();
						try {
							String status = courierController.getOrderStatus(trackingNo);
							if (status.equalsIgnoreCase("Delivered")) {
								System.out.println("Order with tracking number " + trackingNo + " is delivered.");
							} else {
								System.out.println("Order with tracking number " + trackingNo + " is not yet delivered.");
							}
						} catch (TrackingNumberNotFoundException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 8:
						System.out.println("Enter courier ID to categorize parcel by weight:");
						long courierID = sc.nextLong();
						System.out.println(courierController.categorizeParcelByWeight(courierID));

						break;
					case 9:
						System.out.println("Enter customer ID:");
						long customerId = sc.nextLong();
						courierController.displayOrdersForCustomer(customerId);
						break;
					case 10:
						courierController.generateAndDisplayReport();
						break;
					default:
						System.out.println("Invalid courier choice!");
						break;
					}
					break;

				case 2:
					System.out.println("User options:");
					System.out.println("1. Add user");
					System.out.println("2. View user");
					System.out.println("3. Update user");
					int userChoice = sc.nextInt();
					switch (userChoice) {
					case 1:
						userController.addUser();
						break;
					case 2:
						userController.viewUser();
						break;
					case 3:
						System.out.println("Enter the userID to update: ");
						long userID = sc.nextLong();
						System.out.println("Enter the new address: ");
						String address = sc.next();
						userController.updateUser(userID, address);
						break;
					default:
						System.out.println("Invalid user choice!");
						break;
					}
					break;

				case 3:
					System.out.println("Location options:");
					System.out.println("1. Add location");
					System.out.println("2. View locations");
					int locationChoice = sc.nextInt();
					switch (locationChoice) {
					case 1:
						locationController.addLocation();
						break;
					case 2:
						locationController.viewLocations();
						break;
					default:
						System.out.println("Invalid location choice!");
						break;
					}
					break;

				case 4:
					System.out.println("Payment options:");
					System.out.println("1. Make payment");
					System.out.println("2. View payments");
					int paymentChoice = sc.nextInt();
					switch (paymentChoice) {
					case 1:
						paymentController.makePayment();
						break;
					case 2:
						paymentController.viewPayments();
						break;
					default:
						System.out.println("Invalid payment choice!");
						break;
					}
					break;

				case 5:
					System.out.println("Courier staff options:");
					System.out.println("1. Get assigned orders");
					System.out.println("2. Add courier staff");
					System.out.println("3. View courier staff");
					int courierStaffChoice = sc.nextInt();
					switch (courierStaffChoice) {
					case 1:
						try {
							System.out.println("Enter courier staff ID:");
							int courierStaffId = sc.nextInt();
							System.out.println("Assigned orders:");
							System.out.println(employeeController.getAssignedOrder(courierStaffId));
						} catch (InvalidEmployeeIdException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Enter courier staff details:");
						System.out.println("Name:");
						String name = sc.next();
						System.out.println("Contact Number:");
						String contactNumber = sc.next();
						employeeController.addCourierStaff(name, contactNumber);
						break;
					case 3:
						employeeController.viewCourierStaffs();
						break;
					default:
						System.out.println("Invalid courier staff choice!");
						break;
					}
					break;

				default:
					System.out.println("Invalid category choice!");
					break;
				}
				System.out.println("Do you want to continue? (Y/N)");
				ch = sc.next();
			} while (ch.equalsIgnoreCase("Y"));
		} else {
			System.out.println("Invalid username or password... Access denied.");
		}
		System.out.println("Thanks for using our courier management system!!!");
	}
}