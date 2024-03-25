package com.hexaware.entity;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String role;
	
public User() {
}
public User(int userId,String userName,String password,
	String role) {
	this.userId=userId;
	this.userName = userName;
	this.password = password;
	this.role = role;
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
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param username the username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	public String toString() {
		return "User[userId="+userId+",userName=" + userName + ", password=" + password
				+ ", role=" + role + "]";
}
}
