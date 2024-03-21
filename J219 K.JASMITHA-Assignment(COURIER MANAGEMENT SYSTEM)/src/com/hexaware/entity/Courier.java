package com.hexaware.entity;

public class Courier {
	private Long courierID;
	private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private double weight;
    private String status;
    private String trackingNumber;
    private String deliveryDate;
    private Long userID;
    private Long employeeID;
    
    public Courier() {
    	
    }
	
	public Courier(Long courierID,String senderName,
			String senderAddress,String receiverName,
            String receiverAddress,double weight,
            String status,String trackingNumber,
            String deliveryDate,Long userID,Long employeeID)
	{
		this.courierID=courierID;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.deliveryDate = deliveryDate;
		this.userID = userID;
		this.employeeID=employeeID;
        
	}
	public Long getCourierId() {
		return courierID;
	}
	public String getsenderName() {
		return senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public double getWeight() {
		return weight;
	}

	public String getStatus() {
		return status;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public Long getUserID() {
		return userID;
	}
    public void setcourierID(long courierID ) {
    	this.courierID=courierID;
    }
    public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setUserId(Long userID) {
		this.userID = userID;
	}
	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String toString() {
		return "courier[courierid="+courierID+",senderName=" + senderName + ", senderAddress=" + senderAddress
				+ ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", weight=" + weight
				+ ", status=" + status + ", trackingNumber=" + trackingNumber + ", deliveryDate=" + deliveryDate
				+ ", userId=" + userID+", employeeID="+ employeeID+"]";
			

	}
	
}
