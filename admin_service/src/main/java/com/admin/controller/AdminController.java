package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.Admin;
import com.admin.services.AdminServices;


@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private AdminServices adminServ;
	
	
	@PostMapping(path="/registerAdmin")
	public Admin registerUser(@RequestBody Admin adminObj) {
		 return adminServ.registerAdmin(adminObj);
	}
	 @GetMapping(path="/loginAdmin/{email}/{pass}")
	 public Admin loginAdmin(@PathVariable String email, @PathVariable String pass)
	 {
		 return adminServ.loginCheck(email, pass);
	 }
}

