package com.soses.hris.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.api.EmployeeProfileRequest;
import com.soses.hris.cache.configparam.GenderCache;
import com.soses.hris.cache.configparam.MaritalStatusCache;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.entity.ConfigParam;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.EmployeeProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeProfileController.
 *
 * @author hso
 * @since Jan 20, 2022
 */
@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeProfileController extends BaseEmployeeController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeProfileController.class);
	
	/** The Constant EMP_PAGE. */
	private static final String EMP_PAGE = "employee/employee";
	
	/** The employee service. */
	private EmployeeProfileService employeeService;
	
	/** The marital status cache. */
	private MaritalStatusCache maritalStatusCache;

	/** The gender cache. */
	private GenderCache genderCache;
	
	/**
	 * Instantiates a new employee profile controller.
	 *
	 * @param employeeService the employee service
	 * @param maritalStatusCache the marital status cache
	 * @param genderCache the gender cache
	 */
	@Autowired
	public EmployeeProfileController(@Qualifier("EmployeeProfileServiceImpl") EmployeeProfileService employeeService, MaritalStatusCache maritalStatusCache
			, GenderCache genderCache, UserRepository userRepo) {
		super(userRepo);
		this.employeeService = employeeService;
		this.maritalStatusCache = maritalStatusCache;
		this.genderCache = genderCache;
	}


	/**
	 * Gets the employee.
	 *
	 * @param employeeId the employee id
	 * @param model the model
	 * @param isUpdate the is update
	 * @return the employee
	 */
	@GetMapping("/{employeeId}/profile")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("EMPLOYEE PROFILE CONTROLLER");
		BaseEmployeeResponse res = employeeService.getEmployeeDetails(employeeId);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "1");
		if (res!= null) {
			List<ConfigParam> maritalStatusList = maritalStatusCache.getMaritalStatusList();
			List<ConfigParam> genderList = genderCache.getGenderList();
			model.addAttribute("maritalStatusList", maritalStatusList);
			model.addAttribute("genderList", genderList);
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", isUpdate);
			model.addAttribute("isUser", isUser(employeeId));
		}
		model.addAttribute("employeeProfileRequest", new EmployeeProfileRequest());
		return EMP_PAGE;
	}
	
	/**
	 * Update employee.
	 *
	 * @param employeeId the employee id
	 * @param request the request
	 * @param model the model
	 * @return the string
	 */
	@PostMapping(value="/{employeeId}/profile", produces="application/json")
	public String updateEmployee(@PathVariable String employeeId, @Valid EmployeeProfileRequest request, Model model) {
		
		log.info("Request: " + request.toString());
		if (employeeService.updateEmployeeDetails(request)) {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated employee profile.");
		} else {
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return getEmployee(employeeId, model, false);
	}
}
