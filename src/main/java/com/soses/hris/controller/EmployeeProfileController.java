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
import com.soses.hris.api.EmployeeProfileRequest;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.service.EmployeeProfileService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeProfileController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeProfileController.class);
	
	private static final String EMP_PAGE = "/employee/employee";
	
	private EmployeeProfileService employeeService;
	
	@Autowired
	public EmployeeProfileController(@Qualifier("EmployeeProfileServiceImpl") EmployeeProfileService employeeService) {
		super();
		this.employeeService = employeeService;
	}


	@GetMapping("/{employeeId}/profile")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("EMPLOYEE PROFILE CONTROLLER");
		// searchType? case 1 2 3 -> service
		BaseEmployeeResponse res = employeeService.getEmployeeDetails(employeeId);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "1");
		if (res!= null) {
			model.addAttribute("res", res);
			if(isUpdate) {
				model.addAttribute("isUpdate", true);
			} else {
				model.addAttribute("isUpdate", false);
			}
		}
		model.addAttribute("employeeProfileRequest", new EmployeeProfileRequest());
		return EMP_PAGE;
	}
	
//	@PostMapping(value="/{employeeId}/profile", produces="application/json")
//	@ResponseBody
//	public ResponseEntity<BaseEmployeeResponse> updateEmployee(@PathVariable String employeeId, @Valid @RequestBody EmployeeProfileRequest request, Model model) {
//		
//		log.info("EmployeeId: " + employeeId);
//		log.info("Request: " + request.toString());
//
//		BaseEmployeeResponse res = new BaseEmployeeResponse();
//		res.setEmployeeId(employeeId);
//		if (employeeService.updateEmployeeDetails(request)) {
//			return ResponseEntity.ok(res);
//		}
//		return new ResponseEntity<BaseEmployeeResponse>(HttpStatus.BAD_REQUEST);
//	}
	
	@PostMapping(value="/{employeeId}/profile", produces="application/json")
	public String updateEmployee(@PathVariable String employeeId, @Valid EmployeeProfileRequest request, Model model) {
		
		log.info("EmployeeId: " + employeeId);
		log.info("Request: " + request.toString());
		
		if (!employeeService.updateEmployeeDetails(request)) {
			// error
			model.addAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		} else {
			model.addAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully updated employee profile.");
		}
		
		return getEmployee(employeeId, model, false);
	}
}
