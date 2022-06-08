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

import com.soses.hris.api.EmployeeActivityRequest;
import com.soses.hris.api.EmployeeActivityResponse;
import com.soses.hris.repository.UserRepository;
import com.soses.hris.service.ActivityHistoryService;

@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeActivityController extends BaseEmployeeController {

	private static final Logger log = LoggerFactory.getLogger(EmployeeActivityController.class);
	
	private static final String ACTIVITY_PAGE = "employee/employee";
	
	private ActivityHistoryService activityHistoryService;
	
	@Autowired
	public EmployeeActivityController(@Qualifier("ActivityHistoryServiceImpl") ActivityHistoryService activityHistoryService, UserRepository userRepo) {
		super(userRepo);
		this.activityHistoryService = activityHistoryService;
	}
	
	@GetMapping("/{employeeId}/activity")
	@Validated
	public String getEmployee(@PathVariable String employeeId, Model model, EmployeeActivityRequest activityReq) {
		
		log.info("EMPLOYEE ACTIVITY CONTROLLER");
		EmployeeActivityResponse res = activityHistoryService.retrieveEmployeeActivity(activityReq);
		res.setEmployeeId(employeeId);
		model.addAttribute("viewType", "6");
		if (res != null) {
			setPaginationVariables(res.getActivityHistoryPage(), model);
			model.addAttribute("res", res);
		}
		model.addAttribute("isUpdate", true);
		model.addAttribute("isUser", isUser(employeeId));
		return ACTIVITY_PAGE;
	}
}
