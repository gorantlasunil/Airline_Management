package com.jsp.airline.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
    
//	@Query("SELECT f1 FROM Flight f1 WHERE f1.currentLocation = :location AND f1.destination = :desti AND f1.flightDate = :date AND f1.flightName = :name")
//	List<Flight> getDetailsByStartLocatDestiFlightDateFlightName(@Param("location") String from,@Param("desti") String to,@Param("date") String date,
//			@Param("name") String name);
}
