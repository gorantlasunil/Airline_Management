package com.jsp.airline.dto;

import java.time.LocalDate;

import com.jsp.airline.entity.AirlineInformation;
import com.jsp.airline.entity.FareAmount;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.FlightInventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class FlightDTO {

	private String destination;
	private LocalDate flightDate;
	private String flightNo;
	private String flightName;
	private String currentLocation;
	
	private FareAmount fare;
	private FlightInfo flightInfo;
	private FlightInventory inventory;

}
