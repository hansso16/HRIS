package com.soses.hris.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.EmployeeAddressHistoryService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeAddressHistoryController extends BaseEmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeAddressHistoryController.class);
	
	private static final String EMP_PAGE = "employee/employee";
	
	private EmployeeAddressHistoryService employeeAddressHistoryService;
	
	@Autowired
	public EmployeeAddressHistoryController(@Qualifier("EmployeeAddressHistoryService") EmployeeAddressHistoryService employeeAddressHistoryService
			, UserRepository userRepo) {
		super(userRepo);
		this.employeeAddressHistoryService = employeeAddressHistoryService;
	}
	
	@GetMapping("/{employeeId}/address/history/{addressType}")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @PathVariable String addressType) {
		
		log.info("EMPLOYEE ADDRESS HISTORY CONTROLLER");
		BaseEmployeeResponse res = employeeAddressHistoryService.getEmployeeDetails(employeeId, addressType);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "21");
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", true);
			model.addAttribute("isUser", isUser(employeeId));
		}
		return EMP_PAGE;
	}
}
