package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class CheckIn {
	 @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
		private int checkinId;
		private int seatNo;
		private int gateNo;
		
		@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="checkin")
		private Passengers passengers;
}
