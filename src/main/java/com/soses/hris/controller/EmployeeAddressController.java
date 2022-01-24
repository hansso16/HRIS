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
import com.soses.hris.api.EmployeeAddressRequest;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.service.EmployeeAddressService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeAddressController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeAddressController.class);
	
	private static final String EMP_PAGE = "/employee/employee";
	
	private EmployeeAddressService employeeAddressService;
	
	@Autowired
	public EmployeeAddressController(@Qualifier("EmployeeAddressServiceImpl") EmployeeAddressService employeeAddressService) {
		super();
		this.employeeAddressService = employeeAddressService;
	}


	@GetMapping("/{employeeId}/address")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("EMPLOYEE ADDRESS CONTROLLER");
		BaseEmployeeResponse res = employeeAddressService.getEmployeeDetails(employeeId);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "2");
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", isUpdate);
		}
		return EMP_PAGE;
	}
	
	@PostMapping(value="/{employeeId}/address")
	public String updateEmployee(@PathVariable String employeeId, @Valid EmployeeAddressRequest request, Model model) {
		
		log.info("EmployeeId: " + employeeId);
		log.info("Request: " + request.toString());

		if (employeeAddressService.updateEmployeeDetails(request)) {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated employee address.");
		} else {
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return getEmployee(employeeId, model, false);
	}
}
