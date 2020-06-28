package com.rk.flightservice.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="scheduled_flight")
public class FlightScheduleDTO {
	
	@SequenceGenerator(name="scheduleIdGenerator",allocationSize=1,
			           initialValue=1000,sequenceName="flight_scheduled_id")
	@GeneratedValue(generator="scheduleIdGenerator",strategy=GenerationType.SEQUENCE)
	@Id
	private Long scheduleId;
	
	@Column(name="schedule_date")
	//@DateTimeFormat(iso=ISO.DATE)
	private LocalDate scheduleDate;
	
	@Column(name="destination")
	private String destinationAirPort;
	
	@Column(name="source")
	private String sourceAirPort;
	
	@OneToOne(targetEntity=FlightDetailsDTO.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="scheduled_flight_id",referencedColumnName="flight_num")
	private FlightDetailsDTO scheduledFlight;
	
	
	public Long getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDate getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(LocalDate scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getDestinationAirPort() {
		return destinationAirPort;
	}
	public void setDestinationAirPort(String destinationAirPort) {
		this.destinationAirPort = destinationAirPort;
	}
	public String getSourceAirPort() {
		return sourceAirPort;
	}
	public void setSourceAirPort(String sourceAirPort) {
		this.sourceAirPort = sourceAirPort;
	}
	public FlightDetailsDTO getScheduledFlight() {
		return scheduledFlight;
	}
	public void setScheduledFlight(FlightDetailsDTO scheduledFlight) {
		this.scheduledFlight = scheduledFlight;
	}
	@Override
	public String toString() {
		return "FlightScheduleDTO [scheduleId=" + scheduleId + ", scheduleDate=" + scheduleDate
				+ ", destinationAirPort=" + destinationAirPort + ", sourceAirPort=" + sourceAirPort
				+ ", scheduledFlight=" + scheduledFlight + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinationAirPort == null) ? 0 : destinationAirPort.hashCode());
		result = prime * result + ((scheduleDate == null) ? 0 : scheduleDate.hashCode());
		result = prime * result + ((scheduleId == null) ? 0 : scheduleId.hashCode());
		result = prime * result + ((scheduledFlight == null) ? 0 : scheduledFlight.hashCode());
		result = prime * result + ((sourceAirPort == null) ? 0 : sourceAirPort.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightScheduleDTO other = (FlightScheduleDTO) obj;
		if (destinationAirPort == null) {
			if (other.destinationAirPort != null)
				return false;
		} else if (!destinationAirPort.equals(other.destinationAirPort))
			return false;
		if (scheduleDate == null) {
			if (other.scheduleDate != null)
				return false;
		} else if (!scheduleDate.equals(other.scheduleDate))
			return false;
		if (scheduleId == null) {
			if (other.scheduleId != null)
				return false;
		} else if (!scheduleId.equals(other.scheduleId))
			return false;
		if (scheduledFlight == null) {
			if (other.scheduledFlight != null)
				return false;
		} else if (!scheduledFlight.equals(other.scheduledFlight))
			return false;
		if (sourceAirPort == null) {
			if (other.sourceAirPort != null)
				return false;
		} else if (!sourceAirPort.equals(other.sourceAirPort))
			return false;
		return true;
	}
	
	

}
