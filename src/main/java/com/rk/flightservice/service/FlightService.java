package com.rk.flightservice.service;

import java.time.LocalDate;
import java.util.List;

import com.rk.flightservice.entity.FlightDetailsDTO;
import com.rk.flightservice.entity.FlightScheduleDTO;

public interface FlightService {
	
	public List<FlightDetailsDTO> serachFlightsBasedonSourceDestAndDate(String sourceAirPort,String destniationAirPort,LocalDate scheduledDate);
	
	public List<FlightScheduleDTO> getAllFlightScheduleDetails();
	
	public void saveFlightScheduleDetails();

}
