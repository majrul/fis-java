package com.fis.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fis.entity.Flight;

public class InMemoryFlightDao {

	private static List<Flight> listOfFlights;
	
	static {
		listOfFlights = new ArrayList<>();
		listOfFlights.add(new Flight(101, "Air India", "Mumbai", "Delhi", LocalTime.of(11, 30), LocalTime.of(13, 45)));
		listOfFlights.add(new Flight(102, "Spicejet", "Delhi", "Bangalore", LocalTime.of(17, 30), LocalTime.of(19, 10)));
		listOfFlights.add(new Flight(103, "Air India", "Mumbai", "Chennai", LocalTime.of(8, 30), LocalTime.of(10, 30)));
		listOfFlights.add(new Flight(104, "Indigo", "Chennai", "Bangalore", LocalTime.of(9, 30), LocalTime.of(11, 30)));
		listOfFlights.add(new Flight(105, "Air India", "Mumbai", "Delhi", LocalTime.of(13, 30), LocalTime.of(15, 45)));
		listOfFlights.add(new Flight(106, "Spicejet", "Delhi", "Bangalore", LocalTime.of(21, 30), LocalTime.of(23, 10)));
		listOfFlights.add(new Flight(107, "Air India", "Mumbai", "Chennai", LocalTime.of(10, 30), LocalTime.of(12, 30)));
		listOfFlights.add(new Flight(108, "Indigo", "Chennai", "Bangalore", LocalTime.of(11, 30), LocalTime.of(13, 30)));
		listOfFlights.add(new Flight(109, "Vistara", "Mumbai", "Delhi", LocalTime.of(13, 30), LocalTime.of(15, 45)));
		listOfFlights.add(new Flight(110, "Go Air", "Delhi", "Bangalore", LocalTime.of(18, 30), LocalTime.of(20, 10)));
		listOfFlights.add(new Flight(111, "Air India", "Mumbai", "Chennai", LocalTime.of(9, 30), LocalTime.of(11, 30)));
		listOfFlights.add(new Flight(112, "Vistara", "Chennai", "Bangalore", LocalTime.of(10, 30), LocalTime.of(12, 30)));
	}
	
	public void add(Flight flight) {
		listOfFlights.add(flight);
	}
	
	public List<Flight> getAll() {
		return listOfFlights;
	}
	
	public List<Flight> getAvailableFlights(String from, String to) {
		/*List<Flight> list = new ArrayList<>();
		for(Flight flight : listOfFlights)
			if(flight.getSource().equals(from) && flight.getDestination().equals(to))
				list.add(flight);
		return list;*/
		return listOfFlights
				.stream()
				.filter(flight -> flight.getSource().equals(from) && flight.getDestination().equals(to))
				.collect(Collectors.toList());
	}

	public Flight getFlight(int flightNo) {
		for(Flight flight : listOfFlights)
			if(flight.getFlightNo() == flightNo)
				return flight;
		return null; //rather we should throw an exception
	}

}
