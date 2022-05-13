package com.soses.hris.controller.user;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.user.UserRegistrationRequest;
import com.soses.hris.api.user.UserRegistrationResponse;
import com.soses.hris.cache.configparam.GenderCache;
import com.soses.hris.cache.configparam.MaritalStatusCache;
import com.soses.hris.cache.role.RoleCacheService;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ConfigParam;
import com.soses.hris.entity.Role;
import com.soses.hris.entity.User;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.EmployeeProfileService;
import com.soses.hris.service.user.UserRegistrationService;

@Controller
@RequestMapping("/user")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UserRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(UserRegistrationController.class);
	
	private static final String USER_REGISTRATION = "/user/user_registration";
	
	private RoleCacheService roleCache;
	
	private EmployeeProfileService employeeService;
	
	private MaritalStatusCache maritalStatusCache;

	/** The gender cache. */
	private GenderCache genderCache;
	
	private UserRegistrationService userRegistrationService;
	
	private UserRepository userRepo;
	
	@Autowired
	public UserRegistrationController(@Qualifier("EmployeeProfileServiceImpl") EmployeeProfileService employeeService, RoleCacheService roleCache
			, MaritalStatusCache maritalStatusCache, GenderCache genderCache, UserRegistrationService userRegistrationService, UserRepository userRepo) {
		super();
		this.roleCache = roleCache;
		this.employeeService = employeeService;
		this.genderCache = genderCache;
		this.maritalStatusCache = maritalStatusCache;
		this.userRegistrationService = userRegistrationService;
		this.userRepo = userRepo;
	}

	@GetMapping("/add/{employeeId}")
	public String addEmployee(Model model, @PathVariable String employeeId, Principal principal) {
		log.info("ENTER GET:addEmployee(model)");
		
		BaseEmployeeResponse res = employeeService.getEmployeeDetails(employeeId);
		
		if (res != null) {
			List<Role> roleList = roleCache.findAll();
			List<ConfigParam> maritalStatusList = maritalStatusCache.getMaritalStatusList();
			List<ConfigParam> genderList = genderCache.getGenderList();
			model.addAttribute("roleList", roleList);
			model.addAttribute("maritalStatusList", maritalStatusList);
			model.addAttribute("genderList", genderList);
			model.addAttribute("res", res);
			
			User loggedUser = userRepo.findByUsername(principal.getName());
			if (loggedUser != null) {
				model.addAttribute("loggedUser", loggedUser);
			}
		}
		
		return USER_REGISTRATION;
	}
	
	@PostMapping("/add")
	public RedirectView addEmployee(Model model, UserRegistrationRequest request, RedirectAttributes redirectAttrs) {
		log.info("ENTER POST(model, request):"+request.toString());
		
		UserRegistrationResponse res = userRegistrationService.registerUser(request);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setExposeModelAttributes(false);
		
		if (res != null) {
			if (res.getError() != null) {
				String redirectUrl = "/user/add/"+res.getEmployeeId();
				redirectView.setUrl(redirectUrl);
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, res.getError().getMessage());
				return redirectView;
			}
			if (!StringUtil.isEmpty(res.getResponseMessage())) {
				String redirectUrl = "/user/" + res.getUsername();
				redirectView.setUrl(redirectUrl);
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, res.getResponseMessage());
				return redirectView;
			}
			model.addAttribute("res", res);
		}
		
		return redirectView;
	}
}
