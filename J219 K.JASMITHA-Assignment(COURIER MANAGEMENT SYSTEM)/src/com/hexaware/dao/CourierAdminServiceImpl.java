package com.hexaware.dao;
import com.hexaware.entity.Courier;
import com.hexaware.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.connectionutil.DBConnection;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService {
	private List<Employee> employeeList = new ArrayList<>();
	EmployeeDao employeeDao = new EmployeeDao();
	Scanner sc = new Scanner(System.in);

	public int addCourierStaff(String name, String contactNumber) {
		System.out.println("Enter courier staff id :");
		int courierStaffId = sc.nextInt();
		System.out.println("Enter courier staff email :");
		String email = sc.next();
		System.out.println("Enter courier staff salary :");
		double salary = sc.nextDouble();
		System.out.println("Enter courier staff role :");
		String role = sc.next();
		Employee courierStaff = new Employee(courierStaffId, name, email, contactNumber, role, salary);
		employeeList.add(courierStaff);
		employeeDao.addCourierStaff(courierStaff);
		return courierStaffId;
	}

}