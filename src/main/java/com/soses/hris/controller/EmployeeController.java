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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;
import com.soses.hris.cache.CacheService;
import com.soses.hris.common.GlobalConstants;
import com.soses.hris.common.StringUtil;
import com.soses.hris.service.EmployeeService;

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
	
	/** The Constant EMP_LIST. */
	private static final String EMP_LIST = "/employee/employee_list";
	
	/** The general emp service. */
	private EmployeeService generalEmpService;
	
	/** The employee search service. */
	private EmployeeService employeeSearchService;
	
	/**
	 * Sets the employee search service.
	 *
	 * @param employeeSearchService the new employee search service
	 */
	@Autowired
	@Qualifier("EmployeeSearchServiceImpl")
	public void setEmployeeSearchService(EmployeeService employeeSearchService) {
		this.employeeSearchService = employeeSearchService;
	}

	/**
	 * Sets the e service.
	 *
	 * @param generalEmpService the new e service
	 */
	@Autowired
	@Qualifier("GeneralEmployeeSerivceImpl")
	public void seteService(EmployeeService generalEmpService) {
		this.generalEmpService = generalEmpService;
	}

	/** The cache service. */
	@Autowired
	CacheService cacheService;
	
	/**
	 * Employee.
	 *
	 * @param employeeReq the employee req
	 * @param errors the errors
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("")
	public String employee(@Valid BaseEmployeeRequest employeeReq, Errors errors, Model model) {
		
		BaseEmployeeResponse res = null;
		String strEmpId = employeeReq.getEmployeeId();
		if (!StringUtil.isEmpty(strEmpId)) {
			res = employeeSearchService.getEmployeeDetails(strEmpId);
			if (res != null) {
				model.addAttribute("res", res);
			}
		}
		return EMP_LIST;
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
	public String getEmployee(@PathVariable String employeeId, Model model, @RequestParam(required = false, defaultValue = "") String empViewType) {
		
		// searchType? case 1 2 3 -> service
		BaseEmployeeResponse res = null;
		switch (empViewType) {
			case GlobalConstants.EMP_VIEW_GENERAL:
				res = generalEmpService.getEmployeeDetails(employeeId);
				break;
			case GlobalConstants.EMP_VIEW_INFO:
				res = generalEmpService.getEmployeeDetails(employeeId);
				break;
			case GlobalConstants.EMP_VIEW_BENEFITS:
				res = generalEmpService.getEmployeeDetails(employeeId);
				break;
			default:
//				empViewType = GlobalConstants.EMP_VIEW_GENERAL;
				res = generalEmpService.getEmployeeDetails(employeeId);
				break;
		}
		model.addAttribute("viewType", empViewType);
		if (res!= null) {
			model.addAttribute("res", res);
			model.addAttribute("isUpdate", false);
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
		model.addAttribute(EMP_SEARCH_ERR, "Something went wrong. Please try again.");
		return EMP_PAGE;
	}	
	
}
