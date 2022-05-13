package com.soses.hris.controller.user;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.user.BaseUserResponse;
import com.soses.hris.common.StringUtil;
import com.soses.hris.service.user.UserService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private static final String USER_PAGE = "/user/user";

	private UserService userSerivce;
	
	@Autowired
	public UserController(@Qualifier("UserServiceImpl") UserService userSerivce) {
		super();
		this.userSerivce = userSerivce;
	}



	@GetMapping("/{username}")
	public String viewUser(@PathVariable String username, Model model, Principal principal) {
		log.info("viewUser(username,model)");

		if (!StringUtil.isEmpty(username)) {
			BaseUserResponse res = userSerivce.getUserDetails(username, principal);
			if (res != null) {
				model.addAttribute("res", res);
			}
		}
		
		return USER_PAGE;
	}
}
