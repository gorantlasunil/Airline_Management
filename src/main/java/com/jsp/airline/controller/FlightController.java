package com.jsp.airline.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.service.FlightService;
@RestController
@RequestMapping("/flightAirline/v1")
public class FlightController {

	@Autowired
	private FlightService service;
	@PostMapping("/saveFlight")
	public ResponseEntity<String> saveFlight(@RequestBody FlightDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("FlightId inserted: "+service.saveFlightData(dto));
	}
	@GetMapping("/getflight/{fId}")
	public ResponseEntity<String> getflightDetailsById(@PathVariable("fId") int id)
	{
		if(service.getflightbyId(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.getflightbyId(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
}
