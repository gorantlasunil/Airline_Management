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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Passengers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String pEmail;
	private String firstName;
	private String lastName;
	private String Gender;
	private String mobileNumber;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="checkin_id")
	private CheckIn checkin;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="bookin_id")
	private BookingInformation bookinginfo;
}
