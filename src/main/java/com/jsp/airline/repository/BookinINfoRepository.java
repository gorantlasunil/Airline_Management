package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.BookingInformation;

@Repository
public interface BookinINfoRepository extends JpaRepository<BookingInformation, Integer>{

	
}
