package com.nagarro.flightsearchsystem.service;

import java.util.List;

import com.nagarro.flightsearchsystem.domain.Flight;
import com.nagarro.flightsearchsystem.dto.FlightSearchDto;

public interface FlightSearchService {

	public List<Flight> searchFlights(final FlightSearchDto flightSearchDto);
}
