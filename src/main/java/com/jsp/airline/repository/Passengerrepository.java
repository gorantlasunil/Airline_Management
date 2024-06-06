package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.Passengers;

@Repository
public interface Passengerrepository extends JpaRepository<Passengers, Integer> {

}
