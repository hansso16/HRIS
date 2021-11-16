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
	private EmployeeBenefitsTO employeeBenefitsTO;

	/**
	 * Gets the employee benefits TO.
	 *
	 * @return the employee benefits TO
	 */
	public EmployeeBenefitsTO getEmployeeBenefitsTO() {
		return employeeBenefitsTO;
	}

	/**
	 * Sets the employee benefits TO.
	 *
	 * @param employeeBenefitsTO the new employee benefits TO
	 */
	public void setEmployeeBenefitsTO(EmployeeBenefitsTO employeeBenefitsTO) {
		this.employeeBenefitsTO = employeeBenefitsTO;
	}
	
}
