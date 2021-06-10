package com.nagarro.flightsearchsystem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.nagarro.flightsearchsystem.dao.FlightDao;
import com.nagarro.flightsearchsystem.dao.FlightDaoImpl;
import com.nagarro.flightsearchsystem.domain.Flight;
import com.nagarro.flightsearchsystem.dto.FlightSearchDto;
import com.nagarro.flightsearchsystem.util.FareAndDurationComparator;
import com.nagarro.flightsearchsystem.util.FareComparator;

public class FlightSearchServiceImpl implements FlightSearchService {

	public List<Flight> searchFlights(FlightSearchDto flightSearchDto) {

		final FlightDao flightDao = new FlightDaoImpl();
		final List<Flight> flightList = flightDao.getAllFlights();
		final List<Flight> matchingFlightList = findFlights(flightList, flightSearchDto);
		sortFlights(flightSearchDto, matchingFlightList);
		return matchingFlightList;
	}

	private List<Flight> findFlights(List<Flight> flightList, FlightSearchDto flightSearchDto) {
		List<Flight> matchingFlightList = new ArrayList<Flight>();

		for (Flight flight : flightList) {

			if (flightSearchDto.getDepartureLocation().equals(flight.getDepartureLocation())
					&& flightSearchDto.getArrivalLocation().equals(flight.getArrivalLocation())
					&& flightSearchDto.getFlightClass().equals(flight.getFlightClass())
					&& isValidFlightDate(flight.getValidTill(), flightSearchDto)) {
				matchingFlightList.add(flight);

			}
		}
		return matchingFlightList;

	}

	private boolean isValidFlightDate(Date valildTillDate, FlightSearchDto flightSearchDto) {

		Date flightDate = flightSearchDto.getFlightDate();
		if (flightDate.compareTo(valildTillDate) == 0) {

			return true;
		} else if (flightDate.compareTo(valildTillDate) < 0) {
			return true;
		}

		return false;
	}

	private void sortFlights(FlightSearchDto flightSearchDto, List<Flight> flightList) {

		Comparator<Flight> comparator = null;
		if (flightSearchDto.getOutputPreference().equals("1")) {
			comparator = new FareComparator();

		} else if (flightSearchDto.getOutputPreference().equals("2")) {

			comparator = new FareAndDurationComparator();
		}
		Collections.sort(flightList, comparator);

	}

}
