package com.nagarro.flightsearchsystem.controller;

import java.util.List;

import com.nagarro.flightsearchsystem.domain.Flight;
import com.nagarro.flightsearchsystem.dto.FlightSearchDto;
import com.nagarro.flightsearchsystem.service.FlightSearchService;
import com.nagarro.flightsearchsystem.service.FlightSearchServiceImpl;
import com.nagarro.flightsearchsystem.view.Input;
import com.nagarro.flightsearchsystem.view.Output;

public class Application {

	public static void main(String[] args) {
		final Input input = new Input();
		final FlightSearchDto flightSearchDto = input.takeInput();

		final FlightSearchService flightSearchService = new FlightSearchServiceImpl();
		final List<Flight> flightList = flightSearchService.searchFlights(flightSearchDto);

		final Output output = new Output();
		output.displayFlights(flightList);
	}
}
