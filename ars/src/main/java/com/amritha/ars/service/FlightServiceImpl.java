package com.amritha.ars.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amritha.ars.dao.CustomerDao;
import com.amritha.ars.dao.FlightDao;
import com.amritha.ars.dao.TicketDao;
import com.amritha.ars.dto.BookingDetailsDto;
import com.amritha.ars.dto.MealPreferences;
import com.amritha.ars.dto.SearchFlightParams;
import com.amritha.ars.dto.TicketDto;
import com.amritha.ars.entity.Customer;
import com.amritha.ars.entity.Flight;
import com.amritha.ars.entity.Ticket;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	TicketDao ticketDao;

	@Autowired
	FlightDao flightDao;	
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public TicketDto bookFlight(BookingDetailsDto bookingDetails) {
		
		Ticket ticket = new Ticket();
		
		Flight flight = flightDao.getFlightByFlightNumber(bookingDetails.getFlightNumber());
		Customer customer = customerDao.findCustomerById(bookingDetails.getUsername());
		
		ticket.setBookingTime(new Timestamp(System.currentTimeMillis()));
		ticket.setCustomerId(customer.getId());
		ticket.setFlightId(flight.getId());
		ticket.setMealPreferences(bookingDetails.getMealPreferences());
		ticket.setPaymentMode(bookingDetails.getPaymentMode());
		ticket.setTravelClass(bookingDetails.getTravelClass());
		ticket.setPrice(calculateTicketPrice(flight.getPrice(), bookingDetails.getMealPreferences()));
		
		ticketDao.createTicket(ticket);
		
		TicketDto dto = new TicketDto();
		
		dto.setBookingTime(ticket.getBookingTime());
		dto.setFlightTime(flight.getDate());
		dto.setFlightNumber(flight.getFlightNumber());
		dto.setFrom(flight.getFrom());
		dto.setTo(flight.getTo());
		dto.setMealPreferences(bookingDetails.getMealPreferences());
		dto.setPaymentMode(bookingDetails.getPaymentMode());
		dto.setTravelClass(bookingDetails.getTravelClass());
		dto.setUsername(customer.getUsername());
		dto.setPrice(ticket.getPrice());
		
		return dto;
	}

	private double calculateTicketPrice(double price, MealPreferences mealPreferences) {
		return price + calculateMealCost(mealPreferences.getMainMeal(), mealPreferences.getRefreshment());
	}
	
    private double calculateMealCost(String mainMeal, String refreshment) {
        double cost = 0;
        switch (mainMeal.toLowerCase()) {
            case "veg": cost += 50; break;
            case "non-veg": cost += 100; break;
        }
        switch (refreshment.toLowerCase()) {
            case "tea":
            case "coffee":
            case "milk": cost += 20; break;
            case "wine": cost += 150; break;
        }
        return cost;
    }


	@Override
	public List<TicketDto> getTicketsForUser(String username) {
		Customer customer = customerDao.findCustomerById(username);

		List<Ticket> tickets = flightDao.getTicketsForUser(customer.getId());
		
		//populate dto
		List<TicketDto> ticketsDto = new ArrayList<>();
		for (Ticket ticket : tickets) {
			TicketDto dto = new TicketDto();
			
			Flight flight = flightDao.getFlightById(ticket.getFlightId());

			dto.setBookingTime(ticket.getBookingTime());
			dto.setFlightTime(flight.getDate());
			dto.setFlightNumber(flight.getFlightNumber());
			dto.setFrom(flight.getFrom());
			dto.setTo(flight.getTo());
			dto.setMealPreferences(ticket.getMealPreferences());
			dto.setPaymentMode(ticket.getPaymentMode());
			dto.setTravelClass(ticket.getTravelClass());
			dto.setUsername(customer.getUsername());
			dto.setPrice(ticket.getPrice());
			dto.setCustomerName(customer.getName());

			ticketsDto.add(dto);
		}
		
		return ticketsDto;
	}

	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Override
	public List<Flight> searchFlights(SearchFlightParams params) {
		return flightDao.searchFlights(params);
	}

	@Override
	public List<String> getAllLocations() {
		return flightDao.getAllLocations();
	}

}
