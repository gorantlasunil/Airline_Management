package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.jsp.airline.repository.AirlineInfoRepository;
import com.jsp.airline.repository.AmountRepository;
import com.jsp.airline.repository.BookinINfoRepository;
import com.jsp.airline.repository.CheckInRepository;
import com.jsp.airline.repository.FlightInfoRepository;
import com.jsp.airline.repository.FlightInventoryRepository;
import com.jsp.airline.repository.FlightRepository;
import com.jsp.airline.repository.Passengerrepository;
import com.jsp.airline.repository.UserRepository;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	private UserRepository userRepository;
	
	 @Autowired
	private Passengerrepository passRepository;
	
	 @Autowired
		private BookinINfoRepository bookinginforepository;
	 
	 @Autowired
	 private AirlineInfoRepository airlineRepository;
	 
	@Override
	public int saveUser(Userdto dto) {

		User uinsert = userRepository.save(User.builder()
				     .firstName(dto.getFirstName()).lastName(dto.getFirstName()).mobileNo(dto.getMobileNo())
				     .gender(dto.getGender()).userName(dto.getUserName()).password(dto.getPassword())
				.build());
		return uinsert.getUseId();
	}
	@Override
	public int savePassengers(PassengerDto dto) {
		Passengers save = passRepository.save(Passengers.builder()
				.firstName(dto.getFirstName()).lastName(dto.getLastName()).Gender(dto.getGender()).mobileNumber(dto.getMobileNumber())
				.pEmail(dto.getPEmail())
				.bookinginfo(BookingInformation.builder().bookingDate(dto.getBookingInform().getBookingDate()).currentCity(dto.getBookingInform().getCurrentCity()) 
				.destination(dto.getBookingInform().getDestination()).fare(dto.getBookingInform().getFare()).flightDate(dto.getBookingInform().getFlightDate())
				.flightNumber(dto.getBookingInform().getFlightNumber()).flightTime(dto.getBookingInform().getFlightTime()).status(dto.getBookingInform().getStatus())
				.build())
				.checkin(CheckIn.builder().gateNo(dto.getCheckin().getGateNo()).seatNo(dto.getCheckin().getSeatNo()).build())
				.build());
		return save.getPassengerId();
	}

	@Override
	public int savaDetails(BookingInfoDTO dto) {
	
		
		 BookingInformation save = bookinginforepository.save(BookingInformation.builder()
				 .bookingDate(dto.getBookingDate()).currentCity(dto.getCurrentCity()).destination(dto.getDestination())
				 .fare(dto.getFare()).flightDate(dto.getFlightDate()).flightNumber(dto.getFlightNumber()).flightTime(dto.getFlightTime())  
				 .build());
		 
		return save.getBookinId();
	}
	@Override
	public BookingInfoDTO findById(int bookId) {
		Optional<BookingInformation> findById = bookinginforepository.findById(bookId);
		
		if (findById.isPresent()) {
			
			    BookingInformation bookingInfo= findById.get();
			    BookingInfoDTO getDetails = BookingInfoDTO.builder()
			     .bookingDate(bookingInfo.getBookingDate()).currentCity(bookingInfo.getCurrentCity()).destination(bookingInfo.getDestination())
			     .flightDate(bookingInfo.getFlightDate()).flightNumber(bookingInfo.getFlightNumber()).flightTime(bookingInfo.getFlightTime())
			     .fare(bookingInfo.getFare()).status(bookingInfo.getStatus())
			    .build();
			    return getDetails;
		}

		else {
			return null;
		}
}
	@Override
	public int saveAirlineInfo(AirlineInfoDTO dto) {
		 AirlineInformation save = airlineRepository.save(AirlineInformation.builder()
				 .airlineName(dto.getAirlineName())
				 .build());
		return save.getAirlineId();
	}
	
	
	@Autowired
	private AmountRepository fareRepository;
	
	@Override
	public int saveFare(FareAmountDTO dto) {
		 FareAmount save = fareRepository.save(FareAmount.builder()
				 .amount(dto.getAmount()).currency(dto.getCurrency())
				 .build());
		return save.getFareId();
	}
	
	@Autowired
	private FlightInfoRepository flightinfoRepository;
	
	@Override
	public int saveFlightInfo(FlightInfoDTO dto) {
		
		FlightInfo saveFlightInfo = flightinfoRepository.save(FlightInfo.builder()
				.flightNo(dto.getFlightNo()).flightType(dto.getFlightType())
				.flightTime(dto.getFlightTime())
				.airlineinform(AirlineInformation.builder().airlineName(dto.getAirlineInfo().getAirlineName()).build())
				.build());
		
		return saveFlightInfo.getFlightInfoId();
	}
	
	@Autowired
	private FlightInventoryRepository inventoryRepository;
	@Override
	public int saveFlightInventory(FlightInventoryDTO dto) {
		FlightInventory saveInventory = inventoryRepository.save(FlightInventory.builder().count(dto.getCount()).build());
		return saveInventory.getInventoryId();
	}
	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public int saveFlightData(FlightDTO dto) {
		Flight saveFlight = flightRepo.save(Flight.builder().destination(dto.getDestination()).currentLocation(dto.getCurrentLocation()).flightDate(dto.getFlightDate())
				.flightName(dto.getFlightName()).flightNo(dto.getFlightNo())
				 .fare(FareAmount.builder().currency(dto.getFare().getCurrency()).amount(dto.getFare().getAmount()) .build())
				 .flightInfo(FlightInfo.builder().flightNo(dto.getFlightInfo().getFlightNo()).flightTime(dto.getFlightInfo().getFlightTime()).flightType(dto.getFlightInfo().getFlightType()).build())
				 .flightInventory(FlightInventory.builder().count(dto.getInventory().getCount()).build())
				 .build());
		return saveFlight.getFlightId();
	}
	@Autowired
	private CheckInRepository checkinRepo;
	@Override
	public int saveCheckIn(CheckInDTO dto) {
		
		CheckIn saveCheckin = checkinRepo.save(CheckIn.builder().seatNo(dto.getSeatNo()).gateNo(dto.getGateNo()).build());
		return saveCheckin.getCheckinId();
	}
	@Override
	public List<BookingInfoDTO> getAllBookingDetails() {
		List<BookingInformation> findAllBooking = bookinginforepository.findAll();
		if(findAllBooking.size()>0)
		{
			List<BookingInfoDTO> collectAllBookingDetails = findAllBooking.stream().map(n->BookingInfoDTO.builder().bookingDate(n.getBookingDate()).currentCity(n.getCurrentCity()).destination(n.getDestination()) 
					.fare(n.getFare()).flightDate(n.getFlightDate()).flightNumber(n.getFlightNumber()).flightTime(n.getFlightTime()).status(n.getStatus())
					.build()).collect(Collectors.toList());
			return collectAllBookingDetails;
		}
		else {
		return null;
		}
	}
	@Override
	public AirlineInfoDTO findByAirlineInfoId(int airlineId) {
		Optional<AirlineInformation> findByAirlineId = airlineRepository.findById(airlineId);
		if(findByAirlineId.isPresent())
		{
			AirlineInformation airlineInfo = findByAirlineId.get();
			
			 AirlineInfoDTO find = AirlineInfoDTO.builder().airlineName(airlineInfo.getAirlineName()) .build();
		return find;
		}
		else
		return null;
	}
	@Override
	public CheckInDTO findCheckInbyId(int id) {
		Optional<CheckIn> findById = checkinRepo.findById(id);
		if(findById.isPresent())
		{
			CheckIn checkIn = findById.get();
			CheckInDTO findCheckin= CheckInDTO.builder().gateNo(checkIn.getGateNo()).seatNo(checkIn.getSeatNo()) .build();
			return findCheckin;
		}
		else
		return null;
	}
	@Override
	public FareAmountDTO findfareById(int id) {

		Optional<FareAmount> findByfareId = fareRepository.findById(id);
		if(findByfareId.isPresent())
		{
			FareAmount fareAmount = findByfareId.get();
			FareAmountDTO buildFare= FareAmountDTO.builder().currency(fareAmount.getCurrency()).amount(fareAmount.getAmount()).build();
		return buildFare;
		}
		else
		return null;
	}

	@Override
	public FlightDTO getflightbyId(int id) {
		Optional<Flight> findById = flightRepo.findById(id);
			
		if(findById.isPresent())
		{
			Flight flight = findById.get();
			FareAmount fare = new FareAmount();
			FlightDTO build = FlightDTO.builder().destination(flight.getDestination()).currentLocation(flight.getCurrentLocation()).flightDate(flight.getFlightDate())
					.flightName(flight.getFlightName()).flightNo(flight.getFlightNo()).build();
					 return build;
		}
		else
		return null;
	}
	@Override
	public FlightInfoDTO getflightInfoByid(int id) {
		Optional<FlightInfo> findById = flightinfoRepository.findById(id);
		if(findById.isPresent())
		{
			FlightInfo flightInfo = findById.get();
			return FlightInfoDTO.builder().flightNo(flightInfo.getFlightNo()).flightType(flightInfo.getFlightType())
					.flightTime(flightInfo.getFlightTime()).build();
		}
		else
		return null;
	}
	@Override
	public FlightInventoryDTO getflightInventoryById(int id) {
		Optional<FlightInventory> findById = inventoryRepository.findById(id);
		if(findById.isPresent())
		{
			FlightInventory flightInventory = findById.get();
			return FlightInventoryDTO.builder().count(flightInventory.getCount()) .build();
		}
		else
		return null;
	}
	@Override
	public PassengerDto getPassengersById(int id) {
		Optional<Passengers> findById = passRepository.findById(id);
		if(findById.isPresent())
		{
			Passengers passengers = findById.get();
			return PassengerDto.builder().firstName(passengers.getFirstName()).lastName(passengers.getLastName()).gender(passengers.getGender()).mobileNumber(passengers.getMobileNumber())
					.pEmail(passengers.getPEmail()).build();
		}
		return null;
	}
	@Override
	public Userdto getUserById(int Id) {
		Optional<User> findById = userRepository.findById(Id);
		if(findById.isPresent())
		{
			User user = findById.get();
			return Userdto.builder()
				     .firstName(user.getFirstName()).lastName(user.getFirstName()).mobileNo(user.getMobileNo())
				     .gender(user.getGender()).userName(user.getUserName()).password(user.getPassword())
				.build();
		}
		else {
		return null;
		}
	}
	@Override
	public AirlineInformation updateAirlineDetailsById(int id,AirlineInfoDTO dto) {
		Optional<AirlineInformation> findById = airlineRepository.findById(id);
		if(findById.isPresent())
		{
			AirlineInformation airlineInfo = findById.get();
			airlineInfo.setAirlineName(dto.getAirlineName());
			AirlineInformation save = airlineRepository.save(airlineInfo);
		return save;
		}
		else {
		return null;
		}
	}
	@Override
	public FlightInfo updateflightInfoById(int id, FlightInfoDTO dto) {
		Optional<FlightInfo> findById = flightinfoRepository.findById(id);
		if(findById.isPresent())
		{
			FlightInfo flightInfo = findById.get(); 
			flightInfo.setFlightNo(dto.getFlightNo());
		    flightInfo.setFlightTime(dto.getFlightTime());
		    flightInfo.setFlightType(dto.getFlightType());
		    FlightInfo save = flightinfoRepository.save(flightInfo);
		    return save;
		}
		else
		return null;
	}
	@Override
	public FareAmount updatefareById(int id, FareAmountDTO dto) {
		 Optional<FareAmount> fareAmount = fareRepository.findById(id);
		 if(fareAmount.isPresent())
		 {
			 FareAmount fareAmount2 = fareAmount.get();
			 fareAmount2.setAmount(dto.getAmount());
			 fareAmount2.setCurrency(dto.getCurrency());
			 FareAmount save = fareRepository.save(fareAmount2);
			 return save;
		 }
		 else
		return null;
	}
	@Override
	public Flight updateFlightByid(int id, FlightDTO dto) {
		Optional<Flight> findById = flightRepo.findById(id);
		
		if(findById.isPresent())
		{
			Flight flight = findById.get();
			flight.setCurrentLocation(dto.getCurrentLocation());
			flight.setDestination(dto.getDestination());
			flight.setFlightDate(dto.getFlightDate());
			flight.setFlightName(dto.getFlightName());
			flight.setFlightNo(dto.getFlightNo());
			Flight save = flightRepo.save(flight);
			return save;
		}
		else
		return null;
	}
	@Override
	public FlightInventory updateFlightInventory(int id, FlightInventoryDTO dto) {
		Optional<FlightInventory> findById = inventoryRepository.findById(id);
		if(findById.isPresent())
		{
			FlightInventory inventory = findById.get();
			inventory.setCount(dto.getCount());
			return inventoryRepository.save(inventory);
		}
		else
		return null;
	}
	@Override
	public Passengers updatePassengersByid(int id, PassengerDto dto) {
		
		if(passRepository.findById(id).isPresent())
		{
			
			Passengers passengers = passRepository.findById(id).get();
			passengers.setFirstName(dto.getFirstName());
			passengers.setLastName(dto.getLastName());
			passengers.setGender(dto.getGender());
			passengers.setMobileNumber(dto.getMobileNumber());
			passengers.setPEmail(dto.getPEmail());
			
			return passRepository.save(passengers);

		}
		return null;
	}
	@Override
	public User updateUserById(int id, Userdto dto) {
		Optional<User> findById = userRepository.findById(id);
		if(findById.isPresent())
		{
			User user = findById.get();
			user.setFirstName(dto.getFirstName());
			user.setGender(dto.getGender());
			user.setLastName(dto.getLastName());
			user.setMobileNo(dto.getMobileNo());
			user.setPassword(dto.getPassword());
			user.setUserName(dto.getUserName());
			return userRepository.save(user);
		}
		return null;
	}
	@Override
	public BookingInformation updateBookingInformation(int id, BookingInfoDTO dto) {
		Optional<BookingInformation> findById = bookinginforepository.findById(id);
		if(findById.isPresent())
		{
			BookingInformation bookingInfo = findById.get();
			bookingInfo.setBookingDate(dto.getBookingDate());
			bookingInfo.setCurrentCity(dto.getCurrentCity());
			bookingInfo.setDestination(dto.getDestination());
			bookingInfo.setFlightDate(dto.getFlightDate());
			bookingInfo.setFlightNumber(dto.getFlightNumber());
			bookingInfo.setStatus(dto.getStatus());
			bookingInfo.setFare(dto.getFare());
			return bookinginforepository.save(bookingInfo);
		}
		return null;
	}
	@Override
	public CheckIn updateCheckIn(int id, CheckInDTO dto) {
		Optional<CheckIn> findById = checkinRepo.findById(id);
		if(findById.isPresent())
		{
			 CheckIn check = findById.get();
			 check.setGateNo(dto.getGateNo());
			 check.setSeatNo(dto.getSeatNo());
			 return checkinRepo.save(check);
		}
		return null;
	}
	@Override
	public AirlineInformation deleteDetailsByid(int id, AirlineInfoDTO dto) {
		Optional<AirlineInformation> findById = airlineRepository.findById(id);
		if(findById.isPresent())
		{
			AirlineInformation airline = findById.get();
		     String airline1 = airline.getAirlineName();
//		     return airlineRepository
			
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
