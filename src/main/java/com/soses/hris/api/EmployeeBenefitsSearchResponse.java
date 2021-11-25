package com.soses.hris.api;

import com.soses.hris.dto.EmployeeBenefitsTO;

/**
 * The Class EmployeeBenefitsSearchResponse.
 *
 * @author hso
 * @since 11 Nov 2021
 */
public class EmployeeBenefitsSearchResponse extends BaseEmployeeSearchResponse {

	/** The employee benefits TO. */
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

}
