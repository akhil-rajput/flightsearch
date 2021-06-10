package com.nagarro.flightsearchsystem.util;

import java.text.ParseException;
import java.util.Date;

import com.nagarro.flightsearchsystem.exception.InvalidInputException;

public class InputValidator {

	public static Date getValidatedDate(String date) throws InvalidInputException {
		Date validTill = null;
		try {
			validTill = CommonConstants.DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			throw new InvalidInputException("Date not in appropriate(dd-MM-yyyy) format, Enter Again:");
		}
		return validTill;

	}

	public static String getValidatedDepartureLocation(String departureLocation) throws InvalidInputException {

		if (departureLocation.length() == 3) {
			for (int i = 0; i < departureLocation.length(); i++) {
				if (departureLocation.charAt(i) >= 65 && departureLocation.charAt(i) < 91) {

				} else {
					throw new InvalidInputException("Enter Location Code in English Alphabets! ");
				}
			}

		} else {
			throw new InvalidInputException("Enter Correct Location Code Of Length 3");
		}
		return departureLocation;
	}

	public static String getValidatedArrivalLocation(String arrivalLocation) throws InvalidInputException {

		if (arrivalLocation.length() == 3) {
			for (int i = 0; i < arrivalLocation.length(); i++) {
				if (arrivalLocation.charAt(i) >= 65 && arrivalLocation.charAt(i) < 91) {

				} else {
					throw new InvalidInputException("Enter Location Code in English Alphabets! ");
				}
			}

		} else {
			throw new InvalidInputException("Enter Correct Location Code Of Length 3");
		}
		return arrivalLocation;
	}

	public static String getValidatedFlightClass(String flightClass) throws InvalidInputException {

		String validatedFlightClass;
		if (flightClass.equals("E") || flightClass.equals("EB")) {
			validatedFlightClass = flightClass;
		} else {
			throw new InvalidInputException("Enter flight class in correct format: (E or EB)");
		}

		return validatedFlightClass;
	}

	public static String getValidatedOutputPreference(String outputPreference) throws InvalidInputException {
		String validatedOutputPreference;
		if (outputPreference.equals("1") || outputPreference.equals("2")) {
			validatedOutputPreference = outputPreference;
		} else {
			throw new InvalidInputException("Enter output preference in correct format: (1 or 2)");
		}
		return validatedOutputPreference;
	}

}
