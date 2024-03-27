package com.hexaware.entity;
public class Customer {
	 private Long customerID; 
	 private String firstName;
	 private String lastName; 
	 private String email;
	 private String phoneNumber;
	 private String address;
	 private String userName; 
	 private String password; 
	 private String registrationDate ;
	 
	 public Customer() {
	 }
	 public Customer(Long customerID,String firstName, String lastName, String email,
			 String phoneNumber,String address,String userName,String password,String registrationDate )
	 {
		 this.customerID = customerID;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.email = email;
		 this.phoneNumber = phoneNumber;
		 this.address = address;
		 this.userName = userName;
		 this.password=password;
		 this.registrationDate = registrationDate;
		 
	 }
	/**
	 * @return the customerID
	 */
	public Long getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the registrationDate
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String tostring() {
		return "customer[CustomerID="+customerID+",FirstName="+firstName+",lastName="+lastName
				+",email="+email+",phoneNumber="+phoneNumber+",address="+address+",username"+
				userName+",password="+password+",registrationDate="+registrationDate+"]";
	}
}

	