package com.nagarro.flightsearchsystem.util;

import java.util.Comparator;

import com.nagarro.flightsearchsystem.domain.Flight;

public class FareComparator implements Comparator<Flight> {

	public int compare(Flight flight1, Flight flight2) {
		return (int) (flight1.getFare() - flight2.getFare());
	}

}
