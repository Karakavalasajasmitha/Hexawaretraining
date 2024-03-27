package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Customer;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.util.DBConnUtil;

public class CustomerDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	public void registerCustomer(Customer c) {
		try {
			    con = DBConnUtil.getDBCon();
				ps=con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?)");
				ps.setLong(1,c.getCustomerID());
				ps.setString(2, c.getFirstName());
				ps.setString(3,c.getLastName());
				ps.setString(4,c.getEmail());
				ps.setString(5,c.getPhoneNumber());
				ps.setString(6,c.getAddress());
				ps.setString(7,c.getUserName());
				ps.setString(8,c.getPassword());
				ps.setString(9,c.getRegistrationDate());
				
				int numberOfRows = ps.executeUpdate();
				System.out.println(numberOfRows + " row inserted successfully in Customer table!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void viewCustomer() {
			try {
				con = DBConnUtil.getDBCon();
				String query = "SELECT * FROM Customer ";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println("Customer ID: " + rs.getLong(1));
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Address: " + rs.getString(6));
					System.out.println("UserName: " + rs.getString(7));
					System.out.println("Password: " + rs.getString(8));
					System.out.println("RegistrationDate: " + rs.getString(9));
					System.out.println("----------------------------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void getCustomerById(Long customerID)throws CustomerNotFoundException{
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Customer where CustomerID=?";
				ps = con.prepareStatement(query);
				ps.setLong(1, customerID);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("----------------------------------------");
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Address: " + rs.getString(6));
					System.out.println("UserName: " + rs.getString(7));
					System.out.println("Password: " + rs.getString(8));
					System.out.println("RegistrationDate: " + rs.getString(9));
					System.out.println("----------------------------------------");
				} else {
					throw new CustomerNotFoundException(
							"Invalid Customer ID.. Please enter valid Customer ID...");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new CustomerNotFoundException("Error occurred while retrieving Customer details..");
	}
}
		public void getCustomerByUserName(String userName)throws CustomerNotFoundException  {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Customer where userName=?";
				ps = con.prepareStatement(query);
				ps.setString(1, userName);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("----------------------------------------");
					System.out.println("Customer ID: " + rs.getLong(1));
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Address: " + rs.getString(6));
					System.out.println("Password: " + rs.getString(8));
					System.out.println("RegistrationDate: " + rs.getString(9));
					System.out.println("----------------------------------------");
				} else {
					throw new CustomerNotFoundException(
							"Invalid username.. Please enter valid username...");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new CustomerNotFoundException("Error occurred while retrieving Customer details..");
	}
}
		public String updateCustomer(long customerID,String password, String phoneNumber,String address) throws CustomerNotFoundException {
			String response="";
			try {
				con = DBConnUtil.getDBCon();
				String s ="update  Customer ";
				if(password != null)
				{
					s=s+"set Password = "+"'"+password+"'"+",";
				}
				if(phoneNumber != null)
				{
					s=s+"set phoneNumber = "+"'"+phoneNumber+"'"+",";
				}
				if(address != null)
				{
					s=s+"set address = "+"'"+address+"'"+",";
				}
				s=s.substring(0,s.length()-1);
				s+=" Where CustomerID = "+customerID;
			    ps = con.prepareStatement(s);
			   
			    int rowsAffected = ps.executeUpdate();
			    if (rowsAffected > 0) {
			       response = "customer with customerId " + customerID + " has been successfully Updated...";
			        
			    } else {
			        
			    	 throw new CustomerNotFoundException("customer with customerId " + customerID +" not found");
			        
			    }
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
			return response;
			
		}
		public boolean deleteCustomer(Long customerID) throws CustomerNotFoundException {
		try {
			con = DBConnUtil.getDBCon();
		    ps = con.prepareStatement("DELETE FROM customer WHERE customerID = ?");
		    ps.setLong(1, customerID);
		    int rowsAffected = ps.executeUpdate();
		    if (rowsAffected > 0) {
		        System.out.println("customer with customerID " + customerID + " has been successfully deleted...");
		        
		    }else {
		    	throw new CustomerNotFoundException("customer with customerID " + customerID + " not found");
		        
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerNotFoundException("Error occurred while deleting the customer details..");
			
	}
		return true;
		}
}
	

	