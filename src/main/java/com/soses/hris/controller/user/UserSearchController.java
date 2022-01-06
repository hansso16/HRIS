package com.soses.hris.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.user.UserSearchRequest;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.User;
import com.soses.hris.service.user.UserSearchService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserSearchController {

	private static final String USER_LIST = "/user/user_list";
	
	private UserSearchService userSearchService;
	
	@Autowired
	public UserSearchController(@Qualifier("UserSearchServiceImpl")UserSearchService userSearchService) {
		super();
		this.userSearchService = userSearchService;
	}


	@GetMapping("")
	public String employee(@Valid UserSearchRequest userReq, Errors errors, Model model) {
		
		String username = userReq.getUsername();
		if (!StringUtil.isEmpty(username)) {
			Page<User> userPage = userSearchService.searchUser(userReq, userReq);
			if (userPage != null) {
				model.addAttribute("currentPage", userPage.getNumber());
				model.addAttribute("userPage", userPage);
				model.addAttribute("totalPages", userPage.getTotalPages());
				model.addAttribute("totalRows", userPage.getTotalElements());
//				if (totalPages > 0) {
//					List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
//					model.addAttribute("pageNumbers", pageNumbers);
//				}
			}
			
//			res = userSearchService.searchUser(userReq);
//			if (res != null) {
//				model.addAttribute("res", res);
//			}
		}
		return USER_LIST;
	}
	
}
