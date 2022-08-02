package com.fis.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fis.dao.InMemoryFlightDao;
import com.fis.entity.Flight;

//Assumption: We are working for Air India and developing a REST API for searching Flights
@Path("/flight")
public class FlightResource {

	private InMemoryFlightDao dao = new InMemoryFlightDao();

	//http://localhost:8080/JAX-RS-Intro/api/flight/search?from=Mumbai&to=Delhi
	@GET
	@Path("/search")
	public List<Flight> getFlights(@QueryParam("from") String from, @QueryParam("to") String to) {
		List<Flight> list = dao.getAvailableFlights(from, to);
		return list;
	}
	
	//Write another version of the above code and use pathparam instead of queryparam
	//http://localhost:8080/JAX-RS-Intro/api/flight/search/v2/Mumbai/Delhi
	@GET
	@Path("/search/v2/{from}/{to}")
	public List<Flight> getFlightsV2(@PathParam("from") String from, @PathParam("to") String to) {
		List<Flight> list = dao.getAvailableFlights(from, to);
		return list;
	}	
	
	//http://localhost:8080/JAX-RS-Intro/api/flight/101
	@GET
	@Path("/{flightNo}")
	//@Produces("application/xml")
	public Flight getFlight(@PathParam("flightNo") int flightNo) {
		Flight flight = dao.getFlight(flightNo);
		return flight;
	}
	
	@GET
	@Path("/all")
	public List<Flight> getAll() {
		return dao.getAll();
	}
	
	@POST
	@Path("/add")
	//@Consumes("application/json")
	//@Produces("text/plain")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(Flight flight) {
		dao.add(flight);
		
		return "Flight added successfully..";
	}
}
