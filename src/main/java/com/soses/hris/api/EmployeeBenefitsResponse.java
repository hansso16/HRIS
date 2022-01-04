package com.soses.hris.api;

import com.soses.hris.dto.EmployeeBenefitsTO;

/**
 * The Class EmployeeBenefitsResponse.
 *
 * @author hso
 * @since Jan 4, 2022
 */
public class EmployeeBenefitsResponse extends BaseEmployeeSearchResponse {

	/** The employee benefits. */
	private EmployeeBenefitsTO employeeBenefits;

	/**
	 * Gets the employee benefits.
	 *
	 * @return the employee benefits
	 */
	public EmployeeBenefitsTO getEmployeeBenefits() {
		return employeeBenefits;
	}

	/**
	 * Sets the employee benefits.
	 *
	 * @param employeeBenefits the new employee benefits
	 */
	public void setEmployeeBenefits(EmployeeBenefitsTO employeeBenefits) {
		this.employeeBenefits = employeeBenefits;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeBenefitsResponse [employeeBenefits=" + employeeBenefits + ", toString()=" + super.toString()
				+ "]";
	}

}
