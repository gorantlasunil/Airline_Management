package com.jsp.airline.dto;

import com.jsp.airline.entity.BookingInformation;
import com.jsp.airline.entity.CheckIn;
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
@ToString
@Builder
public class PassengerDto {
	private String pEmail;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	
	
	private CheckIn checkin;
	private BookingInformation bookingInform;
}
