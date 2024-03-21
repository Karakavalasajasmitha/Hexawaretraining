package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.connectionutil.DBConnection;
import com.hexaware.entity.Location;

public class LocationDao {
	Connection conn = DBConnection.getDBConn();

	public void addLocation(Location location) {
		try {
			String query = "INSERT INTO LOCATION VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, location.getLocationID());
			ps.setString(2, location.getLocationName());
			ps.setString(3, location.getAddress());
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row(s) inserted successfully into Location table!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewLocations() {
		try {
			String query = "SELECT * FROM LOCATION";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Location ID: " + rs.getLong(1));
				System.out.println("Location Name: " + rs.getString(2));
				System.out.println("Address: " + rs.getString(3));
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

