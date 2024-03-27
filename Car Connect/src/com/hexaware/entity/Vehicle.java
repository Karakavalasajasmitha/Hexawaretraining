package com.hexaware.entity;

public class Vehicle {
	private Long vehicleID;
	private String model;
	private String make;
	private String year; 
	private String color;
	private String registrationNumber;
	private Boolean availability;
	private Double dailyRate;
	
	public Vehicle() {
		
	}
	
	public Vehicle(Long vehicleID,String model,
	String make, String year,String color,String registrationNumber,
    Boolean availability,Double dailyRate) {
		this.vehicleID = vehicleID;
		this.model = model;
		this.make = make;
		this.year = year;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.availability = availability;
		this.dailyRate = dailyRate;
	}
	/**
	 * @return the vehicleID
	 */
	public Long getVehicleID() {
		return vehicleID;
	}
	/**
	 * @param vehicleID the vehicleID to set
	 */
	public void setVehicleID(Long vehicleID) {
		this.vehicleID = vehicleID;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	/**
	 * @return the availability
	 */
	public boolean isAvailability() {
		return availability;
	}
	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	/**
	 * @return the dailyRate
	 */
	public Double getDailyRate() {
		return dailyRate;
	}
	/**
	 * @param dailyRate the dailyRate to set
	 */
	public void setDailyRate(Double dailyRate) {
		this.dailyRate = dailyRate;
	} 
	public String toString() {
		return "vehicle[vehicleID="+vehicleID+",model="+model+",make="+make+
				",year="+year+",color="+color+",registrationNumber="+registrationNumber+
				",availability="+availability+",dailyRate="+dailyRate+"]";
	}

}
