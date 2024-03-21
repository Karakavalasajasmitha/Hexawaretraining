package com.hexaware.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hexaware.entity.Courier;
import com.hexaware.entity.Location;
import com.hexaware.entity.Payment;
import com.hexaware.entity.User;
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;

public class CourierUserServiceImpl implements ICourierUserService {
	public List<Courier> courierList = new ArrayList<>();
	CourierServiceDb db = new CourierServiceDb();
	private static long trackingNumberCounter = CourierServiceDb.getLastUsedTrackingNumberFromDB();
	Scanner sc = new Scanner(System.in);

	public String placeOrder(Courier courier) {
		db.insertCourier(courier);
		return courier.getTrackingNumber();
	}

	public String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
		return db.getOrderStatus(trackingNumber);
	}

	public boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
		return db.cancelOrder(trackingNumber);

	}

	public List<Courier> getAssignedOrder(int courierStaffId) throws InvalidEmployeeIdException {
		return db.getAssignedOrder(courierStaffId);
	}

	public void updateCourier(String trackingNumber, String newStatus) {
		db.updateCourierStatus(trackingNumber, newStatus);
	}
}