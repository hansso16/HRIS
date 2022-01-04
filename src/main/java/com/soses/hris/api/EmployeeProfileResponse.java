package com.soses.hris.api;

import com.soses.hris.dto.EmployeeTO;

/**
 * The Class EmployeeProfileResponse.
 *
 * @author hso
 * @since Jan 3, 2022
 */
public class EmployeeProfileResponse extends BaseEmployeeSearchResponse {

	/** The employee. */
	private EmployeeTO employee;

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public EmployeeTO getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(EmployeeTO employee) {
		this.employee = employee;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeProfileResponse [employee=" + employee + "]";
	}
}
