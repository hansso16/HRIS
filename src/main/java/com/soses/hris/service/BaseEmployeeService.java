package com.soses.hris.service;

import com.soses.hris.api.BaseEmployeeRequest;
import com.soses.hris.api.BaseEmployeeResponse;

/**
 * The Interface BaseEmployeeService.
 *
 * @author hso
 * @since Jan 17, 2022
 */
public interface BaseEmployeeService {

	/**
	 * Gets the employee details.
	 *
	 * @param employeeId the employee id
	 * @return the employee details
	 */
	//get details
	BaseEmployeeResponse getEmployeeDetails(String employeeId); // what is the return type??
	
	boolean updateEmployeeDetails(BaseEmployeeRequest request);
	
}
