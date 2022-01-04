package com.soses.hris.api;

import java.util.List;

import com.soses.hris.entity.EmployeeDependent;

/**
 * The Class EmployeeDependentRequest.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeDependentRequest extends BaseEmployeeRequest {

	/** The employee dependent. */
	private List<EmployeeDependent> employeeDependent;

	/**
	 * Gets the employee dependent.
	 *
	 * @return the employee dependent
	 */
	public List<EmployeeDependent> getEmployeeDependent() {
		return employeeDependent;
	}

	/**
	 * Sets the employee dependent.
	 *
	 * @param employeeDependent the new employee dependent
	 */
	public void setEmployeeDependent(List<EmployeeDependent> employeeDependent) {
		this.employeeDependent = employeeDependent;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeDependentRequest [employeeDependent=" + employeeDependent + ", toString()=" + super.toString()
				+ "]";
	}
	
}
