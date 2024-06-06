package com.jsp.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class AirlineInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airlineId;
	private String airlineName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "airlineinform")
	private List<FlightInfo> flightInfo;
}
