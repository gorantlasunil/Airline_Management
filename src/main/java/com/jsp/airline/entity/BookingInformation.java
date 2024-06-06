package com.jsp.airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jsp.airline.dto.PassengerDto;

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
public class BookingInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookinId;
	private LocalDate bookingDate;
	private String destination;
	//fare means amount
	private double fare;
	private LocalDate flightDate;
	private String flightNumber;
	private String status;
	private LocalTime flightTime;
	private String currentCity;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "bookinginfo")
	private List<Passengers> passengers; 
}
