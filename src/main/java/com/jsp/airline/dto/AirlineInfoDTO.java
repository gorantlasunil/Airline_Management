package com.jsp.airline.dto;

import com.jsp.airline.entity.AirlineInformation;
import com.jsp.airline.entity.FlightInfo;

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
@Builder
@ToString
public class AirlineInfoDTO {
	
	private String airlineName;
	
}
