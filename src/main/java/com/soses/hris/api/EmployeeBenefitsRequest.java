package com.soses.hris.api;

import com.soses.hris.entity.EmployeeBenefits;

/**
 * The Class EmployeeBenefitsRequest.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeBenefitsRequest extends BaseEmployeeRequest {

	/** The employee benefits. */
	private EmployeeBenefits employeeBenefits;

	/**
	 * Gets the employee benefits.
	 *
	 * @return the employee benefits
	 */
	public EmployeeBenefits getEmployeeBenefits() {
		return employeeBenefits;
	}

	/**
	 * Sets the employee benefits.
	 *
	 * @param employeeBenefits the new employee benefits
	 */
	public void setEmployeeBenefits(EmployeeBenefits employeeBenefits) {
		this.employeeBenefits = employeeBenefits;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeBenefitsRequest [employeeBenefits=" + employeeBenefits + ", toString()=" + super.toString()
				+ "]";
	}
	
}
