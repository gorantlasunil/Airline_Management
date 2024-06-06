package com.jsp.airline.service;

import java.time.LocalDate;
import java.util.List;

import com.jsp.airline.dto.FlightDTO;

public interface FlightService {
	int saveFlightData(FlightDTO dto);
	FlightDTO getflightbyId(int id);

}
