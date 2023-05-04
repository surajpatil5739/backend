package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.user.repository.*;
import com.user.entity.*;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public Users registerUser(Users user) {
		return userRepository.save(user);
	}
	
	public Users loginCheck(String email,String pass)
	{
		return userRepository.check(email, pass);
	}

}
