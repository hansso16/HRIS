package com.soses.hris.api;

import com.soses.hris.entity.EmployeeInfo;

/**
 * The Class EmployeeInfoRequest.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeInfoRequest extends BaseEmployeeRequest {

	/** The employee info. */
	private EmployeeInfo employeeInfo;

	/**
	 * Gets the employee info.
	 *
	 * @return the employee info
	 */
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	/**
	 * Sets the employee info.
	 *
	 * @param employeeInfo the new employee info
	 */
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeInfoRequest [employeeInfo=" + employeeInfo + ", toString()=" + super.toString() + "]";
	}
	
}
