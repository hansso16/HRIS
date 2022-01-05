package com.soses.hris.controller;

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
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.common.StringUtil;
import com.soses.hris.dto.ErrorPageDTO;
import com.soses.hris.service.EmployeeRegistrationService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeRegistrationController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	private static final String ADD_EMP = "/employee/add_employee";

	private static final String ADD_EMP_SUC = "/employee/add_employee_success";
	
	private EmployeeRegistrationService employeeRegistrationService;
	
	@Autowired
	public EmployeeRegistrationController(EmployeeRegistrationService employeeRegistrationService) {
		this.employeeRegistrationService = employeeRegistrationService;
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
//		return ADD_EMP;
		return ADD_EMP;
	}

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
