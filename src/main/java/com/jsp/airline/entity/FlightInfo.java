package com.jsp.airline.entity;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class FlightInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightInfoId;
	private String flightNo;
	private String flightType;
	private LocalTime flightTime;
	
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="airline_id")
	private AirlineInformation airlineinform;
}
