package com.hexaware.entity;

public class Clothing extends Product{
	private String size;
	private String color;
	
public Clothing() {
		
	}
	public Clothing(String size,String color) {
		this.size=size;
		this.color=color;
	}
	
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
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
	public String toString() {
		return "Clothing[size="+size+",color=" + color + "]"; 
	
	}
}

