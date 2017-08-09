package com.springboot.local.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.local.domain.AuthzEmpData;

@RestController
public class AuthzServices {
	
	@RequestMapping("/authorize")
	public AuthzEmpData authorizePublic(@RequestParam(value="name", defaultValue="Amrit") String name){
		authorizePrivate("Singh");
		return new AuthzEmpData(name,"1234","Computer");
	}
	
	private AuthzEmpData authorizePrivate(String name){
		return new AuthzEmpData(name,"1234","Computer");
	}

}
