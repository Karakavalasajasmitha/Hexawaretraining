package com.hexaware.entity;

public class Electronics extends Product{
	private String brand;
	private int warrantyPeriod;
	
	public Electronics() {
		
	}
	public Electronics(String brand,int warrantyPeriod) {
		this.brand=brand;
		this.warrantyPeriod=warrantyPeriod;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the warrantyPeriod
	 */
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	/**
	 * @param warrantyPeriod the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	public String toString() {
		return "Electronics[brand="+brand+",warrantyPeriod=" + warrantyPeriod + "]"; 
	
	}
}
