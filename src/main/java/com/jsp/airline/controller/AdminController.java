package com.jsp.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.jsp.airline.service.AdminService;
@RestController
@RequestMapping("/airline/v1")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/userInserted")
	public ResponseEntity<String> saveDate(@RequestBody Userdto dto)
	{
//		int saveUser = service.saveUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("user Data inserted: "+service.saveUser(dto));
		
	}
	@PostMapping("/saveBooking")
	public ResponseEntity<String> saveDetails(@RequestBody BookingInfoDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("id inserted: "+service.savaDetails(dto));
		
		}
	@PostMapping("/passengerinsert")
	public ResponseEntity<String> addpassenger(@RequestBody PassengerDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("passengerID :"+service.savePassengers(dto));
	}

	@GetMapping("/getbookingDetails/{bookid}")
	public ResponseEntity<String> getDetailsById(@PathVariable("bookid") int bookInId)
	{
	 return ResponseEntity.status(HttpStatus.FOUND).body("BookingDetails: "+service.findById(bookInId));	
	}
	@PostMapping("/saveDetailsAirline")
	public ResponseEntity<String> saveAirline(@RequestBody AirlineInfoDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("Airline inserted: "+service.saveAirlineInfo(dto));
	}
	@PostMapping("/saveFare")
	public ResponseEntity<String> saveFare(@RequestBody FareAmountDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("fare Inserted Id: "+service.saveFare(dto));
	}
	
	@PostMapping("/saveFlightInfo")
	public ResponseEntity<String> saveFlightInfo(@RequestBody FlightInfoDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("flightInfo isinserted: "+service.saveFlightInfo(dto));
	}
	
	@PostMapping("/saveInventory")
	public ResponseEntity<String> saveFlightInventory(@RequestBody FlightInventoryDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("inventoryId inserted: "+service.saveFlightInventory(dto));
	}
	@PostMapping("/saveFlight")
	public ResponseEntity<String> saveFlight(@RequestBody FlightDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("FlightId inserted: "+service.saveFlightData(dto));
	}
	
	@PostMapping("/saveCheckIn")
	public ResponseEntity<String> saveCheckIn(@RequestBody CheckInDTO dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("ChckinId inserted :"+service.saveCheckIn(dto));
	}
	
	//operation exclude of insert
	@GetMapping("/getallbookingDetails")
	public ResponseEntity<String> getAllBookingDetails(){
		
		return ResponseEntity.status(HttpStatus.FOUND).body("fetchAllDetails: "+service.getAllBookingDetails());
	}

	@GetMapping("/getairline/{aId}")
	public ResponseEntity<String> getDetailsByAirlineId(@PathVariable("aId") int id)
	{
		if(service.findByAirlineInfoId(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.findByAirlineInfoId(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
		
	}
	@GetMapping("/getcheckin/{cId}")
	public ResponseEntity<String> getCheckinDetailsBycheckInId(@PathVariable("cId") int id)
	{
		if(service.findCheckInbyId(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.findCheckInbyId(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
	@GetMapping("/getfare/{fId}")
	public ResponseEntity<String> getfareDetailsById(@PathVariable("fId") int id)
	{
		if(service.findfareById(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.findfareById(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
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
	@GetMapping("/getflightInfo/{fId}")
	public ResponseEntity<String> getflightInfoDetailsById(@PathVariable("fId") int id)
	{
		if(service.getflightInfoByid(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.getflightInfoByid(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
	
	@GetMapping("/getflightInventory/{fId}")
	public ResponseEntity<String> getflightInventoyDetailsById(@PathVariable("fId") int id)
	{
		if(service.getflightInventoryById(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.getflightInventoryById(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
	@GetMapping("/getPassenger/{pId}")
	public ResponseEntity<String> gePassengersByid(@PathVariable("pId") int id)
	{
		if(service.getPassengersById(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.getPassengersById(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
	@GetMapping("/getUser/{uId}")
	public ResponseEntity<String> getuserDetailsById(@PathVariable("uId") int id)
	{
		if(service.getUserById(id)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body("getDetails :"+service.getUserById(id));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invaild data:");
		}
	}
	@PutMapping("/updateAirline/{aid}")
	public ResponseEntity<AirlineInformation> updateAirline(@PathVariable("aid") int id ,@RequestBody AirlineInfoDTO dto) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateAirlineDetailsById(id,dto));
	}
	
	@PutMapping("/updateFlightInfo/{fid}")
	public ResponseEntity<FlightInfo> updateFlightInfoDetails(@PathVariable("fid") int id,@RequestBody FlightInfoDTO dto)
	{
		if(service.updateflightInfoById(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateflightInfoById(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	@PutMapping("/updateFare/{fid}")
	public ResponseEntity<FareAmount> updateFareDetails(@PathVariable("fid") int id,@RequestBody FareAmountDTO dto)
	{
		if(service.updatefareById(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updatefareById(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
		
	@PutMapping("/updateFlight/{id}")
	public ResponseEntity<Flight> updateFlightDetails(@PathVariable("id") int id,@RequestBody FlightDTO dto)
	{
		if(service.updateFlightByid(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateFlightByid(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	
	@PutMapping("/updateFlightInventory/{id}")
	public ResponseEntity<FlightInventory> updateFlightInventoryDetails(@PathVariable("id") int id,@RequestBody FlightInventoryDTO dto)
	{
		if(service.updateFlightInventory(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateFlightInventory(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	
	@PutMapping("/updatepassengers/{id}")
	public ResponseEntity<Passengers> updatepassengersDetails(@PathVariable("id") int id,@RequestBody PassengerDto dto)
	{
		if(service.updatePassengersByid(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updatePassengersByid(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable("id") int id,@RequestBody Userdto dto)
	{
		if(service.updateUserById(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateUserById(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	@PutMapping("/updateBookingInfo/{id}")
	public ResponseEntity<BookingInformation> updateBookingInfoDetails(@PathVariable("id") int id,@RequestBody BookingInfoDTO dto)
	{
		if(service.updateBookingInformation(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateBookingInformation(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}
	@PutMapping("/updateCheckIn/{id}")
	public ResponseEntity<CheckIn> updateCheckInDetails(@PathVariable("id") int id,@RequestBody CheckInDTO dto)
	{
		if(service.updateCheckIn(id, dto)!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.updateCheckIn(id, dto));
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
