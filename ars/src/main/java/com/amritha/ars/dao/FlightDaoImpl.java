package com.amritha.ars.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amritha.ars.dto.SearchFlightParams;
import com.amritha.ars.entity.Flight;
import com.amritha.ars.entity.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Component
public class FlightDaoImpl implements FlightDao {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Flight> getAllFlights() {
		/*
		ResultSetExtractor<List<Flight>> rse = new ResultSetExtractor<List<Flight>>() {

			@Override
            public List<Flight> extractData(ResultSet rs) throws SQLException {
                List<Flight> flights = new ArrayList<>();
            
                while (rs.next()) {
                	Flight flight = new Flight();
                
                	flight.setId(rs.getLong("id"));
                	flight.setFlightNumber(rs.getString("flight_number"));
                	flight.setFrom(rs.getString("from_location"));
                	flight.setTo(rs.getString("to_location"));
                	flight.setDate(rs.getTimestamp("flight_date"));
                	flight.setDuration(rs.getDouble("duration"));
                	flight.setSeatsAvailable(rs.getInt("seats_available"));
                	flight.setPrice(rs.getDouble("price"));
                	
                    flights.add(flight);
                }
                return flights;
            }
        };
        
		List<Flight> flights = jdbcTemplate.query("select * from flight", rse);
		*/
		
		Query query = em.createQuery("from Flight");
		List<Flight> flights = query.getResultList();
		
		return flights;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> searchFlights(SearchFlightParams params) {
		Query query = em.createQuery("from Flight where from = :from and to = :to and date between :startTime and :endTime");
		query.setParameter("from", params.getFrom());
		query.setParameter("to", params.getTo());
		query.setParameter("startTime", convertToTimestamp(params.getFromDate()));
		query.setParameter("endTime", convertToTimestamp(params.getToDate()));
		
		List<Flight> flights = query.getResultList();
		
		return flights;
	}  

	private Timestamp convertToTimestamp(String dateString) {
		try {
			//"2025-05-11T04:15"
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date date = sdf.parse(dateString);

			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			throw new RuntimeException("Invalid date format", e);
		}
	}

	@Override
	public List<String> getAllLocations() {
		List<Flight> allFlights = getAllFlights();
		Set<String> unqLocations = new HashSet<>();
		
		for (Flight flight : allFlights) {
			unqLocations.add(flight.getFrom());
			unqLocations.add(flight.getTo());
		}
		
		String[] s = new String[unqLocations.size()];
		
		List<String> list = Arrays.asList(unqLocations.toArray(s));
		Collections.sort(list);
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Flight getFlightByFlightNumber(String flightNumber) {
		Query query = em.createQuery("from Flight where flightNumber = :flightNumber");
		query.setParameter("flightNumber", flightNumber);
		
		List<Flight> list = query.getResultList();
		
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketsForUser(Long customerId) {
		Query query = em.createQuery("from Ticket where customerId = :customerId order by bookingTime desc");
		query.setParameter("customerId", customerId);
		
		List<Ticket> list = query.getResultList();
		
		return list;
	}

	@Override
	public Flight getFlightById(Long flightId) {
		return em.find(Flight.class, flightId);
	}
}
