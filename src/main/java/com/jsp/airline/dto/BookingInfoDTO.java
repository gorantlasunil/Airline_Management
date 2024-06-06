package com.jsp.airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jsp.airline.entity.BookingInformation;
import com.jsp.airline.entity.Passengers;

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
public class BookingInfoDTO {

	private LocalDate bookingDate;
	private String destination;
	//fare means amount
	private double fare;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String currentCity;
	private String status;	
	
	private BookingInformation bookingInfo;
}
