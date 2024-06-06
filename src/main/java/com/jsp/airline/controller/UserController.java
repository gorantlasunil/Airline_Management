package com.jsp.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.Userdto;
import com.jsp.airline.service.UserService;

@RestController
@RequestMapping("/userAirline/v1")
public class UserController {
    
	@Autowired
	private UserService service;
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody Userdto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("User id inserted: "+service.addUser(dto));
	}
 	 
	@GetMapping("loginUser/{mb}/{pass}")
	public ResponseEntity<List<Userdto>> loginUser(@PathVariable("mb") String mobileNo,@PathVariable("pass") String password)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(service.loginByMobileNoAndPassword(mobileNo, password));
	}
}
