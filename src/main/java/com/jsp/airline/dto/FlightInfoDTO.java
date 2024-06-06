package com.jsp.airline.dto;

import java.time.LocalTime;


import com.jsp.airline.entity.AirlineInformation;


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
public class FlightInfoDTO {
	private String flightNo;
	private String flightType;
	private LocalTime flightTime;
	
	private AirlineInfoDTO airlineInfo;

}
