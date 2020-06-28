package com.rk.flightservice.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rk.flightservice.entity.FlightScheduleDTO;

@Repository
public interface FlightServiceDAO extends JpaRepository<FlightScheduleDTO,Long> {
	
	@Query(value="select f FROM FlightScheduleDTO f where f.sourceAirPort = ?1 and f.destinationAirPort= ?2 and f.scheduleDate = ?3 ")
	public List<FlightScheduleDTO> findFlights(String sourceAirPort,String destniationAirPort,LocalDate scheduledDate);

}
