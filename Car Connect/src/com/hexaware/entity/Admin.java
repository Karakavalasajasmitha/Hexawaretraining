package com.hexaware.entity;

public class Admin {
	 private Long adminID;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String phoneNumber;
	 private String userName;
	 private String password;
	 private String role;
	 private String joinDate ;
	 
	 public Admin() {
		 
	 }
	 public Admin(Long adminID,String firstName, String lastName,
	 String email,String phoneNumber,String userName,String password,String role,
	 String joinDate) {
		 this.adminID = adminID;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.email = email;
		 this.phoneNumber = phoneNumber;
		 this.userName = userName;
		 this.password = password;
		 this.role = role;
		 this.joinDate = joinDate;
	 }
	 
	/**
	 * @return the adminID
	 */
	public Long getAdminID() {
		return adminID;
	}
	/**
	 * @param adminID the adminID to set
	 */
	public void setAdminID(Long adminID) {
		this.adminID = adminID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	/**
	 * @return the joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public String toString() {
		return "admin[AdminID="+adminID+",FirstName="+firstName+",LastName="+lastName+
				",Email="+email+",PhoneNumber="+phoneNumber+",Username="+userName+",Password"+
				password+",Role="+role+",JoinDate="+joinDate+"]";
	}

}
