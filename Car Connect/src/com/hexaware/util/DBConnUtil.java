package com.hexaware.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil  {
	static Connection con;
	
	public static Connection getDBCon()
	{
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy", "root", "Jasmitha@2002");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
	public static void main(String[] args) {
		System.out.println(getDBCon());
	}
}
