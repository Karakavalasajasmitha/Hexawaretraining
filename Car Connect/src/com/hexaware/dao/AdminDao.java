package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.entity.Admin;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.util.DBConnUtil;
public class AdminDao {
	    Connection con;
		PreparedStatement ps;
		Statement stmt;
		ResultSet rs;
	public  void registerAdmin(Admin a) {
		try {
			con = DBConnUtil.getDBCon();
			PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?,?,?,?,?,?)");
			ps.setLong(1,a.getAdminID());
			ps.setString(2, a.getFirstName());
			ps.setString(3,a.getLastName());
			ps.setString(4,a.getEmail());
			ps.setString(5,a.getPhoneNumber());
			ps.setString(6,a.getUserName());
			ps.setString(7,a.getPassword());
			ps.setString(8,a.getRole());
			ps.setString(9,a.getJoinDate());
			int numberOfRows = ps.executeUpdate();
			System.out.println(numberOfRows + " row inserted successfully in Admin table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void viewAdmin() {
			try {
				con = DBConnUtil.getDBCon();
				String query = "SELECT * FROM Admin";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println("Admin ID: " + rs.getLong(1));
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Username: " + rs.getString(6));
					System.out.println("Password: " + rs.getString(7));
					System.out.println("Role: " + rs.getString(8));
					System.out.println("JoinDate : " + rs.getString(9));
					System.out.println("----------------------------------------");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void getAdminById(Long adminID)throws AdminNotFoundException  {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Admin where adminID=?";
			    ps = con.prepareStatement(query);
				ps.setLong(1, adminID);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Username: " + rs.getString(6));
					System.out.println("Password: " + rs.getString(7));
					System.out.println("Role: " + rs.getString(8));
					System.out.println("JoinDate : " + rs.getString(9));
					System.out.println("----------------------------------------");
				} else {
					throw new AdminNotFoundException(
							"Invalid Admin ID.. Please enter valid Admin ID...");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new AdminNotFoundException("Error occurred while retrieving admin details..");
	}
}
		public void getAdminByUserName(String userName)throws AdminNotFoundException  {
			try {
				con = DBConnUtil.getDBCon();
				String query="select * from Admin where userName=?";
				ps = con.prepareStatement(query);
				ps.setString(1, userName);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("Admin ID: " + rs.getLong(1));
					System.out.println("First Name: " + rs.getString(2));
					System.out.println("Last Name: " + rs.getString(3));
					System.out.println("Email: " + rs.getString(4));
					System.out.println("Phone Number: " + rs.getString(5));
					System.out.println("Password: " + rs.getString(7));
					System.out.println("Role: " + rs.getString(8));
					System.out.println("JoinDate : " + rs.getString(9));
					System.out.println("----------------------------------------");
				} else {
					throw new AdminNotFoundException(
							"Invalid username.. Please enter valid username...");
				}
		}
			catch (SQLException e) {
				e.printStackTrace();
				throw new AdminNotFoundException("Error occurred while retrieving admin details..");
	}
}
		public String updateAdmin(long adminID,String password, String phoneNumber) throws AdminNotFoundException {
			String response="";
			try {
				con = DBConnUtil.getDBCon();
				String s ="update  Admin ";
				if(password != null)
				{
					s=s+"set Password = "+"'"+password+"'"+",";
				}
				if(phoneNumber != null)
				{
					s=s+"set phoneNumber = "+"'"+phoneNumber+"'"+",";
				}
				s=s.substring(0,s.length()-1);
				s+=" Where AdminID = "+adminID;
				ps = con.prepareStatement(s);
			   
			    int rowsAffected = ps.executeUpdate();
			    if (rowsAffected > 0) {
			       response = "Admin with Id " + adminID + " has been successfully Updated...";
			        
			    } else {
			        
			    	 throw new AdminNotFoundException("Admin with AdminId " + adminID +" not found");
			        
			    }
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
			
			return response;
			
		}
		public boolean deleteAdmin(Long adminID) throws AdminNotFoundException {
		try {
			con = DBConnUtil.getDBCon();
			ps = con.prepareStatement("DELETE FROM admin WHERE adminID = ?");
		    ps.setLong(1, adminID);
		    int rowsAffected = ps.executeUpdate();
		    if (rowsAffected > 0) {
		        System.out.println("Admin with AdminID " + adminID + " has been successfully deleted...");
		        
		    }else {
		    	throw new AdminNotFoundException("Admin with AdminID " + adminID + " not found");
		        
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminNotFoundException("Error occurred while deleting the admin details..");
			
	}
		return true;
		}
}
	
