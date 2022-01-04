package com.soses.hris.service;

import com.soses.hris.api.EmployeeInfoRequest;

/**
 * The Interface EmployeeInfoService.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public interface EmployeeInfoService extends BaseEmployeeService {

	/**
	 * Update employee details.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	boolean updateEmployeeDetails(EmployeeInfoRequest request);
}
