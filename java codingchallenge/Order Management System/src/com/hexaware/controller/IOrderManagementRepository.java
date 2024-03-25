package com.hexaware.controller;

import java.sql.Connection;
import java.util.List;

import com.hexaware.entity.Order;
import com.hexaware.entity.Product;
import com.hexaware.entity.User;
import com.hexaware.exception.OrderNotFoundException;
import com.hexaware.exception.UserNotFoundException;

public interface IOrderManagementRepository {
	public void createUser();
	public void viewUser();
	public boolean userExists(int userId) throws UserNotFoundException ;
	public void createProduct()throws UserNotFoundException;
	public void createOrder();
	public boolean cancelOrder() throws UserNotFoundException,OrderNotFoundException;
	public List<Product> getOrderByUser();
	public void getAllProducts();

}
