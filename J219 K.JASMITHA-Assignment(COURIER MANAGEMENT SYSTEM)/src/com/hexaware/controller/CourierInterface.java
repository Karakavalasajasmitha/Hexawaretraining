package com.hexaware.controller;

import java.util.List;

import com.hexaware.entity.Courier;
import com.hexaware.exception.TrackingNumberNotFoundException;

public interface CourierInterface {
		String placeOrder();

		String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException;

		boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;

		void updateCourierStatus(String trackingNumber, String newStatus);

		void retrieveDeliveryHistory(String trackingNumber);

		String categorizeParcelByWeight(long courierID);

		void displayOrdersForCustomer(long customerId);

		void generateAndDisplayReport();

		void viewCourier(); 
}

