package com.hexaware.controller;
import com.hexaware.exception.ReservationNotFoundException;

public interface IReservationService {
    void getReservationsByCustomerID(Long customerID)throws ReservationNotFoundException; 
    void getReservationById(Long reservationID)throws ReservationNotFoundException; 
	void createReservation() ;
	boolean cancelReservation(Long reservationID)throws ReservationNotFoundException ;
	String updateReservation(Long reservationID)throws ReservationNotFoundException;
	void viewReservation();
}
