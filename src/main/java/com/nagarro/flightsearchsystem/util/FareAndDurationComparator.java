package com.nagarro.flightsearchsystem.util;

import java.util.Comparator;

import com.nagarro.flightsearchsystem.domain.Flight;

public class FareAndDurationComparator implements Comparator<Flight> {

	public int compare(Flight flight1, Flight flight2) {
		int x = (int) (flight1.getFare() - flight2.getFare());
		if (x == 0) {
			if ((flight1.getFlightDur() - flight2.getFlightDur()) > 0) {
				x = 1;
			}
		}
		return x;
	}
}
