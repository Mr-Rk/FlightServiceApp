package com.rk.flightservice.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.flightservice.entity.FlightDetailsDTO;
import com.rk.flightservice.entity.FlightScheduleDTO;
import com.rk.flightservice.service.FlightService;

@RestController
@RequestMapping(value="flightservice")
public class FlightServiceRestController {
	

	private FlightService flightService;
	
	@Autowired
	public FlightServiceRestController(FlightService flightService) {
		super();
		this.flightService = flightService;
	}
	
	 @InitBinder
	  public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
	      @Override
	      public void setAsText(String text) throws IllegalArgumentException {
	        setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
	      }
	    });
	 }

	
	@GetMapping(value="/serch_flights",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<FlightDetailsDTO>> searchFlights(@RequestParam(value="source") String sourceAirPort,
			                                                    @RequestParam(value="destination") String destniationAirPort,
			                                                    @RequestParam(value="travelDate",required=true)
			/* @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) */ LocalDate scheduledDate) {
		
		
		  List<FlightDetailsDTO> listOfFlights = flightService.serachFlightsBasedonSourceDestAndDate(sourceAirPort,
				                                                                                     destniationAirPort, 
				                                                                                     scheduledDate);	
		
		return ResponseEntity.status(listOfFlights.isEmpty()?HttpStatus.NO_CONTENT:HttpStatus.OK).body(listOfFlights);
		
	}
	

}
