package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.VehicleDao;
import com.hexaware.entity.Vehicle;
import com.hexaware.exception.VehicleNotFoundException;

public class VehicleService implements IVehicleService{
	Scanner sc=new Scanner(System.in);
	VehicleDao vd=new VehicleDao();
	@Override
	public void addVehicle() {
		System.out.println("Enter Vehicle details:");
		System.out.println("Enter VehicleID:");
		Long vehicleID = sc.nextLong();
		System.out.println("Enter Model:");
		String model = sc.next();
		System.out.println("Enter Make:");
		String make = sc.next();
		System.out.println("Enter Year:");
		String year = sc.next();
		System.out.println("Enter Color:");
		String color = sc.next();
		System.out.println("Enter RegistrationNumber:");
		String registrationNumber = sc.next();
		System.out.println("Enter Availability:");
		Boolean availability = sc.nextBoolean();
		System.out.println("Enter DailyRate:");
		Double dailyRate = sc.nextDouble();
		Vehicle v = new Vehicle(vehicleID,model,make, year, color, registrationNumber,availability,dailyRate);
		vd.addVehicle(v);
		System.out.println("Vehicle added successfully !!!");
	}
	@Override
	public void getVehicleById(Long vehicleID)throws VehicleNotFoundException {
		 vd.getVehicleById(vehicleID);	
	}
	@Override
	public void getAvailableVehicles(boolean availability )throws VehicleNotFoundException {
		vd.getAvailableVehicles(availability);	
	}

	@Override
	public String updateVehicle(Long vehicleID)throws VehicleNotFoundException {
		String model=null;
		String make = null;
		String color=null;
		String ch;
		
		System.out.print("Want to update model (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter new model : ");
			model = sc.next();
		}
		
		System.out.print("want to update Make (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter the new PhoneNumber : ");
			make = sc.next();
		}
		System.out.print("want to update color (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter the new Color : ");
			color = sc.next();
		}
		return vd.updateVehicle(vehicleID,model,make,color);
		
	}	

	@Override
	public boolean removeVehicle(Long vehicleId) throws VehicleNotFoundException {
		return vd.removeVehicle(vehicleId);
		
	}
	@Override
	public void viewVehicle() {
		vd.viewVehicle();
	}
}
