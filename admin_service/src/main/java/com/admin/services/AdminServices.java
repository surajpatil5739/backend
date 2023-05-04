package com.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.Admin;
import com.admin.repository.AdminRepository;



@Service
public class AdminServices {

	@Autowired
	private AdminRepository adminrepo;
	
	public Admin registerAdmin(Admin user) {
		return adminrepo.save(user);
	}
	
	public Admin loginCheck(String email,String pass)
	{
		return adminrepo.check(email, pass);
	}
}
