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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.service.ActivityHistoryService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeActivityController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeActivityController.class);
	
	private static final String ACTIVITY_PAGE = "/employee/employee";
	
	private ActivityHistoryService activityHistoryService;
	
	@Autowired
	public EmployeeActivityController(@Qualifier("ActivityHistoryServiceImpl") ActivityHistoryService activityHistoryService) {
		super();
		this.activityHistoryService = activityHistoryService;
	}
	
	@GetMapping("/{employeeId}/activity")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "false") boolean isUpdate) {
		
		log.info("EMPLOYEE ACTIVITY CONTROLLER");
		return ACTIVITY_PAGE;
	}
}
