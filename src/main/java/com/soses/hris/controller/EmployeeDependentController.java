package com.soses.hris.controller;

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
import com.soses.hris.api.EmployeeDependentRequest;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.service.EmployeeDependentService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeDependentController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeDependentController.class);
	
	private static final String EMP_PAGE = "/employee/employee";
	
	private EmployeeDependentService employeeDependentService;
	
	@Autowired
	public EmployeeDependentController(@Qualifier("EmployeeDependentServiceImpl") EmployeeDependentService employeeDependentService) {
		super();
		this.employeeDependentService = employeeDependentService;
	}


	@GetMapping("/{employeeId}/dependent")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("EMPLOYEE DEPENDENT CONTROLLER");
		// searchType? case 1 2 3 -> service
		BaseEmployeeResponse res = employeeDependentService.getEmployeeDetails(employeeId);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "4");
		if (res!= null) {
			model.addAttribute("res", res);
			if(isUpdate) {
				model.addAttribute("isUpdate", true);
			} else {
				model.addAttribute("isUpdate", false);
			}
		}
		return EMP_PAGE;
	}
	
	@PostMapping(value="/{employeeId}/dependent")
	public String updateEmployee(@PathVariable String employeeId, @Valid EmployeeDependentRequest request, Model model) {
		
		log.info("EmployeeId: " + employeeId);
		log.info("Request: " + request.toString());

		if (!employeeDependentService.updateEmployeeDetails(request)) {
			// set error
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		} else {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated employee benefits.");
		}
		
		return getEmployee(employeeId, model, false);
	}
}
