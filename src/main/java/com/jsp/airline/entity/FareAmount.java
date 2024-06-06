package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class FareAmount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fareId;
	private String currency;
	private String  amount;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "fare")
	private Flight flight;
}
