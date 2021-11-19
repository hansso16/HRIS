package com.soses.hris.api;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

/**
 * The Class BaseEmployeeRequest.
 *
 * @author hso
 * @since 18 Nov 2021
 */
public class BaseEmployeeRequest {

	/** The employee id. */
	@Digits(fraction = 0, integer = Integer.MAX_VALUE)
	@Positive
	private String employeeId;

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BaseEmployeeRequest [employeeId=" + employeeId + "]";
	}
	
}
