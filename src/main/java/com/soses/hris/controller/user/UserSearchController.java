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
import com.soses.hris.controller.BaseSearchController;
import com.soses.hris.entity.User;
import com.soses.hris.service.user.UserSearchService;

/**
 * The Class UserSearchController.
 *
 * @author hso
 * @since Mar 21, 2022
 */
@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserSearchController extends BaseSearchController {

	/** The Constant USER_LIST. */
	private static final String USER_LIST = "user/user_list";
	
	/** The user search service. */
	private UserSearchService<User> userSearchService;
	
	/**
	 * Instantiates a new user search controller.
	 *
	 * @param userSearchService the user search service
	 */
	@Autowired
	public UserSearchController(@Qualifier("UserSearchServiceImpl")UserSearchService<User> userSearchService) {
		super();
		this.userSearchService = userSearchService;
	}


	/**
	 * Search entity.
	 *
	 * @param userReq the user req
	 * @param errors the errors
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("")
	public String searchEntity(@Valid UserSearchRequest userReq, Errors errors, Model model) {
		
		String username = userReq.getUsername();
		if (userReq != null) {
			Page<User> userPage = userSearchService.searchUser(userReq);
			if (userPage != null) {
				setPaginationVariables(userPage, model);
				model.addAttribute("username", username);
			}
		}
		return USER_LIST;
	}
	
}
