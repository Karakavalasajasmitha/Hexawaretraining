package com.hexaware.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.dao.CourierAdminServiceImpl;
import com.hexaware.dao.CourierUserServiceImpl;
import com.hexaware.dao.EmployeeDao;
import com.hexaware.entity.Courier;
import com.hexaware.entity.Employee;
import com.hexaware.exception.InvalidEmployeeIdException;

public class EmployeeController implements EmployeeInterface {
	CourierAdminServiceImpl adminService = new CourierAdminServiceImpl();
	CourierUserServiceImpl userService = new CourierUserServiceImpl();
	EmployeeDao employeeDao = new EmployeeDao();

	Scanner sc = new Scanner(System.in);

	@Override
	public List<Courier> getAssignedOrder(int courierStaffId) throws InvalidEmployeeIdException {
		return userService.getAssignedOrder(courierStaffId);
	}

	@Override
	public int addCourierStaff(String name, String contactNumber) {
		return adminService.addCourierStaff(name, contactNumber);
	}

	@Override
	public void viewCourierStaffs() {
		employeeDao.viewCourierStaff();
	}
}