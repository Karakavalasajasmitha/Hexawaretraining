package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.connectionutil.DBConnection;
import com.hexaware.entity.Employee;

public class EmployeeDao {
	Connection conn = DBConnection.getDBConn();

	public void addCourierStaff(Employee courierStaff) {
		try {
			String query = "INSERT INTO EMPLOYEE (EmployeeID,Name, Email, ContactNumber, Role, Salary) VALUES (?,?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, courierStaff.getEmployeeID());
			ps.setString(2, courierStaff.getEmployeeName());
			ps.setString(3, courierStaff.getEmail());
			ps.setString(4, courierStaff.getContactNumber());
			ps.setString(5, courierStaff.getRole());
			ps.setDouble(6, courierStaff.getSalary());
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row(s) inserted successfully into Employee table!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewCourierStaff() {
		try {
			String query = "SELECT * FROM EMPLOYEE";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Employee ID: " + rs.getLong(1));
				System.out.println("Employee Name: " + rs.getString(2));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("Contact Number: " + rs.getString(4));
				System.out.println("Role: " + rs.getString(5));
				System.out.println("Salary: " + rs.getDouble(6));
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

