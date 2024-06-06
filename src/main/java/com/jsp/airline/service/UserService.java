package com.jsp.airline.service;

import java.util.List;

import com.jsp.airline.dto.Userdto;
import com.jsp.airline.entity.User;

public interface UserService {

	int addUser(Userdto dto);
	List<Userdto> loginByMobileNoAndPassword(String mobileNo,String password);
}
