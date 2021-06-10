package com.nagarro.flightsearchsystem.view;

import java.util.List;

import com.nagarro.flightsearchsystem.domain.Flight;
import com.nagarro.flightsearchsystem.util.CommonConstants;

public class Output {

	public void displayFlights(final List<Flight> flightList) {
		printDottedLine();
		System.out.println(String.format("%-20s%-25s%-25s%-20s%-20s%-25s %-20s %-20s %-20s", "Flight No",
				"Departure Location ", "Arrival Location", "Valid Till", "Flight Time", "Flight Duration", "Fare",
				"Seat Availability", "Class"));
		printDottedLine();
		displayAllFlightInfo(flightList);
		printDottedLine();
	}

	private void displayAllFlightInfo(List<Flight> flightList) {
		if (flightList.size() == 0) {
			System.out.println("                                                       No Flight Found!");
			return;
		}

		for (Flight flight : flightList) {
			System.out.println(String.format("%-20s%-25s%-25s%-20s%-20s%-25s %-20s %-20s %-20s", flight.getFlightNo(),
					flight.getDepartureLocation(), flight.getArrivalLocation(),
					CommonConstants.DATE_FORMAT.format(flight.getValidTill()), flight.getFlightTime(),
					flight.getFlightDur(), flight.getFare(), flight.getSeatAvailability(), flight.getFlightClass()));
		}

	}

	public void printDottedLine() {
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}
