package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.FareAmount;

@Repository
public interface AmountRepository extends JpaRepository<FareAmount, Integer>{

}
