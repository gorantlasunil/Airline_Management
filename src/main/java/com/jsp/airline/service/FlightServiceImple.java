package com.jsp.airline.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.AirlineInfoDTO;
import com.jsp.airline.dto.FareAmountDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.dto.FlightInfoDTO;
import com.jsp.airline.dto.FlightInventoryDTO;
import com.jsp.airline.entity.AirlineInformation;
import com.jsp.airline.entity.FareAmount;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.FlightInventory;
import com.jsp.airline.repository.FlightRepository;

@Service
public class FlightServiceImple implements FlightService {
	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public int saveFlightData(FlightDTO dto) {
		Flight saveFlight = flightRepo.save(Flight.builder().destination(dto.getDestination()).currentLocation(dto.getCurrentLocation()).flightDate(dto.getFlightDate())
				.flightName(dto.getFlightName()).flightNo(dto.getFlightNo())
				 .fare(FareAmount.builder().currency(dto.getFare().getCurrency()).amount(dto.getFare().getAmount()).build())
				 .flightInfo(FlightInfo.builder().flightNo(dto.getFlightInfo().getFlightNo()).flightTime(dto.getFlightInfo().getFlightTime()).flightType(dto.getFlightInfo().getFlightType()).build())
				 .flightInventory(FlightInventory.builder().count(dto.getInventory().getCount()).build())
				 .build());
		return saveFlight.getFlightId();
	}
	@Override
	public FlightDTO getflightbyId(int id) {
		Optional<Flight> findById = flightRepo.findById(id);
			
		if(findById.isPresent())
		{
			Flight flight = findById.get();
			FareAmount fare = new FareAmount();
			FlightDTO build = FlightDTO.builder().destination(flight.getDestination()).currentLocation(flight.getCurrentLocation()).flightDate(flight.getFlightDate())
			.flightName(flight.getFlightName()).flightNo(flight.getFlightNo())
			.fare(FareAmount.builder().currency(flight.getFare().getCurrency()).amount(flight.getFare().getAmount()) .build())
			.flightInfo(FlightInfo.builder().flightNo(flight.getFlightInfo().getFlightNo()).flightTime(flight.getFlightInfo().getFlightTime())
					.flightType(flight.getFlightInfo().getFlightType())
					.build())
			 .inventory(FlightInventory.builder().count(flight.getFlightInventory().getCount()).build())
			.build();
			return build;
		}
		else
		return null;
	}

}
	
	
	
	
	
	
	
