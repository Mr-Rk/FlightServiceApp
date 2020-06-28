package com.rk.flightservice.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.flightservice.dao.FlightServiceDAO;
import com.rk.flightservice.entity.FlightDetailsDTO;
import com.rk.flightservice.entity.FlightScheduleDTO;
import com.rk.flightservice.exception.InValidTraveDateException;

@Service
public class FlightServiceImpl implements FlightService {
	
	
	private  FlightServiceDAO flightServiceDAO;
	
    @Autowired
	public FlightServiceImpl(FlightServiceDAO flightServiceDAO) {
		super();
		this.flightServiceDAO = flightServiceDAO;
	}
    

	@Override
	public List<FlightDetailsDTO> serachFlightsBasedonSourceDestAndDate(String sourceAirPort,
			String destniationAirPort, LocalDate scheduledDate) {
		
		checkTravelDate(scheduledDate);
		
		List<FlightDetailsDTO> listOfFlights=new ArrayList();;
		
		List<FlightScheduleDTO> listOfScheduledFlights = flightServiceDAO.
				                                        findFlights(sourceAirPort, destniationAirPort, scheduledDate);
		if(!listOfScheduledFlights.isEmpty()) {
			//Iterating over the all elements and retrieving the flight details and storing in the list of flight collection.
			listOfScheduledFlights.forEach(eachScheduledFlight->{
				listOfFlights.add(eachScheduledFlight.getScheduledFlight());
			});
		}
		
      return listOfFlights;
	}

	@Override
	public List<FlightScheduleDTO> getAllFlightScheduleDetails() {
		return flightServiceDAO.findAll();
	}
	
	@Override
	public void saveFlightScheduleDetails() {
		FlightDetailsDTO flightDetailsDTO = new FlightDetailsDTO();
		FlightScheduleDTO scheduleDTO= new FlightScheduleDTO();
		flightDetailsDTO.setAirlineName("Air Asia");
		flightDetailsDTO.setArrivalTime(LocalTime.of(13, 34));
		flightDetailsDTO.setDepartureTime(LocalTime.of(11, 23));
		flightDetailsDTO.setPrice(43566F);
		flightDetailsDTO.setNoOfStops(34);
		flightDetailsDTO.setTravelDuration(2);
		
		scheduleDTO.setSourceAirPort("Delhi");
		scheduleDTO.setDestinationAirPort("Mumbai");
		scheduleDTO.setScheduleDate(LocalDate.of(2020, 06, 24));
		scheduleDTO.setScheduledFlight(flightDetailsDTO);
		
		flightServiceDAO.save(scheduleDTO);
	}
	
	public void checkTravelDate(LocalDate travelDate) {
		if(travelDate.isBefore(LocalDate.now())) {
			throw new InValidTraveDateException("TravelDate should not be past!"); 
		}
	}
	

}
