package com.soses.hris.api;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseEmployeeResponse.
 */
public class BaseEmployeeResponse {

	/** The employee id. */
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
		return "BaseEmployeeResponse [employeeId=" + employeeId + "]";
	}
	
}
