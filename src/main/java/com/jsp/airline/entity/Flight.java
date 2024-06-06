package com.jsp.airline.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String destination;
	private LocalDate flightDate;
	private String flightNo;
	private String flightName;
	private String currentLocation;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fare_id")
	private FareAmount fare;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flightInfo_Id")
    private FlightInfo flightInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private FlightInventory flightInventory;

}
