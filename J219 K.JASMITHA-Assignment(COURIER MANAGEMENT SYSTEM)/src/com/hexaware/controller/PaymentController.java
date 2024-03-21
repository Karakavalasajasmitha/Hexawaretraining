package com.hexaware.controller;

import java.util.Scanner;

import com.hexaware.dao.PaymentDao;
import com.hexaware.entity.Payment;

public class PaymentController implements PaymentInterface {
	PaymentDao paymentDao = new PaymentDao();
	Scanner sc = new Scanner(System.in);

	@Override
	public void makePayment() {
		System.out.println("Enter payment details:");
		System.out.println("Payment ID:");
		long paymentID = sc.nextLong();
		System.out.println("Courier ID:");
		long courierID = sc.nextLong();
		System.out.println("Payment ID:");
		long locationID = sc.nextLong();
		System.out.println("Amount:");
		double amount = sc.nextDouble();
		System.out.println("Payment Date in yyyy-mm-dd format:");
		String paymentDate = sc.next();
		Payment payment = new Payment(paymentID, courierID,locationID,amount, paymentDate);
		paymentDao.makePayment(payment);
		System.out.println("Payment made successfully.");
	}

	@Override
	public void viewPayments() {
		paymentDao.viewPayments();
	}
}
