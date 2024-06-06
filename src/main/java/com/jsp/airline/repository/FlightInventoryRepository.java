package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.FlightInventory;

@Repository
public interface FlightInventoryRepository extends JpaRepository<FlightInventory ,Integer>  {

}
