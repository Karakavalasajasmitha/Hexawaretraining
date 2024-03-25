package com.hexaware.controller;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.hexaware.dao.OrderProcessorDao;
import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.entity.User;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public class OrderProcessorController implements IOrderManagementRepository  {
	OrderProcessorDao op=new OrderProcessorDao();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void createUser() {
		User user=new User();
		List <User> ulist=new ArrayList<User>();
		System.out.println("Enter userId:");
		user.setUserId(sc.nextInt());
		System.out.println("Enter username:");
		user.setUserName(sc.next());
		System.out.println("Enter password:");
		user.setPassword(sc.next());
		System.out.println("Enter role:");
		user.setRole(sc.next());
		ulist.add(user);
		System.out.println("User Created successfully !!!");
	}

	@Override
	public void viewUser() {
		op.viewUser();
	}

	@Override
	public boolean userExists(int userId) throws UserNotFoundException {
		return op.userExists(userId);
	}

	@Override
	public void createProduct() throws UserNotFoundException {
		List<Product> plist=new ArrayList<Product>();
		User user=new User();
		Product product=new Product();
		System.out.println("Enter type(Clothing/Electronics):");
		String type = sc.next();
		if (type.equalsIgnoreCase("Clothing")){
			System.out.print("Size: ");
	        String size = sc.next();
	        System.out.print("Color: ");
	        String color = sc.next();
	        
		}
		else if (type.equalsIgnoreCase("Electronics")) {
	        System.out.print("Brand: ");
	        String brand = sc.nextLine();
	        System.out.print("Warranty Period: ");
	        int warrantyPeriod = sc.nextInt();
	        sc.nextLine();
	}
		System.out.println("Enter productId:");
		product.setProductId(sc.nextInt());
		System.out.println("Enter productName:");
		product.setProductName(sc.next());
		System.out.println("Enter description:");
		product.setDescription(sc.next());
		System.out.println("Enter price:");
		product.setPrice(sc.nextDouble());
		System.out.println("Enter quantityInStock:");
		product.setQuantityInStock(sc.nextInt());
		System.out.println("Enter type(Clothing/Electronics):");
		plist.add(product);
		System.out.println("product Created successfully !!!");
	}

	@Override
	public void createOrder() {
		User user=new User();
		Product product=new Product();
		Order o=new Order();
		System.out.println("Enter productId:");
		product.setProductId(sc.nextInt());
		System.out.println("Enter UserId:");
		user.setUserId(sc.nextInt());
		System.out.println("Enter OrderId:");
		o.setOrderId(sc.nextInt());
		System.out.println("product Created successfully !!!");
	}
	

	@Override
	public boolean cancelOrder() throws UserNotFoundException, OrderNotFoundException {
		int userId=sc.nextInt();
		int orderId=sc.nextInt();
		return op.cancelOrder(userId, orderId);
	}

	@Override
	public List<Product> getOrderByUser() {
		return op.getOrderByUser();
	}

	@Override
	public void getAllProducts() {
		op.getAllProducts();
		
	}
}

	