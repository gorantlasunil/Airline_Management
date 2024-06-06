package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.AirlineInformation;

@Repository
public interface AirlineInfoRepository extends JpaRepository<AirlineInformation, Integer>{

	AirlineInformation findByAirlineId(int aid);

}
