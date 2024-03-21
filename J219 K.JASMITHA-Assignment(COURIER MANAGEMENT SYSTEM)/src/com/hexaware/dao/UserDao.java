package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.hexaware.connectionutil.DBConnection;
import com.hexaware.entity.User;
public class UserDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	public void addUser(User u) {
		try {
			con =DBConnection.getDBConn();
			ps= con.prepareStatement("insert into user values (?,?,?,?,?,?)");
			ps.setLong(1,u.getUserID());
			ps.setString(2,u.getUserName());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPassword());
			ps.setString(5,u.getContactNumber());
			ps.setString(6,u.getAddress());
			
			int noof = ps.executeUpdate();
			System.out.println(noof + " rows inserted");

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void viewUser()
	{
		try {
			con =DBConnection.getDBConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from user");
			
			while(rs.next())
			{
				
				System.out.println("user Id :"+rs.getLong(1));
				System.out.println("user Name :"+rs.getString(2));
				System.out.println("user Email :"+rs.getString(3));
				System.out.println("user Password :"+rs.getString(4));
				System.out.println("user Contact :"+rs.getString(5));
				System.out.println("user Address :"+rs.getString(6));
				System.out.println("--------------------------");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void updateUser(long userID, String address) {
		try {
			PreparedStatement ps = con.prepareStatement("update user set Address = ? where userID = ?");
			ps.setString(1,address );
			ps.setLong(2, userID);
			
			int numberOfRows = ps.executeUpdate();
			if (numberOfRows == 0) {
				System.out.println("User not found for the given ID.");
			} else {
				System.out.println(numberOfRows + " user updated successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
