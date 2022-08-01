package com.fis.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.fis.dao.InMemoryFlightDao;
import com.fis.entity.Flight;

//Assumption: We are working for Air India and developing a REST API for searching Flights
@Path("/flight")
public class FlightResource {

	//http://localhost:8080/JAX-RS-Intro/api/flight/search?from=Mumbai&to=Delhi
	@GET
	@Path("/search")
	public List<Flight> getFlights(@QueryParam("from") String from, @QueryParam("to") String to) {
		InMemoryFlightDao dao = new InMemoryFlightDao();
		List<Flight> list = dao.getAvailableFlights(from, to);
		return list;
	}
}
