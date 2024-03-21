package com.hexaware.dao;
import java.sql.Connection;
import java.sql.SQLException;
import com.hexaware.connectionutil.DBConnection;
import com.hexaware.entity.Courier;
import com.hexaware.exception.InvalidEmployeeIdException;
import com.hexaware.exception.TrackingNumberNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CourierServiceDb {
	static Connection conn = DBConnection.getDBConn();
	public static void insertCourier(Courier c) {
				try {
			PreparedStatement ps=conn.prepareStatement("insert into Courier values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1,c.getCourierId());
			ps.setString(2, c.getsenderName());
			ps.setString(3,c.getSenderAddress());
			ps.setString(4,c.getReceiverName());
			ps.setString(5,c.getReceiverAddress());
			ps.setDouble(6,c.getWeight());
			ps.setString(7,c.getStatus());
			ps.setString(8,c.getTrackingNumber());
			ps.setString(9,c.getDeliveryDate());
			ps.setLong(10,c.getUserID());
			ps.setLong(11,c.getEmployeeID());
			int numberOfRows=ps.executeUpdate();
			System.out.println(numberOfRows + "inserted Successfully in Courier table!!");
			
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
	}
	public static String getOrderStatus(String trackingNumber) throws TrackingNumberNotFoundException {
		try {
			String query = "SELECT Status FROM Courier WHERE TrackingNumber = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, trackingNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else {
				throw new TrackingNumberNotFoundException(
						"Invalid Tracking Number. Please enter proper tracking number.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TrackingNumberNotFoundException("Error occurred while retrieving order status.");
		}
	}

	public static boolean cancelOrder(String trackingNumber) throws TrackingNumberNotFoundException {
		try {
			String query = "UPDATE Courier SET Status = 'Cancelled' WHERE TrackingNumber = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, trackingNumber);
			int numberOfRows = ps.executeUpdate();
			if (numberOfRows > 0) {
				return true;
			} else {
				throw new TrackingNumberNotFoundException(
						"Invalid Tracking Number... Please enter proper tracking number!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new TrackingNumberNotFoundException("Error occurred while cancelling order.");
		}
	}

	public static List<Courier> getAssignedOrder(int courierStaffId) throws InvalidEmployeeIdException {
		List<Courier> assignedOrders = new ArrayList<>();
		try {
			String query = "SELECT * FROM Courier WHERE EmployeeId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, courierStaffId);
			ResultSet rs = ps.executeQuery();
			boolean employeeExists = false;
			while (rs.next()) {
				Courier c = new Courier();
				c.setcourierID(rs.getLong(1));
				c.setSenderName(rs.getString(2));
				c.setSenderAddress(rs.getString(3));
				c.setReceiverName(rs.getString(4));
				c.setReceiverAddress(rs.getString(5));
				c.setWeight(rs.getDouble(6));
				c.setStatus(rs.getString(7));
				c.setTrackingNumber(rs.getString(8));
				c.setDeliveryDate(rs.getString(9));
				c.setEmployeeID(rs.getLong(10));
				assignedOrders.add(c);
				employeeExists = true;
			}
			if (!employeeExists) {
				throw new InvalidEmployeeIdException("Invalid Employee ID... Employee with the given ID does not exist.."); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assignedOrders;
	}

	public static void updateCourierStatus(String trackingNumber, String newStatus) {
		try {
			String query = "UPDATE Courier SET Status = ? WHERE TrackingNumber = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newStatus);
			ps.setString(2, trackingNumber);
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " courier updated successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void retrieveDeliveryHistory(String trackingNumber) {

		try {
			String query = "SELECT Status, DeliveryDate FROM Courier WHERE TrackingNumber = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, trackingNumber);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String status = rs.getString(1);
				String deliveryDate = rs.getString(2);
				System.out.println("Status: " + status + ", Delivery Date: " + deliveryDate);
			} else {
				System.out.println("No delivery history found for tracking number: " + trackingNumber);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static String categorizeParcelByWeight(long courierID) {
		try {
			String query = "SELECT Weight FROM Courier WHERE CourierID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, courierID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				double weight = rs.getDouble(1);
				if (weight <= 5) {
					return "Courier weight is Light";
				} else if (weight > 5 && weight <= 15) {
					return "Courier weight is Medium";
				} else {
					return "Courier weight is Heavy";
				}
			} else {
				return "Courier with courierID: " + courierID + " not found.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error occurred while categorizing parcel by weight...";
		}
	}

	public static void displayOrdersForCustomer(Long customerId) {
		boolean found = false;
		try {
			String query = "SELECT * FROM Courier WHERE UserID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, customerId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Tracking Number: " + rs.getString("TrackingNumber"));
				System.out.println("Sender's Name: " + rs.getString("SenderName"));
				System.out.println("Receiver's Name: " + rs.getString("ReceiverName"));
				System.out.println("Weight: " + rs.getDouble("Weight"));
				System.out.println("Status: " + rs.getString("Status"));
				found = true;
			}
			if (!found) {
				System.out.println("No orders found for customer: " + customerId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occurred while fetching orders for customer: " + customerId);
		}
	}

	public void generateAndDisplayReport() {
		try {
			String query = "SELECT * FROM Courier";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			System.out.println("Courier Report:");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Tracking Number   | Sender's Name  | Receiver's Name | Status");
			System.out.println("---------------------------------------------------------------");

			while (rs.next()) {
				String trackingNumber = rs.getString("TrackingNumber");
				String senderName = rs.getString("SenderName");
				String receiverName = rs.getString("ReceiverName");
				String status = rs.getString("Status");

				System.out.printf("%-18s| %-15s| %-15s| %-10s\n", trackingNumber, senderName, receiverName, status);
				System.out.println("---------------------------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occurred while generating and displaying report.");
		}
	}

	public static long getLastUsedTrackingNumberFromDB() {
		long lastUsedTrackingNumber = 0;
		try {
			conn = DBConnection.getDBConn();
			String query = "SELECT MAX(TrackingNumber) AS LastTrackingNumber FROM Courier";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				lastUsedTrackingNumber = rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Math.max(10000, lastUsedTrackingNumber + 1);
	}

	public void viewCouriers() {
		try {
			String query = "SELECT * FROM Courier";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println("Courier ID: " + rs.getLong("CourierID"));
				System.out.println("Sender's Name: " + rs.getString("SenderName"));
				System.out.println("Sender's Address: " + rs.getString("SenderAddress"));
				System.out.println("Receiver's Name: " + rs.getString("ReceiverName"));
				System.out.println("Receiver's Address: " + rs.getString("ReceiverAddress"));
				System.out.println("Weight: " + rs.getDouble("Weight"));
				System.out.println("Status: " + rs.getString("Status"));
				System.out.println("Tracking Number: " + rs.getString("TrackingNumber"));
				System.out.println("Delivery Date: " + rs.getString("DeliveryDate"));
				System.out.println("Employee ID: " + rs.getLong("EmployeeId"));
				System.out.println("User ID: " + rs.getLong("UserID"));
				System.out.println("----------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}