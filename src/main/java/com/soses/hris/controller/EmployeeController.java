package com.soses.hris.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.cache.CacheService;
import com.soses.hris.entity.Employee;
import com.soses.hris.service.EmployeeService;
import com.soses.hris.service.impl.EmployeeServiceImpl;

/**
 * The Class EmployeeController.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	/** The Constant EMP_SEARCH_ERR. */
	private static final String EMP_SEARCH_ERR = "empSearchError";
	
	/** The Constant EMP_PAGE. */
	private static final String EMP_PAGE = "/employee/employee";
	private static final String EMP_LIST = "/employee/employee_list";
	
	/** The emp service. */
	private EmployeeServiceImpl empService;
	
	private EmployeeService generalEmpService;
	
	
	@Autowired
	@Qualifier("GeneralEmployeeSerivceImpl")
	public void seteService(EmployeeService generalEmpService) {
		this.generalEmpService = generalEmpService;
	}

	/**
	 * Sets the emp service.
	 *
	 * @param empService the new emp service
	 */
	@Autowired
	public void setEmpService(EmployeeServiceImpl empService) {
		this.empService = empService;
	}

	@Autowired
	CacheService cacheService;
	
	/**
	 * Employee.
	 *
	 * @return the string
	 */
	@GetMapping("")
	public String employee() {
		System.out.println(cacheService.deriveMaritalStatus("S"));
		return EMP_PAGE;
	}
	
	/**
	 * Employee search.
	 *
	 * @param employeeReq the employee req
	 * @param errors the errors
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/search")
	public String employeeSearch(@Valid BaseEmployeeRequest employeeReq, Errors errors, Model model) {
		
		String strEmployeeId = employeeReq.getEmployeeId();
		if (errors.hasErrors()) {
			log.info("employee(); Invalid EmployeeId: " + strEmployeeId);
			model.addAttribute(EMP_SEARCH_ERR, "Invalid Employee Id: " + strEmployeeId);
			return "forward:/employee";
		} 
		return "redirect:/employee/"+strEmployeeId;
	}
	
	/**
	 * Gets the employee.
	 *
	 * @param employeeId the employee id
	 * @param model the model
	 * @return the employee
	 */
	@GetMapping("/{employeeId}")
	@Validated
	public String getEmployee(@PathVariable int employeeId, Model model) {
		
		log.info("getEmployee()");
		
		// searchType? case 1 2 3 -> service
		
		BaseEmployeeResponse res = generalEmpService.getEmployeeDetails(employeeId);
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", false);
		} else {
			model.addAttribute(EMP_SEARCH_ERR, "Employee id not found.");
		}
		return EMP_PAGE;
	}
	
	/**
	 * Handle method argument type mismatch exception.
	 *
	 * @param e the e
	 * @param model the model
	 * @return the string
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, Model model) {

		log.error(e.getMessage());
		model.addAttribute(EMP_SEARCH_ERR, "Something went wrong, please try again.");
		return EMP_PAGE;
	}	
	
}
