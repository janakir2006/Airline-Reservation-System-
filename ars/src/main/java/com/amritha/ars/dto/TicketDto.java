package com.amritha.ars.dto;

import java.sql.Timestamp;

public class TicketDto {
	
	private String flightNumber;
	private String from;
	private String to;
    private Timestamp flightTime;
    private double price;
    private String username;
    private Timestamp bookingTime;
    private String travelClass;	
    private String paymentMode;
	private MealPreferences mealPreferences;
	private String customerName;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Timestamp getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(Timestamp flightTime) {
		this.flightTime = flightTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public MealPreferences getMealPreferences() {
		return mealPreferences;
	}
	public void setMealPreferences(MealPreferences mealPreferences) {
		this.mealPreferences = mealPreferences;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
