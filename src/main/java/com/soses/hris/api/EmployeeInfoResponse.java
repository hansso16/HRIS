package com.soses.hris.api;

import com.soses.hris.dto.EmployeeInfoTO;

/**
 * The Class EmployeeInfoResponse.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeInfoResponse extends BaseEmployeeSearchResponse {

	/** The employee info. */
	private EmployeeInfoTO employeeInfo;

	/**
	 * Gets the employee info.
	 *
	 * @return the employee info
	 */
	public EmployeeInfoTO getEmployeeInfo() {
		return employeeInfo;
	}

	/**
	 * Sets the employee info.
	 *
	 * @param employeeInfo the new employee info
	 */
	public void setEmployeeInfo(EmployeeInfoTO employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeInfoResponse [employeeInfo=" + employeeInfo + ", toString()=" + super.toString() + "]";
	}
	
}
