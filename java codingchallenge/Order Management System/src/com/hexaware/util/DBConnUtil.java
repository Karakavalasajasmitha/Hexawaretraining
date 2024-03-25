package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
	    static Connection conn;
		public static Connection getDBConn() {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OMS", "root", "Jasmitha@2002");
			} catch (SQLException e) {
		
				e.printStackTrace();
			}

			return conn;
		}

		public static void main(String[] args) {
			System.out.println(getDBConn());


		}
	}
