package com.soses.hris.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import com.soses.hris.api.employee.EmployeeSearchRequest;
import com.soses.hris.entity.Employee;
import com.soses.hris.service.EmployeeSearchService;

/**
 * The Class EmployeeController.
 *
 * @author hso
 * @since 11 Nov 2021
 */
@Controller
@RequestMapping("/employee")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class EmployeeSearchController extends BaseSearchController{

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(EmployeeSearchController.class);
	
	/** The Constant EMP_LIST. */
	private static final String EMP_LIST = "employee/employee_list";

	private EmployeeSearchService employeeSearchService;
	
	@Autowired
	public EmployeeSearchController(EmployeeSearchService employeeSearchService) {
		super();
		this.employeeSearchService = employeeSearchService;
	}

	/**
	 * Employee.
	 *
	 * @param employeeReq the employee req
	 * @param errors the errors
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("")
	public String searchEntity(@Valid EmployeeSearchRequest employeeReq, Errors errors, Model model) {
		
		log.info("ENTER employee(employeeReq,errors,model): employeeReq -> " + employeeReq.toString());
		Page<Employee> employeePage = null;
		String employeeId = employeeReq.getEmployeeId();
		if (employeeId != null) {
			employeePage = employeeSearchService.searchEmployee(employeeReq);
			if (employeePage != null) {
				setPaginationVariables(employeePage, model);
				model.addAttribute("employeeId", employeeId);
			}
		}
		return EMP_LIST;
	}
}
