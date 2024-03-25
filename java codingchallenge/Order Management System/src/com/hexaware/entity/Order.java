package com.hexaware.entity;

public class Order {
	private int productId;
	private int userId;
	private int orderId;
	
	public Order() {
	}
	public Order(int productId,int userId,int orderId) {
		this.userId=userId;
		this.productId = productId;
		this.orderId = orderId;
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
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String toString() {
		return "Order[userId="+userId+",productId=" + productId + ", orderId=" + orderId + "]";
	}
}
