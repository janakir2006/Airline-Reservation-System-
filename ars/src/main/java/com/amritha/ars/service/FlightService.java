package com.amritha.ars.service;

import java.util.List;

import com.amritha.ars.dto.BookingDetailsDto;
import com.amritha.ars.dto.SearchFlightParams;
import com.amritha.ars.dto.TicketDto;
import com.amritha.ars.entity.Flight;

public interface FlightService {
	
	public TicketDto bookFlight(BookingDetailsDto bookingDetails);

	public List<TicketDto> getTicketsForUser(String username);

	public List<Flight> getAllFlights();

	public List<Flight> searchFlights(SearchFlightParams params);

	public List<String> getAllLocations();
}
