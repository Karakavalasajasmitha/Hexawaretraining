package com.hexaware.controller;

import com.hexaware.exception.AdminNotFoundException;

public interface IAdminService {
	void getAdminById(Long adminID)throws AdminNotFoundException  ;
	void getAdminByUsername(String userName)throws AdminNotFoundException; 
    void registerAdmin(); 
	String updateAdmin(Long adminID)throws AdminNotFoundException; 
	boolean deleteAdmin(Long adminID)throws AdminNotFoundException;
	void viewAdmin();
}
