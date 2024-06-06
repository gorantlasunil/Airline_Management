package com.jsp.airline.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.Userdto;
import com.jsp.airline.entity.User;
import com.jsp.airline.repository.UserRepository;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public int addUser(Userdto dto) {
		
		User save = userRepo.save(User.builder().firstName(dto.getFirstName()).lastName(dto.getLastName()).gender(dto.getGender()) 
				.mobileNo(dto.getMobileNo()).userName(dto.getUserName()) .password(dto.getPassword())
				.build());
		return save.getUseId();
	}
	@Override
	public List<Userdto> loginByMobileNoAndPassword(String mobileNo, String password) {
		List<User> login = userRepo.userLoginByMobileAndPassword(mobileNo, password);
		if(login.isEmpty())
		{
			return null;
		}
		else {
			List<Userdto> collect = login.stream().map(n->Userdto.builder().mobileNo(n.getMobileNo()).userName(n.getUserName())
					.gender(n.getGender()).firstName(n.getFirstName()).lastName(n.getLastName()).password(n.getPassword())
					.build()).collect(Collectors.toList());
			return collect;
		}
	}

}
