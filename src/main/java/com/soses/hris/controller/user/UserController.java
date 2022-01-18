package com.soses.hris.controller.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserController {

	private static final String USER_PAGE = "/user/user";
	
	@GetMapping("/{employeeId}")
	public String viewUser(@PathVariable String employeeId, Model model) {
		
		
		
		
		return USER_PAGE;
	}
}
