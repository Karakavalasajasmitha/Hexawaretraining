package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.LocationDao;
import com.hexaware.entity.Location;

public class LocationController implements LocationInterface {
	LocationDao locationDao = new LocationDao();
	Scanner sc = new Scanner(System.in);
@Override
	public void addLocation() {
		System.out.println("Enter location details:");
		System.out.println("Location ID:");
		long locationID = sc.nextLong();
		System.out.println("Location Name:");
		String locationName = sc.next();
		System.out.println("Address:");
		String address = sc.next();
		Location l = new Location();
		l.setLocationID(locationID);
		l.setLocationName(locationName);
		l.setAddress(address);
		locationDao.addLocation(l);
		System.out.println("Location added successfully.");
	}

	@Override
	public void viewLocations() {
		locationDao.viewLocations();
	}
}
