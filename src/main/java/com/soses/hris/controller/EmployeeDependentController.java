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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
			model.addAttribute("isUpdate", isUpdate);
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
	
	@GetMapping(value="/{employeeId}/dependent/delete")
	public RedirectView deleteDependent(@PathVariable String employeeId, @RequestParam String dependentId, Model model, RedirectAttributes redirectAttrs) {
		
		log.info("DELETE DEPENDENT");
		String redirectUrl="/employee/" + employeeId + "/dependent";
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		short dId = 0; 
		try {
			dId = Short.parseShort(dependentId);
			if (employeeDependentService.deleteEmployeeDependent(employeeId, dId)) {
				redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully deleted dependent.");
			} else {
				redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
//		return getEmployee(employeeId, model, false);
		return redirectView;
	}
	
	@GetMapping("/{employeeId}/dependent/add")
	@Validated
	public String addEmployeeDependent(@PathVariable String employeeId, Model model) {
		
		log.info("REGISTER EMPLOYEE DEPENDENT CONTROLLER");
		// searchType? case 1 2 3 -> service
		model.addAttribute("viewType", "5");
		BaseEmployeeResponse res = new BaseEmployeeResponse();
		res.setEmployeeId(employeeId);
		model.addAttribute("res", res);
		model.addAttribute("isUpdate", true);
		return EMP_PAGE;
	}
	
	@PostMapping(value="/{employeeId}/dependent/add")
	public RedirectView saveEmployeeDependent(@PathVariable String employeeId, @Valid EmployeeDependentRequest request, Model model
			, RedirectAttributes redirectAttrs) {
		
		log.info("EmployeeId: " + employeeId);
		log.info("Request: " + request.toString());
		String redirectUrl="/employee/" + employeeId + "/dependent";
		RedirectView redirectView = new RedirectView(redirectUrl, true);
		redirectView.setExposeModelAttributes(false);
		if (employeeDependentService.addEmployeeDependents(request)) {
			// set error
			redirectAttrs.addFlashAttribute(GlobalConstants.SUCCESS_MESSAGE, "Successfully added employee dependent.");
		} else {
			redirectAttrs.addFlashAttribute(GlobalConstants.ERROR_MESSAGE, GlobalConstants.GENERIC_ERROR_MESSAGE_DESC);
		}
		
		return redirectView;
	}
}
