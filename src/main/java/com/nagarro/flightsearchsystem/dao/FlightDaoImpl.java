package com.nagarro.flightsearchsystem.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.flightsearchsystem.domain.Flight;
import com.nagarro.flightsearchsystem.util.CommonConstants;
import com.opencsv.CSVReader;

public class FlightDaoImpl implements FlightDao {

	public List<Flight> getAllFlights() {
		final List<Flight> flightList = readAllFiles();
		return flightList;
	}

	private List<Flight> readAllFiles() {

		final String path = "C:\\Users\\akhilmahendru\\eclipse-workspace\\flightsearchsystem\\resources\\CSV";
		final List<Flight> flightList = getFlightsFromFiles(path);
		return flightList;

	}

	private List<Flight> getFlightsFromFiles(final String path) {
		final List<Flight> flights = new ArrayList<Flight>();

		final File[] fileList = new File(path).listFiles();

		for (final File file : fileList) {
			readCsvFile(file, flights);

		}

		return flights;
	}

	private void readCsvFile(File file, List<Flight> flights) {

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(file));
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		// Reading the contents of the csv file
		String line[];
		boolean flag = false;
		try {
			while ((line = reader.readNext()) != null) {
				for (int i = 0; i < line.length; i++) {
					String row = line[i];
					String rowArr[] = row.split("\\|");
					if (flag == true)
						addFlightInfo(rowArr, flights);
					else
						flag = true;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addFlightInfo(String[] rowArr, List<Flight> flights) {

		Flight flight = new Flight();
		flight.setFlightNo(rowArr[0]);
		flight.setDepartureLocation(rowArr[1]);
		flight.setArrivalLocation(rowArr[2]);
		try {
			flight.setValidTill(CommonConstants.DATE_FORMAT.parse(rowArr[3]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		flight.setFlightTime(rowArr[4]);
		flight.setFlightDur(Double.parseDouble(rowArr[5]));
		flight.setSeatAvailability(rowArr[rowArr.length - 2]);
		flight.setFlightClass(rowArr[rowArr.length - 1]);
		flight.setFare(Double.parseDouble(rowArr[6]));
		flights.add(flight);

	}
}
