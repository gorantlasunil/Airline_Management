package com.jsp.airline.service;

import java.util.List;

import com.jsp.airline.dto.AirlineInfoDTO;
import com.jsp.airline.dto.BookingInfoDTO;
import com.jsp.airline.dto.CheckInDTO;
import com.jsp.airline.dto.FareAmountDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.dto.FlightInfoDTO;
import com.jsp.airline.dto.FlightInventoryDTO;
import com.jsp.airline.dto.PassengerDto;
import com.jsp.airline.dto.Userdto;
import com.jsp.airline.entity.AirlineInformation;
import com.jsp.airline.entity.BookingInformation;
import com.jsp.airline.entity.CheckIn;
import com.jsp.airline.entity.FareAmount;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.FlightInventory;
import com.jsp.airline.entity.Passengers;
import com.jsp.airline.entity.User;

public interface AdminService {
	int saveUser(Userdto dto);
	int savePassengers(PassengerDto dto);
	int savaDetails(BookingInfoDTO dto);
	int saveAirlineInfo(AirlineInfoDTO dto);
	int saveFare(FareAmountDTO dto);
	int saveFlightInfo(FlightInfoDTO dto);
	int saveFlightInventory(FlightInventoryDTO dto);
	int saveFlightData(FlightDTO dto);
	int saveCheckIn(CheckInDTO dto);
	List<BookingInfoDTO> getAllBookingDetails();
	BookingInfoDTO findById(int bookId);
	AirlineInfoDTO findByAirlineInfoId(int airlineId);	
    CheckInDTO findCheckInbyId(int id);
    FareAmountDTO findfareById(int id);
    FlightDTO getflightbyId(int id);
    FlightInfoDTO getflightInfoByid(int id);
    FlightInventoryDTO getflightInventoryById(int id);
    PassengerDto getPassengersById(int id);
    Userdto getUserById(int Id);
    AirlineInformation updateAirlineDetailsById(int id, AirlineInfoDTO dto);
    FlightInfo updateflightInfoById(int id,FlightInfoDTO dto);
    FareAmount updatefareById(int id,FareAmountDTO dto);
    Flight updateFlightByid(int id,FlightDTO dto);
    FlightInventory updateFlightInventory(int id,FlightInventoryDTO dto);
    Passengers updatePassengersByid(int id,PassengerDto dto);
    User updateUserById(int id,Userdto dto);
    BookingInformation updateBookingInformation(int id,BookingInfoDTO dto);
    CheckIn updateCheckIn (int id,CheckInDTO dto);
    
    AirlineInformation deleteDetailsByid(int id,AirlineInfoDTO dto);
    
    
    
}

