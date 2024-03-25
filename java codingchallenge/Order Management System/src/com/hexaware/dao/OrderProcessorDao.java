package com.hexaware.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.entity.User;
import com.hexaware.exception.*;
import com.hexaware.util.DBConnUtil;

public class OrderProcessorDao {
	static Connection con = DBConnUtil.getDBConn();
	static PreparedStatement ps;
	public void createUser() {
			try {
				User user=new User();
				PreparedStatement ps=con.prepareStatement("insert into Admin values(?,?,?,?)");
				ps.setInt(1,user.getUserId());
				ps.setString(2, user.getUserName());
				ps.setString(3,user.getPassword());
				ps.setString(4,user.getRole());
				System.out.println("User Created Successfully !!!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			public void viewUser() {
				try {
					String query = "SELECT * FROM user";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						System.out.println("user ID: " + rs.getInt(1));
						System.out.println("user Name: " + rs.getString(2));
						System.out.println("password: " + rs.getString(3));
						System.out.println("role: " + rs.getString(4));
						System.out.println("----------------------------------------");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		public boolean userExists(int userId) throws UserNotFoundException {
			try {
				        String sql = "SELECT * FROM User WHERE userId = ?";
				        Connection conn=null;
						PreparedStatement ps = conn.prepareStatement(sql);
				        ps.setInt(1, userId);
				        ResultSet rs = ps.executeQuery();
				        return rs.next(); 
			 
	        } catch (SQLException e) {
		      e.printStackTrace();
		     throw new UserNotFoundException("Error occured while fetching the user details..");
	}
		}
		public static void createProduct(User user,Product product)throws UserNotFoundException {
			try {
					PreparedStatement ps=con.prepareStatement("insert into  values(?,?,?,?,?,?,?,?,?)");
					ps.setInt(1,product.getProductId());
					ps.setString(2, product.getProductName());
					ps.setString(3,product.getDescription());
					ps.setDouble(4,product.getPrice());
					ps.setInt(5,product.getQuantityInStock());
					ps.setString(6,product.getType());
					System.out.println("Product Created Successfully !!!");
				}
				catch (SQLException e) {
				e.printStackTrace();
			}
		}
			public void getAllProducts() {
				try {
					String query = "SELECT * FROM Product";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						System.out.println("Product ID: " + rs.getInt(1));
						System.out.println("Product Name: " + rs.getString(2));
						System.out.println("description: " + rs.getString(3));
						System.out.println("price: " + rs.getDouble(4));
						System.out.println("quantityInStock: " + rs.getInt(4));
						System.out.println("type: " + rs.getString(4));
						System.out.println("----------------------------------------");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
public void createOrder(User user, Product product,Order o) {
		 try {
				PreparedStatement ps=con.prepareStatement("insert into order values(?,?,?)");
				ps.setInt(1, product.getProductId());
				ps.setInt(2, user.getUserId());
				ps.setInt(3, o.getOrderId());
				
				
				System.out.println("Product Created Successfully !!!");
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
}
public boolean cancelOrder(int userId, int orderId) throws UserNotFoundException,OrderNotFoundException  {
				try {
					con = DBConnUtil.getDBConn();
				    ps = con.prepareStatement("DELETE FROM order WHERE orderID = ?");
				    ps.setInt(1, orderId);
				    ps.setInt(2, userId);
				
				    int rowsAffected = ps.executeUpdate();
				    if (rowsAffected > 0) {
				        System.out.println("order with orderID " + orderId + " has been successfully cancled...");
				        
				    }else {
				    	throw new OrderNotFoundException("order with orderID " + orderId + " not found");
				        
				    }
				} catch (SQLException e) {
					e.printStackTrace();
					throw new OrderNotFoundException("Error occurred while deleting the order details..");
					
			}
				return true;
				}
public List<Product> getOrderByUser() {
    User user=new User();
	List<Product> orderedProducts = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conn = DBConnUtil.getDBConn();

        // SQL query to fetch ordered products for the given user
        String sql = "SELECT p.productId, p.productName, p.description, p.price, p.quantityInStock, p.type " +
                     "FROM Orders o " +
                     "INNER JOIN Product p ON o.productId = p.productId " +
                     "WHERE o.userId = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getUserId());

        // Execute the query
        rs = ps.executeQuery();

        // Process the result set
        while (rs.next()) {
            // Create Product objects from the retrieved data
            Product p = new Product();
            p.setProductId(rs.getInt("productId"));
            p.setProductName(rs.getString("productName"));
            p.setDescription(rs.getString("description"));
            p.setPrice(rs.getDouble("price"));
            p.setQuantityInStock(rs.getInt("quantityInStock"));
            p.setType(rs.getString("type"));
            orderedProducts.add(p);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
return orderedProducts;
}
}