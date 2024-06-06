package com.jsp.airline.dto;

import com.jsp.airline.entity.Flight;
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
@Builder
@ToString
public class FlightInventoryDTO {
	
	private String count;

}
