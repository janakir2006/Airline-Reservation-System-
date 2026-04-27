package com.amritha.ars.entity;

import java.sql.Timestamp;

import com.amritha.ars.dto.MealPreferences;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	@Column(name = "flight_id")
	private Long flightId;
    
	@Column(name = "price")
    private double price;

	@Column(name = "customer_id")
    private Long customerId;
	
	@Column(name = "booking_time")
    private Timestamp bookingTime;
	
	@Column(name = "travel_class")
    private String travelClass;	
	
	@Column(name = "payment_mode")
    private String paymentMode;
	
	@Column(name = "meal_preferences")
	@Convert(converter = MealPreferencesConverter.class)
	private MealPreferences mealPreferences;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
		
}
