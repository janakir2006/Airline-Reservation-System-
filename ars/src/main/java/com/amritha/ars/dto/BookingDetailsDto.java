package com.amritha.ars.dto;

public class BookingDetailsDto {

	private String flightNumber;
	private String username;
	private String travelClass;
	private MealPreferences mealPreferences;
	private String paymentMode;
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}