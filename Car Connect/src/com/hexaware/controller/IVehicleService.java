package com.hexaware.controller;

import com.hexaware.exception.VehicleNotFoundException;

public interface IVehicleService {
	void getVehicleById(Long vehicleID)throws VehicleNotFoundException; 
	void getAvailableVehicles(boolean availability)throws VehicleNotFoundException ;
	void addVehicle();
	void viewVehicle();
	String updateVehicle(Long vehicleID)throws VehicleNotFoundException;
	boolean removeVehicle(Long vehicleId)throws VehicleNotFoundException ;

}
