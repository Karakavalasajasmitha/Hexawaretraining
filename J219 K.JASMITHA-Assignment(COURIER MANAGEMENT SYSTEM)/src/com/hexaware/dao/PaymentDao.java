package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.connectionutil.DBConnection;
import com.hexaware.entity.Payment;

public class PaymentDao {
	Connection conn = DBConnection.getDBConn();

	public void makePayment(Payment payment) {
		try {
			String query = "INSERT INTO PAYMENT VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, payment.getPaymentID());
			ps.setLong(2, payment.getCourierID());
			ps.setDouble(3, payment.getAmount());
			ps.setString(4, payment.getPaymentDate());
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row(s) inserted successfully into Payment table!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewPayments() {
		try {
			String query = "SELECT * FROM PAYMENT";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Payment ID: " + rs.getLong(1));
				System.out.println("Courier ID: " + rs.getLong(2));
				System.out.println("Amount: " + rs.getDouble(3));
				System.out.println("Location ID: " + rs.getLong(4));
				
				System.out.println("Payment Date: " + rs.getString(5));
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
