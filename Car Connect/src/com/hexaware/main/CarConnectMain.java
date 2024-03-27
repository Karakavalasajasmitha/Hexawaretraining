package com.hexaware.main;
import java.util.Scanner;
import com.hexaware.controller.AdminService;
import com.hexaware.controller.AuthenticationService;
import com.hexaware.controller.CustomerService;
import com.hexaware.controller.IAdminService;
import com.hexaware.controller.IAuthenticationService;
import com.hexaware.controller.ICustomerService;
import com.hexaware.controller.IReservationService;
import com.hexaware.controller.IVehicleService;
import com.hexaware.controller.ReservationService;
import com.hexaware.controller.VehicleService;
import com.hexaware.exception.*;

public class CarConnectMain {
	public static void main(String[] args) {
	IAdminService as = new AdminService();
	ICustomerService cs = new CustomerService();
	IReservationService rs = new ReservationService();
	IVehicleService vs = new VehicleService();
	IAuthenticationService AS=new AuthenticationService();
	AS.startAuthentication();
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    	String ch=null;
		do{
    		System.out.println("Select choice :");
    		System.out.println("1. Customer");
    		System.out.println("2. Vehicle");
			System.out.println("3. Reservation");
			System.out.println("4. Admin");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Customer options:");
				System.out.println("1. Register Customer");
				System.out.println("2. View Customer");
				System.out.println("3. Get Customer By CustomerId");
				System.out.println("4. Get Customer By Username");
				System.out.println("5. Update Customer");
				System.out.println("6. Delete Customer");
				int customerChoice = sc.nextInt();
				switch (customerChoice) {
				case 1:
					cs.registerCustomer();
					break;
				case 2:
					cs.viewCustomer();
					break;
				case 3:
					System.out.println("Enter Customer ID:");
					Long customerID  = sc.nextLong();
					try {
						 cs.getCustomerById(customerID);
					} catch (CustomerNotFoundException c) {
						System.out.println(c.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter Customer username:");
					String userName  = sc.next();
					try {
						cs.getCustomerByUsername(userName);
					} catch (CustomerNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Enter the CustomerID to update: ");
					Long customerId = sc.nextLong();
					try {
						cs.updateCustomer(customerId);
					} catch (CustomerNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("Enter the customerId to delete :");
					Long customerid = sc.nextLong();
					try {
						cs.deleteCustomer(customerid);
					} catch (CustomerNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid customer choice!!!");
					break;
				}break;
			case 2:
				System.out.println("Vehicle options:");
				System.out.println("1. Add Vehicle");
				System.out.println("2. View Customer");
				System.out.println("3. Get Vehicle By vehicle Id");
				System.out.println("4. Get Available Vehicles");
				System.out.println("5. Update Vehicle");
				System.out.println("6. Remove Vehicle ");
				int vehicleChoice = sc.nextInt();
				switch (vehicleChoice) {
				case 1:
					vs.addVehicle();
					break;
				case 2:
					vs.viewVehicle();
					break;
				case 3:
					try {
						System.out.println("Enter vehicle ID:");
						Long vehicleID=sc.nextLong();
						vs.getVehicleById(vehicleID);
					} catch (VehicleNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						vs.getAvailableVehicles(true);
					} catch (VehicleNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Enter the vehicleID to update: ");
					Long vehicleId = sc.nextLong();
					try {
						vs.updateVehicle(vehicleId);
					} catch (VehicleNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("Enter the vehicleId to remove :");
					Long vehicleid = sc.nextLong();
					try {
						vs.removeVehicle(vehicleid);
					} catch (VehicleNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid vehicle choice!!!");
					break;
				}
				break;
			case 3:
				System.out.println("Reservation options:");
				System.out.println("1. Create Reservation");
				System.out.println("2. View Reservation");
				System.out.println("3. Get Reservation By Reservation Id");
				System.out.println("4. Get Reservation By CustomerId");
				System.out.println("5. Update Reservation");
				System.out.println("6. Cancel Reservation ");
				int reservationChoice = sc.nextInt();
				switch (reservationChoice) {
				case 1:
						rs.createReservation();
					break;
				case 2:
					rs.viewReservation();
					break;
				case 3:
					System.out.println("Enter Reservation ID:");
					Long reservationID  = sc.nextLong();
					try {
						rs.getReservationById(reservationID);
					} catch (ReservationNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter Customer ID:");
					Long customerID  = sc.nextLong();
					try {
						rs.getReservationsByCustomerID(customerID);
					} catch (ReservationNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Enter the ReservationID to update: ");
					Long reservationId = sc.nextLong();
					try {
						rs.updateReservation(reservationId);
					} catch (ReservationNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("Enter the ReservationId to cancel :");
					Long reservationid = sc.nextLong();
					try {
						rs.cancelReservation(reservationid);
					} catch (ReservationNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Reservation choice!!!");
					break;
				}
				break;
			case 4:
				System.out.println("Admin options:");
				System.out.println("1. Register Admin");
				System.out.println("2. View Admin");
				System.out.println("3. Get Admin By Admin Id");
				System.out.println("4. Get Admin By Username");
				System.out.println("5. Update Admin");
				System.out.println("6. delete Admin ");
				int adminChoice = sc.nextInt();
				switch (adminChoice) {
				case 1:
					as.registerAdmin();
					break;
				case 2:
					as.viewAdmin();
					break;
				case 3:
					System.out.println("Enter Admin ID:");
					Long adminID  = sc.nextLong();
					try {
						 as.getAdminById(adminID);
					} catch (AdminNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Enter Admin username:");
					String userName  = sc.next();
					try {
						as. getAdminByUsername(userName);
					} catch (AdminNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Enter the AdminID to update: ");
					Long adminId = sc.nextLong();
					try {
						as.updateAdmin(adminId);
					} catch (AdminNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					System.out.println("Enter the AdminId to delete :");
					Long adminid = sc.nextLong();
					try {
						as.deleteAdmin(adminid);
					} catch (AdminNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					System.out.println("Invalid Admin choice!!!");
					break;
			        }break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
				System.out.println("Do you want to continue? (Y/N)");
				ch = sc.next();
    	}while(ch.equalsIgnoreCase("Y"));
      System.out.println("Thanks for using our system!!!");
    	}
	}