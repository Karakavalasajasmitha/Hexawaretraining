package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Reservation;
import com.hexaware.exception.ReservationNotFoundException;
import com.hexaware.util.DBConnUtil;

public class ReservationDao{
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	public  void createReservation(Reservation r){
		try {
			con = DBConnUtil.getDBCon();
			String query="INSERT INTO RESERVATION VALUES(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setLong(1,r.getReservationID());
			ps.setLong(2, r.getCustomerID());
			ps.setLong(3,r.getVehicleID());
			ps.setString(4,r.getStartDate());
			ps.setString(5,r.getEndDate());
			ps.setDouble(6,r.getTotalCost());
			ps.setString(7,r.getStatus());
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row inserted successfully in reservation table!");
		} catch (SQLException e) {
			e.printStackTrace();}
	}
		public void viewReservation() {
			try {
				con = DBConnUtil.getDBCon();
				String query = "SELECT * FROM Reservation";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println("ReservationID: " + rs.getLong(1));
					System.out.println("CustomerID: " + rs.getLong(2));
					System.out.println("VehicleID: " + rs.getLong(3));
					System.out.println("StartDate: " + rs.getString(4));
					System.out.println("EndDate: " + rs.getString(5));
					System.out.println("TotalCost: " + rs.getDouble(6));
					System.out.println("Status: " + rs.getString(7));
					System.out.println("----------------------------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void getReservationById(Long reservationID) throws ReservationNotFoundException {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Reservation where reservationID=?";
				ps = con.prepareStatement(query);
				ps.setLong(1, reservationID);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("CustomerID: " + rs.getLong(2));
					System.out.println("VehicleID: " + rs.getLong(3));
					System.out.println("StartDate: " + rs.getString(4));
					System.out.println("EndDate: " + rs.getString(5));
					System.out.println("TotalCost: " + rs.getDouble(6));
					System.out.println("Status: " + rs.getString(7));
					System.out.println("----------------------------------------");
					
				} else {
					throw new ReservationNotFoundException(
							"Invalid Reservation ID.. Please enter valid Reservation ID...");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new ReservationNotFoundException("Error occurred while retrieving Reservation details..");
}
		}
		public void getReservationsByCustomerId(Long customerID)throws ReservationNotFoundException {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from reservation where customerID=?";
				ps = con.prepareStatement(query);
				ps.setLong(1, customerID);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("ReservationID: " + rs.getLong(2));
					System.out.println("VehicleID: " + rs.getLong(3));
					System.out.println("StartDate: " + rs.getString(4));
					System.out.println("EndDate: " + rs.getString(5));
					System.out.println("TotalCost: " + rs.getDouble(6));
					System.out.println("Status: " + rs.getString(7));
					System.out.println("----------------------------------------");
				}
				else {
					throw new ReservationNotFoundException(
					"There are no reservations for this Customer ID:"+customerID);
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new ReservationNotFoundException("Error occurred while retrieving Reservation details..");
	}
}
		public String updateReservation(Long reservationID,String startDate, String endDate)throws ReservationNotFoundException {
			String response="";
			try {
				con = DBConnUtil.getDBCon();
				String s ="update  Reservation ";
				if(startDate != null)
				{
					s=s+"set startDate = "+"'"+startDate+"'"+",";
				}
				if(endDate != null)
				{
					s=s+"set endDate = "+"'"+endDate+"'"+",";
				}
				s=s.substring(0,s.length()-1);
				s+=" Where reservationID = "+reservationID;
				PreparedStatement ps = con.prepareStatement(s);
			   
			    int rowsAffected = ps.executeUpdate();
			    if (rowsAffected > 0) {
			       response = "reservation with Id " + reservationID + " has been successfully Updated...";
			        
			    } else {
			    	throw new ReservationNotFoundException("reservation with reservationID " + reservationID +" not found");   
			    }
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			return response;
		}
		public boolean cancelReservation(Long reservationID) throws ReservationNotFoundException {
		try {
			con = DBConnUtil.getDBCon();
			ps = con.prepareStatement("DELETE FROM reservation WHERE reservationID = ?");
		    ps.setLong(1, reservationID);
		    int rowsAffected = ps.executeUpdate();
		    if (rowsAffected > 0) {
		        System.out.println("reservation with reservationID " + reservationID + " has been successfully cancled...");
		        
		    }else {
		    	throw new ReservationNotFoundException("reservation with reservationID " + reservationID + " not found");
		        
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ReservationNotFoundException("Error occurred while deleting the reservation details..");
			
	}
		return true;
		}
    public boolean reservationExists(Long reservationId) throws SQLException  {
	String query = "SELECT * FROM reservation WHERE reservationid = ?";
	PreparedStatement ps = con.prepareStatement(query);
	ps.setLong(1, reservationId);
	ResultSet rs = ps.executeQuery();
	return rs.next();

}
}


