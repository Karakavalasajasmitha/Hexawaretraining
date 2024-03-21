package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Courier;
import com.hexaware.entity.CourierCompanyCollection;
public class CourierUserServiceCollectionImpl implements ICourierUserService  {
private CourierCompanyCollection companyObj;

public CourierUserServiceCollectionImpl(CourierCompanyCollection companyObj) {
	this.companyObj = companyObj;
}

@Override
public String getOrderStatus(String trackingNumber) {
	return null;
}

@Override
public boolean cancelOrder(String trackingNumber) {
	return false;
}

@Override
public List<Courier> getAssignedOrder(int courierStaffId) {
	return null;
}

@Override
public String placeOrder(Courier courier) {
	return null;
}
}