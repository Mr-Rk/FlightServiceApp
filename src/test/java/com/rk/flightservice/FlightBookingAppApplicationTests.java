package com.rk.flightservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rk.flightservice.controller.FlightServiceRestController;
import com.rk.flightservice.dao.FlightServiceDAO;
import com.rk.flightservice.entity.FlightDetailsDTO;
import com.rk.flightservice.entity.FlightScheduleDTO;
import com.rk.flightservice.service.FlightService;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightServiceRestController.class)
public class FlightBookingAppApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FlightService flightService;
	
	@MockBean
	private FlightServiceDAO flightDAO;
	
	@Before
	public void loadScheduledFlightData() {
		
		FlightDetailsDTO flightDetailsDTO = new FlightDetailsDTO();
		FlightScheduleDTO scheduleDTO= new FlightScheduleDTO();
		flightDetailsDTO.setAirlineName("Air Asia");
		flightDetailsDTO.setArrivalTime(LocalTime.of(13, 34));
		flightDetailsDTO.setDepartureTime(LocalTime.of(11, 23));
		flightDetailsDTO.setPrice(43566F);
		flightDetailsDTO.setNoOfStops(34);
		flightDetailsDTO.setTravelDuration(2);
		
		scheduleDTO.setSourceAirPort("Mumbai");
		scheduleDTO.setDestinationAirPort("Delhi");
		scheduleDTO.setScheduleDate(LocalDate.of(2020, 06, 24));
		scheduleDTO.setScheduledFlight(flightDetailsDTO);
		
		flightDAO.save(scheduleDTO);
		
	}
	
	@Test
	public void testGetAllScheduledFlights() throws Exception {
		
	    mvc.perform(get("http://localhost:3387/flightservice/serch_flights?source=Mumbai&destination=Delhi&travelDate=2020-06-24").
	    		  	contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	
	

}
