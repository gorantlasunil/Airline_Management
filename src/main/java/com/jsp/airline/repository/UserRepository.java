package com.jsp.airline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsp.airline.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {

	@Query("SELECT u1 FROM User u1 WHERE u1.mobileNo=:mobile AND u1.password=:password")
	List<User> userLoginByMobileAndPassword(@Param("mobile") String mobileNo,@Param("password") String password);
	
}
