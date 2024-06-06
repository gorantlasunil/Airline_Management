package com.jsp.airline.dto;

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
@Builder
@ToString
public class CheckInDTO {
	private int seatNo;
	private int gateNo;
}
