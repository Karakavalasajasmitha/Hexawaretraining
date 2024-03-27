package com.hexaware.controller;
import java.util.Scanner;
import com.hexaware.dao.ReservationDao;
import com.hexaware.entity.Reservation;
import com.hexaware.exception.ReservationNotFoundException;

public class ReservationService implements IReservationService {
	Scanner sc=new Scanner(System.in);
	ReservationDao rd=new ReservationDao();
	@Override
	public void createReservation() {
			System.out.println("Enter ReservationId:");
			Long reservationID = sc.nextLong();
			System.out.println("Enter CustomerID:");
			Long customerID = sc.nextLong();
			System.out.println("Enter VehicleID:");
			Long vehicleID = sc.nextLong();
			System.out.println("Enter StartDate(yyyy-mm-dd):");
			String startDate = sc.next();
			System.out.println("Enter EndDate(yyyy-mm-dd):");
			String endDate = sc.next();
			System.out.println("Enter TotalCost:");
			Double totalCost = sc.nextDouble();
			System.out.println("Enter Status:");
			String status = sc.next();
			Reservation r = new Reservation(reservationID,customerID, vehicleID, startDate, endDate,totalCost,status);
			rd.createReservation(r);
			System.out.println("Reservation created successfully !!!");
			
		}
	public void viewReservation() {
		rd.viewReservation();
	}

	@Override
	public void getReservationById(Long reservationID)throws ReservationNotFoundException {
		 rd.getReservationById(reservationID);
		
	}
	@Override
	public String updateReservation(Long reservationID) throws ReservationNotFoundException {
		String startDate=null;
		String endDate = null;
		String ch;
		
		System.out.print("Want to update startDate (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter new startDate : ");
			startDate = sc.next();
		}
		
		System.out.print("want to update endDate (Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y"))
		{
			System.out.print("enter the new endDate : ");
			endDate = sc.next();
		}
		return rd.updateReservation(reservationID,startDate,endDate);
		
	}	
	@Override
	public boolean cancelReservation(Long reservationID)throws ReservationNotFoundException {
		return rd.cancelReservation(reservationID);
		
	}

	@Override
	public void getReservationsByCustomerID(Long customerID) throws ReservationNotFoundException {
		rd.getReservationsByCustomerId(customerID);
		
	}

}
