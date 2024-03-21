package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Courier;
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;

public interface ICourierUserService {
	String placeOrder(Courier courier);
	String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException;
	boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException;
	List<Courier> getAssignedOrder(int courierStaffId) throws InvalidEmployeeIdException;

}