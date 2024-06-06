package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.entity.FlightInfo;
@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer>{

//	@Query("UPDATE f1 FROM FlightInfo f1 set ")
//	FlightInfo updateflightInfoByFLightNo(String FlightNo,FlightDTO dto);
}
