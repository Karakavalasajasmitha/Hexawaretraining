package com.hexaware.controller;

import java.util.List;

import com.hexaware.entity.Courier;
import com.hexaware.exception.InvalidEmployeeIdException;

public interface EmployeeInterface {
	List<Courier> getAssignedOrder(int courierStaffId) throws InvalidEmployeeIdException;

	int addCourierStaff(String name, String contactNumber);

	void viewCourierStaffs();

}
