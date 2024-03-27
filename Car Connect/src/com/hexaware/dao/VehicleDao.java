package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Vehicle;
import com.hexaware.exception.VehicleNotFoundException;
import com.hexaware.util.DBConnUtil;

public class VehicleDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	public void addVehicle(Vehicle v) {
		try {
			con = DBConnUtil.getDBCon();
			ps=con.prepareStatement("insert into Vehicle values(?,?,?,?,?,?,?,?)");
			ps.setLong(1,v.getVehicleID());
			ps.setString(2, v.getModel());
			ps.setString(3,v.getMake());
			ps.setString(4,v.getYear());
			ps.setString(5,v.getColor());
			ps.setString(6,v.getRegistrationNumber());
			ps.setBoolean(7,v.isAvailability());
			ps.setDouble(8,v.getDailyRate());
			
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row inserted successfully in vehicle table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void viewVehicle() {
			try {
				con = DBConnUtil.getDBCon();
				String query = "SELECT * FROM Vehicle";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println("Vehicle ID: " + rs.getLong(1));
					System.out.println("Model: " + rs.getString(2));
					System.out.println("Make: " + rs.getString(3));
					System.out.println("Year: " + rs.getString(4));
					System.out.println("Color: " + rs.getString(5));
					System.out.println("RegistrationNumber: " + rs.getString(6));
					System.out.println("Availability: " + rs.getBoolean(7));
					System.out.println("DailyRate: " + rs.getDouble(8));
					System.out.println("----------------------------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void getVehicleById(Long vehicleID)throws VehicleNotFoundException {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Vehicle where vehicleID=?";
				ps = con.prepareStatement(query);
				ps.setLong(1, vehicleID);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					System.out.println("----------------------------------------");
					System.out.println("Model: " + rs.getString(2));
					System.out.println("Make: " + rs.getString(3));
					System.out.println("Year: " + rs.getString(4));
					System.out.println("Color: " + rs.getString(5));
					System.out.println("RegistrationNumber: " + rs.getString(6));
					System.out.println("Availability: " + rs.getBoolean(7));
					System.out.println("DailyRate: " + rs.getDouble(8));
					System.out.println("----------------------------------------");
					
				} else {
					throw new VehicleNotFoundException(
							"Invalid vehicle ID.. Please enter valid vehicle ID...");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new VehicleNotFoundException("Error occurred while retrieving vehicle details..");
	}
}
		public void getAvailableVehicles(boolean availability)throws VehicleNotFoundException  {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from vehicle where availability=?";
				ps = con.prepareStatement(query);
				ps.setBoolean(1, true);
				rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("Vehicle ID: " + rs.getLong(1));
					System.out.println("Model: " + rs.getString(2));
					System.out.println("Color: " + rs.getString(5));
					System.out.println("RegistrationNumber: " + rs.getString(6));
					System.out.println("Availability: " + rs.getBoolean(7));
					System.out.println("DailyRate: " + rs.getDouble(8));
					System.out.println("----------------------------------------");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new VehicleNotFoundException("There are no availabile vehicles..");
	}
}
		public String updateVehicle(long vehicleID,String model,String make, String color) throws VehicleNotFoundException {
			String response="";
			try {
				con = DBConnUtil.getDBCon();
				String s ="update  vehicle ";
				if(model != null)
				{
					s=s+"set model = "+"'"+model+"'"+",";
				}
				if(make != null)
				{
					s=s+"set make = "+"'"+make+"'"+",";
				}
				if(color != null)
				{
					s=s+"set color = "+"'"+color+"'"+",";
				}
				s=s.substring(0,s.length()-1);
				s+=" Where vehicleID = "+vehicleID;
				PreparedStatement ps = con.prepareStatement(s);
			   
			    int rowsAffected = ps.executeUpdate();
			    if (rowsAffected > 0) {
			       response = "vehicle with Id " + vehicleID + " has been successfully Updated...";
			        
			    } else {
			        
			    	 throw new VehicleNotFoundException("Vehicle with vehicleId " + vehicleID +" not found");
			        
			    }
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
			return response;
			
		}
		public boolean removeVehicle (Long vehicleID) throws VehicleNotFoundException {
		try {
			con = DBConnUtil.getDBCon();
			ps = con.prepareStatement("DELETE FROM vehicle WHERE vehicleID = ?");
		    ps.setLong(1, vehicleID);
		    int rowsAffected = ps.executeUpdate();
		    if (rowsAffected > 0) {
		        System.out.println("vehicle with vehicleID " + vehicleID + " has been successfully removed...");
		        
		    }else {
		    	throw new VehicleNotFoundException("vehicle with vehicleID " + vehicleID + " not found");
		        
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VehicleNotFoundException("Error occurred while removing the vehicle details..");
			
	}
		return true;
		}
}
	
