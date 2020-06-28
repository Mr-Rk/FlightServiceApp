package com.rk.flightservice.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class FlightDetailsDTO {
	
	@Id
	@SequenceGenerator(name="flightNumGenerator",sequenceName="flight_num_seq")
	@GeneratedValue(generator="flightNumGenerator",strategy=GenerationType.SEQUENCE)
	@Column(name="flight_num")
	private Long flightNum;
	
	@Column(name="airline_name")
    private String airlineName;
	
	@Column(name="departue_time")
    private LocalTime departureTime;
	
	@Column(name="arrival_time")
    private LocalTime arrivalTime;
	
	@Column(name="travel_duration")
	private Integer travelDuration;
	
	@Column(name="price")
    private Float price;
	
	@Column(name="no_of_stops")
    private Integer noOfStops;
    
    
	public Long getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(Long flightNum) {
		this.flightNum = flightNum;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public Integer getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(Integer travelDuration) {
		this.travelDuration = travelDuration;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getNoOfStops() {
		return noOfStops;
	}
	public void setNoOfStops(Integer noOfStops) {
		this.noOfStops = noOfStops;
	}
	
	
	@Override
	public String toString() {
		return "FlightDetailsDTO [flightNum=" + flightNum + ", airlineName=" + airlineName + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", price=" + price + ", noOfStops=" + noOfStops
				+ "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlineName == null) ? 0 : airlineName.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((flightNum == null) ? 0 : flightNum.hashCode());
		result = prime * result + ((noOfStops == null) ? 0 : noOfStops.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		FlightDetailsDTO other = (FlightDetailsDTO) obj;
		if (airlineName == null) {
			if (other.airlineName != null)
				return false;
		} else if (!airlineName.equals(other.airlineName))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (flightNum == null) {
			if (other.flightNum != null)
				return false;
		} else if (!flightNum.equals(other.flightNum))
			return false;
		if (noOfStops == null) {
			if (other.noOfStops != null)
				return false;
		} else if (!noOfStops.equals(other.noOfStops))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}
