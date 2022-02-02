package com.soses.hris.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/changepassword")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ChangePasswordController {

	private static final String CHANGE_PWD = "/user/change_password";
	
	@GetMapping("")
	public String changePassword() {
		return CHANGE_PWD;
	}
	
	@PostMapping("")
	public String changePasswordd() {
		return CHANGE_PWD;
	}
}
