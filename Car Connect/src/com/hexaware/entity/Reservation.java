package com.hexaware.entity;

public class Reservation {
	 private Long reservationID;
	 private Long customerID;
	 private Long vehicleID;
	 private String startDate;
	 private String endDate;
	 private double totalCost;
	 private String status;
	 
	 public Reservation() { 
	 }
	 public Reservation(Long reservationID,Long customerID,Long vehicleID,
     String startDate,String endDate,double totalCost,String status) {
		 this.reservationID = reservationID;
		 this.customerID = customerID;
		 this.vehicleID = vehicleID;
		 this.startDate = startDate;
		 this.endDate = endDate;
		 this.totalCost = totalCost;
		 this.status = status;	 
	 }
	/**
	 * @return the reservationID
	 */
	public Long getReservationID() {
		return reservationID;
	}
	/**
	 * @param reservationID the reservationID to set
	 */
	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}
	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString()
	{
		return "Reservation[ReservationID="+reservationID+",CustomerID="+customerID
				+",VehicleID="+vehicleID+",StartDate="+startDate+",EndDate="+",TotalCost="+
				totalCost+",Status="+status+"]";
	}	

}
