package com.soses.hris.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.AddEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.cache.configparam.GenderCache;
import com.soses.hris.cache.configparam.MaritalStatusCache;
import com.soses.hris.cache.region.RegionCacheService;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.common.StringUtil;
import com.soses.hris.entity.ConfigParam;
import com.soses.hris.entity.Region;
import com.soses.hris.service.EmployeeRegistrationService;

/**
 * The Class EmployeeRegistrationController.
 *
 * @author hso
 * @since Jan 6, 2022
 */
@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeRegistrationController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	/** The Constant ADD_EMP. */
	private static final String ADD_EMP = "/employee/add_employee";

	/** The Constant ADD_EMP_SUC. */
	private static final String ADD_EMP_SUC = "/employee/add_employee_success";
	
	/** The employee registration service. */
	private EmployeeRegistrationService employeeRegistrationService;
	
	/** The marital status cache. */
	private MaritalStatusCache maritalStatusCache;
	
	private RegionCacheService regionCache;

	/** The gender cache. */
	private GenderCache genderCache;
	
	/**
	 * Instantiates a new employee registration controller.
	 *
	 * @param employeeRegistrationService the employee registration service
	 * @param maritalStatusCache the marital status cache
	 * @param genderCache the gender cache
	 */
	@Autowired
	public EmployeeRegistrationController(EmployeeRegistrationService employeeRegistrationService, MaritalStatusCache maritalStatusCache
			, GenderCache genderCache, RegionCacheService regionCache) {
		this.employeeRegistrationService = employeeRegistrationService;
		this.maritalStatusCache = maritalStatusCache;
		this.genderCache = genderCache;
		this.regionCache = regionCache;
	}
	
	/**
	 * Adds the employee.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/add")
	public String addEmployee(Model model) {
		
		List<ConfigParam> maritalStatusList = maritalStatusCache.getMaritalStatusList();
		List<ConfigParam> genderList = genderCache.getGenderList();
		List<Region> regionList = regionCache.findAll();
		
		model.addAttribute("maritalStatusList", maritalStatusList);
		model.addAttribute("genderList", genderList);
		model.addAttribute("regionList", regionList);
		
		return ADD_EMP;
	}

	/**
	 * Adds the employee.
	 *
	 * @param addEmployeeRequest the add employee request
	 * @param errors the errors
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/add")
	public String addEmployee(@Valid @ModelAttribute AddEmployeeRequest addEmployeeRequest, Errors errors, Model model) {
		
		log.info("Add Employee Request: " + addEmployeeRequest.toString());
		BaseEmployeeResponse response = employeeRegistrationService.registerEmployee(addEmployeeRequest);
		
		if (response == null || StringUtil.isEmpty(response.getEmployeeId())) {
			// failure message
//			ErrorPageDTO error = new ErrorPageDTO();
//			error.setMessage("Registration failed. Please try again. If issue persists, please contact your system admin.");
//			response.setError(error);
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			return ADD_EMP;
		}
		model.addAttribute("res", response);
		
		return ADD_EMP_SUC;
	}
}
