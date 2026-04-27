package com.amritha.ars.dao;

import java.util.List;

import com.amritha.ars.dto.SearchFlightParams;
import com.amritha.ars.entity.Flight;
import com.amritha.ars.entity.Ticket;

public interface FlightDao {

	public List<Flight> getAllFlights();
	
	public List<Flight> searchFlights(SearchFlightParams params);

	public List<String> getAllLocations();

	public Flight getFlightByFlightNumber(String flightNumber);

	public List<Ticket> getTicketsForUser(Long id);

	public Flight getFlightById(Long flightId);
}
