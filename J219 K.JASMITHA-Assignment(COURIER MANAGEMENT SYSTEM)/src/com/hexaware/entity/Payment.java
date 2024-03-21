package com.hexaware.entity;
public class Payment {

	    private long paymentID;
	    private long courierID;
	    private double amount;
	    private long locationID;
	    private String paymentDate;

	    public Payment() {
	    }

	    public Payment(long paymentID,long courierID,long locationID,double amount,String paymentDate){
	        this.paymentID=paymentID;
	        this.courierID=courierID;
	        this.amount=amount;
	        this.locationID=locationID;
	        this.paymentDate=paymentDate;
	    }

	    public long getPaymentID(){
	        return paymentID;
	    }

	    public void setPaymentID(long paymentID){
	        this.paymentID=paymentID;
	    }
	    public long getCourierID(){
	        return courierID;
	    }
	    public void setCourierID(long courierID){
	        this.courierID=courierID;
	    }
	    public long getLocationID(){
	        return locationID;
	    }
	    public void getLocationID(long locationID){
	        this.locationID=locationID;
	    }

	    public double getAmount(){
	        return amount;
	    }

	    public void setAmount(double amount){
	        this.amount=amount;
	    }

	    public String getPaymentDate(){
	        return paymentDate;
	    }

	    public void setPaymentDate(String paymentDate) {
	        this.paymentDate=paymentDate;
	    }

	    @Override
		public String toString() {
			return "Payment [paymentID=" + paymentID + ", courierID=" + courierID + ", amount=" + amount + ", paymentDate="
					+ paymentDate + "]";
		}
	}

