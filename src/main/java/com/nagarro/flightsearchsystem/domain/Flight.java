package com.nagarro.flightsearchsystem.domain;

import java.util.Date;

import com.nagarro.flightsearchsystem.util.CommonConstants;

public class Flight {

	private String flightNo;
	private String departureLocation;
	private String arrivalLocation;
	private Date validTill;
	private String flightTime;
	private Double flightDur;
	private double fare;
	private String seatAvailability;
	private String flightClass;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public Double getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(Double rowArr) {
		this.flightDur = rowArr;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {

		if (this.getFlightClass().equals("EB")) {
			this.fare = fare + fare * CommonConstants.FARE_TAX;
		} else {
			this.fare = fare;
		}

	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

}
