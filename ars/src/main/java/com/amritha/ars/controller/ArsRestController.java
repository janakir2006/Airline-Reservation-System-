package com.amritha.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amritha.ars.dao.CustomerDao;
import com.amritha.ars.dto.BookingDetailsDto;
import com.amritha.ars.dto.SearchFlightParams;
import com.amritha.ars.dto.TicketDto;
import com.amritha.ars.entity.Customer;
import com.amritha.ars.entity.Flight;
import com.amritha.ars.service.CustomerService;
import com.amritha.ars.service.FlightService;
import com.amritha.ars.entity.User;
import com.amritha.ars.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArsRestController {

	@Autowired
	FlightService flightService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
    private UserService userService;

	@GetMapping("/flights")
	public List<Flight> getFlights() {
		return flightService.getAllFlights();
	}

	@PostMapping("/registerCustomer")
	public String registerCustomer(@RequestBody Customer customer) {
		customerService.registerCustomer(customer);
		
		return "ok";
	}
	
	@PostMapping("/searchFlights")
	public List<Flight> searchFlights(@RequestBody SearchFlightParams params) {
		return flightService.searchFlights(params);		
	}
	

	@GetMapping("/locations")
	public List<String> getAllLocations() {
		return flightService.getAllLocations();
	}

	@PostMapping("/bookFlight")
	public TicketDto bookFlight(@RequestBody BookingDetailsDto bookingDetails) {
		return flightService.bookFlight(bookingDetails);
	}
	
	@GetMapping("/myTickets")
	public List<TicketDto> myTickets(@RequestParam String username) {
		return flightService.getTicketsForUser(username);
	}
	

}
	

