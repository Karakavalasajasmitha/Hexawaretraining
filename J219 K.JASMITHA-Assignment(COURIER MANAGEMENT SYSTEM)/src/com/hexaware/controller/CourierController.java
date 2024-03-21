package com.hexaware.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.CourierServiceDb;
import com.hexaware.dao.CourierUserServiceImpl;
import com.hexaware.entity.Courier;
import com.hexaware.exception.TrackingNumberNotFoundException;

public class CourierController implements CourierInterface {
	CourierUserServiceImpl userService = new CourierUserServiceImpl();;
	Scanner sc=new Scanner(System.in);
	CourierServiceDb cd=new CourierServiceDb();
	public List <Courier> clist=new ArrayList<Courier>();
	private static long trackingNumberCounter = CourierServiceDb.getLastUsedTrackingNumberFromDB();
	public CourierController() {
		super();}
	@Override
	public String placeOrder() {
		Courier c =new Courier();
		System.out.println("Enter courierId:");
		c.setcourierID(sc.nextLong());
		System.out.println("enter Sender name : ");
    	c.setSenderName(sc.next());
		System.out.println("enter Sender Address : ");
    	c.setSenderAddress(sc.next());
    	System.out.println("enter Reciever Name : ");
    	c.setReceiverName(sc.next());
    	System.out.println("enter Reciver Address : ");
    	c.setReceiverAddress(sc.next());
    	System.out.println("enter courier Weight in Kgs : ");
    	c.setWeight(sc.nextDouble());
        System.out.println("enter Status :");
        c.setStatus(sc.next());
        System.out.println("enter the date of delivery(yyyy-mm-dd) : ");
        c.setDeliveryDate(sc.next());
        System.out.println("enter the user id : ");
        c.setUserId(sc.nextLong());
        c.setTrackingNumber("" + trackingNumberCounter++);
		clist.add(c);
		System.out.println("Courier added successfully!!");
		return userService.placeOrder(c);	
	}

	@Override
	public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
		return userService.getOrderStatus(trackingNumber);
	}

	@Override
	public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
		for (Courier c : clist) {
			if (c.getTrackingNumber().equals(trackingNumber)) {
				c.setStatus("Cancelled");
			}
		}
		return userService.cancelOrder(trackingNumber);
	}

	public void updateCourierStatus(String trackingNumber, String newStatus) {
		for (Courier c : clist) {
			if (c.getTrackingNumber().equals(trackingNumber)) {
				c.setStatus(newStatus);
				break;
			}
		}
		userService.updateCourier(trackingNumber, newStatus);
	}

	public void retrieveDeliveryHistory(String trackingNumber) {
		cd.retrieveDeliveryHistory(trackingNumber);
	}

	public String categorizeParcelByWeight(long courierID) {
		return cd.categorizeParcelByWeight(courierID);
	}

	public void displayOrdersForCustomer(long customerId) {
		cd.displayOrdersForCustomer(customerId);
	}

	public void generateAndDisplayReport() {
		cd.generateAndDisplayReport();
	}

	@Override
	public void viewCourier() {
		cd.viewCouriers();

	}

}