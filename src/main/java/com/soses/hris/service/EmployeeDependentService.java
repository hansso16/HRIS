package com.soses.hris.service;

import com.soses.hris.api.EmployeeDependentRequest;

/**
 * The Interface EmployeeDependentService.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public interface EmployeeDependentService extends BaseEmployeeService {

	/**
	 * Update employee details.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean updateEmployeeDetails(EmployeeDependentRequest request);
	
	/**
	 * Delete employee dependent.
	 *
	 * @param employeeId the employee id
	 * @param dependentId the dependent id
	 * @return true, if successful
	 */
	boolean deleteEmployeeDependent(String employeeId, short dependentId);
	
	/**
	 * Adds the employee dependents.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean addEmployeeDependents(EmployeeDependentRequest request);
}
