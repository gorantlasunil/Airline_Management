package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class FlightInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inventoryId;
	private String count;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "flightInventory")
	private Flight flight;
	
}
