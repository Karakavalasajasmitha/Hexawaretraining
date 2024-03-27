package com.hexaware.controller;

import com.hexaware.exception.CustomerNotFoundException;

public interface ICustomerService {
	void getCustomerById(Long customerID) throws CustomerNotFoundException;
	void getCustomerByUsername(String username)throws CustomerNotFoundException ;
	void registerCustomer(); 
	String updateCustomer(Long customerID ) throws CustomerNotFoundException;
	boolean deleteCustomer(Long customerID)throws CustomerNotFoundException;
	void viewCustomer();
}
