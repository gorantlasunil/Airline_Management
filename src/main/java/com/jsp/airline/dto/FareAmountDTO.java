package com.jsp.airline.dto;

import com.jsp.airline.entity.FareAmount;
import com.jsp.airline.entity.Flight;

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
public class FareAmountDTO {
	
	private String currency;
	private String  amount;
	
	private FareAmount fareAmount;
}
