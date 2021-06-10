package com.nagarro.flightsearchsystem.view;

import java.util.Date;
import java.util.Scanner;
import com.nagarro.flightsearchsystem.dto.FlightSearchDto;
import com.nagarro.flightsearchsystem.exception.InvalidInputException;
import com.nagarro.flightsearchsystem.util.InputValidator;

public class Input {

	Scanner scanner = new Scanner(System.in);

	public FlightSearchDto takeInput() {
		System.out.println("Enter Flight details: ");
		final FlightSearchDto flightSearchDto = takeFlightDetail();
		return flightSearchDto;
	}

	private FlightSearchDto takeFlightDetail() {
		final FlightSearchDto flightSearchDto = new FlightSearchDto();
		flightSearchDto.setDepartureLocation(getDepartureLocation());
		flightSearchDto.setArrivalLocation(getArrivalLocation());
		flightSearchDto.setFlightDate(getFlightDate());
		flightSearchDto.setFlightClass(getFlightClass());
		flightSearchDto.setOutputPreference(getOutputPreference());
		return flightSearchDto;
	}

	private String getFlightClass() {
		System.out.println("Enter Flight Class : ");
		String flightClass = null;
		boolean isValidInput = false;
		do {
			try {
				flightClass = InputValidator.getValidatedFlightClass(scanner.next().toUpperCase());
				isValidInput = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);

		return flightClass;
	}

	private String getOutputPreference() {

		System.out.print("Output preference(Sort by Fare/Sort by both Fare and Duration)):\n(Enter 1/2): ");
		String outputPreference = null;
		boolean isValidInput = false;
		do {
			try {
				outputPreference = InputValidator.getValidatedOutputPreference(scanner.next());
				isValidInput = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);
		return outputPreference;

	}

	private Date getFlightDate() {
		System.out.println("Enter Flight Date : ");
		Date flightDate = null;
		boolean isValidInput = false;
		do {
			try {
				flightDate = InputValidator.getValidatedDate(scanner.next());
				isValidInput = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);
		return flightDate;

	}

	private String getArrivalLocation() {
		System.out.println("Enter Arrival Location : ");
		String arrivalLocation = null;
		boolean isValidInput = false;
		do {
			try {
				arrivalLocation = InputValidator.getValidatedArrivalLocation(scanner.next().toUpperCase());
				isValidInput = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);

		return arrivalLocation;
	}

	private String getDepartureLocation() {
		System.out.println("Enter Departure Location : ");
		String departureLocation = null;
		boolean isValidInput = false;
		do {
			try {
				departureLocation = InputValidator.getValidatedDepartureLocation(scanner.next().toUpperCase());
				isValidInput = true;
			} catch (InvalidInputException invalidInputException) {
				System.err.println(invalidInputException.getMessage());
			}
		} while (!isValidInput);

		return departureLocation;
	}

}
