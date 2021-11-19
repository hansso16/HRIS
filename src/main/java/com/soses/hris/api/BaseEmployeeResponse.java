package com.soses.hris.api;

/**
 * The Class BaseEmployeeResponse.
 *
 * @author hso
 * @since 17 Nov 2021
 */
public class BaseEmployeeResponse extends BaseResponse{

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
