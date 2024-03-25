package com.hexaware.entity;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int quantityInStock;
	private String type;
	
public Product() {
    	
    }
	
	public Product(int productId,String productName,String description,double price,
	int quantityInStock,String type)
	{
		this.productId=productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.type = type; 
	}
	
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the quantityInStock
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}
	/**
	 * @param quantityInStock the quantityInStock to set
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return "product[productid="+productId+",productName=" + productName + ", description=" + description
				+ ", price=" + price + ", quantityInStock=" + quantityInStock + ", type=" + type+"]";
			

	}

}
